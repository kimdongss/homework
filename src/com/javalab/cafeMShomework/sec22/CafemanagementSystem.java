package com.javalab.cafeMShomework.sec22;


import java.util.ArrayList;


public class CafemanagementSystem {
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

        // 직원 데이터 생성 및 호출
        ArrayList<Employee> employees = initializeEmployeeData();

        // 주문 데이터 생성 및 호출
        ArrayList<Order> orders = initializeOrderData();


        // 새로운 사원을 추가 하고 결과를 프린트
        employees = addNewEmployeeData(employees);

        // 두 건의 주문을 추가
        orders = addNewOrderData(orders);

        // 전체 주문 목록을 조회
        showTotalOrderList(orders, products, employees, categories);

        // 주문의 가격이 5000원 이상인 주문을 조회합니다.
        showOver5000WonOrder(orders, products);

        // Charlie 사원이 처리한 주문만 조회합니다.
        showOrderByCharlie(orders,employees);

        // 커피 카테고리에 속한 주문만 조회 (별도의 ArrayList 사용)
        showCoffeeCategoryProduct(categories, orders, products);

        // 카테고리별로 주문 합계 금액을 조회
        showOrderByCategory(categories, orders, products);


    } // end of main

    // 1번 for문은 카테고리 2반for문은 주문, 2번째 for문 안에서 o.상품아이디를 이용해서 상품을 찾아오고 if문으로 그 상품의 카테고리아이디와 c.카테고리 아이디가 같으면 변수를 선언해서 주문금액을 계산해서 누적 합산, 변수선언과 프린트문은 1번째 for문 안 2번째 for문 밖에서
    private static void showOrderByCategory(ArrayList<Category> categories, ArrayList<Order> orders, ArrayList<Product> products) {
        System.out.println("<< 카테고리 별 주문금액 조회 >>");
        for(Category c : categories){
            int TotalAmountByCategory = 0;
            for(Order o : orders){
                Product product = findProductById(products, o.getProductId());
                if(product.getCategoryId() == c.getCategoryId()){
                    TotalAmountByCategory += product.getPrice() * o.getQuantity();
                }
            }
            System.out.println("카테고리: " + c.getName() + "의 주문 합계는: " + TotalAmountByCategory + "원 입니다.");
        }
    }

    private static void showCoffeeCategoryProduct(ArrayList<Category> categories, ArrayList<Order> orders, ArrayList<Product> products) {
        ArrayList<Order> CoffeeList = new ArrayList<Order>(); // 카테고리에서 커피인인 상품 객체를 저장할 ArrayList
        for(Order o : orders){
            Category category = findCoffeeByName(categories, "Coffee");
            Product product = findProductById(products, o.getProductId());
            if (product.getCategoryId() == category.getCategoryId()){ // 주문 상품 중 커피 카테고리인 것
                CoffeeList.add(o); // 상품이름이 초코라떼인 상품 객체를 chocoLatteList에 추가
            }
        }

        //chocoLatteList에 저장된 카테고리 객체 출력
        System.out.println("카테고리가 '커피'인 주문상품 출력");
        for(Order o : CoffeeList){
            System.out.println("주문번호    주문일자        상품아이디   주문수량    처리사원");
            System.out.println(o.getOrderId() + " " + o.getOrderDate() + "\t" + o.getProductId() + "\t\t" + o.getQuantity() + "\t\t\t" + o.getEmployeeId());
        }

    }

    private static Category findCoffeeByName(ArrayList<Category> categories, String coffee) {
        for (Category c : categories){
            if (c.getName().equals("Coffee")){
                return c;
            }
        }
        return null;
    }

    // 주문 프린트하면 너무 많으니 건수로 프린트
    private static void showOrderByCharlie(ArrayList<Order> orders, ArrayList<Employee> employees) {
        System.out.println("<< Charlie 사원이 처리한 주문 조회 >>");
        int cOrderCount = 0;
        Employee employee = findCharlieByName(employees, "Charlie");
        if (employee != null){
            for (Order order : orders){
                if (employee.getEmployeeId() == order.getEmployeeId()){
                    cOrderCount++;
                }
            }
        }
        System.out.println("charlie 사원이 처리한 주문은 총: " + cOrderCount + "건입니다.");
    }

    private static Employee findCharlieByName(ArrayList<Employee> employees, String charlie) {
        for (Employee employee : employees){
            if (employee.getName().equals("Charlie")){
                return employee;
            }
        }
        return null;
    }

    // 주문 프린트하면 너무 많으니까 건수로 프린트
    private static void showOver5000WonOrder(ArrayList<Order> orders, ArrayList<Product> products) {
        System.out.println("<< 주문금액이 5000원 이상인 주문 조회 >>");
        int i = 0;
        for(Order o : orders){
            int totalAmount = 0;
            Product product = findProductById(products, o.getProductId());
            totalAmount = o.getQuantity() * product.getPrice();
                if (totalAmount >= 5000) {
                    i++;
//                    System.out.println(o.getOrderId());
                }
        }
        System.out.println("5천원 이상의 주문은 총 " + i + "건입니다.");
    }


    // o.주문번호,주문일자,상품번호,사번,주문수량 / o.pid<->p."상품명" orderdata에 있는 productId로 productData와 비교해서 맞는거 name 가져오면됌 /
    // 카테고리명 productId로 productData가서 categoryId 가져온다음 CategoryData가서 name 가져오면됌
    // 사원명 o.사원번호로 employeeData가서 이름가져오면됌
    // 총 주문금액 상품페이지가서 가격을 가져와서 주문수량과 곱한 후 출력
    // 상품데이터에서 o.productId로 상품이름, 가격, 카테고리id 가져오기,  카테고리데이터에서 p.카테고리id로 카테고리명가져오기, 사원데이터에서 o.사번번호로 사원이름가져오기
    private static void showTotalOrderList(ArrayList<Order> orders, ArrayList<Product> products, ArrayList<Employee> employees, ArrayList<Category> categories) {
        System.out.println("=================================================================");
        System.out.println("주문번호 주문일자 상품번호 상품명 카테고리명 사원번호 사원명 주문수량 총주문금액");
        System.out.println("-----------------------------------------------------------------");
        for (Order o : orders) {
            int totalAmount = 0;
            Product product = findProductById(products, o.getProductId());
            Category category = findCategoryById(categories, product.getCategoryId());
            Employee employee = findEmployeeById(employees, o.getEmployeeId());
            totalAmount = o.getQuantity() * product.getPrice();

            System.out.println(o.getOrderId() + " " + o.getOrderDate() + " " + o.getProductId() + " " + product.getName() + " " + category.getName() + " " + o.getEmployeeId() + " " + employee.getName() + " " + o.getQuantity() + " " + totalAmount);
        }
        System.out.println("=================================================================");
    }

    private static Employee findEmployeeById(ArrayList<Employee> employees, int employeeId){
        for (Employee e : employees) {
            if (e.getEmployeeId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    private static Category findCategoryById(ArrayList<Category> categories, int categoryId){
        for (Category c : categories) {
            if (c.getCategoryId() == categoryId) {
                return c;
            }
        }
        return null;
    }

    private static Product findProductById(ArrayList<Product> products, int productId){
        for (Product p : products) {
            if (p.getProductId() == productId) {
                return p;
            }
        }
        return null;
    }



    private static ArrayList<Order> addNewOrderData(ArrayList<Order> orders) {
        orders.add(new Order(84938492, "2024-10-18 13:00", 10, 206, 2));
        orders.add(new Order(84938493, "2024-10-18 15:00", 11, 203, 3));
        System.out.println("=== 주문 2건 추가 완료 ===");
        return orders;
    }

    private static ArrayList<Employee> addNewEmployeeData(ArrayList<Employee> employees) {
        employees.add(new Employee(206, "scott", "차장", 6000));
        System.out.println("=== 사원 추가 후 리스트 ===");
        for (Employee e : employees) {
            System.out.println(e.getEmployeeId() + " " + e.getName() + " " + e.getPosition() + " " + e.getSalary());
        }
        return employees;


    }


    private static ArrayList<Order> initializeOrderData() {
        // 1. Order 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Order> oList = new ArrayList<>();
        // 2. ArrayList에 추가할 Order 객체 생성
        oList.add(new Order(38167661, "2017-09-13 10:15", 1, 201, 1));
        oList.add(new Order(89217292, "2017-09-13 10:20", 2, 201, 1));
        oList.add(new Order(39178813, "2017-09-13 10:40", 3, 201, 1));
        oList.add(new Order(63105814, "2017-09-13 10:05", 4, 201, 1));
        oList.add(new Order(47018155, "2017-09-13 11:15", 5, 201, 1));
        oList.add(new Order(46078736, "2017-09-13 11:25", 6, 201, 1));
        oList.add(new Order(32215457, "2017-09-13 11:35", 7, 201, 1));
        oList.add(new Order(60728468, "2017-09-13 11:45", 8, 201, 1));
        oList.add(new Order(99145989, "2017-09-13 11:50", 9, 201, 1));
        oList.add(new Order(65700651, "2017-09-13 12:00", 8, 202, 1));
        oList.add(new Order(65700622, "2017-09-13 12:00", 7, 202, 1));
        oList.add(new Order(65700633, "2017-09-13 12:00", 6, 202, 1));
        oList.add(new Order(65700654, "2017-09-13 12:00", 5, 202, 1));
        oList.add(new Order(54449845, "2017-09-13 12:10", 4, 202, 1));
        oList.add(new Order(66578206, "2017-09-13 12:15", 3, 202, 1));
        oList.add(new Order(79287287, "2017-09-13 12:35", 3, 202, 1));
        oList.add(new Order(56679568, "2017-09-13 12:50", 6, 203, 1));
        oList.add(new Order(39865399, "2017-09-13 12:55", 4, 203, 1));
        oList.add(new Order(49791941, "2017-09-13 13:15", 6, 203, 1));
        oList.add(new Order(49791942, "2017-09-13 13:15", 8, 203, 1));
        oList.add(new Order(49791943, "2017-09-13 13:15", 11, 203, 1));
        oList.add(new Order(49791944, "2017-09-13 13:15", 12, 203, 1));
        oList.add(new Order(73592625, "2017-09-13 13:30", 13, 203, 1));
        oList.add(new Order(57111296, "2017-09-13 13:45", 14, 203, 1));
        oList.add(new Order(57111297, "2017-09-13 13:45", 15, 203, 1));
        oList.add(new Order(57111298, "2017-09-13 13:45", 16, 203, 1));
        oList.add(new Order(57111299, "2017-09-13 13:45", 17, 203, 1));
        oList.add(new Order(69598401, "2017-09-13 13:05", 18, 203, 1));
        oList.add(new Order(69598402, "2017-09-13 13:05", 19, 203, 1));
        oList.add(new Order(69598403, "2017-09-13 13:05", 20, 203, 1));
        oList.add(new Order(69598404, "2017-09-13 13:05", 21, 205, 1));
        oList.add(new Order(67173435, "2017-09-13 14:30", 21, 205, 1));
        oList.add(new Order(67173436, "2017-09-13 14:30", 21, 205, 1));
        oList.add(new Order(67173437, "2017-09-13 14:30", 21, 205, 1));
        oList.add(new Order(67173438, "2017-09-13 14:30", 15, 205, 1));
        oList.add(new Order(36320861, "2017-09-13 14:35", 15, 205, 1));
        oList.add(new Order(71781102, "2017-09-13 14:05", 15, 205, 1));
        oList.add(new Order(55756203, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(55756204, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(55756205, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(55756206, "2017-09-13 14:55", 15, 205, 1));
        oList.add(new Order(22817527, "2017-09-13 15:00", 21, 205, 1));
        oList.add(new Order(55183918, "2017-09-13 15:15", 11, 205, 1));
        oList.add(new Order(39118499, "2017-09-13 15:40", 12, 205, 1));
        oList.add(new Order(56152541, "2017-09-13 15:45", 13, 204, 1));
        oList.add(new Order(44004392, "2017-09-13 16:45", 14, 204, 1));
        oList.add(new Order(57522353, "2017-09-13 16:55", 15, 204, 1));
        oList.add(new Order(57522354, "2017-09-13 16:55", 17, 204, 1));
        oList.add(new Order(57522355, "2017-09-13 16:55", 19, 204, 1));
        oList.add(new Order(57522356, "2017-09-13 16:55", 20, 204, 1));
        oList.add(new Order(97267867, "2017-09-13 17:40", 20, 204, 1));
        oList.add(new Order(23534038, "2017-09-13 17:55", 20, 204, 1));
        oList.add(new Order(91629259, "2017-09-13 18:20", 20, 204, 1));
        oList.add(new Order(37776981, "2017-09-13 19:15", 20, 204, 1));
        oList.add(new Order(46888642, "2017-09-13 19:20", 21, 204, 1));
        oList.add(new Order(47293153, "2017-09-13 19:25", 13, 203, 1));
        oList.add(new Order(34402594, "2017-09-13 20:25", 1, 203, 1));
        oList.add(new Order(75967085, "2017-09-13 20:45", 2, 203, 1));
        oList.add(new Order(41288266, "2017-09-13 20:55", 3, 203, 1));
        oList.add(new Order(38559077, "2017-09-13 21:25", 4, 203, 1));
        oList.add(new Order(16229008, "2017-09-13 21:40", 5, 203, 1));
        oList.add(new Order(59480819, "2017-09-13 22:00", 14, 203, 1));
        oList.add(new Order(96791241, "2017-09-13 22:10", 15, 203, 1));
        oList.add(new Order(50021772, "2017-09-13 22:35", 16, 203, 1));
        oList.add(new Order(55861803, "2017-09-13 22:40", 17, 203, 1));
        oList.add(new Order(68585784, "2017-09-13 22:50", 18, 203, 1));
        oList.add(new Order(92127745, "2017-09-13 22:55", 21, 203, 1));
        oList.add(new Order(92127746, "2017-09-13 22:55", 21, 203, 1));
        oList.add(new Order(92127747, "2017-09-13 22:55", 21, 203, 1));
        oList.add(new Order(92127748, "2017-09-13 22:55", 21, 202, 1));
        oList.add(new Order(94113279, "2017-09-13 23:15", 15, 202, 1));
        oList.add(new Order(17708771, "2017-09-13 23:20", 16, 202, 1));
        oList.add(new Order(71621022, "2017-09-13 23:25", 17, 202, 1));
        oList.add(new Order(49305843, "2017-09-13 23:45", 12, 202, 1));
        return oList;
    }

    private static ArrayList<Employee> initializeEmployeeData() {
        // 1. Employee 객체를 저장할 수 있는 ArrayList 객체 생성
        ArrayList<Employee> eList = new ArrayList<>();
        // 2. ArrayList에 추가할 Employee 객체 생성
        eList.add(new Employee(201, "Alice", "사원", 3000));
        eList.add(new Employee(202, "Bob", "대리", 4000));
        eList.add(new Employee(203, "Charlie", "과장", 5000));
        eList.add(new Employee(204, "David", "사원", 3200));
        eList.add(new Employee(205, "Eve", "대리", 4200));
        return eList;
    }


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
