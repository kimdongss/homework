package com.javalab.shoppingmallhomework;

/**
 * 주문 도메인 클래스
 * - 주문 정보를 담는 클래스
 * - 주문번호, 고객번호, 상품id, 주문수량, 총 주문금액을 가진다.
 */
public class Order {
    // 필드선언
    private int orderId; // 주문번호
    private String memberId; // 고객번호
    private int productId; // 상품id
    private int quantity; // 주문수량
    private double totalAmount; // 총 주문금액

    public Order() {
    }

    public Order(int orderId, String memberId, int productId, int quantity, double totalAmount) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // 고객 정보 출력 메소드
    public void displayMemberInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + memberId);
        System.out.println("Product ID: " + productId);
        System.out.println("Quantity: " + quantity);
        System.out.println("TotalAmount $: " + totalAmount);
        System.out.println("----------------------------");
    }
}
