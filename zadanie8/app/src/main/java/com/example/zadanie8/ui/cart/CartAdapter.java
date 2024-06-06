package com.example.zadanie8.ui.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.zadanie8.R;
import com.example.zadanie8.ui.product.Product;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Product> {

    public CartAdapter(@NonNull Context context, @NonNull List<Product> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        }

        Product product = getItem(position);

        TextView productNameTextView = convertView.findViewById(R.id.product_name);
        TextView productPriceTextView = convertView.findViewById(R.id.product_price);
        Button removeButton = convertView.findViewById(R.id.remove_button);

        if (product != null) {
            productNameTextView.setText(product.getName());
            productPriceTextView.setText(String.format("$%s", product.getPrice().toString()));
            removeButton.setTag(product);

            removeButton.setOnClickListener(v -> {
                CartViewModel.removeProductFromCart(product);
                Navigation.findNavController(v).navigate(R.id.refresh_nav_cart);

            });
        }

        return convertView;
    }
}
