package com.example.zadanie8.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.zadanie8.R;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    private ListView categoryListView;
    private List<Category> categoryList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_category_list, container, false);
        categoryListView = root.findViewById(R.id.category_list_view);

        initializeCategoryList();
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, categoryList);
        categoryListView.setAdapter(adapter);

        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
            Category selectedCategory = categoryList.get(position);
            Bundle bundle = new Bundle();
            bundle.putString("category_name", selectedCategory.getName());
            Navigation.findNavController(view).navigate(R.id.action_productFragment_to_productListFragment, bundle);
        });

        return root;
    }

    private void initializeCategoryList() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Books"));
        categoryList.add(new Category("Clothing"));
        categoryList.add(new Category("Electronics"));
    }
}
