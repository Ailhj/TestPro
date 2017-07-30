package Utility;

//import com.mysql.cj.api.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Real on 2017-07-28.
 */
public class Test {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/copyrighted","admin1","lml1399H*");
            //Connection con = DriverManager.getConnection("jdbc:mysql://118.89.147.29:3306/copyrighted","admin1","lml1399H*");
            Connection con = DriverManager.getConnection("jdbc:mysql://173.206.162.67:3306/testpro","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
//                System.out.println(rs);
            con.close();

        }catch (Exception e){System.out.println(e);}


//            try{
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
//                Statement stmt = con.createStatement();
//                stmt.executeUpdate("update user set status = '1' where parent = 'Alpha'");
//
//                con.close();
//
//            }catch (Exception e){System.out.println(e);}

//
//        final String userName = "vuejsdemo182";
//        final String password = "5A02hau243";
//
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(userName, password);
//                    }
//                });
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("vuejsdemo182@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse("xiguang182@gmail.com"));
//            message.setSubject("Testing Subject");
//            message.setText("Dear Mail Crawler,"
//                    + "\n\n No spam to my email, please!");
//
//            Transport.send(message);
//
//            System.out.println("Done");
//
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }


//        try{
//            emailUtil.sendEmail("Beta",sqlUtil.genVeriKey("Beta"));
//        }catch (Exception e){System.out.println(e);}

//        Date time1 = new Date();
//        System.out.println(time1);
//        Calendar c = Calendar.getInstance();
//        c.setTime(time1);
//        c.add(Calendar.DATE, 7);
//        time1 = c.getTime();
//        System.out.println(time1);

//        Date tNow = new Date();
//
//        String key = "123";
//        String parent = "Alpha";
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("update user set verification = '"+key+"', expireDate ='" +tNow+ "' where parent = '"+ parent+"'");
//
//            con.close();
//        }catch (Exception e){System.out.println(e);}

//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
//            Statement stmt = con.createStatement();
//            ResultSet rs=stmt.executeQuery("select expireDate from user where parent = 'Delta'");
//            rs.next();
//            Date time1 = rs.getDate(1);
//            con.close();
//            Date timeNow = new Date();
//            System.out.println(time1.after(timeNow));
//
//        }catch (Exception e){System.out.println(e);}
//
    }
}
