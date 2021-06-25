package com.codetriage.scraper;
/*
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;
*/
import java.nio.charset.Charset;

public class EmailTemplate {

    public static void main(String[] args) {

        //sendEmail();

    }

    private static void sendEmail() {
        /*MailMessage message = new MailMessage();

        //Set subject of the message, body and sender informationas
        message.setSubject("Subject line I need to copy - INITAL - MIDDLE - FINAL");
        message.setHtmlBody("<b>Hello World! My first automated email</b>");
        message.setFrom(new MailAddress("haroonshinwari24@gmail.com", "Haroon", false));


        //Specify Encoding
        message.setBodyEncoding(Charset.forName("US-ASCII"));

        //Add To recipients and CC recipients
        message.getTo().addItem(new MailAddress("haroon24@live.co.uk", "Receipient1", false));
        //message.getCC().addItem(new MailAddress("emailCC@address.com", "Receipient2", false));

        //Create an instance of SMTPClient Class
        SmtpClient client = new SmtpClient();

        //Specify your mailing host server, Username, Password, Port
        client.setHost("smtp.gmail.com");
        client.setUsername("haroonshinwari24@gmail.com");
        client.setPassword("H");
        client.setPort(25);

        try {
            //Client will send message
            client.send(message);
            System.out.println("Message sent successfully");
        }catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}
