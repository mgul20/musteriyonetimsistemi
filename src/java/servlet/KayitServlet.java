/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.IstekTalep;
import model.Kontak;
import model.User;
import model.Musteri;
import model.Teklif;
import model.Teklif_detay;
import proje.CodingDAO;
import proje.LoginDAO;
/**
 *
 * @author MGUL
 */

public class KayitServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private LoginDAO loginDAO;
        private CodingDAO codingDAO;

    public void init() {
        loginDAO = new LoginDAO();
        String jdbcURL = getServletContext().getInitParameter("jdbc:mysql://localhost:3306/mgul");
        String jdbcUsername = getServletContext().getInitParameter("root");
        String jdbcPassword = getServletContext().getInitParameter("Sivas2020");
 
        codingDAO = new CodingDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/musinsert":
                    insertMus(request, response);
                    break;
                case "/teklifinsert":
                    insertTeklif(request, response);
                    break;
                case "/insertteklifdetayekle":
                    insertTeklifDetay(request, response);
                    break; 
                case "/kontakinsert":
                    insertMusKontak(request, response);
                    break;
                case "/kontakupdate":
                    updateMusKontak(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/insertistektalep":
                    insertIstekTalep(request, response);
                    break;                    
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/istektalepdelete":
                    deleteIstekTalep(request, response);
                    break;                    
                case "/deletemus":
                    deleteMusteri(request, response);
                    break;
                case "/deleteteklifdetay":
                    deleteTeklifDetay(request, response);
                    break;
                case "/deletekontak":
                    deleteKontak(request, response);
                    break;                    
                case "/update":
                    updateUser(request, response);
                    break;
                case "/updateistektalep":
                    updateistektalep(request, response);
                    break;                    
                case "/musupdate":
                    updateMusteri(request, response);
                    break;
                case "/tekliftamamla":
                    musteriTeklifTamamla(request, response);
                    break;
                case "/teklifonay":
                    musteriTeklifOnay(request, response);
                    break;                    

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getServletPath();
        switch (action) {

            case "/insert":
                String name = request.getParameter("name");
                if (LoginDAO.control(name)) {

                    out.print("<p align=center style=\"color:red\">Kullanici Adi daha önce kullanılmış</p>");
                    RequestDispatcher rd = request.getRequestDispatcher("user-form.jsp");
                    rd.include(request, response);

                } else {
                    doGet(request, response);

                }
                break;
            default:
                doGet(request, response);
                break;

        } 
       
    }
    private void insertMus(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        request.setCharacterEncoding("utf-8");
        String kodu = request.getParameter("kodu");
        String adi = request.getParameter("adi");
        String yetkiliadi = request.getParameter("yetkiliadi");
        String turu = request.getParameter("turu");
        String email = request.getParameter("email");
        String gsm = request.getParameter("gsm");
        String tel = request.getParameter("tel");
        String ulke = request.getParameter("ulke");
        String sehir = request.getParameter("sehir");
        String adres = request.getParameter("adres");
        Musteri newMusteri = new Musteri(kodu, adi, yetkiliadi, turu,email, gsm, tel, ulke,sehir,adres);
        codingDAO.insertMusteri(newMusteri);
        response.sendRedirect("listmus");
    }
                                                    private void insertTeklif(HttpServletRequest request, HttpServletResponse response)
                                                    throws SQLException, IOException{
                                                                request.setCharacterEncoding("utf-8");
                                                                int musteri_id = Integer.parseInt(request.getParameter("musteri_id"));
                                                                int kontak_id = 0;
                                                                String teklif_no = request.getParameter("teklif_no");
                                                                String durumu = request.getParameter("durumu");
                                                                String konu = request.getParameter("konu");
                                                                String tarih = request.getParameter("tarih");
                                                                String aciklama = request.getParameter("aciklama");
                                                                String onay = "0";
                                                                String tamamla = "0";
                                                                Teklif newTeklif = new Teklif(musteri_id,kontak_id,teklif_no,durumu,konu,tarih,aciklama,onay,tamamla);
                                                                codingDAO.insertTeklif(newTeklif);
                                                                String yol="musdetay?id="+String.valueOf(musteri_id);
                                                       response.sendRedirect(yol);
                                                     }     
    private void insertMusKontak(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        request.setCharacterEncoding("utf-8");
        int musteri_id = Integer.parseInt(request.getParameter("musteri_id"));
        String departman = request.getParameter("departman");
        String unvan = request.getParameter("unvan");
        String hitap = request.getParameter("hitap");
        String gsm = request.getParameter("gsm");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        Kontak newKontak = new Kontak(musteri_id,departman,unvan,hitap,gsm,tel,email);
        codingDAO.insertMusteriKontak(newKontak);
        response.sendRedirect("listmus");
    }
     
                                                        private void insertUser(HttpServletRequest request, HttpServletResponse response)
                                                        throws SQLException, IOException {
                                                        request.setCharacterEncoding("utf-8");
                                                        String name = request.getParameter("name");
                                                        String email = request.getParameter("email");
                                                        String tamadi = request.getParameter("tamadi");
                                                        String password = request.getParameter("password");
                                                        String turu = request.getParameter("turu");
                                                        User newUser = new User(name, email, tamadi, password,turu);
                                                        codingDAO.insertUser(newUser);
                                                        response.sendRedirect("list");
                                                    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id);
        codingDAO.deleteUser(user);
        response.sendRedirect("list");
    }
                                                    private void deleteMusteri(HttpServletRequest request, HttpServletResponse response)
                                                    throws SQLException, IOException {
                                                        int id = Integer.parseInt(request.getParameter("id"));
                                                        Musteri musteri = new Musteri(id);
                                                        codingDAO.deleteMusteri(musteri);
                                                        response.sendRedirect("listmus");
                                                    }
        
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tamadi = request.getParameter("tamadi");
        String password = request.getParameter("password");
        String turu = request.getParameter("turu");
        User user = new User(id, name, email, tamadi, password,turu);
        codingDAO.updateUser(user);
        response.sendRedirect("list");
    }
                                                    private void updateMusteri(HttpServletRequest request, HttpServletResponse response)
                                                    throws SQLException, IOException {
                                                        request.setCharacterEncoding("utf-8");
                                                        int id = Integer.parseInt(request.getParameter("id"));
                                                        String kodu = request.getParameter("kodu");
                                                        String adi = request.getParameter("adi");
                                                        String yetkiliadi = request.getParameter("yetkiliadi");
                                                        String turu = request.getParameter("turu");
                                                        String email = request.getParameter("email");
                                                        String gsm = request.getParameter("gsm");
                                                        String tel = request.getParameter("tel");
                                                        String ulke = request.getParameter("ulke");
                                                        String sehir = request.getParameter("sehir");
                                                        String adres = request.getParameter("adres");
                                                        Musteri musteri = new Musteri(id,kodu, adi, yetkiliadi, turu,email, gsm, tel, ulke,sehir,adres);
                                                        codingDAO.updateMusteri(musteri);
                                                        response.sendRedirect("listmus");
                                                    }
    private void insertTeklifDetay(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException{
        request.setCharacterEncoding("utf-8");
        int teklifid = Integer.parseInt(request.getParameter("teklif_id"));
        String sira = request.getParameter("sira");
        String kodu = request.getParameter("kodu");
        String adi = request.getParameter("adi");
        double miktar = Double.parseDouble(request.getParameter("miktar"));
        double fiyat = Double.parseDouble(request.getParameter("fiyat"));
        double toplam =miktar*fiyat;
        Teklif_detay newTeklifDetay = new Teklif_detay(teklifid,sira,kodu,adi,miktar,fiyat,toplam);
        codingDAO.insertTeklifDetay(newTeklifDetay);
        response.sendRedirect("teklifdetayekle?id="+String.valueOf(teklifid));
     }
                                                    private void deleteTeklifDetay(HttpServletRequest request, HttpServletResponse response)
                                                    throws SQLException, IOException {
                                                        
                                                        int id = Integer.parseInt(request.getParameter("id"));
                                                        int teklifid = Integer.parseInt(request.getParameter("teklif_id"));
                                                        Teklif_detay teklifdetay = new Teklif_detay(id);
                                                        codingDAO.deleteTeklifDetay(teklifdetay);
                                                        response.sendRedirect("teklifdetayekle?id="+String.valueOf(teklifid));
                                                        
                                                    } 
private void musteriTeklifTamamla(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException {
    request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));
    Teklif teklif = new Teklif(id);
    codingDAO.teklifTamamla(teklif);
    response.sendRedirect("listmus");
}
                                                        private void insertIstekTalep(HttpServletRequest request, HttpServletResponse response)
                                                        throws SQLException, IOException {
                                                        request.setCharacterEncoding("utf-8");
                                                        int userid = Integer.parseInt(request.getParameter("userid"));
                                                        String turu = request.getParameter("turu");
                                                        String konu = request.getParameter("konu");
                                                        String aciklama = request.getParameter("aciklama");
                                                        String cevap = request.getParameter("cevap");
                                                        String tamamla = request.getParameter("tamamla");
                                                        IstekTalep newIstekTalep = new IstekTalep(userid, turu, konu, aciklama, cevap, tamamla);
                                                        codingDAO.insertIstekTalep(newIstekTalep);
                                                        response.sendRedirect("istektalep");
                                                    }
