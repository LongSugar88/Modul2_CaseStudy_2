package PoductManagerment;

import Product.MobilePhone;

import java.util.Comparator;

public class I_myComparator implements Comparator<MobilePhone> {

    @Override
    public int compare(MobilePhone mobilePhone1, MobilePhone mobilePhone2) {
        if(mobilePhone1.getPrice() >  mobilePhone2.getPrice()){
            return 1;
        }
        else if(mobilePhone1.getPrice() ==  mobilePhone2.getPrice()){
            return 0;
        }
        else
            return -1;
    }
}
