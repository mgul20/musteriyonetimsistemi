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
public class Teklif_detay {
    
        protected int id;
        protected int teklif_id;
        protected String sira;
        protected String kodu;
        protected String adi;
        protected double miktar;
        protected double fiyat;
        protected double toplam;



    
        
            public Teklif_detay() {}
                public Teklif_detay(int id) {
                this.id=id;
                }
                
    public Teklif_detay(int teklif_id, String sira, String kodu, String adi,double miktar, double fiyat, double toplam) {
        super();
        this.teklif_id=teklif_id;
        this.sira=sira;
        this.kodu=kodu;
        this.adi=adi;
        this.miktar=miktar;
        this.fiyat=fiyat;
        this.toplam=toplam;
        
        }

    public Teklif_detay(int id,int teklif_id, String sira, String kodu, String adi,double miktar, double fiyat, double toplam) {
        super();
        this.id = id;
        this.teklif_id=teklif_id;
        this.sira=sira;
        this.kodu=kodu;
        this.adi=adi;
        this.miktar=miktar;
        this.fiyat=fiyat;
        this.toplam=toplam;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeklif_id() {
        return teklif_id;
    }

    public void setTeklif_id(int teklif_id) {
        this.teklif_id = teklif_id;
    }

    public String getSira() {
        return sira;
    }

    public void setSira(String sira) {
        this.sira = sira;
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

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public double getToplam() {
        return toplam;
    }

    public void setToplam(double toplam) {
        this.toplam = toplam;
    }
    
}
