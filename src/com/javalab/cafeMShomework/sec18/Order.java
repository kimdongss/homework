package com.javalab.cafeMShomework.sec18;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  주문 정보 생성 클래스
 */

public class Order {
    //필드
    private int orderId;
    private LocalDateTime orderDate;
    private int productId;
    private int employeeId;
    private int quantity;

    //생성자
    public Order() {
    }

    //오버로딩 생성자
    // 문자열로 입력된 날짜를 파싱하여 LocalDateTime 객체로 변환하는 생성자입니다.
    public Order(int orderId, String orderDateString, int productId, int employeeId, int quantity) {
        // DateTimeFormatter 클래스의 ofPattern 메소드를 사용하여 날짜 형식을 지정합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.orderId = orderId;
        // LocalDateTime 클래스의 parse 메소드를 사용하여 문자열을  LocalDateTime 객체로 변환합니다.
        this.orderDate = LocalDateTime.parse(orderDateString, formatter);
        this.productId = productId;
        this.employeeId = employeeId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
