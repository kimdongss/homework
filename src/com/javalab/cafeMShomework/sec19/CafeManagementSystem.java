package com.javalab.cafeMShomework.sec19;

import com.javalab.cafeMShomework.sec18.Category;
import com.javalab.cafeMShomework.sec18.Employee;
import com.javalab.cafeMShomework.sec18.Order;
import com.javalab.cafeMShomework.sec18.Product;

public class CafeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Cafe Management System");

        // 1. 카테고리 데이터 생성 및 초기화
        Category[] categories = initializeCategoryData();

        // 2. 상품 데이터 생성 및 초기화
        Product[] products = initializeProductData();

//        //  카테고리 데이터 출력
//        printCategoryData(categories);
//
//        // 상품 클래스 데이터 출력
//        printProductData(products);

        // 3. 특정 카테고리에 속한 상품들 출력, 카테고리 이름을 전달해서 해당 카테고리에 속한 상품들을 반환받자
        Product[] categoryProducts = getProductsByCategoryName("Coffee", categories, products);

        // 4. 찾아진 카테고리에 소속된 상품들 출력하기, 메소드로 분리
        printProductListWithCategoryName(categoryProducts);

        // 5. 상품의 이름으로 상품 1개만 조회
        Product product = findProductByName("초코라떼", products);

        // 6. 찾은 상품을 출력하기
        printProduct(product);

        // 7. 특정 상품의 가격을 변경
        updateProductPrice("초코라떼", 6000, products); // 기존가격 5000 -> 6000

        // 8. 빵 종류의 상품 가격을 밀가루 값 인상으로 15% 인상
        increaseBakeryPrice(products); // 빵 카테고리 = 5

        // 9. 사원 기초 데이터 생성 및 초기화
        Employee[] employees = initializeEmployeeData();

        // 10. 주문 기초 데이터 생성 및 초기화
        Order[] orders = initializeOrderDate();

        // 11. 주문을 처리하는 메소드
        // 주문을 처리하는 직원데이터에서
        // "Alice" 사원이 2024-10-17 03:52에 1번상품을 2개 주문하는 건을 처리함
        // order 객체 생성
