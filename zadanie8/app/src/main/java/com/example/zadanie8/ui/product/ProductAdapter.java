package com.example.zadanie8.ui.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zadanie8.R;
import com.example.zadanie8.ui.cart.CartViewModel;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private List<Product> productList;

    public ProductAdapter(@NonNull Context context, @NonNull List<Product> objects, @NonNull List<Product> cart) {
        super(context, 0, objects);
        this.productList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent, false);
        }

        Product product = productList.get(position);

        TextView productNameTextView = convertView.findViewById(R.id.product_name);
        TextView productPriceTextView = convertView.findViewById(R.id.product_price);
        Button addToCartButton = convertView.findViewById(R.id.add_to_cart_button);

        productNameTextView.setText(product.toString());
        productPriceTextView.setText(String.format("$%s", product.getPrice().toString()));

        addToCartButton.setOnClickListener(v -> {
            CartViewModel.addProductToCart(product);
        });

        return convertView;
    }
}
