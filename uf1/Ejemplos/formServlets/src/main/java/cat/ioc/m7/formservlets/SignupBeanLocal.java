package cat.ioc.m7.formservlets;

import cat.ioc.m7.formservlets.constraints.Check18;
import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import cat.ioc.m7.formservlets.constraints.Color;
import cat.ioc.m7.formservlets.constraints.Email;
import cat.ioc.m7.formservlets.constraints.NotBlank;

@Local
public interface SignupBeanLocal {

    @NotNull (message = "El nom no pot estar buit.")
    @NotBlank(message = "El nom no pot estar buit.")    
    public String getNom();

    @NotNull(message = "El cognom no pot estar buit.")
    @NotBlank(message = "El cognom no pot estar buit.")    
    public String getCognoms();

    @Check18 (message = "Has de tenir més de 18 anys.")
    @NotBlank(message = "La data de naixement no pot estar buida.")    
    public String getNaixement();

    @NotNull(message = "El gènere no pot estar buit.")    
    public String getSexe();

    @Email
    @NotBlank(message = "El correu no pot estar buit.")
    public String getEmail();

    @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "El telèfon no és vàlid.")
    @NotBlank(message = "El telèfon no pot estar buit.")    
    public String getTelefon();

    @Color(message = "El color no pot estar buit.")
    public String getColor();

    @NotNull(message = "La marca del cotxe no pot estar buida.")    
    public String getMarcaCotxe();
    
    @NotBlank(message = "El vehicle1 no pot estar buit.")
    public String getVehicle1();

    @NotBlank(message = "El vehicle2 no pot estar buit.")
    public String getVehicle2();

    @NotNull(message = "El navegador no pot estar buit.")
    @NotBlank(message = "El navegador no pot estar buit.")    
    public String getNavegador();

    
    public String print();
    public void setNom(String nom);
    public void setCognoms(String cognoms);
    public void setNaixement(String naixement);
    public void setSexe(String sexe);
    public void setEmail(String email);
    public void setTelefon(String telefon);
    public void setColor(String color);
    public void setMarcaCotxe(String marcaCotxe);
    public void setVehicle1(String vehicle1);
    public void setVehicle2(String vehicle2);
    public void setNavegador(String navegador);
}
