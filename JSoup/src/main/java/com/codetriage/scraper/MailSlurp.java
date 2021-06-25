package com.codetriage.scraper;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class MailSlurp {

    public static void main(String[] args) {

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                URI.create("https://api.mailslurp.com/sendEmail?apiKey=="))
                .header("accept", "application/json")
                .build();

        // use the client to send the request
        //var response = client.send(request,new JsonBodyHandler<>(APOD.class));

        // the response:
        //System.out.println(response.body().get().title);

    }


}
