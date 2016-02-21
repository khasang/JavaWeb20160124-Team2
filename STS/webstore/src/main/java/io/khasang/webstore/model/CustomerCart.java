package io.khasang.webstore.model;

import java.util.*;

public class CustomerCart {
    protected List<CartItem> cartItems;

    public CustomerCart() {
        this.cartItems = new ArrayList<CartItem>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(String productName, String description, int vendorName) {
        CartItem cartItem = new CartItem(productName, description, vendorName);
        // проверка на пустую корзину товаров
        if (cartItems.isEmpty()) {
            cartItems.add(cartItem);
        } else {
            // проверка на наличие одинакового элемента
            boolean isEqual = false;
            for (CartItem next : cartItems) {
                if (next.equals(cartItem)) {
                    next.quantity++;
                    isEqual = true;
                }
            }
            if (!isEqual) {
                cartItems.add(cartItem);
            }
        }
    }

    public void removeItem(String productName) {
        for (Iterator<CartItem> iterator = cartItems.iterator(); iterator.hasNext(); ) {
            CartItem next = iterator.next();
            if (next.getProductName().equals(productName)) {
                if (next.quantity > 1) {
                    next.quantity--;
                } else {
                    iterator.remove();
                }
            }
        }
    }

    public String addItemInMenuPage(String productName, String description, int vendorName){
        addItem(productName, description, vendorName);
        return "Product added!";
    }
}