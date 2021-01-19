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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.IstekTalep;
import model.Kontak;
import model.User;
import model.Musteri;
import model.Teklif;
import model.Teklif_detay;
import servlet.LoginServlet;

public class LoginDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/mgul";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Sivas2020";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, tamadi, password,turu) VALUES(?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,tamadi,password,turu from users where id =?";
    private static final String SELECT_USER_GIRIS_ID = "select id,name,email,tamadi,password,turu from users where name =?";
    private static final String SELECT_MUSTERI_BY_ID = "select id,kodu,adi,yetkiliadi,turu,email,gsm,tel,ulke,sehir,adres from musteri where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_ALL_MUSTERI = "select * from musteri";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, tamadi =? , password=?,turu=? where id = ?;";

    public LoginDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

            pst = conn.prepareStatement("select * from users where name=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);
 

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
        
    }
        public static boolean control(String name) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

            pst = conn.prepareStatement("select * from users where name=? ");
            pst.setString(1, name);

 

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
        
    }
    
public  List<User> selectAllUsers() {

// using try-with-resources to avoid closing resources (boiler plate code)
List<User> users = new ArrayList<> ();
// Step 1: Establishing a Connection
try (Connection connection = getConnection();
    // Step 2:Create a statement using connection object
    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
    System.out.println(preparedStatement);
    // Step 3: Execute the query or update query
    ResultSet rs = preparedStatement.executeQuery();
    // Step 4: Process the ResultSet object.
    while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String tamadi = rs.getString("tamadi");
        String password = rs.getString("password");
        String turu = rs.getString("turu");
        users.add(new User(id, name, email, tamadi, password,turu));
    }
} catch (SQLException e) {
    printSQLException(e);
}
return users;
}
                                                                public  List<Teklif> selectMusteriTeklif(int musteriid) {
                                                                  List<Teklif> teklif = new ArrayList<> ();
                                                                  try (Connection connection = getConnection();
                                                                      PreparedStatement preparedStatement = connection.prepareStatement("select * from teklif where musteri_id=?");) {
                                                                      preparedStatement.setInt(1, musteriid);
                                                                      ResultSet rs = preparedStatement.executeQuery();
                                                                      while (rs.next()) {
                                                                          int id  = rs.getInt("id");
                                                                          int musteri_id = rs.getInt("musteri_id");
                                                                          int kontak_id = rs.getInt("kontak_id");
                                                                          String teklif_no = rs.getString("teklif_no");
                                                                          String durumu = rs.getString("durumu");
                                                                          String konu = rs.getString("konu");
                                                                          String tarih = rs.getString("tarih");
                                                                          String aciklama = rs.getString("aciklama");
                                                                          String onay = rs.getString("onay");
                                                                          String tamamla = rs.getString("tamamla");
                                                                          teklif.add(new Teklif(id, musteri_id,kontak_id, teklif_no, durumu, konu, tarih, aciklama, onay,tamamla));
                                                                      }
                                                                    } catch (SQLException e) {
                                                                      printSQLException(e);
                                                                  }
                                                                  return teklif;
                                                              }
public  List<Kontak> selectMusteriDetay(int musteriid) {
  List<Kontak> kontak = new ArrayList<> ();
  try (Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("select * from kontak where musteri_id=?");) {
      preparedStatement.setInt(1, musteriid);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
          int id  = rs.getInt("id");
          int musteri_id = rs.getInt("musteri_id");
          String departman = rs.getString("departman");
          String unvan = rs.getString("unvan");
          String hitap = rs.getString("hitap");
          String gsm = rs.getString("gsm");
          String tel = rs.getString("tel");
          String email = rs.getString("email");

          kontak.add(new Kontak(id, musteri_id, departman, unvan, hitap, gsm, tel, email));
      }
    } catch (SQLException e) {
      printSQLException(e);
  }
  return kontak;
}
                                                                public  List<Kontak> selectAllKontak() {
                                                                  List<Kontak> kontak = new ArrayList<> ();
                                                                  try (Connection connection = getConnection();
                                                                      PreparedStatement preparedStatement = connection.prepareStatement("select * from kontak ");) {
                                                                      ResultSet rs = preparedStatement.executeQuery();
                                                                      while (rs.next()) {
                                                                          int id = rs.getInt("id");
                                                                          int musteri_id = rs.getInt("musteri_id");
                                                                          String departman = rs.getString("departman");
                                                                          String unvan = rs.getString("unvan");
                                                                          String hitap = rs.getString("hitap");
                                                                          String gsm = rs.getString("gsm");
                                                                          String tel = rs.getString("tel");
                                                                          String email = rs.getString("email");


                                                                          kontak.add(new Kontak(id, musteri_id, departman, unvan, hitap, gsm, tel, email));
                                                                      }
                                                                    } catch (SQLException e) {
                                                                      printSQLException(e);
                                                                  }
                                                                  return kontak;
                                                              }      
