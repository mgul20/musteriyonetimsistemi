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
public class Musteri {
        protected int id;
        protected int count=0;
        protected String kodu;
        protected String adi;
        protected String yetkiliadi;
        protected String turu;
        protected String email;
        protected String gsm;
        protected String tel;
        protected String ulke;
        protected String sehir;
        protected String adres;

    
        
            public Musteri() {}
                public Musteri(int id) {
    this.id=id;
    }

    public Musteri(String kodu, String adi, String yetkiliadi, String turu,String email, String gsm, String tel, String ulke,String sehir, String adres) {
        super();
        this.kodu=kodu;
        this.adi=adi;
        this.yetkiliadi=yetkiliadi;
        this.turu=turu;
        this.email=email;
        this.gsm=gsm;
        this.tel=tel;
        this.ulke=ulke;
        this.sehir=sehir;
        this.adres=adres;
        
        
        
    }

    public Musteri(int id, String kodu, String adi, String yetkiliadi, String turu,String email, String gsm, String tel, String ulke,String sehir, String adres) {
        super();
        this.id = id;
        this.kodu=kodu;
        this.adi=adi;
        this.yetkiliadi=yetkiliadi;
        this.turu=turu;
        this.email=email;
        this.gsm=gsm;
        this.tel=tel;
        this.ulke=ulke;
        this.sehir=sehir;
        this.adres=adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        public int getCount() {
        return id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getKodu() {
        return kodu;
    }

    public void setKodu(String kodu) {
        this.kodu = kodu;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getYetkiliadi() {
        return yetkiliadi;
    }

    public void setYetkiliadi(String yetkiliadi) {
        this.yetkiliadi = yetkiliadi;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
