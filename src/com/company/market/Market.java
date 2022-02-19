package com.company.market;

import com.company.person.seller.Seller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Seller> sellers;

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public void addSeller(Seller seller) {
        if (sellers == null) {
            sellers = new ArrayList<>();
        }
        sellers.add(seller);
    }
}
