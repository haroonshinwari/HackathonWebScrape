package com.codetriage.scraper;

public class NFPMonthlyData {

    String month;
    String previous;
    String actual;
    String consensus;
    String tefForecast;

    public NFPMonthlyData(String month, String actual, String previous, String consensus, String tefForecast) {
        this.month = month;
        this.previous = previous;
        this.actual = actual;
        this.consensus = consensus;
        this.tefForecast = tefForecast;
    }

    public NFPMonthlyData() {
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getConsensus() {
        return consensus;
    }

    public void setConsensus(String consensus) {
        this.consensus = consensus;
    }

    public String getTefForecast() {
        return tefForecast;
    }

    public void setTefForecast(String tefForecast) {
        this.tefForecast = tefForecast;
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Month:  " + month +
                "\nActual: " + actual +
                " Previous: " + previous +
                " Consensus: " + consensus +
                " TEF Forecast: " + tefForecast + "\n";
    }
}
