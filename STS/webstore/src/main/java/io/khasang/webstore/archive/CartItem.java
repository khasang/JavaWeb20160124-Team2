package io.khasang.webstore.archive;

public class CartItem {
    private String productName;
    private String description;
    private int vendorCode;
    int quantity;

    public CartItem(String productName, String description, int vendorCode) {
        this.productName = productName;
        this.description = description;
        this.vendorCode = vendorCode;
        this.quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return productName != null ? productName.equals(cartItem.productName) : cartItem.productName == null;

    }

    @Override
    public int hashCode() {
        return productName != null ? productName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", vendorCode=" + vendorCode +
                ", quantity=" + quantity +
                '}';
    }
}
