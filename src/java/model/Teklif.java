/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author MGUL
 */
public class Teklif {
    
        protected int id;
        protected int musteri_id;
        protected int kontak_id;
        protected int count=0;
        protected String teklif_no;
        protected String durumu;
        protected String konu;
        protected String tarih;
        protected String aciklama;
        protected String onay;
        protected String tamamla;


    
        
            public Teklif() {}
                public Teklif(int id) {
                this.id=id;
                }
                
    public Teklif(int musteri_id,int kontak_id, String teklif_no, String durumu, String konu,String tarih, String aciklama, String onay, String tamamla) {
        super();
        this.musteri_id=musteri_id;
        this.kontak_id=kontak_id;
        this.teklif_no=teklif_no;
        this.durumu=durumu;
        this.konu=konu;
        this.tarih=tarih;
        this.aciklama=aciklama;
        this.onay=onay;
        this.tamamla=tamamla;
        }
    public Teklif(int id,String onay) {
        super();
        this.id=id;
        this.onay=onay;
        }

    public Teklif(int id,int musteri_id,int kontak_id, String teklif_no, String durumu, String konu,String tarih, String aciklama, String onay,String tamamla) {
        super();
        this.id = id;
        this.musteri_id=musteri_id;
        this.kontak_id=kontak_id;
        this.teklif_no=teklif_no;
        this.durumu=durumu;
        this.konu=konu;
        this.tarih=tarih;
        this.aciklama=aciklama;
        this.onay=onay;
        this.tamamla=tamamla;

    }
    public int getCount() {
    return id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTamamla() {
        return tamamla;
    }

    public void setTamamla(String tamamla) {
        this.tamamla = tamamla;
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

    public int getKontak_id() {
        return kontak_id;
    }

    public void setKontak_id(int kontak_id) {
        this.kontak_id = kontak_id;
    }

    public String getTeklif_no() {
        return teklif_no;
    }

    public void setTeklif_no(String teklif_no) {
        this.teklif_no = teklif_no;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getOnay() {
        return onay;
    }

    public void setOnay(String onay) {
        this.onay = onay;
    }
    
}
