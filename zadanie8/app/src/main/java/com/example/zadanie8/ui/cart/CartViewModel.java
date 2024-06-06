package com.example.zadanie8.ui.cart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.zadanie8.ui.product.Product;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends ViewModel {

    private static final MutableLiveData<List<Product>> cart = new MutableLiveData<>(new ArrayList<>());

    public CartViewModel() {
    }

    public LiveData<List<Product>> getCart() {
        return cart;
    }

    public static void addProductToCart(Product product) {
        List<Product> currentCart = cart.getValue();
        if (currentCart != null) {
            currentCart.add(product);
            cart.setValue(currentCart);
        }
    }

    public static void removeProductFromCart(Product product) {
        List<Product> currentCart = cart.getValue();
        assert currentCart != null;
        for (Product p : currentCart) {
            if (p.equals(product)) {
                currentCart.remove(p);
                break;
            }
        }
    }
}
