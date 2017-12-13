package cat.ioc.m7.formservlets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;


@Stateless
public class PostBean implements PostBeanLocal {

    @Override
    public Boolean isValidEmail(String email) {
        //pattern
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    @Override
    public Boolean isValidAge(String age) {
        //min 18
        if(age != null && !age.equals("")) return Integer.parseInt(age) >= 18;
        return false;
    }
    
    @Override
    public Boolean isValidPost(String message) {
        //length post < 150
        return message.length() <= 150;
    }
}
