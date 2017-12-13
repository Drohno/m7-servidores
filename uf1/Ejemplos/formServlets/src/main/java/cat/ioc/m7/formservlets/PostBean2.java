package cat.ioc.m7.formservlets;

import javax.ejb.Stateful;


@Stateful
public class PostBean2 implements PostBean2Local {
    
    private int edat;
    
    private String message;
        
    private String email;

    @Override
    public int getEdat() {
        return edat;
    }

    @Override
    public void setEdat(String edat) {
         if(!edat.equals("")){
            this.edat=Integer.parseInt(edat);
        }
        else{
            this.edat = 0;
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

 
}
