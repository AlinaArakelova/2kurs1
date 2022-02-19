package com.company.person.customer;

import com.company.market.Market;
import com.company.person.Person;
import com.company.person.seller.Seller;
import com.company.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private List<Product> expectedPurchaseList; //
    private List<Product> purchaseList; //список покупок

    public Customer(List<Product> expectedPurchaseList, int cash) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        if (purchaseList == null) {
            purchaseList = new ArrayList<>();
        }
        purchaseList.add(product);
    }

    public void findProductOnMarket(Market market, String firstName, String lastName) {
        for (Product product: getExpectedPurchaseList()) {
            boolean isBought = false;
            for (Seller seller: market.getSellers()) {
                if (seller.getName().equals(firstName) && seller.getLastName().equals(lastName)){
                    isBought = seller.sellProducts(this, product);
                    if (isBought) {
                        System.out.println("нашла любимого продавца и купила у него");
                        break;
                    }
                }
            }

            if (isBought == true) {
                continue;
            }
            for (Seller seller: market.getSellers()) {
                isBought = seller.sellProducts(this, product);
                if (isBought) {
                    System.out.println("купила у кого попало");
                    break;
                }
            }
        }
    }

    public void info() {
        StringBuilder result = new StringBuilder("Я купил ");
        if (purchaseList.size()==0) {
            result.append("ничего");
        } else {
            for(Product product: purchaseList) {
                result.append(product.getName());
                result.append(" в количестве ");
                result.append(product.getQuantity());
                result.append(" ");
            }
        }
        result.append(". У меня осталось: ");
        result.append(getCash());
        result.append(" рублей");

        System.out.println(result);
    }

    public List<Product> getExpectedPurchaseList() {
        return expectedPurchaseList;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }
}