private void musteriTeklifOnay(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException {
    request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));
    String onay = request.getParameter("onay");
    Teklif teklif = new Teklif(id,onay);
    codingDAO.teklifOnay(teklif);
    response.sendRedirect("listteklif");
}
                                                    private void deleteIstekTalep(HttpServletRequest request, HttpServletResponse response)
                                                    throws SQLException, IOException {
                                                        
                                                        int id = Integer.parseInt(request.getParameter("id"));
                                                        IstekTalep istektalep = new IstekTalep(id);
                                                        codingDAO.deleteIstekTalep(istektalep);
                                                        response.sendRedirect("istektalep");
                                                        
                                                    }
    private void updateistektalep(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String konu = request.getParameter("konu");
        String aciklama = request.getParameter("aciklama");
        String cevap = request.getParameter("cevap");
        String tamamla = request.getParameter("tamamla");
        IstekTalep istektalep = new IstekTalep(id,konu, aciklama, cevap, tamamla);
        codingDAO.updateIstekTalep(istektalep);
        response.sendRedirect("istektalep");
    }
                                                                                private void updateMusKontak(HttpServletRequest request, HttpServletResponse response)
                                                                                throws SQLException, IOException {
                                                                                    request.setCharacterEncoding("utf-8");
                                                                                    int id = Integer.parseInt(request.getParameter("id"));
                                                                                    int musteri_id = Integer.parseInt(request.getParameter("musteri_id"));
                                                                                    String departman = request.getParameter("departman");
                                                                                    String unvan = request.getParameter("unvan");
                                                                                    String hitap = request.getParameter("hitap");
                                                                                    String gsm = request.getParameter("gsm");
                                                                                    String tel = request.getParameter("tel");
                                                                                    String email = request.getParameter("email");
                                                                                    Kontak editKontak = new Kontak(id,musteri_id,departman,unvan,hitap,gsm,tel,email);
                                                                                    codingDAO.updateMusteriKontak(editKontak);
                                                                                    response.sendRedirect("listkontak");
                                                                                }   
private void deleteKontak(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    Kontak kontak = new Kontak(id);
    codingDAO.deleteKontak(kontak);
    response.sendRedirect("listkontak");

}                                                                                
       
}