public  List<Teklif_detay> selectAllTeklifDetay(int teklifid) {
    List<Teklif_detay> tdetay = new ArrayList<> ();
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from teklif_detay where teklif_id=?");) {
        preparedStatement.setInt(1, teklifid);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int teklif_id = rs.getInt("teklif_id");
            String sira = rs.getString("sira");
            String kodu = rs.getString("kodu");
            String adi = rs.getString("adi");
            double miktar = rs.getDouble("miktar");
            double fiyat = rs.getDouble("fiyat");
            double toplam = rs.getDouble("toplam");
            tdetay.add(new Teklif_detay(id,teklif_id,sira, kodu, adi, miktar, fiyat, toplam));
        }
      } catch (SQLException e) {
        printSQLException(e);
    }
    return tdetay;
}
                                                                public  List<Musteri> selectAllMusteri() {
                                                                  List<Musteri> musteri = new ArrayList<> ();
                                                                  try (Connection connection = getConnection();
                                                                      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MUSTERI);) {
                                                                      ResultSet rs = preparedStatement.executeQuery();
                                                                      while (rs.next()) {
                                                                          int id = rs.getInt("id");
                                                                          String kodu = rs.getString("kodu");
                                                                          String adi = rs.getString("adi");
                                                                          String yetkiliadi = rs.getString("yetkiliadi");
                                                                          String turu = rs.getString("turu");
                                                                          String email = rs.getString("email");
                                                                          String gsm = rs.getString("gsm");
                                                                          String tel = rs.getString("tel");
                                                                          String ulke = rs.getString("ulke");
                                                                          String sehir = rs.getString("sehir");
                                                                          String adres = rs.getString("adres");
                                                                          musteri.add(new Musteri(id, kodu, adi, yetkiliadi, turu, email, gsm, tel, ulke, sehir,adres));
                                                                      }
                                                                    } catch (SQLException e) {
                                                                      printSQLException(e);
                                                                  }
                                                                  return musteri;
                                                              }
