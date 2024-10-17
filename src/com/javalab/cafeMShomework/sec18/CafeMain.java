package com.javalab.cafeMShomework.sec18;

public class CafeMain {
    public static void main(String[] args) {
        // 1. 카테고리 데이터 생성 및 초기화
        Category[] categories = initializeCategoryData();

        // 2. 상품 데이터 생성 및 초기화
        Product[] products = initializePriductData();

        //  카테고리 데이터 출력
        printCategoryData(categories);

        // 상품 클래스 데이터 출력
        printProductData(products);
    }

    private static void printProductData(Product[] products) {
        System.out.println("============================================================");
        System.out.println("ProductId      productName        categoryId        price");
        for (Product product : products){
            System.out.println(product.getProductId() + "\t\t\t" + product.getName() + "\t\t\t\t" + product.getCategoryId() + "\t\t\t\t" + product.getPrice());
        }
    }

    /**
     * 카테고리 데이터 출력
     * @param categories
     */
    private static void printCategoryData(Category[] categories){
        System.out.println("============================================================");
        System.out.println("CategoryId      Name                Description");
        for (Category category : categories){
            System.out.println(category.getCategoryId() + "\t\t\t" + category.getName() + "\t\t\t\t" + category.getDescription());
        }
    }

    // 카테고리 객체 저장용 배열 6개
    private static Category[] initializeCategoryData(){
        Category[] categories = new Category[6];
        categories[0] = new Category(1, "Coffe", "모든 종류의 커피");
        categories[1] = new Category(2, "Latte", "다양한 종류의 라떼");
        categories[2] = new Category(3, "Ade/Shake", "신선한 에이드와 쉐이크");
        categories[3] = new Category(4, "Smoothie/Juice", "건강한 스무디와 주스");
        categories[4] = new Category(5, "Bakery", "갓 구은 빵");
        categories[5] = new Category(6, "Tea", "전통 차와 허브 차");
        return categories;
    }

    // 상품 객체 저장용 배열 28개
    private static Product[] initializePriductData(){
        Product[] products = new Product[28];
        products[0] = new Product(1,"카라멜마끼아또",  1, 5000);
        products[1] = new Product(2,"홍차라떼",  2, 5000);
        products[2] = new Product(3,"초코라떼",  2, 5000);
        products[3] = new Product(4,"오레오",  3, 5000);
        products[4] = new Product(5,"카라멜마끼아또",  1, 5000);
        products[5] = new Product(6,"초코라떼",  2, 4500);
        products[6] = new Product(7,"복숭아스무디",  4, 5000);
        products[7] = new Product(8,"커피콩빵",  5, 3000);
        products[8] = new Product(9,"바니라라떼",  1, 5000);
        products[9] = new Product(10,"매실차",  6, 4500);
        products[10] = new Product(11,"깔라만시",  6, 4500);
        products[11] = new Product(12,"카페라떼",  1, 4000);
        products[12] = new Product(13,"헤이즐넛라떼",  1, 5000);
        products[13] = new Product(14,"카라멜마끼아또",  1, 5000);
        products[14] = new Product(15,"아메리카노",  1, 4000);
        products[15] = new Product(16,"캐모마일",  6, 4500);
        products[16] = new Product(17,"아포가또",  3, 5500);
        products[17] = new Product(18,"비엔나커피",  1, 5000);
        products[18] = new Product(19,"베이글",  5, 3500);
        products[19] = new Product(20,"카푸치노",  1, 4000);
        products[20] = new Product(21,"허니브레드",  5, 6000);
        products[21] = new Product(22,"카페모카",  1, 5000);
        products[22] = new Product(23,"얼그레이",  6, 4500);
        products[23] = new Product(24,"히비아이스트",  3, 5000);
        products[24] = new Product(25,"플레인 와플",  5, 6000);
        products[25] = new Product(26,"요거트",  3, 5500);
        products[26] = new Product(27,"유자스무디",  4, 5000);
        products[27] = new Product(28,"딸기스무디",  4, 5000);
        return products;
    }
}
