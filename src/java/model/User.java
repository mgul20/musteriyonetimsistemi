/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String tamadi;
    protected String password;
    protected String turu;

    public User() {}
    
    public User(int id) {
    this.id=id;
    }

    public User(String name, String email, String tamadi, String password,String turu) {
        super();
        this.name = name;
        this.email = email;
        this.tamadi = tamadi;
        this.password = password;
        this.turu = turu;
    }

    public User(int id, String name, String email, String tamadi, String password,String turu) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.tamadi = tamadi;
        this.password = password;
        this.turu = turu;
    }

    public User(User id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTuru() {
        return turu;
    }
    public void setTuru(String turu) {
        this.turu = turu;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTamadi() {
        return tamadi;
    }
    public void setTamadi(String tamadi) {
        this.tamadi = tamadi;
    }
        public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
