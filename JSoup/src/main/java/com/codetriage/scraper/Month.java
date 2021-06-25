package com.codetriage.scraper;

import java.time.LocalDate;

public class Month {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        String month = now.getMonth().toString();

        month = month.charAt(0) + month.substring(1,3).toLowerCase();
        System.out.println(month);
    }
}
