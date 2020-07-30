/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
/**
 *
 * @author Axl Orellana
 */
public class Client implements Serializable{
    
    private final String idCard;
    private final String name;
    private final String email;
    private final String cellphone;
    private final String birthdate;

    public Client(String idCard, String name, String email, String cellphone, String birthdate) {
        this.idCard = idCard;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.birthdate = birthdate;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getBirthdate() {
        return birthdate;
    }
    
}
