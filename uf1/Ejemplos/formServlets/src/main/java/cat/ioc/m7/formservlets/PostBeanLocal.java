package cat.ioc.m7.formservlets;

import javax.ejb.Local;

@Local
public interface PostBeanLocal {

    public Boolean isValidEmail(String email);

    public Boolean isValidAge(String age);

    public Boolean isValidPost(String message);
    
}
