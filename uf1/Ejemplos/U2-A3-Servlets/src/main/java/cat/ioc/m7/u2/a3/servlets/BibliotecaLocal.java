/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.ioc.m7.u2.a3.servlets;


import javax.ejb.Local;

@Local
public interface BibliotecaLocal {

    public String catalogar(String llibre);

    public String veureDisponibilitat(String llibre);

    public Boolean demanarPrestec(String llibre);

}
