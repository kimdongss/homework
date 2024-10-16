package com.javalab.shoppingmallhomework;

/**
 * 고객 정보 도메인 클래스
 * - 고객 정보를 저장하는 클래스
 * - 고객 정보는 아이디, 비밀번호, 이름, 이메일로 구성
 */
public class Member {
    // 필드선언
    private String id; // 아이디
    private String password; // 비밀번호
    private String name; // 이름
    private String email; // 이메일

    public Member() {
    }

    public Member(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 고객 정보 출력 메소드
    public void displayMemberInfo() {
        System.out.println("ID: " + id);
        System.out.println("Password: " + password);
        System.out.println("Name: $" + name);
        System.out.println("Email: " + email);
        System.out.println("----------------------------");
    }
}
