package com.javalab.cafeMShomework.sec22;


import java.util.ArrayList;

public class ArrayListReturn {
    public static void main(String[] args) {

        // 1. 카테고리 기본 데이터 생성 메소드 호출
        ArrayList<Category> categories = initializeCategoryData();

        // 2. 카테고리 id가 3인 카테고리의 description을 조회 및 출력
//        showCategoryDescription(categories);
        Category category = null; // 카테고리 id가 3인 카테고리 객체를 저장할 변수
        for(Category c : categories){
            if(c.getCategoryId() == 3){
                category = c; // 카테고리id가 3인 카ㅔ고리 객체를 찾아서 category 변수에 저장
                break;
            }
        }
        System.out.println("카테고리 id가 3인 카테고리의 설명: " + category.getDescription());

        // 3. 카테고리 아이디가 짝수인 카테고리 객체만 조회
        ArrayList<Category> evenCategoryList = new ArrayList<Category>(); // 카테고리id가 짝수인 카테고리 객체를 저장할 ArrayList
        for(Category c : categories){
            if( c.getCategoryId() % 2 == 0){ // 2로 나누어 떨어지면 짝수라는 뜻
                evenCategoryList.add(c); // 카테고리id가 짝수인 카테고리 객체를 evenCategoryList에 추가
            }
        }
        //evenCategoryList에 저장된 카테고리 객체 출력
        for(Category c : evenCategoryList){
            System.out.println(c.getCategoryId() + " " + c.getName() + " " + c.getDescription());
        }

        // 4. 카테고리 id가 5인 카테고리의 이름을 "Bread"로 변경, description을 "고소한 빵"으로 변경
        for(Category c : categories){
            if(c.getCategoryId() == 5){ // 카테고리 id가 5 인 경우
                c.setName("Bread"); // 카테고리 이름을 "Bread"로 변경
                c.setDescription("고소한 빵"); // 카테고리 설명을 "고소한 빵"으로 변경
            }
        }
        // 변경된 카테고리 정보 출력
        System.out.println("====카테고리 id가 5인 카테고리의 이름과 설명 변경 후 출력====");
        for(Category c : categories){
            System.out.println(c.getCategoryId() + " " + c.getName() + " " + c.getDescription());
        }
        
        // 6. 상품 데이터 생성 메소드 호출
        ArrayList<Product> products = initializeProductdata();

        // 7. 초코라떼라는 이름을 가진 상품 객체를 조회하되 별도의 ArrayList에 저장해서 출력
        ArrayList<Product> chocoLatteList = new ArrayList<Product>(); // 상품리스트에서 초코라떼인 상품 객체를 저장할 ArrayList
//        Product product = findProductByNam("초코라떼", products);
        for(Product p : products){
            if (p.getName().equals("초코라떼")){ // 상품이름이 "초코라떼"인 경우
                chocoLatteList.add(p); // 상품이름이 초코라떼인 상품 객체를 chocoLatteList에 추가
            }
        }
        //chocoLatteList에 저장된 카테고리 객체 출력 /  "초코라떼" 상품 객체 출력
        System.out.println("상품 이름이 '초코라떼'인 상품 출력");
        for(Product p : chocoLatteList){
            System.out.println(p.getProductId() + " " + p.getName() + " " + p.getCategoryId() + " " + p.getPrice() + " " + p.getStock());
        }



    } // end of main


    /**
     * 상품 기본 데이터를 생성하여 ArrayList에 추가하고 반환해주는 메소드 
     * @return
     */
    public static ArrayList<Product> initializeProductdata() {
        // 1. Product 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Product> pList = new ArrayList<>();
        // 2. ArrayList에 추가할 Product 객체 생성
        pList.add(new Product(1, "카라멜마끼아또", 1, 5000, 1));
        pList.add(new Product(2, "홍차라떼", 2, 5000, 2));
        pList.add(new Product(3, "초코라떼", 2, 5000, 3));  // 초코라떼 한 번만 남김
        pList.add(new Product(4, "오레오", 3, 5000, 4));
        pList.add(new Product(5, "초코라떼", 2, 4500, 5));  // 가격이 다른 경우는 중복으로 처리하지 않음
        pList.add(new Product(6, "복숭아스무디", 4, 5000, 6));
        pList.add(new Product(7, "커피콩빵", 5, 3000, 7));
        pList.add(new Product(8, "바니라라떼", 1, 5000, 8));
        pList.add(new Product(9, "매실차", 6, 4500, 9));
        pList.add(new Product(10, "깔라만시", 6, 4500, 10));
        pList.add(new Product(11, "카페라떼", 1, 4000, 10));
        pList.add(new Product(12, "헤이즐넛라떼", 1, 5000, 10));
        pList.add(new Product(13, "아메리카노", 1, 4000, 10));
        pList.add(new Product(14, "캐모마일", 6, 4500, 10));
        pList.add(new Product(15, "아포가또", 3, 5500, 10));
        pList.add(new Product(16, "비엔나커피", 1, 5000, 10));
        pList.add(new Product(17, "베이글", 5, 3500, 10));
        pList.add(new Product(18, "카푸치노", 1, 4000, 10));
        pList.add(new Product(19, "허니브레드", 5, 6000, 10));
        pList.add(new Product(20, "얼그레이", 6, 4500, 10));
        pList.add(new Product(21, "레몬에이드", 3, 5000, 10));
        return pList;
    }

//    private static void showCategoryDescription(ArrayList<Category> categories) {
//        Category category = null; // 카테고리 id가 3인 카테고리 객체를 저장할 변수
//        for(Category c : categories){
//            if(c.getCategoryId() == 3){
//                category = c; // 카테고리id가 3인 카ㅔ고리 객체를 찾아서 category 변수에 저장
//                break;
//            }
//        }
//        System.out.println("카테고리 id가 3인 카테고리의 설명: " + category.getDescription());
//    }


    /**
     * 카테고리 기본 데이터를 생성하여 ArrayList에 추가하는 메소드
     * @return : Category 객체가 추가된 ArrayList 반환
     *
     */

    public static ArrayList<Category> initializeCategoryData(){
        // 1. Category 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Category> categorieslist = new ArrayList<>();
        // 2. ArrayList에 추가할 Category 객체 생성
        Category c1 = new Category(1, "Coffee", "모든 종류의 커피");
        Category c2 = new Category(2, "Latte", "다양한 종류의 라떼");
        Category c3 = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        Category c4 = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        Category c5 = new Category(5, "Bakery", "갓 구은 빵");
        Category c6 = new Category(6, "Tea", "전통 차와 허브 차");
        // 3. 생성한 카테고리 객체들을 각각 ArrayList에 추가해줌
        categorieslist.add(c1);
        categorieslist.add(c2);
        categorieslist.add(c3);
        categorieslist.add(c4);
        categorieslist.add(c5);
        categorieslist.add(c6);
        // 4. 생성한 ArrayList 반환
        return categorieslist;
    }
}
