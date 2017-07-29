package Utility;

import Model.user;
import Model.userView;
import sun.rmi.server.InactiveGroupException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Real on 2017-07-28.
 */
public class sqlUtil {
    public static void updateStatus(String parent)throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update user set status = '1' where parent = '"+ parent+"'");

            con.close();

        }catch (Exception e){System.out.println(e);}
    }

    public static user[] selectAll() throws  Exception{
        List<user> query= new ArrayList<user>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user");
            while(rs.next()){
                user tmp = new user();
                tmp.id = rs.getInt(1);
                tmp.kid=rs.getString(2);
                tmp.parent=rs.getString(3);
                tmp.emailAddress=rs.getString(4);
                tmp.status = rs.getInt(5);
                query.add(tmp);
            }
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
//                System.out.println(rs);
            con.close();

        }catch (Exception e){System.out.println(e);}

        user[] result = new user[query.size()];
        result = query.toArray(result);
        return result;
    }


    public static void resetStatus() throws Exception{

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update user set status = '0'");

            con.close();

        }catch (Exception e){System.out.println(e);}

    }

    public static Integer verify(String parent,String verification){

        userView tmp = new userView();
        tmp.setId(0);
        Integer count = 0;
        Date cTime = new Date();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user where parent = '"+ parent +"'");


            while(rs.next()){
                if(tmp.getId()==0) {
                    tmp.setId(rs.getInt(1));
                    tmp.setVerification(rs.getString(6));
                    tmp.setIssueCount(rs.getInt(8));
                    tmp.setExpireDate(rs.getDate(7));
                }
                count++;
            }
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
//                System.out.println(rs);
            con.close();
        }catch (Exception e){System.out.println(e);}

        if(verification.equals(tmp.getVerification())) {
            if(tmp.getExpireDate().after(cTime)){
                try{
                    updateStatus(parent);
                } catch (Exception e){};
                return count;
            }else{
                //expired
                return -1;
            }

        }else{
            return 0;
        }
    }


    public static String genVeriKey(String parent, Integer issueCount) throws Exception{

        String key = messageUtil.keyGenerator(parent);
        Integer count = issueCount + 1;
        Date time1 = new Date();
        System.out.println(time1);
        Calendar c = Calendar.getInstance();
        c.setTime(time1);
        c.add(Calendar.DATE, 7);
        time1 = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String cTime = sdf.format(time1);

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
        Statement stmt = con.createStatement();

        stmt.executeUpdate("update user set verification = '"+key+"', expireDate ='" +cTime+ "', issueCount = '"+count+"' where parent = '"+ parent+"'");

        con.close();

        return key;
    }

    public static String getEmailbyParent(String parent) throws Exception{
        String email;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery("select email from user where parent = '"+ parent+"'");

        rs.next();
        email = rs.getString(1);

        con.close();

        return email;
    }

    public static Integer getIssueCount(String parent) throws Exception{
        Integer issueCount;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery("select issueCount from user where parent = '"+ parent+"'");
        rs.next();
        issueCount = rs.getInt(1);
        return issueCount;
    }

}