//        Order order1 = new Order(1, "2024-10-17 03:52", 1, 201, 2);
//        // 주문 추가 메소드
//        addOrder(order1, orders);

        // 12. 주문 데이터 출력
        // - 주문정보 출력할 때 상품의 단가 출력(주문에 대한 totalAmount)
        showOrderData(categories, products, orders, employees);

        // 13. 주문 통계 출력 메소드
        // - 총 주문 금액(중) -매출
        // - 가장 큰 주문액
        showOrderStatistics(orders, categories, products, employees);

        // 과제 1. 사원별 주문 처리 건수 2. 가장 많이 판매된 상품 3. 최고 매출을 기록한 사원 (이중for문)



    } // end of main

    private static void showOrderStatistics(Order[] orders, Category[] categories, Product[] products, Employee[] employees) {
        int totalsales = 0; // 주문의 총 매출
        int maxOrderAmount = 0;
        int mostPopularProductId = 0;
        for(Order order : orders){
            Product product = findProductById(order.getProductId(), products);
            int orderAmount = product.getPrice() * order.getQuantity();
            totalsales += orderAmount; // 주문금액을 누적해서 더하기 (totalsales에 담기)
            if (orderAmount > maxOrderAmount){
                maxOrderAmount = orderAmount;
            }


        }
        System.out.println("현재 주문의 총 매출은: $" + totalsales);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("주문 중 가장 큰 주문액은: $" + maxOrderAmount);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        // 1. 사원 별 주문 처리 건수 사원아이디, 주문데이터의 사원아이디 비교 후 같으면 주문처리 건수를 변수선언해서 카운드 후치가산하여 저장하고 1번째 for문 속 2번째 for문 밖에서선언 및 프린트
        for (Employee employee : employees) {
            int orderByEmployeecount = 0;
            for(Order order : orders){
                if(order.getEmployeeId() == employee.getEmployeeId()){
                    orderByEmployeecount++;
                }
            }
            System.out.println("사원이름: " + employee.getName() + "사번: " + employee.getEmployeeId() + "의 주문 처리 건수는: " + orderByEmployeecount + "번 입니다.");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        }

        // 2. 최고 매출을 기록한 사원
        // 사원별로 총 매출을 계산, 첫 번째 for문 order, 2번째 for문 employee, 2번째 for문 안에서 if문으로 사번이 주문의 사번과 같을 때, order.주문수량과 product. 가격을 곱해서 변수에 누적저장, 변수 선언은 2번째 for문 밖에서하고
        // find를 order for문 안에서 써서 orderId에 해당하는 product를 가져온다.가져와서 상품의 가격을 계산식에 사용한다.
        // 2번째 for문 밖 1번째 for문 안 사원별 매출액을 if문으로 비교하여 최고 매출액이 갱신될때 최고 매출액을 변수에 저장하고 해당사원을 같이 해당 변수에 저장하도록하여(employee for문 이용) 마지막에 if문으로 갱신되어 저장된 사원의 이름과 최고 매출액을 프린트

        int topSalesAmount = 0; // 최고매출액을 저장
        int topSalesEmId = 0;
        String topSalesEmName = null;
        for(Employee employee : employees){
            int totalAmountOfEmployee = 0;
            for(Order order : orders) {
                Product product = findPriceByProductId(order.getProductId(), products);
                if (employee.getEmployeeId() == order.getEmployeeId()) {
                    totalAmountOfEmployee += order.getQuantity() * product.getPrice();
                }

            }
            if (totalAmountOfEmployee > topSalesAmount){
                topSalesAmount = totalAmountOfEmployee;
                topSalesEmId = employee.getEmployeeId();
                topSalesEmName = employee.getName();
            }
            System.out.println(employee.getName() + "사원의 총 판매량은 " + totalAmountOfEmployee);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        }System.out.println("최고 매출액을 달성한 사원명: " + topSalesEmName + " 사번: " + topSalesEmId + "번" + " $" + topSalesAmount);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");



        //3. 가장 많이 판매된 상품
        // 첫번째 for문 product 2번째 for문 order
        // 2번째 for문 안 if문으로 product.id와 order.productId가 같으면 order.quantity를 누적저장 저장하는 변수선언 및 초기화(0)는 1번째 for문 안 2번째 for문 밖
        // 그렇게 저장된 변수를 새로운 변수와 if 문으로 비교하여 더큰게 오면 그 변수를 새로운 변수에 저장하고 그 레벨에서 상품의 이름과 총 판매갯수를 저장하고 1번째 for문 밖에서 변수를 이용하여 프린트
        // 변수를 잡아먹지 않고 리턴하여 프린트메소드를 따로 만들면 좋지만 일단.... 구현 먼저...
        int topOrderQuantity = 0;
        String topOrderProductName = null;
        for(Product product : products) {
            int totalOrderQuantity = 0;
            for(Order order : orders) {
                if(product.getProductId() == order.getProductId()) {
                    totalOrderQuantity += order.getQuantity();
                }
            }
            if(totalOrderQuantity > topOrderQuantity){
                topOrderQuantity = totalOrderQuantity;
                topOrderProductName = product.getName();
            }
        }
        System.out.println("가장 많이 팔린 제품은: " + topOrderProductName + "이고 판매 수량은: " + topOrderQuantity + "개 입니다.");
    }




    private static Product findPriceByProductId(int productId, Product[] products) {
        for(Product product : products){
            if(product.getProductId() == productId){
                return product;
            }
        }
        return null;
    }


    private static void showOrderData(Category[] categories, Product[] products, Order[] orders, Employee[] employees) {
        System.out.println("<< 주문 데이터 출력 >>");
        System.out.println("===================================================================================================================================");
        System.out.println("OrderId    OrderDate            ProductId    ProductName     CategoryName   EmployeeId   EmployeeName      Quantity     totalAmount");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        double totalAmount =0; // 주문수량 * 상품 가격을 담을 변수 선언 int 형으로 해도 상관 없음
        for (Order order : orders){
            // 상품 정보 출력
            Product product = findProductById(order.getProductId(), products);
            totalAmount = product.getPrice() * order.getQuantity();
//            System.out.println("상품명: " + product.getName());
            // 카테고리 정보 출력
            Category category = findCategoryById(product.getCategoryId(), categories);
//            System.out.println("카테고리: " + category.getName());
            // 사원 정보 출력
            Employee employee = findEmployeeById(order.getEmployeeId(), employees);
//            System.out.println("사원명: " + employee.getName());
            // 주문 정보 출력
            System.out.println(order.getOrderId() + "\t" + order.getOrderDate() + "\t" + order.getProductId() + "\t\t\t" + product.getName() + "\t\t\t" + category.getName() + "\t\t\t" + order.getEmployeeId() + "\t\t\t" + employee.getName()  + "\t\t\t\t" + order.getQuantity() + "\t\t\t$" + totalAmount );
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        }

    }

    /**
     * 사원 id로 사원 객체 찾기
     * @param employeeId
     * @param employees
     */
    private static Employee findEmployeeById(int employeeId, Employee[] employees) {
        for(Employee employee : employees){
            if(employee.getEmployeeId() == employeeId){
                return employee;
            }
        }
        return null;
    }

    /**
     * 특정 카테고리 조회
     * - 전달된 카테고리id로 카테고리 배열에서 해당 객체 찾아서 반환
     * @ priductId
     */
    private static Category findCategoryById(int categoryId, Category[] categories) {
        for(Category category : categories){
            if(category.getCategoryId() == categoryId){
                return category;
            }
        }
        return null;
    }

    // 현재 주문이 갖고 있는 상품 id와 동일한 상품 객체를 찾아서 반환.
    private static Product findProductById(int productId, Product[] products) {
        for(Product product : products) {
            if(product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }


    private static Order[] initializeOrderDate() {
        // Order 객체 생성
        Order[] orders = new Order[74];
        orders[0] = new Order(38167661, "2017-09-13 10:15", 1, 201, 1);
        orders[1] = new Order(89217292, "2017-09-13 10:20", 2, 201, 1);
        orders[2] = new Order(39178813, "2017-09-13 10:40", 3, 201, 1);
        orders[3] = new Order(63105814, "2017-09-13 10:05", 4, 201, 1);
        orders[4] = new Order(47018155, "2017-09-13 11:15", 5, 201, 1);
        orders[5] = new Order(46078736, "2017-09-13 11:25", 6, 201, 1);
        orders[6] = new Order(32215457, "2017-09-13 11:35", 7, 201, 1);
        orders[7] = new Order(60728468, "2017-09-13 11:45", 8, 201, 1);
        orders[8] = new Order(99145989, "2017-09-13 11:50", 9, 201, 1);
        orders[9] = new Order(65700651, "2017-09-13 12:00", 8, 202, 1);
        orders[10] = new Order(65700622, "2017-09-13 12:00", 7, 202, 1);
        orders[11] = new Order(65700633, "2017-09-13 12:00", 6, 202, 1);
        orders[12] = new Order(65700654, "2017-09-13 12:00", 5, 202, 1);
        orders[13] = new Order(54449845, "2017-09-13 12:10", 4, 202, 1);
        orders[14] = new Order(66578206, "2017-09-13 12:15", 3, 202, 1);
        orders[15] = new Order(79287287, "2017-09-13 12:35", 3, 202, 1);
        orders[16] = new Order(56679568, "2017-09-13 12:50", 6, 203, 1);
        orders[17] = new Order(39865399, "2017-09-13 12:55", 4, 203, 1);
        orders[18] = new Order(49791941, "2017-09-13 13:15", 6, 203, 1);
        orders[19] = new Order(49791942, "2017-09-13 13:15", 8, 203, 1);
        orders[20] = new Order(49791943, "2017-09-13 13:15", 11, 203, 1);
        orders[21] = new Order(49791944, "2017-09-13 13:15", 12, 203, 1);
        orders[22] = new Order(73592625, "2017-09-13 13:30", 13, 203, 1);
        orders[23] = new Order(57111296, "2017-09-13 13:45", 14, 203, 1);
        orders[24] = new Order(57111297, "2017-09-13 13:45", 15, 203, 1);
        orders[25] = new Order(57111298, "2017-09-13 13:45", 16, 203, 1);
        orders[26] = new Order(57111299, "2017-09-13 13:45", 17, 203, 1);
        orders[27] = new Order(69598401, "2017-09-13 13:05", 18, 203, 1);
        orders[28] = new Order(69598402, "2017-09-13 13:05", 19, 203, 1);
        orders[29] = new Order(69598403, "2017-09-13 13:05", 20, 203, 1);
        orders[30] = new Order(69598404, "2017-09-13 13:05", 21, 205, 1);
        orders[31] = new Order(67173435, "2017-09-13 14:30", 21, 205, 1);
        orders[32] = new Order(67173436, "2017-09-13 14:30", 21, 205, 1);
        orders[33] = new Order(67173437, "2017-09-13 14:30", 21, 205, 1);
        orders[34] = new Order(67173438, "2017-09-13 14:30", 15, 205, 1);
        orders[35] = new Order(36320861, "2017-09-13 14:35", 15, 205, 1);
        orders[36] = new Order(71781102, "2017-09-13 14:05", 15, 205, 1);
        orders[37] = new Order(55756203, "2017-09-13 14:55", 15, 205, 1);
        orders[38] = new Order(55756204, "2017-09-13 14:55", 15, 205, 1);
        orders[39] = new Order(55756205, "2017-09-13 14:55", 15, 205, 1);
        orders[40] = new Order(55756206, "2017-09-13 14:55", 15, 205, 1);
        orders[41] = new Order(22817527, "2017-09-13 15:00", 21, 205, 1);
        orders[42] = new Order(55183918, "2017-09-13 15:15", 11, 205, 1);
        orders[43] = new Order(39118499, "2017-09-13 15:40", 12, 205, 1);
        orders[44] = new Order(56152541, "2017-09-13 15:45", 13, 204, 1);
        orders[45] = new Order(44004392, "2017-09-13 16:45", 14, 204, 1);
        orders[46] = new Order(57522353, "2017-09-13 16:55", 15, 204, 1);
        orders[47] = new Order(57522354, "2017-09-13 16:55", 17, 204, 1);
        orders[48] = new Order(57522355, "2017-09-13 16:55", 19, 204, 1);
        orders[49] = new Order(57522356, "2017-09-13 16:55", 20, 204, 1);
        orders[50] = new Order(97267867, "2017-09-13 17:40", 20, 204, 1);
        orders[51] = new Order(23534038, "2017-09-13 17:55", 20, 204, 1);
        orders[52] = new Order(91629259, "2017-09-13 18:20", 20, 204, 1);
        orders[53] = new Order(37776981, "2017-09-13 19:15", 20, 204, 1);
        orders[54] = new Order(46888642, "2017-09-13 19:20", 21, 204, 1);
        orders[55] = new Order(47293153, "2017-09-13 19:25", 13, 203, 1);
        orders[56] = new Order(34402594, "2017-09-13 20:25", 1, 203, 1);
        orders[57] = new Order(75967085, "2017-09-13 20:45", 2, 203, 1);
        orders[58] = new Order(41288266, "2017-09-13 20:55", 3, 203, 1);
        orders[59] = new Order(38559077, "2017-09-13 21:25", 4, 203, 1);
        orders[60] = new Order(16229008, "2017-09-13 21:40", 5, 203, 1);
        orders[61] = new Order(59480819, "2017-09-13 22:00", 14, 203, 1);
        orders[62] = new Order(96791241, "2017-09-13 22:10", 15, 203, 1);
        orders[63] = new Order(50021772, "2017-09-13 22:35", 16, 203, 1);
        orders[64] = new Order(55861803, "2017-09-13 22:40", 17, 203, 1);
        orders[65] = new Order(68585784, "2017-09-13 22:50", 18, 203, 1);
        orders[66] = new Order(92127745, "2017-09-13 22:55", 21, 203, 1);
        orders[67] = new Order(92127746, "2017-09-13 22:55", 21, 203, 1);
        orders[68] = new Order(92127747, "2017-09-13 22:55", 21, 203, 1);
        orders[69] = new Order(92127748, "2017-09-13 22:55", 21, 202, 1);
        orders[70] = new Order(94113279, "2017-09-13 23:15", 15, 202, 1);
        orders[71] = new Order(17708771, "2017-09-13 23:20", 16, 202, 1);
        orders[72] = new Order(71621022, "2017-09-13 23:25", 17, 202, 1);
        orders[73] = new Order(49305843, "2017-09-13 23:45", 12, 202, 1);
        return orders;
    }

    private static Employee[] initializeEmployeeData() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(201, "Alice", "사원", 3000);
        employees[1] = new Employee(202, "Bob", "대리", 4000);
        employees[2] = new Employee(203, "Charlie", "과장", 5000);
        employees[3] = new Employee(204, "David", "사원", 3200);
        employees[4] = new Employee(205, "Eve", "대리", 4200);
        return employees;
    }

    /**
     * 빵 카테고리에 속한 상품들의 가격을 밀가루 값 인상으로 15% 인상하는 메소드
     * - 빵 카테고리 : categoryId = 5
     *
     * @param products
     */
    private static void increaseBakeryPrice(Product[] products) {
        for (Product product : products) {
            if (product.getCategoryId() == 5) {
                int beforePrice = product.getPrice();
                int afterPrice = (int) (product.getPrice() * 1.15);
                product.setPrice(afterPrice);
                System.out.println(product.getName() + "의 가격이 $" + beforePrice + "에서 $" + afterPrice + " 로 변경되었습니다. ");
            }
        }
    }

    /**
     * 상품의 가격을 변경하는 메소드
     *
     * @param productName
     * @param price
     * @param products
     */
    private static void updateProductPrice(String productName, int price, Product[] products) { //값이 넘어오는거는 int밖에 없고 나머지는 참조주소만 넘어온다. products는 여러개의 값을 가지고있는Product 타입 배열의 주소이다.
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                int beforePrice = product.getPrice();
                product.setPrice(price);
                System.out.println(product.getName() + "상품의 가격이 $" + beforePrice + "에서 $" + price + "로 변경되었습니다.");

                break;
            }
        }
    }


    private static void printProduct(Product product) {
        System.out.println("============================================================");
        System.out.println("ProductId      productName        CategoryId        Price");
        System.out.println("------------------------------------------------------------");
        System.out.println(product.getProductId() + "\t\t\t\t" + product.getName() + "\t\t\t\t" + product.getCategoryId() + "\t\t\t\t" + product.getPrice());
        System.out.println("============================================================");
    }

    // 상품의 이름으로 상품1개 조회
    private static Product findProductByName(String productName, Product[] products) {
        Product product = null; // 찾아진 상품 객체를 저장할 변수
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                product = p;
                break;
            }
        }
        return product;
    }

    private static void printProductListWithCategoryName(Product[] categoryProducts) {
        // 상품 가격 누적 변수
        int totalAmount = 0;
        System.out.println("============================================================");
        System.out.println("ProductId      productName        CategoryId        Price");
        for (Product product : categoryProducts) {
            if (product == null) {
                break;
            }
            System.out.println(product.getProductId() + "\t\t\t\t" + product.getName() + "\t\t\t\t" + product.getCategoryId() + "\t\t\t\t" + product.getPrice());
            totalAmount += product.getPrice();
        }
        System.out.println("해당 카테고리의 가격 합계는: $" + totalAmount);
        System.out.println("============================================================");
    }


    // 특정 카테고리에 속한 상품들을 반환하는 메소드
    private static Product[] getProductsByCategoryName(String categoryName, Category[] categories, Product[] products) {
        // 1. 전달받은 카테고리 이름과 일치하는 상품 객체들을 저장할 배열 생성
        Product[] categoryProducts = new Product[products.length];

        // 2. 전달받은 카테고리 이름에 해당하는 카테고리의 id를 찾아온다.
        int categoryId = 0;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                categoryId = category.getCategoryId();
                break;
            }
        }
        // 3. 찾은 카테고리 id에 해당하는 상품 객체들을 찾아서 배열에 저장
        int count = 0;
        for (Product product : products) {
            if (product.getCategoryId() == categoryId)
                categoryProducts[count++] = product;
        }
        return categoryProducts;
    }


    // 상품 데이터 출력
