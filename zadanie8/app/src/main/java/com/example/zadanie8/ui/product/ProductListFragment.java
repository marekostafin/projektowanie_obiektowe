package com.example.zadanie8.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zadanie8.R;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment {

    private ListView productListView;
    private List<Product> productList;
    private List<Product> cart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product_list, container, false);
        productListView = root.findViewById(R.id.product_list_view);

        cart = new ArrayList<>();

        Bundle bundle = getArguments();
        if (bundle != null) {
            String categoryName = bundle.getString("category_name");
            initializeProductList(categoryName);
            ProductAdapter adapter = new ProductAdapter(getContext(), productList, cart);
            productListView.setAdapter(adapter);
        }

        return root;
    }

    private void initializeProductList(String categoryName) {
        productList = new ArrayList<>();
        if (categoryName.equals("Electronics")) {
            productList.add(new Product("Laptop", 999.99));
            productList.add(new Product("Smartphone", 800.00));
        } else if (categoryName.equals("Books")) {
            productList.add(new Product("Cookbook", 31.99));
            productList.add(new Product("Lord of the Rings", 70.00));
        } else if (categoryName.equals("Clothing")) {
            productList.add(new Product("T-Shirt", 20.00));
            productList.add(new Product("Jeans", 55.99));
            productList.add(new Product("Hoodie", 49.99));
        }
    }
}
