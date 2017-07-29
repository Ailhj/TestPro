package Utility;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Real on 2017-07-28.
 */
public class emailUtil {
    public static void sendEmail(String parent,String key, String emailAddress){


        String link = "http://localhost:8080/show?parent="+parent+"&key="+key;
        final String userName = "vuejsdemo182";
        final String password = "5A02hau243";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vuejsdemo182@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("xiguang182@gmail.com"));
            message.setSubject("Agreement confirmation");
            message.setText("Dear "+parent+","
                    + "This email suppose to be sent to " + emailAddress
                    + "\n\n Click the following Link to agree"
                    + "\n\n "+ link);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
}