public Musteri kisiselMusteri() {
      Musteri musteri=null;
       try (Connection connection = getConnection();
       PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from musteri where turu like 'Ki%'");) 
       {
       ResultSet rs = preparedStatement.executeQuery();
       rs.next();
       int r = rs.getInt(1);
       musteri = new Musteri(r);
       } catch (SQLException e) {
           printSQLException(e);
       }return musteri;
   }  
                                                                public Musteri potMusteri() {
                                                                       Musteri musteri=null;
                                                                        try (Connection connection = getConnection();
                                                                        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from musteri where turu like 'Pot%'");) 
                                                                        {
                                                                        ResultSet rs = preparedStatement.executeQuery();
                                                                        rs.next();
                                                                        int r = rs.getInt(1);
                                                                        musteri = new Musteri(r);
                                                                        } catch (SQLException e) {
                                                                            printSQLException(e);
                                                                        }return musteri;
                                                                    } 
public Musteri gercekMusteri() {
       Musteri musteri=null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from musteri where turu like 'Ger%'");) 
        {
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int r = rs.getInt(1);
        musteri = new Musteri(r);
        } catch (SQLException e) {
            printSQLException(e);
        }return musteri;
    }               
                                                                public Musteri musteriCount() {
                                                                      Musteri musteri=null;
                                                                       try (Connection connection = getConnection();
                                                                       PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from musteri");) {
                                                                       System.out.println(preparedStatement);
                                                                       ResultSet rs = preparedStatement.executeQuery();
                                                                       rs.next();
                                                                       int t = rs.getInt(1);
                                                                       musteri = new Musteri(t);
                                                                       } catch (SQLException e) {
                                                                           printSQLException(e);
                                                                       }
                                                                       return musteri;
                                                                   }
       
public Teklif selectTeklif(int id) {
    Teklif teklif = null;
    // Step 1: Establishing a Connection
    try (Connection connection = getConnection();
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement("select * from teklif where id=?");) {
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int musteri_id = rs.getInt("musteri_id");
            int kontak_id = rs.getInt("kontak_id");
            String teklif_no = rs.getString("teklif_no");
            String durumu = rs.getString("durumu");
            String konu = rs.getString("konu");
            String tarih = rs.getString("tarih");
            String aciklama = rs.getString("aciklama");
            String onay = rs.getString("onay");
            String tamamla = rs.getString("tamamla");
            teklif = new Teklif(id,musteri_id,kontak_id,teklif_no,durumu,konu,tarih,aciklama,onay,tamamla);
        }
    } catch (SQLException e) {
        printSQLException(e);
    }
    return teklif;
}
                                                            public Musteri selectMusteri(int id) {
                                                                   Musteri musteri = null;
                                                                   // Step 1: Establishing a Connection
                                                                   try (Connection connection = getConnection();
                                                                       // Step 2:Create a statement using connection object
                                                                       PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MUSTERI_BY_ID);) {
                                                                       preparedStatement.setInt(1, id);
                                                                       ResultSet rs = preparedStatement.executeQuery();
                                                                       while (rs.next()) {
                                                                           String kodu = rs.getString("kodu");
                                                                           String adi = rs.getString("adi");
                                                                           String yetkiliadi = rs.getString("yetkiliadi");
                                                                           String turu = rs.getString("turu");
                                                                           String email = rs.getString("email");
                                                                           String gsm = rs.getString("gsm");
                                                                           String tel = rs.getString("tel");
                                                                           String ulke = rs.getString("ulke");
                                                                           String sehir = rs.getString("sehir");
                                                                           String adres = rs.getString("adres");
                                                                           musteri = new Musteri(id,kodu,adi,yetkiliadi,turu,email,gsm,tel,ulke,sehir,adres);
                                                                       }
                                                                   } catch (SQLException e) {
                                                                       printSQLException(e);
                                                                   }
                                                                   return musteri;
                                                               }
public User selectUser(int id) {
   User user = null;
   // Step 1: Establishing a Connection
   try (Connection connection = getConnection();
       // Step 2:Create a statement using connection object
       PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
       preparedStatement.setInt(1, id);
       System.out.println(preparedStatement);
       // Step 3: Execute the query or update query
       ResultSet rs = preparedStatement.executeQuery();

       // Step 4: Process the ResultSet object.
       while (rs.next()) {
           String name = rs.getString("name");
           String email = rs.getString("email");
           String tamadi = rs.getString("tamadi");
           String password = rs.getString("password");
           String turu = rs.getString("turu");
           user = new User(id, name, email, tamadi, password,turu);
       }
   } catch (SQLException e) {
       printSQLException(e);
   }
   return user;
}

                                                                public User selectUserGiris(String name) {
                                                                User user = null;
                                                                // Step 1: Establishing a Connection
                                                                try (Connection connection = getConnection();
                                                                    // Step 2:Create a statement using connection object
                                                                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_GIRIS_ID);) {
                                                                    preparedStatement.setString(1, name);
                                                                    System.out.println(preparedStatement);
                                                                    // Step 3: Execute the query or update query
                                                                    ResultSet rs = preparedStatement.executeQuery();

                                                                    // Step 4: Process the ResultSet object.
                                                                    while (rs.next()) {
                                                                        int id = rs.getInt("id");
                                                                        String email = rs.getString("email");
                                                                        String tamadi = rs.getString("tamadi");
                                                                        String password = rs.getString("password");
                                                                        String turu = rs.getString("turu");
                                                                        user = new User(id, name, email, tamadi, password,turu);
                                                                    }
                                                                } catch (SQLException e) {
                                                                    printSQLException(e);
                                                                }
                                                                return user;
                                                            }
