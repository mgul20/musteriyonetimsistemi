/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.IstekTalep;
import model.Kontak;
import model.User;
import model.Musteri;
import model.Teklif;
import model.Teklif_detay;


import proje.LoginDAO;
import proje.CodingDAO;

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;
    private CodingDAO codingDAO;
    public String yetki;
    public int userid;

    public void init() {
        loginDAO = new LoginDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getServletPath();
        
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/newmus":
                    showNewFormMusteri(request, response);
                    break;
                case "/kontakmus":
                    showNewFormKontak(request, response);
                    break;
                case "/istektalepac":
                    showEditIstekTalep(request, response);
                    break;
                case "/istektalep":
                    showNewFormIstekTalep(request, response);
                    break;
                case "/teklifmus":
                    showNewFormTeklif(request, response);
                    break;
                case "/teklifdetayekle":
                    showNewFormTeklifDetay(request, response);
                    break;                    
                case "/home":
                    home(request, response);
                    break;                   
                case "/listteklif":
                    listTeklif(request, response);
                    break;
                case "/listteklifonayli":
                    listTeklif(request, response);
                    break;
                case "/listteklifonaysiz":
                    listTeklif(request, response);
                    break;
                case "/list":
                    listUser(request, response);
                    break;
                case "/listmus":
                    listMusteri(request, response);
                    break;
                case "/listkontak":
                    listKontak(request, response);
                    break;                    
                case "/musdetay":
                    MusteriDetay(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/editmus":
                    showEditFormMusteri(request, response);
                    break;
                case "/editkontak":
                    showEditKontak(request, response);
                    break;
        
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        HttpSession session = request.getSession(false);
        HttpSession sessiontur = request.getSession(false);
        HttpSession sessionid = request.getSession(false);
        HttpSession count = request.getSession(false);
        HttpSession countgercek = request.getSession(false);
        HttpSession countpotansiyel = request.getSession(false);
        HttpSession countkisisel = request.getSession(false);
        HttpSession toplamteklif = request.getSession(false);
        HttpSession onayli = request.getSession(false);
        HttpSession onaysiz = request.getSession(false);
        HttpSession tutar = request.getSession(false);        
        if(LoginDAO.validate(n, p)){
            Teklif tekliftoplam = loginDAO.teklifToplam();
            toplamteklif.setAttribute("tekliftoplam", tekliftoplam.getCount());
            Teklif onayliteklif = loginDAO.onayliTeklif();
            onayli.setAttribute("onayli", onayliteklif.getCount());
            Teklif onaysizteklif = loginDAO.onaysizTeklif();
            onaysiz.setAttribute("onaysiz", onaysizteklif.getCount());
            Teklif tutaronayteklif = loginDAO.tutarOnayTeklif();
            tutar.setAttribute("onaylitutar", tutaronayteklif.getCount());
            Musteri existingMusteri = loginDAO.musteriCount();
            count.setAttribute("msayi", existingMusteri.getCount());
            Musteri gercek = loginDAO.gercekMusteri();
            countgercek.setAttribute("gsayi", gercek.getCount());
            Musteri potansiyel = loginDAO.potMusteri();
            countpotansiyel.setAttribute("psayi", potansiyel.getCount());
            Musteri kisisel = loginDAO.kisiselMusteri();
            countkisisel.setAttribute("ksayi", kisisel.getCount());
            User existingUser = loginDAO.selectUserGiris(n);
            yetki=existingUser.getTuru();
            userid=existingUser.getId();
            request.setAttribute("yetki", yetki);
            session.setAttribute("tamadi", existingUser.getTamadi());
            sessiontur.setAttribute("turu", existingUser.getTuru());
            sessionid.setAttribute("userid", existingUser.getId());
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("<p align=center style=\"color:red\">Kullanici Adi veya Sifre Hatali</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
    } 
        
    
private void home(HttpServletRequest request, HttpServletResponse response)
throws SQLException, ServletException, IOException {
        request.setCharacterEncoding("utf-8");
    HttpSession count = request.getSession(false);
    HttpSession countgercek = request.getSession(false);
    HttpSession countpotansiyel = request.getSession(false);
    HttpSession countkisisel = request.getSession(false);
        HttpSession toplamteklif = request.getSession(false);
        HttpSession onayli = request.getSession(false);
        HttpSession onaysiz = request.getSession(false);
        HttpSession tutar = request.getSession(false); 
            Teklif tekliftoplam = loginDAO.teklifToplam();
            toplamteklif.setAttribute("tekliftoplam", tekliftoplam.getCount());
            Teklif onayliteklif = loginDAO.onayliTeklif();
            onayli.setAttribute("onayli", onayliteklif.getCount());
            Teklif onaysizteklif = loginDAO.onaysizTeklif();
            onaysiz.setAttribute("onaysiz", onaysizteklif.getCount());
            Teklif tutaronayteklif = loginDAO.tutarOnayTeklif();
            tutar.setAttribute("onaylitutar", tutaronayteklif.getCount());        
    Musteri existingMusteri = loginDAO.musteriCount();
    count.setAttribute("msayi", existingMusteri.getCount());
    Musteri gercek = loginDAO.gercekMusteri();
    countgercek.setAttribute("gsayi", gercek.getCount());
    Musteri potansiyel = loginDAO.potMusteri();
    countpotansiyel.setAttribute("psayi", potansiyel.getCount());
    Musteri kisisel = loginDAO.kisiselMusteri();
    countkisisel.setAttribute("ksayi", kisisel.getCount());
    RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
    dispatcher.forward(request, response);
}
            
                                                                                private void listUser(HttpServletRequest request, HttpServletResponse response)
                                                                                throws SQLException, IOException, ServletException {
                                                                                    request.setCharacterEncoding("utf-8");
                                                                                    List<User> listUser = loginDAO.selectAllUsers();
                                                                                    request.setAttribute("listUser", listUser);
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");
                                                                                    dispatcher.forward(request, response);
                                                                                }
private void listMusteri(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException {
    request.setCharacterEncoding("utf-8");
    List<Musteri> listMusteri = loginDAO.selectAllMusteri();
    request.setAttribute("listMusteri", listMusteri);
    RequestDispatcher dispatcher = request.getRequestDispatcher("musteri-list.jsp");
    dispatcher.forward(request, response);
}   
                                                                                private void listKontak(HttpServletRequest request, HttpServletResponse response)
                                                                                throws SQLException, IOException, ServletException {
                                                                                        request.setCharacterEncoding("utf-8");
                                                                                    List<Kontak> listKontak = loginDAO.selectAllKontak();
                                                                                    request.setAttribute("listKontak", listKontak);
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("kontak-list.jsp");
                                                                                    dispatcher.forward(request, response);
                                                                                }         
private void MusteriDetay(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException {       
    int id = Integer.parseInt(request.getParameter("id"));
    int musteri_id = Integer.parseInt(request.getParameter("id"));
    Musteri existingMusteri = loginDAO.selectMusteri(id);
    List<Kontak> MusteriDetay = loginDAO.selectMusteriDetay(musteri_id);
    List<Teklif> MusteriTeklif = loginDAO.selectMusteriTeklif(musteri_id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("musteridetay.jsp");
    request.setAttribute("teklif", MusteriTeklif);
    request.setAttribute("kontak", MusteriDetay);
    request.setAttribute("musteri", existingMusteri);
    dispatcher.forward(request, response);
}

    
                                                                                private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                                                                                throws ServletException, IOException {
                                                                                    request.setCharacterEncoding("utf-8");
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
                                                                                    dispatcher.forward(request, response);
                                                                                }
private void showNewFormMusteri(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    RequestDispatcher dispatcher = request.getRequestDispatcher("musterikayit.jsp");
    dispatcher.forward(request, response);
}
                                                                                private void showNewFormKontak(HttpServletRequest request, HttpServletResponse response)
                                                                                throws ServletException, IOException {
                                                                                        request.setCharacterEncoding("utf-8");
                                                                                        int id = Integer.parseInt(request.getParameter("id"));
                                                                                    Musteri existingMusteri = loginDAO.selectMusteri(id);
                                                                                    request.setAttribute("musteri", existingMusteri);
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("kontakkayit.jsp");
                                                                                    dispatcher.forward(request, response);
                                                                                }
private void showNewFormTeklif(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));
    Musteri existingMusteri = loginDAO.selectMusteri(id);
    request.setAttribute("musteri", existingMusteri);
    RequestDispatcher dispatcher = request.getRequestDispatcher("teklif.jsp");
    dispatcher.forward(request, response);
}
                                                                                private void showNewFormTeklifDetay(HttpServletRequest request, HttpServletResponse response)
                                                                                throws ServletException, IOException, SQLException {
                                                                                        request.setCharacterEncoding("utf-8");
                                                                                        int id = Integer.parseInt(request.getParameter("id"));
                                                                                        int teklif_id = Integer.parseInt(request.getParameter("id"));
                                                                                        Teklif existingTeklif= loginDAO.selectTeklif(id);
                                                                                        List<Teklif_detay> existingTeklifDetay= loginDAO.selectAllTeklifDetay(teklif_id);
                                                                                        request.setAttribute("dteklif", existingTeklifDetay);
                                                                                        request.setAttribute("teklif", existingTeklif);
                                                                                        RequestDispatcher dispatcher = request.getRequestDispatcher("teklif_detay.jsp");
                                                                                        dispatcher.forward(request, response);
                                                                                }
        
private void showEditForm(HttpServletRequest request, HttpServletResponse response)
throws SQLException, ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));
    User existingUser = loginDAO.selectUser(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
    request.setAttribute("user", existingUser);
    dispatcher.forward(request, response);
}
                                                                                private void showEditFormMusteri(HttpServletRequest request, HttpServletResponse response)
                                                                                throws SQLException, ServletException, IOException {
                                                                                        request.setCharacterEncoding("utf-8");
                                                                                    int id = Integer.parseInt(request.getParameter("id"));
                                                                                    Musteri existingMusteri = loginDAO.selectMusteri(id);
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("musterikayit.jsp");
                                                                                    request.setAttribute("musteri", existingMusteri);
                                                                                    dispatcher.forward(request, response);

                                                                                }
private void listTeklif(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException {
    String sorgu = request.getServletPath();
    String link =null;
    switch (sorgu){
        case "/listteklif":
                List<Teklif> listTeklif = loginDAO.selectAllTeklif();
                RequestDispatcher dispatcher = request.getRequestDispatcher("listteklif.jsp");
                request.setAttribute("listTeklif", listTeklif);
                request.setAttribute("yetki", yetki);
                dispatcher.forward(request, response);
            break;
        case "/listteklifonayli":
            link="1";
                List<Teklif> listTeklifOnay = loginDAO.selectAllTeklifKontrol(link);
                RequestDispatcher dispatcheronay = request.getRequestDispatcher("listteklif.jsp");
                request.setAttribute("listTeklif", listTeklifOnay);
                request.setAttribute("yetki", yetki);
                dispatcheronay.forward(request, response);
            break;
        case "/listteklifonaysiz":
            link="0";
                List<Teklif> listTeklifOnaysiz = loginDAO.selectAllTeklifKontrol(link);
                RequestDispatcher dispatcheronaysiz = request.getRequestDispatcher("listteklif.jsp");
                request.setAttribute("listTeklif", listTeklifOnaysiz);
                request.setAttribute("yetki", yetki);
                dispatcheronaysiz.forward(request, response);
            break;    
            
               
    }
}
                                                                                private void showNewFormIstekTalep(HttpServletRequest request, HttpServletResponse response)
                                                                                throws ServletException, IOException {
                                                                                    request.setCharacterEncoding("utf-8");
                                                                                    if (yetki.equals("Admin")){
                                                                                            List<IstekTalep> listIstekTalep = loginDAO.selectAllIstekTalep(); 
                                                                                            request.setAttribute("listIstekTalep", listIstekTalep);
                                                                                            
                                                                                       }else {
                                                                                            List<IstekTalep> listIstekTalep = loginDAO.selectAllIstekTalepUser(userid); 
                                                                                            request.setAttribute("listIstekTalep", listIstekTalep);
                                                                                    }
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("istektalep.jsp");
                                                                                    dispatcher.forward(request, response);
                                                                                }
private void showEditIstekTalep(HttpServletRequest request, HttpServletResponse response)
throws SQLException, ServletException, IOException {
        request.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(request.getParameter("id"));
    IstekTalep existingIstekTalep = loginDAO.selectIstekTalep(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("istektaleponay.jsp");
    request.setAttribute("istektalep", existingIstekTalep);
    dispatcher.forward(request, response);

}                                                                                
                                                                                private void showEditKontak(HttpServletRequest request, HttpServletResponse response)
                                                                                throws SQLException, ServletException, IOException {
                                                                                        request.setCharacterEncoding("utf-8");
                                                                                    int id = Integer.parseInt(request.getParameter("id"));
                                                                                    Kontak existingKontak = loginDAO.selectKontak(id);
                                                                                    RequestDispatcher dispatcher = request.getRequestDispatcher("kontakkayit.jsp");
                                                                                    request.setAttribute("kontak", existingKontak);
                                                                                    dispatcher.forward(request, response);

                                                                                } 

} 