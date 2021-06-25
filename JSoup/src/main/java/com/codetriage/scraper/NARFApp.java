package com.codetriage.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class NARFApp {

    public static void main(String[] args) {

        //Fetches data from Trading Economics website
        HashMap<String, NFPMonthlyData> NFPData = fetchDataFromTradingEconomics();

        //Ask user which month to store data for
        NFPMonthlyData monthlyData = askUserForMonth(NFPData);

        //Saving latest monthly data to file
        saveDataToFile(monthlyData);
        System.out.println("Data successfully updated");

        //create template
        fillInitalEmailTemplate(monthlyData);


    }

    private static NFPMonthlyData askUserForMonth( HashMap<String, NFPMonthlyData> NFPData) {
        boolean correctMonthEntered = false;
        NFPMonthlyData monthlyData = null;
        String monthEntered= "";

        while (!correctMonthEntered) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Which month would you like to store data for? (please enter the first three letters of the month)");
            monthEntered = sc.next();
            Set<String> monthsInTable = NFPData.keySet();
            if (monthsInTable.contains(monthEntered)) {
                correctMonthEntered = true;
            }else {
                System.out.println("Invalid month entered. Please try again. Use the first three characters of the month");
            }
        }
        monthlyData = NFPData.get(monthEntered);
        System.out.println(monthlyData.toString());

        return monthlyData;
    }


    private static String getMonth() {
        LocalDate now = LocalDate.now();
        String month = now.getMonth().toString();

        month = month.charAt(0) + month.substring(1,3).toLowerCase();
        return month;
    }

    private static HashMap<String,NFPMonthlyData> fetchDataFromTradingEconomics() {

        HashMap<String, NFPMonthlyData> NFPData = null;
        try {
            // Here we create a document object and use JSoup to fetch the website
            Document doc = Jsoup.connect("https://tradingeconomics.com/united-states/non-farm-payrolls").get();

            // With the document fetched, we use JSoup's title() method to fetch the title
            //System.out.printf("Title: %s\n", doc.title());

            // Get the list of table entries
            Elements repositories = doc.getElementsByClass("an-estimate-row");

            NFPData = new HashMap<>();


            for (Element repository : repositories) {

                //Get rows of data for each month
                Elements tableRows = repository.getElementsByTag("td");
                System.out.println(repository.text());

                //String currentMonth = getMonth();

                String month = tableRows.get(3).text();
                String actual = tableRows.get(4).text();
                String previous = tableRows.get(5).text();
                String consensus = tableRows.get(6).text();
                String tefForecast = tableRows.get(7).text();

                NFPMonthlyData nfpObject = new NFPMonthlyData(month, actual, previous, consensus, tefForecast);

                NFPData.put(month, nfpObject);

            }
            return NFPData;

            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NFPData;
    }

    private static void saveDataToFile(NFPMonthlyData monthlyData) {
        try {
            FileWriter writer = new FileWriter("NRFData.txt", false);
            writer.write(monthlyData.getActual() + "\n");
            writer.write(monthlyData.getPrevious() + "\n");
            writer.write(monthlyData.getConsensus() + "\n");
            writer.write(monthlyData.getTefForecast());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fillEmailTemplate(NFPMonthlyData nfpMonthlyData) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which email would you like to send?");

        return "email template";
    }


    public static String fillInitalEmailTemplate(NFPMonthlyData nfpMonthlyData) {

        System.out.println("\\n\\n\\n======== EMAIL TO BE SENT OUT ======");

        String template = "Market Event: \n• US Non-Farm Payroll Figures, 08:05ET release for "+nfpMonthlyData.getMonth() +".\n• " +
                "Overall Status: Green\n" +
                "• Update Time: 08:00 ET\n\n" +
                "Business Lines:\n• Equities and F&O   - Green\n" +
                "• FICC Macro - eCCEM   - Green\n•" +
                " FICC Macro - Rates & Research   - Green\n" +
                "• FICC Spread - Credit/Spread   - Green\n\n" +
                "Issues:\nNone\n\n" +
                "Notes: \n" + "" +
                "• Survey (DailyFX): Forecast: " + nfpMonthlyData.getTefForecast() + ", " +
                "Previous: " + nfpMonthlyData.getPrevious() + "\n\n" +
                "• Adobe Chat: http://go/mktshmv1\n\nRegards,\n\nCIB Command Center";

        System.out.println(template);

        return template;
    }

    public static String fillSecondEmailTemplate(NFPMonthlyData nfpMonthlyData) {

        System.out.println("\\n\\n\\n======== EMAIL TO BE SENT OUT ======");

        String template = "Market Event: \n• US Non-Farm Payroll Figures, 08:05ET release for "+nfpMonthlyData.getMonth() +".\n• " +
                "Overall Status: Green\n" +
                "• Update Time: 08:00 ET\n\n" +
                "Business Lines:\n• Equities and F&O   - Green\n" +
                "• FICC Macro - eCCEM   - Green\n•" +
                " FICC Macro - Rates & Research   - Green\n" +
                "• FICC Spread - Credit/Spread   - Green\n\n" +
                "Issues:\nNone\n\n" +
                "Notes: \n" + "" +
                "• Survey (DailyFX): Forecast: " + nfpMonthlyData.getTefForecast() + ", " +
                "Actual: " + nfpMonthlyData.getActual() + "\n\n" +
                "• Adobe Chat: http://go/mktshmv1\n\nRegards,\n\nCIB Command Center";

        System.out.println(template);

        return template;
    }

}
