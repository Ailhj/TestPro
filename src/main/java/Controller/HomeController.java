package Controller;

import Model.emailVeri;
import Model.user;
import Model.userView;
import Utility.emailUtil;
import Utility.sqlUtil;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Real on 2017-07-27.
 */

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String homePage(){
        return "test";
    }

    @RequestMapping(value = "/test")
    public String testPage(){
        return "test2";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String hPage(){
        return "add";
    }

//    @RequestMapping(value="/select")
//    @ResponseBody
//    public userView[] selectAll(){
//        List<userView> query= new ArrayList<userView>();
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testpro","root","1234");
//            Statement stmt = con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from user");
//            userView tmp = new userView();
//            while(rs.next()){
//                tmp.setId(rs.getInt(1));
//                tmp.setKid(rs.getString(2));
//                tmp.setParent(rs.getString(3));
//                tmp.setEmailAddress(rs.getString(4));
//                tmp.setStatus(rs.getInt(5));
//                query.add(tmp);
//            }
////                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
////                System.out.println(rs);
//            con.close();
//
//        }catch (Exception e){System.out.println(e);}
//        userView[] result = new userView[query.size()];
//        JsonArray ja = new JsonArray(Arrays.asList(result));
//        result = query.toArray(result);
//        return result;
//    }
@RequestMapping(value="/select")
@ResponseBody
public user[] selectAll(){
    try{
        return sqlUtil.selectAll();
    }catch (Exception e){System.out.println(e);}

    return null;
}

    @RequestMapping(value="/update")
    @ResponseBody
    public void updateStatus(@RequestParam("parent") String parent){
        try{
            sqlUtil.updateStatus(parent);
        }catch (Exception e){System.out.println(e);}

    }

    @RequestMapping(value="/reset")
    @ResponseBody
    public void resetStatus(){

        try{
            sqlUtil.resetStatus();
        }catch (Exception e){System.out.println(e);}

    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView showUser(@RequestParam String parent,@RequestParam String key)
    {
        ModelAndView mav = new ModelAndView("emailConfirm");

//        emailVeri ev = new emailVeri();
//        ev.parent=parent;
//        ev.hashCode=key;

        Integer result = sqlUtil.verify(parent, key);

        mav.addObject("Key",parent +"- Number kids affected: "+result);
        return mav;
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    @ResponseBody
    public String sendEmail(@RequestParam(value = "parent[]") String[] parents){
        String result="";
        Integer count = 0;
        Integer issueCount;
        String address = "";
        try{
            for(String parent : parents){
//            emailUtil.sendEmail(parent);
                //Maximun 2 issue count
                issueCount = sqlUtil.getIssueCount(parent);
                if(issueCount < 2){
                    address= sqlUtil.getEmailbyParent(parent);
                    emailUtil.sendEmail(parent, sqlUtil.genVeriKey(parent,issueCount), address);
                    count++;
                }

            }
        }catch (Exception e){}
        result = count+" email sent";
        return result;
    }
}