//    private static void printProductData(Product[] products) {
//        System.out.println("============================================================");
//        System.out.println("ProductId      productName        categoryId        price");
//        for (Product product : products){
//            System.out.println(product.getProductId() + "\t\t\t" + product.getName() + "\t\t\t\t" + product.getCategoryId() + "\t\t\t\t" + product.getPrice());
//        }
//    }

//    /**
//     * 카테고리 데이터 출력
//     * @param categories
//     */
//    private static void printCategoryData(Category[] categories){
//        System.out.println("============================================================");
//        System.out.println("CategoryId      Name                Description");
//        for (Category category : categories){
//            System.out.println(category.getCategoryId() + "\t\t\t" + category.getName() + "\t\t\t\t" + category.getDescription());
//        }
//    }

    // 카테고리 객체 저장용 배열 6개
    private static Category[] initializeCategoryData() {
        Category[] categories = new Category[6];
        categories[0] = new Category(1, "Coffee", "모든 종류의 커피");
        categories[1] = new Category(2, "Latte", "다양한 종류의 라떼");
        categories[2] = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        categories[3] = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        categories[4] = new Category(5, "Bakery", "갓 구은 빵");
        categories[5] = new Category(6, "Tea", "전통 차와 허브 차");
        return categories;
    }

    // 상품 객체 저장용 배열 28개
    private static Product[] initializeProductData() {
        // 상품 배열
        Product[] products = new Product[21];
        products[0] = new Product(1, "카라멜마끼아또", 1, 5000, 1);
        products[1] = new Product(2, "홍차라떼", 2, 5000, 2);
        products[2] = new Product(3, "초코라떼", 2, 5000, 3);  // 초코라떼 한 번만 남김
        products[3] = new Product(4, "오레오", 3, 5000, 4);
        products[4] = new Product(5, "초코라떼", 2, 4500, 5);  // 가격이 다른 경우는 중복으로 처리하지 않음
        products[5] = new Product(6, "복숭아스무디", 4, 5000, 6);
        products[6] = new Product(7, "커피콩빵", 5, 3000, 7);
        products[7] = new Product(8, "바니라라떼", 1, 5000, 8);
        products[8] = new Product(9, "매실차", 6, 4500, 9);
        products[9] = new Product(10, "깔라만시", 6, 4500, 10);
        products[10] = new Product(11, "카페라떼", 1, 4000, 10);
        products[11] = new Product(12, "헤이즐넛라떼", 1, 5000, 10);
        products[12] = new Product(13, "아메리카노", 1, 4000, 10);
        products[13] = new Product(14, "캐모마일", 6, 4500, 10);
        products[14] = new Product(15, "아포가또", 3, 5500, 10);
        products[15] = new Product(16, "비엔나커피", 1, 5000, 10);
        products[16] = new Product(17, "베이글", 5, 3500, 10);
        products[17] = new Product(18, "카푸치노", 1, 4000, 10);
        products[18] = new Product(19, "허니브레드", 5, 6000, 10);
        products[19] = new Product(20, "얼그레이", 6, 4500, 10);
        products[20] = new Product(21, "레몬에이드", 3, 5000, 10);
        return products;
    }
}
