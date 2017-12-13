package cat.ioc.m7.formservlets;

import javax.ejb.Local;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Local
public interface PostBean2Local {
    
    @Min(value=18, message = "Has de ser major d'edat per escriure un missatge.")        
    public int getEdat();

    @NotNull @Size(min=1, max=150, message = "El missatge no és vàlid. Ha de tenir menys de 150 caràcters.")
    public String getMessage();

    @NotNull @Pattern(regexp="^(.+)@(.+)$", message = "El correu no és vàlid.")
    public String getEmail();
    
    public void setEdat(String edat);
    
    public void setMessage(String message);
    
    public void setEmail(String email);
    
}
