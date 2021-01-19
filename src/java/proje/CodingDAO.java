/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

/**
 *
 * @author MGUL
 */

 
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.IstekTalep;
import model.Kontak;
import model.Musteri;
import model.Teklif;
import model.Teklif_detay;
import model.User;

 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class CodingDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public CodingDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {


//connect = DriverManager.getConnection("jdbc:mysql://localhost:XXXX/DATABASE?useUnicode=true&characterEncoding=utf8","root","123456");

        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }


            jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mgul?useUnicode=yes&characterEncoding=UTF-8", "root","Sivas2020");
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     


                                                     public boolean insertUser(User user) throws SQLException {
                                                        
                                                        String sql = "INSERT INTO users" + "  (name, email, tamadi, password,turu) VALUES(?, ?, ?,?,?);";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                           statement.setString(1, user.getName());
                                                           statement.setString(2, user.getEmail());
                                                           statement.setString(3, user.getTamadi());
                                                           statement.setString(4, user.getPassword());
                                                           statement.setString(5, user.getTuru());
                                                        boolean rowInserted = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowInserted;
                                                     }
         
         
    public boolean insertMusteri(Musteri musteri) throws SQLException {
        String sql = "INSERT INTO musteri" + "  (kodu, adi, yetkiliadi, turu,email, gsm, tel, ulke,sehir,adres) VALUES(?,?,?,?,?,?,?,?,?,?);";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, musteri.getKodu());
        statement.setString(2, musteri.getAdi());
        statement.setString(3, musteri.getYetkiliadi());
        statement.setString(4, musteri.getTuru());
        statement.setString(5, musteri.getEmail());
        statement.setString(6, musteri.getGsm());
        statement.setString(7, musteri.getTel());
        statement.setString(8, musteri.getUlke());
        statement.setString(9, musteri.getSehir());
        statement.setString(10, musteri.getAdres());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
                                                    public boolean insertTeklif(Teklif teklif) throws SQLException {
                                                        String sql = "INSERT INTO teklif (musteri_id,kontak_id, teklif_no, durumu, konu, tarih, aciklama, onay, tamamla) VALUES(?,?,?,?,?,?,?,?,?);";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                        statement.setInt(1, teklif.getMusteri_id());
                                                        statement.setInt(2, teklif.getKontak_id());
                                                        statement.setString(3, teklif.getTeklif_no());
                                                        statement.setString(4, teklif.getDurumu());
                                                        statement.setString(5, teklif.getKonu());
                                                        statement.setString(6, teklif.getTarih());
                                                        statement.setString(7, teklif.getAciklama());
                                                        statement.setString(8, teklif.getOnay());
                                                        statement.setString(9, "0");
                                                        boolean rowInserted = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowInserted;
                                                    }
    public boolean insertMusteriKontak(Kontak kontak) throws SQLException {
        String sql = "INSERT INTO kontak (musteri_id, departman, unvan, hitap, gsm, tel, email) VALUES(?,?,?,?,?,?,?);";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, kontak.getMusteri_id());
        statement.setString(2, kontak.getDepartman());
        statement.setString(3, kontak.getUnvan());
        statement.setString(4, kontak.getHitap());
        statement.setString(5, kontak.getGsm());
        statement.setString(6, kontak.getTel());
        statement.setString(7, kontak.getEmail());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
                  
                                                    public boolean deleteUser(User user) throws SQLException {
                                                        String sql = "DELETE FROM users where id = ?";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                        statement.setInt(1, user.getId());
                                                        boolean rowDeleted = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowDeleted;
                                                    }
        
    public boolean deleteMusteri(Musteri musteri) throws SQLException {
        String sql = "DELETE FROM musteri where id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, musteri.getId());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

                                                    public boolean updateUser(User user) throws SQLException {
                                                        String sql = "UPDATE users SET name = ?, email = ?, tamadi = ?, password=?, turu=?";
                                                        sql += " WHERE id = ?";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                        statement.setString(1, user.getName());
                                                        statement.setString(2, user.getEmail());
                                                        statement.setString(3, user.getTamadi());
                                                        statement.setString(4, user.getPassword());
                                                        statement.setString(5, user.getTuru());
                                                        statement.setInt(6, user.getId());
                                                        boolean rowUpdated = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowUpdated;
                                                    }
    public boolean updateMusteri(Musteri musteri) throws SQLException {
        String sql = "UPDATE musteri SET kodu = ?, adi = ?, yetkiliadi = ?, turu=?, email=?, gsm=?, tel=?, ulke=?, sehir=?, adres=?";
        sql += " WHERE id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, musteri.getKodu());
        statement.setString(2, musteri.getAdi());
        statement.setString(3, musteri.getYetkiliadi());
        statement.setString(4, musteri.getTuru());
        statement.setString(5, musteri.getEmail());
        statement.setString(6, musteri.getGsm());
        statement.setString(7, musteri.getTel());
        statement.setString(8, musteri.getUlke());
        statement.setString(9, musteri.getSehir());
        statement.setString(10, musteri.getAdres());
        statement.setInt(11, musteri.getId());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
                                                    public boolean insertTeklifDetay(Teklif_detay teklif) throws SQLException {
                                                        String sql = "INSERT INTO teklif_detay (teklif_id, sira, kodu, adi, miktar, fiyat, toplam) VALUES(?,?,?,?,?,?,?);";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                        statement.setInt(1, teklif.getTeklif_id());
                                                        statement.setString(2, teklif.getSira());
                                                        statement.setString(3, teklif.getKodu());
                                                        statement.setString(4, teklif.getAdi());
                                                        statement.setDouble(5, teklif.getMiktar());
                                                        statement.setDouble(6, teklif.getFiyat());
                                                        statement.setDouble(7, teklif.getToplam());
                                                        boolean rowInserted = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowInserted;
                                                    }    
    public boolean deleteTeklifDetay(Teklif_detay teklif_detay) throws SQLException {
        String sql = "DELETE FROM teklif_detay where id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, teklif_detay.getId());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    } 
                                                    public boolean teklifTamamla(Teklif teklif) throws SQLException {
                                                        String sql = "UPDATE teklif SET tamamla = ?";
                                                        sql += " WHERE id = ?";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                        statement.setString(1, "1");
                                                        statement.setInt(2, teklif.getId());
                                                        boolean rowUpdated = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowUpdated;
                                                    }
public boolean insertIstekTalep(IstekTalep istektalep) throws SQLException {

   String sql = "INSERT INTO istektalep" + "  (userid, turu, konu, aciklama,tamamla) VALUES(?, ?, ?, ?, ?);";
   connect();
   PreparedStatement statement = jdbcConnection.prepareStatement(sql);
      statement.setInt(1, istektalep.getUserid());
      statement.setString(2, istektalep.getTuru());
      statement.setString(3, istektalep.getKonu());
      statement.setString(4, istektalep.getAciklama());
      statement.setString(5, "Hayır");
   boolean rowInserted = statement.executeUpdate() > 0;
   statement.close();
   disconnect();
   return rowInserted;
}
                                                    public boolean teklifOnay(Teklif teklif) throws SQLException {
                                                        if (teklif.getOnay().equals("1")){
                                                            String sqll = "UPDATE teklif SET onay = ?";
                                                            sqll += " WHERE id = ?";
                                                            connect();
                                                            PreparedStatement statementt = jdbcConnection.prepareStatement(sqll);
                                                            statementt.setString(1, "0");
                                                            statementt.setInt(2, teklif.getId());
                                                            boolean rowUpdatedd = statementt.executeUpdate() > 0;
                                                            statementt.close();
                                                            disconnect();
                                                            return rowUpdatedd;
                                                            
                                                        } else {
                                                            
                                                            String sql = "UPDATE teklif SET onay = ?";
                                                            sql += " WHERE id = ?";
                                                            connect();
                                                            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                            statement.setString(1, "1");
                                                            statement.setInt(2, teklif.getId());
                                                            boolean rowUpdated = statement.executeUpdate() > 0;
                                                            statement.close();
                                                            disconnect();
                                                            return rowUpdated;
                                                        }
        
                                                       }
    public boolean deleteIstekTalep(IstekTalep istektalep) throws SQLException {
        String sql = "DELETE FROM istektalep where id = ? and tamamla='Hayır' ";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, istektalep.getId());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    } 
                                                    public boolean updateIstekTalep(IstekTalep istektalep) throws SQLException {
                                                        String sql = "UPDATE istektalep SET cevap = ?, tamamla = ?";
                                                        sql += " WHERE id = ?";
                                                        connect();
                                                        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                        statement.setString(1, istektalep.getCevap());
                                                        statement.setString(2, "Evet");
                                                        statement.setInt(3, istektalep.getId());
                                                        boolean rowUpdated = statement.executeUpdate() > 0;
                                                        statement.close();
                                                        disconnect();
                                                        return rowUpdated;
                                                    }  
    public boolean updateMusteriKontak(Kontak kontak) throws SQLException {
        String sql = "UPDATE kontak SET musteri_id=?, departman=?, unvan=?, hitap=?, gsm=?, tel=?, email=?";
        sql += " WHERE id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, kontak.getMusteri_id());
        statement.setString(2, kontak.getDepartman());
        statement.setString(3, kontak.getUnvan());
        statement.setString(4, kontak.getHitap());
        statement.setString(5, kontak.getGsm());
        statement.setString(6, kontak.getTel());
        statement.setString(7, kontak.getEmail());
        statement.setInt(8, kontak.getId());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    } 
                                                                                public boolean deleteKontak(Kontak kontak) throws SQLException {
                                                                                    String sql = "DELETE FROM Kontak where id = ? ";
                                                                                    connect();
                                                                                    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
                                                                                    statement.setInt(1, kontak.getId());
                                                                                    boolean rowDeleted = statement.executeUpdate() > 0;
                                                                                    statement.close();
                                                                                    disconnect();
                                                                                    return rowDeleted;
                                                                                }     

}