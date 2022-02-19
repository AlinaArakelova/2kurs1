package com.company.person.seller;

import com.company.person.Person;
import com.company.person.customer.Customer;
import com.company.product.Product;

import java.util.List;

public class Seller extends Person {
    private String name;
    private String lastName;
    private List<Product> products;

    public boolean sellProducts(Customer customer, Product expectedProduct) {
        for (Product product : products) {
            //Проверяем по имени товара, что у продавца есть продукт
            if (product.getName().equals(expectedProduct.getName())) {
                //проверяем, что количество товара больше или равно, чем мы хотим купить
                if (product.getQuantity() >= expectedProduct.getQuantity()) {
                    //Проверяем, что количество денег позволяет купить товар
                    long requiredCash = (long) product.getPrice() * expectedProduct.getQuantity();
                    if (customer.getCash() >= requiredCash) {
                        //Уменьшаем  количество продукта у продавца
                        product.setQuantity(product.getQuantity() - expectedProduct.getQuantity());
                        //создаем новый объект для покупателя, чтобы ссылка не дублировалась

                        Product customerProduct = new Product();
                        customerProduct.setQuantity(expectedProduct.getQuantity());
                        customerProduct.setName(expectedProduct.getName());
                        //добавляем количество продуктов у покупателя
                        customer.addPurchase(customerProduct);
                        //увеличиваем кэш продавца
                        setCash(getCash() + requiredCash);
                        //уменьшаем кэш покупателя
                        customer.setCash(customer.getCash() - requiredCash);
                        //сообщаем потребителю метода, что покупка совершена
                        System.out.println("купила у " + getName() + " " + product.getName());
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
