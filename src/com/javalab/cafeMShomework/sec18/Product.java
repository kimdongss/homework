package com.javalab.cafeMShomework.sec18;

/**
 * Product 클래스
 * - 상품 정보를 저장하는 클래스
 * - 상품 정보는 상품 아이디, 상품 이름, 카테고리 아이디, 가격으로 구성
 */

public class Product {
    // 필드
    private int productId;
    private String name;
    private int categoryId;
    private int price;
    private int stock;

    // 생성자
    public Product(){
    }
    // 오버로딩 생성자
    public Product(int productId, String name, int categoryId, int price){
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }
    // 재고량이 추가된 생성자
    public Product(int productId, String name, int categoryId, int price, int stock){
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // 상품 정보 출력 메소드
    public void displayProductInfo() {
        System.out.println("productId: " + productId);
        System.out.println("name: " + name);
        System.out.println("categoryId: " + categoryId);
        System.out.println("price: " + price);
        System.out.println("----------------------------");
    }
}
