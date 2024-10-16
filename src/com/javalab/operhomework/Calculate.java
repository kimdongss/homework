package com.javalab.operhomework;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        //Scanner 클래스 import
        //new 객체생성 연산자, Scanner  클래스를 객체로 생성해서 메모리에 할당
        // system.in 키보드로 부터 값을 입력받는 표준 입력 스트림
        Scanner scan = new Scanner(System.in);
        // java.lang 패키지에 있는 클래스들은 import하지 않아도 사용 가능.
        System.out.println("계산할 첫번째 숫자를 입력하세요.");
        String data1 = scan.nextLine(); // 문자열 입력, 한줄 입력
        System.out.println("계산할 연산자를 입력하세요(+, -, *, /)");
        String oper = scan.nextLine(); // 문자열 입력, 한줄 입력
        System.out.println("계산할 두번째 숫자를 입력하세요.");
        String data2 = scan.nextLine(); // 문자열 입력, 한줄 입력

        double a = Double.parseDouble(data1);
        double b = Double.parseDouble(data2);

//        while (true) {
//            oper = scan.nextLine(); // 문자열 입력, 한줄 입력
//            if (!oper.equals("+") && !oper.equals("-") && !oper.equals("*") && !oper.equals("/")) {
//                System.out.println("지원하는 연산자가 아닙니다.");
//                return; // 반복문 종료
//            }
//            break;
//        }

        switch (oper) {
            case "+":
                add(a, b);
                break; // switch 문 종료
            case "-":
                minus(a, b);
                break;
            case "*":
                multi(a, b);
                break;
            case "/":
                div(a, b);
                break;
            default: // else 역할
                System.out.println("입력하신 숫자와 연산자를 확인 해 주세요.");
        }
    }

    public static void add(double a, double b) {
        double result = (double) a + b;
        System.out.println(a + " + " + b + " = " + result);
    }

    public static void minus(double a, double b) {
        double result = (double) a - b;
        System.out.println(a + " - " + b + " = " + result);
    }

    public static void multi(double a, double b) {
        double result = (double) a * b;
        System.out.println(a + " - " + b + " = " + result);
    }

    public static void div(double a, double b) {
        double result = (double) a / b;
        System.out.println(a + " - " + b + " = " + result);
    }
}

// Integer.parseInt(quantity)
//         double dblf = (double)a / b; // double로 형 변환
// double pi = Double.parseDouble(piStr);