public  List<Teklif> selectAllTeklif() {
  List<Teklif> teklif = new ArrayList<> ();
  try (Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("select * from teklif where tamamla=1");) {
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
          int id  = rs.getInt("id");
          int musteri_id = rs.getInt("musteri_id");
          int kontak_id = rs.getInt("kontak_id");
          String teklif_no = rs.getString("teklif_no");
          String durumu = rs.getString("durumu");
          String konu = rs.getString("konu");
          String tarih = rs.getString("tarih");
          String aciklama = rs.getString("aciklama");
          String onay = rs.getString("onay");
          String tamamla = rs.getString("tamamla");
          teklif.add(new Teklif(id, musteri_id,kontak_id, teklif_no, durumu, konu, tarih, aciklama, onay,tamamla));
      }
    } catch (SQLException e) {
      printSQLException(e);
  }
  return teklif;
}       
                                                                public Teklif teklifToplam() {
                                                                       Teklif teklif=null;
                                                                        try (Connection connection = getConnection();
                                                                        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from teklif where tamamla='1'");) 
                                                                        {
                                                                        ResultSet rs = preparedStatement.executeQuery();
                                                                        rs.next();
                                                                        int r = rs.getInt(1);
                                                                        teklif = new Teklif(r);
                                                                        } catch (SQLException e) {
                                                                            printSQLException(e);
                                                                        }return teklif;
                                                                    }
public Teklif onayliTeklif() {
       Teklif teklif=null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from teklif where onay='1' and tamamla='1'");) 
        {
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int r = rs.getInt(1);
        teklif = new Teklif(r);
        } catch (SQLException e) {
            printSQLException(e);
        }return teklif;
    }
                                                                public Teklif onaysizTeklif() {
                                                                       Teklif teklif=null;
                                                                        try (Connection connection = getConnection();
                                                                        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as toplam from teklif where onay='0' and tamamla='1'");) 
                                                                        {
                                                                        ResultSet rs = preparedStatement.executeQuery();
                                                                        rs.next();
                                                                        int r = rs.getInt(1);
                                                                        teklif = new Teklif(r);
                                                                        } catch (SQLException e) {
                                                                            printSQLException(e);
                                                                        }return teklif;
                                                                    }
public Teklif tutarOnayTeklif() {
       Teklif teklif=null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select sum(td.toplam) as toplam from teklif t,teklif_detay td where t.id=td.teklif_id and t.onay='1'");) 
        {
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int r = rs.getInt(1);
        teklif = new Teklif(r);
        } catch (SQLException e) {
            printSQLException(e);
        }return teklif;
    }
                                                                                public  List<IstekTalep> selectAllIstekTalep() {
                                                                                  List<IstekTalep> istektalep = new ArrayList<> ();
                                                                                  try (Connection connection = getConnection();
                                                                                      PreparedStatement preparedStatement = connection.prepareStatement("select i.id,i.userid,u.tamadi,i.turu,i.konu,i.aciklama,i.cevap,i.tamamla from istektalep i,users u where i.userid=u.id ");) {
                                                                                      ResultSet rs = preparedStatement.executeQuery();
                                                                                      while (rs.next()) {
                                                                                          int id  = rs.getInt("id");
                                                                                          int userid = rs.getInt("userid");
                                                                                          String tamadi= rs.getString("tamadi");
                                                                                          String turu = rs.getString("turu");
                                                                                          String konu = rs.getString("konu");
                                                                                          String aciklama = rs.getString("aciklama");
                                                                                          String cevap = rs.getString("cevap");
                                                                                          String tamamla = rs.getString("tamamla");
                                                                                          istektalep.add(new IstekTalep(id, userid,turu, konu, aciklama, cevap,tamamla,tamadi));
                                                                                      }
                                                                                    } catch (SQLException e) {
                                                                                      printSQLException(e);
                                                                                  }
                                                                                  return istektalep;
                                                                                }
public  List<IstekTalep> selectAllIstekTalepUser(int user_id) {
  List<IstekTalep> istektalep = new ArrayList<> ();
  try (Connection connection = getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("select i.id,i.userid,u.tamadi,i.turu,i.konu,i.aciklama,i.cevap,i.tamamla from istektalep i,users u where i.userid=u.id and userid=? ");) {
      preparedStatement.setInt(1, user_id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
          int id  = rs.getInt("id");
          int userid = rs.getInt("userid");
          String tamadi= rs.getString("tamadi");
          String turu = rs.getString("turu");
          String konu = rs.getString("konu");
          String aciklama = rs.getString("aciklama");
          String cevap = rs.getString("cevap");
          String tamamla = rs.getString("tamamla");
          istektalep.add(new IstekTalep(id, userid,turu, konu, aciklama, cevap,tamamla,tamadi));
      }
    } catch (SQLException e) {
      printSQLException(e);
  }
  return istektalep;
}

                                                                                public  List<Teklif> selectAllTeklifKontrol(String sorgu) {
                                                                                  List<Teklif> teklif = new ArrayList<> ();
                                                                                  try (Connection connection = getConnection();
                                                                                      PreparedStatement preparedStatement = connection.prepareStatement("select * from teklif where tamamla=1 and onay=?");) {
                                                                                      preparedStatement.setString(1, sorgu);
                                                                                      ResultSet rs = preparedStatement.executeQuery();
                                                                                      while (rs.next()) {
                                                                                          int id  = rs.getInt("id");
                                                                                          int musteri_id = rs.getInt("musteri_id");
                                                                                          int kontak_id = rs.getInt("kontak_id");
                                                                                          String teklif_no = rs.getString("teklif_no");
                                                                                          String durumu = rs.getString("durumu");
                                                                                          String konu = rs.getString("konu");
                                                                                          String tarih = rs.getString("tarih");
                                                                                          String aciklama = rs.getString("aciklama");
                                                                                          String onay = rs.getString("onay");
                                                                                          String tamamla = rs.getString("tamamla");
                                                                                          teklif.add(new Teklif(id, musteri_id,kontak_id, teklif_no, durumu, konu, tarih, aciklama, onay,tamamla));
                                                                                      }
                                                                                    } catch (SQLException e) {
                                                                                      printSQLException(e);
                                                                                  }
                                                                                  return teklif;
                                                                                }
public IstekTalep selectIstekTalep(int id) {
       IstekTalep istektalep = null;
       try (Connection connection = getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("select * from istektalep where id = ?");) {
           preparedStatement.setInt(1, id);
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()) {
               String konu = rs.getString("konu");
               String aciklama = rs.getString("aciklama");
               String cevap = rs.getString("cevap");
               String tamamla = rs.getString("tamamla");
               istektalep = new IstekTalep(id,konu,aciklama,cevap,tamamla);
           }
       } catch (SQLException e) {
           printSQLException(e);
       }
       return istektalep;
   } 
                                                                                public  Kontak selectKontak(int id) {
                                                                                  Kontak kontak = null;
                                                                                  try (Connection connection = getConnection();
                                                                                      PreparedStatement preparedStatement = connection.prepareStatement("select * from kontak where id=? ");) {
                                                                                      preparedStatement.setInt(1, id);
                                                                                      ResultSet rs = preparedStatement.executeQuery();
                                                                                      while (rs.next()) {
                                                                                          int musteri_id = rs.getInt("musteri_id");
                                                                                          String departman = rs.getString("departman");
                                                                                          String unvan = rs.getString("unvan");
                                                                                          String hitap = rs.getString("hitap");
                                                                                          String gsm = rs.getString("gsm");
                                                                                          String tel = rs.getString("tel");
                                                                                          String email = rs.getString("email");
                                                                                          kontak = new Kontak(id, musteri_id, departman, unvan, hitap, gsm, tel, email);
                                                                                      }
                                                                                    } catch (SQLException e) {
                                                                                      printSQLException(e);
                                                                                  }
                                                                                  return kontak;
                                                                              }

private void printSQLException(SQLException ex) {
for (Throwable e: ex) {
        if (e instanceof SQLException) {
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null) {
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }
}    
    
}
