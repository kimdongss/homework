package com.javalab.memberhomework;

/**
 * 1. 클래스 이름 Member
 * 2. 클래스 속성(필드)
 * 문자열 id
 * 문자열 password
 * 문자열 name
 * 정수 age
 *
 * 3.구현 기능
 * 1) 필드
 * 2) 모든 생성자(오버로딩)
 * 3) 게터 세터 메소드
 * 4) Member 정보 출력 메소드
 *
 * 4. 구체적인 기능
 * 1) 멤버 객체를 만들 때 오버로딩 생성자를 통해서 3명 생성
 * 2) 2명은  빈 객체를 만들고 세터메소드로 정보를 세팅
 * ) 총5명의 멤버를 만들고 멤버 목록을 출력하세요.
 */
class Member {
    // 필드, 속성, 멤버변수(인스턴스 변수)
    private String id;
    private String password;
    private String name;
    private int age;

    // 기본 생성자
    public Member() { // 생성자의 목적은 객체를 초기화, 초기값을 셋팅 / 필드들이 각각의 기본값으로 세팅 됨(int:0, String:null)
    }                   // 컴파일러가 기본생성자든 1~4개 생성자든 1개라도 생성자가 있으면 기본생성자를 기본적으로(임의로) 만들어 주지 않는다. 따라서 기본생성자를 실행클래스에서 사용할 예정이라면 코드를 적어줘야 한다.
    // 생성자 - id만 초기화
    public Member(String id){
        this.id = id;
    }
    // 생성자 - id, password 초기화
    public Member(String id, String password){
        this.id = id;
        this.password = password;
    }
    // 생성자 - id, password, name 초기화
    public Member(String id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }
    // 오버로딩 생성자 / 매서드의 이름이 같아야하고, 개수 타입 순서중 하나라도 달라야한다.
    // 서로다른 매개변수를 입력받을 때, 다른동작을 할때 쓸 수있다.
    public Member(String id, String password, String name, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }
    //getter
    public String getId() {
        return this.id;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }
    //getter
    public String getPassword() {
        return this.password;
    }
    //setter
    public void setPassword(String password) {
        this.password = password;
    }
    //getter
    public String getName() {
        return this.name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }
    //getter
    public int getAge() {
        return this.age;
    }
    //setter
    public void setAge(int age) {
        this.age = age;
    }

    // 멤버 정보 출력 메소드
    public void showMemberInfo() {
        System.out.println("id는: " + id);
        System.out.println("password는: " + password);
        System.out.println("name: " + name);
        System.out.println("age는: " + age);
        System.out.println("=======================");
    }

}


//setter 이용할 떄
//car1.changeSpeed(100);