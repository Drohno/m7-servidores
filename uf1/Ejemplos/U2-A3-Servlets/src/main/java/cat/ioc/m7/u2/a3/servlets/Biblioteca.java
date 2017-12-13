package cat.ioc.m7.u2.a3.servlets;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@DeclareRoles({"bibliotecari"})
@Stateless
public class Biblioteca implements BibliotecaLocal {

   @RolesAllowed({"bibliotecari"})
   @Override
   public String catalogar(String llibre){
	  return "Llibre " + llibre + " catalogat.";
   }
   
   @PermitAll
   @Override
   public String veureDisponibilitat(String llibre){
       if(llibre.equals("Java")){
           return "Llibre " + llibre + " disponible.";
       }
       return "Llibre " + llibre + " no disponible.";
   } 
   
   
   @DenyAll
   @Override
   public Boolean demanarPrestec(String llibre){
      return false;
   } 
   
   
}
