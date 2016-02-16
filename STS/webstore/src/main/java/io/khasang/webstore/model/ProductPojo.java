package io.khasang.webstore.model;

/**
 * Товар
 */
public class ProductPojo {
    private int ID;
    private String pname;
    private String product;
    private String imgSrc;
    private double cost;

    public ProductPojo() {
    }

    public ProductPojo(int ID, String pname, String product) {
        this.ID = ID;
        this.pname = pname;
        this.product = product;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ID: " + getID() +
                " NAME: " + getPname() +
                " DESCRIPTION: " + getProduct();
    }
}
