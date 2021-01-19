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
public class IstekTalep {
        protected int id;
        protected int userid;
        protected String tamadi;
        protected String turu;
        protected String konu;
        protected String aciklama;
        protected String cevap;
        protected String tamamla;



    
        
            public IstekTalep() {}
                public IstekTalep(int id) {
                this.id=id;
                }
    public IstekTalep(int userid, String turu, String konu, String aciklama,String cevap, String tamamla) {
        super();
        this.userid=userid;
        this.turu=turu;
        this.konu=konu;
        this.aciklama=aciklama;
        this.cevap=cevap;
        this.tamamla=tamamla;
        
        }

    public IstekTalep(int id,int userid, String turu, String konu, String aciklama,String cevap, String tamamla,String tamadi) {
        super();
        this.id = id;
        this.userid=userid;
        this.turu=turu;
        this.konu=konu;
        this.aciklama=aciklama;
        this.cevap=cevap;
        this.tamamla=tamamla;
        this.tamadi=tamadi;
    }
        public IstekTalep(int id, String konu, String aciklama,String cevap, String tamamla) {
        super();
        this.id = id;
        this.konu=konu;
        this.aciklama=aciklama;
        this.cevap=cevap;
        this.tamamla=tamamla;

    } 

    public String getTamadi() {
        return tamadi;
    }

    public void setTamadi(String tamadi) {
        this.tamadi = tamadi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getTamamla() {
        return tamamla;
    }

    public void setTamamla(String tamamla) {
        this.tamamla = tamamla;
    }
    
    
}
