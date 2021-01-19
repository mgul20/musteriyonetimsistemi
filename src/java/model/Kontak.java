/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MGUL
 */
public class Kontak {

        protected int id;
        protected int musteri_id;
        protected String departman;
        protected String unvan;
        protected String hitap;
        protected String gsm;
        protected String tel;
        protected String email;



    
        
            public Kontak() {}
                public Kontak(int id) {
                this.id=id;
                }
                
    public Kontak(int musteri_id, String departman, String unvan, String hitap,String gsm, String tel, String email) {
        super();
        this.musteri_id=musteri_id;
        this.departman=departman;
        this.unvan=unvan;
        this.hitap=hitap;
        this.gsm=gsm;
        this.tel=tel;
        this.email=email;
        }

    public Kontak(int id,int musteri_id, String departman, String unvan, String hitap,String gsm, String tel, String email) {
        super();
        this.id = id;
        this.musteri_id=musteri_id;
        this.departman=departman;
        this.unvan=unvan;
        this.hitap=hitap;
        this.gsm=gsm;
        this.tel=tel;
        this.email=email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getHitap() {
        return hitap;
    }

    public void setHitap(String hitap) {
        this.hitap = hitap;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
            
}
