package com.javalab.memberhomework;


public class MemberMain {
    public static void main(String[] args) {

        Member member1 = new Member(); // Member 빈 객체 생성
        member1.setId("id1"); // Setter 메소드로 값 세팅
        member1.setPassword("password1");
        member1.setName("Kim");
        member1.setAge(21);

        Member member2 = new Member(); // 빈 객체 생성
        member2.setId("id2");
        member2.setPassword("password2");
        member2.setName("Park");
        member2.setAge(22);


        Member member3 = new Member("id3", "password3", "Lee", 23);
        Member member4 = new Member("id4", "password4", "choi", 24);
        Member member5 = new Member("id5", "password5", "hwang", 25);


        System.out.println("member1.getId() = " + member1.getId());
        System.out.println("member1.getPassword() = " + member1.getPassword());
        System.out.println("member1.getName() = " + member1.getName());
        System.out.println("member1.getAge() = " + member1.getAge());
        System.out.println("=======================");
        System.out.println("member2.getId() = " + member2.getId());
        System.out.println("member2.getPassword() = " + member2.getPassword());
        System.out.println("member2.getName() = " + member2.getName());
        System.out.println("member2.getAge() = " + member2.getAge());
        System.out.println("=======================");

        member3.showMemberInfo();
        member4.showMemberInfo();
        member5.showMemberInfo();

        // member3 객체의 이름을 "서길동", 나이를 48로 변경
        member3.setName("서길동");
        member3.setAge(48);
        member3.showMemberInfo();
    }
}
//setter 이용할 떄
//car1.changeSpeed(100);