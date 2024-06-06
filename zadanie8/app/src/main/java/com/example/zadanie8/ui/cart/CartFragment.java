package com.example.zadanie8.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.zadanie8.R;
import com.example.zadanie8.databinding.FragmentCartBinding;
import com.example.zadanie8.ui.product.Category;
import com.example.zadanie8.ui.product.Product;

import java.util.List;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    private CartViewModel cartViewModel;
    private TextView totalSumTextView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cartViewModel = new ViewModelProvider(requireActivity()).get(CartViewModel.class);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView cartListView = binding.cartListView;
        totalSumTextView = binding.totalSumTextView;

        cartViewModel.getCart().observe(getViewLifecycleOwner(), products -> {
            CartAdapter adapter = new CartAdapter(getContext(), products);
            cartListView.setAdapter(adapter);
            updateTotalSum(products);
        });

        return root;
    }

    private void updateTotalSum(List<Product> products) {
        double totalSum = 0;
        for (Product product : products) {
            totalSum += product.getPrice();
        }
        totalSumTextView.setText(getString(R.string.total_sum_format, totalSum));
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
