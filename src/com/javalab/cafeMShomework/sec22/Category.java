package com.javalab.cafeMShomework.sec22;

/**
 * Category 클래스
 * - 카테고리 정보를 저장하는 클래스
 * - 카테고리 정보는 카테고리 아이디, 카테고리 이름, 카테고리 설명으로 구성
 */

public class Category {
    // 필드
    private int categoryId ;
    private String name;
    private String description;

    // 생성자
    public Category(){
    }

    // 오버로딩 생성자
    public Category(int categoryId, String name, String description){
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // 카테고리 정보 출력 메소드
    public void displayCategoryInfo() {
        System.out.println("categoryId: " + categoryId);
        System.out.println("name: " + name);
        System.out.println("description: " + description);
        System.out.println("----------------------------");
    }
}

