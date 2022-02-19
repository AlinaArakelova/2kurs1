package com.company;

import com.company.market.Market;
import com.company.person.customer.Customer;
import com.company.person.seller.Seller;
import com.company.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

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
}
