package com.example.littlebakery;

public class Horizontal_Product_Scroll_Model {

    private int ProductImage;
    private String ProductName;
    private String ProductPrice;
    private String CuttedPrice;

    public Horizontal_Product_Scroll_Model(int productImage, String productName, String productPrice, String cuttedPrice) {
        ProductImage = productImage;
        ProductName = productName;
        ProductPrice = productPrice;
        CuttedPrice = cuttedPrice;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getCuttedPrice() {
        return CuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        CuttedPrice = cuttedPrice;
    }
}
