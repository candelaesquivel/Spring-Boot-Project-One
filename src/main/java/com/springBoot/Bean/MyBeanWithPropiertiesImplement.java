package com.springBoot.Bean;

public class MyBeanWithPropiertiesImplement implements MyBeanWithPropierties{

    private String nam;
    private String lastNam;

    public MyBeanWithPropiertiesImplement(String nam, String lastNam) {
        this.nam = nam;
        this.lastNam = lastNam;
    }

    @Override
    public String function() {
        return nam+"-"+lastNam;
    }
}
