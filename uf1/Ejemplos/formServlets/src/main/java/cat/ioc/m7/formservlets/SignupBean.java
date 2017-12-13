package cat.ioc.m7.formservlets;

import javax.ejb.Stateful;

@Stateful
public class SignupBean implements SignupBeanLocal {

    private String nom;

    private String cognoms;

    private String naixement;

    private String sexe;

    private String email;

    private String telefon;

    private String color;

    private String marcaCotxe;

    private String vehicle1;

    private String vehicle2;

    private String navegador;

    @Override
    public String print() {

        return "<p>nom=" + nom + "</p> <p>"
                + "cognoms=" + cognoms + "</p><p>"
                + "naixement=" + naixement + "</p><p>"
                + "sexe=" + sexe + "</p> <p>email=" + email + "</p><p>"
                + "telefon=" + telefon + "</p> <p>"
                + "color=" + color + "</p> <p>"
                + "marcaCotxe=" + marcaCotxe + "</p> <p>"
                + "vehicle1=" + vehicle1 + "</p> <p>"
                + "vehicle2=" + vehicle2 + "</p> <p>"
                + "navegador=" + navegador + "</p>";
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getCognoms() {
        return cognoms;
    }

    @Override
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @Override
    public String getNaixement() {
        return naixement;
    }

    @Override
    public void setNaixement(String naixement) {
        this.naixement = naixement;
    }

    @Override
    public String getSexe() {
        return sexe;
    }

    @Override
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTelefon() {
        return telefon;
    }

    @Override
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getMarcaCotxe() {
        return marcaCotxe;
    }

    @Override
    public void setMarcaCotxe(String marcaCotxe) {
        this.marcaCotxe = marcaCotxe;
    }

    @Override
    public String getVehicle1() {
        return vehicle1;
    }

    @Override
    public void setVehicle1(String vehicle1) {
        this.vehicle1 = vehicle1;
    }

    @Override
    public String getVehicle2() {
        return vehicle2;
    }

    @Override
    public void setVehicle2(String vehicle2) {
        this.vehicle2 = vehicle2;
    }

    @Override
    public String getNavegador() {
        return navegador;
    }

    @Override
    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }
}
