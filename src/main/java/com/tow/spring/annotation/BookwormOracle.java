package com.tow.spring.annotation;

import com.tow.spring.xml.Oracle;

public class BookwormOracle implements Oracle {
    @Override
    public String gefineMeaningOfLife() {
        return "Encyclopedias are a waste of money - user the Internet";
    }
}