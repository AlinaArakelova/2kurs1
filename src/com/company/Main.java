package com.company;

import com.company.market.Market;
import com.company.person.customer.Customer;
import com.company.person.seller.Seller;
import com.company.product.Product;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/*public class Main {

    public static void main(String[] args) {
        Market market = new Market();

        Seller firstSeller = createFirstSeller();
        Seller secondSeller = createSecondSeller();

        market.addSeller(firstSeller);
        market.addSeller(secondSeller);

        Customer customer = createFirstCustomer();
        customer.findProductOnMarket(market, "Алина", "Аракелова");
        customer.info();
    }
    private static Customer createFirstCustomer() {
        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setQuantity(3);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setQuantity(2);

        return new Customer(List.of(firstProduct,secondProduct), 50);
    }

    private static Seller createFirstSeller() {
        Seller seller = new Seller();
        seller.setName("Алина");
        seller.setLastName("Аракелова");
        seller.setCash(0);

        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setPrice(10);
        firstProduct.setQuantity(0);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setPrice(8);
        secondProduct.setQuantity(100);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);
        seller.setProducts(products);

        return seller;


    }

    private static Seller createSecondSeller(){
        Seller seller = new Seller();
        seller.setName("Гэвин");
        seller.setLastName("Кэннеди");
        seller.setCash(0);

        Product firstProduct = new Product();
        firstProduct.setName(MarketConstants.TOMATOES_PRODUCT_NAME);
        firstProduct.setPrice(8);
        firstProduct.setQuantity(40);

        Product secondProduct = new Product();
        secondProduct.setName(MarketConstants.CUCUMBER_PRODUCT_NAME);
        secondProduct.setPrice(5);
        secondProduct.setQuantity(12);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);
        seller.setProducts(products);

        return seller;


    }
}*/


public class Main {

    public static void main(String[] args) {
        try {
            correct(new String[][]{{"1", "2", "3", "4"}, {"2", "2", "2", "3", "3"}, {"2", "2", "2", "2"}, {"2", "2", "2", "2"}});
            System.out.println("все верно");
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("не верный размер");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("не верно в ячейке " + e.i + ", " + e.j);
        } catch (MyArrayRowSizeException e) {
            e.printStackTrace();
            System.out.println("не верный размер массива под номером " + e.i);
        }

    }

    public static void correct(String[][] arr) throws MyArraySizeException, MyArrayDataException, MyArrayRowSizeException {
        int number = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArrayRowSizeException(i);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    number = number + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }
    }
}


//Напишите метод, на вход которого подаётся
// двумерный строковый массив размером 4х4, при подаче массива
// другого размера необходимо бросить исключение MyArraySizeException.

// Далее метод должен пройтись по всем элементам массива,
// преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось
// (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException,
// с детализацией в какой именно ячейке лежат неверные данные.

