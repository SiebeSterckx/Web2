package ui.controller;

import domain.DomainException;
import domain.db.Auto_db;
import domain.model.Auto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private final Auto_db autodb = new Auto_db();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            processRequest(request, response);
        }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        processRequest(request, response);
        }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String command = "index";
        if (request.getParameter("command") != null) {
             command = request.getParameter("command");
        }

        String destination = "";
        switch(command){
            case "add":
                destination = this.add(request);
                break;
            case "voegToe":
                destination = voegToe(request);
                break;
            case "overzicht":
                destination = overzicht(request);
                break;
            case "zoekFormulier":
                destination = zoekFormulier(request, response);
                break;
            case "zoek":
                destination = zoek(request);
                break;
            case "removeConfirmPage":
                destination = removeConfirmPage(request);
                break;
            case "remove":
                destination = remove(request);
                break;
            case "updateConfirmPage":
                destination = updateConfirmPage(request);
                break;
            case "addMetVerwijderSession":
                destination = addMetVerwijderSession(request);
                break;
            case "update":
                destination = update(request, response);
                break;

            default:
                destination = index(request);

        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String index(HttpServletRequest request){
        request.setAttribute("meestgespotte", autodb.getMeestGespotteAuto());

        Cookie cookie = getCookieWithKey(request, "laatstAangepast");
        if(cookie==null){
            request.setAttribute("laatstAangepast", "Er zijn nog geen updates geweest.");
        }
        else {
            String info= cookie.getValue();
            Auto auto = autodb.vindAuto(Integer.parseInt(info));

            if(auto != null) {
                request.setAttribute("laatstAangepast", "De laatst aangepaste auto is de "+auto.getMerk()+" "+auto.getModel()+" met "+auto.getPk()+" pk en "+auto.getAantalSpots()+" spots. ");
            }
            else{
                request.setAttribute("laatstAangepast","De auto met id " + info + " bestaat niet meer.");
            }
        }
        return "index.jsp";
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies)
        {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }

    private String voegToe(HttpServletRequest request){

        return "voeg toe.jsp";
    }

    private String overzicht(HttpServletRequest request){
        request.setAttribute("geefautos", autodb.getAutos());
        request.setAttribute("meestgespotte", autodb.getMeestGespotteAuto());
        return "overzicht.jsp";
    }

    private String add(HttpServletRequest request){
        ArrayList<String> errors = new ArrayList<>();

        Auto auto = new Auto();
        setMerk(auto, request, errors);
        setModel(auto, request, errors);
        setPk(auto, request, errors);

        setAantalSpots(auto, request, errors);

        if (errors.size() == 0) {
            try {
                autodb.add(auto);
                return overzicht(request);
            } catch (DomainException exc) {
                errors.add(exc.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "voeg toe.jsp";

    }

    private void setMerk(Auto auto, HttpServletRequest request, ArrayList<String> errors) {
        String merk = request.getParameter("input_merk");

        try {
            auto.setMerk(merk);
            request.setAttribute("merkPreviousValue", merk);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setModel(Auto auto, HttpServletRequest request, ArrayList<String> errors) {
        String model = request.getParameter("input_model");

        try {
            request.setAttribute("modelPreviousValue", model);
            auto.setModel(model);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());

        }
    }
    private void setPk(Auto auto, HttpServletRequest request, ArrayList<String> errors) {
        String pk = request.getParameter("input_pk");
        if(request.getParameter("input_pk") != null && !request.getParameter("input_pk").isEmpty()) {

            try {
                request.setAttribute("pkPreviousValue", pk);
                auto.setPk(Integer.parseInt(pk));
            }
            catch (DomainException exc) {
                errors.add(exc.getMessage());

            }
        }
    }
    private void setAantalSpots(Auto auto, HttpServletRequest request, ArrayList<String> errors) {
        String spots = request.getParameter("input_spots");

        try {
            request.setAttribute("spotsPreviousValue", spots);
            auto.setAantalSpots(Integer.parseInt(spots));
        } catch (NumberFormatException exc) {
            errors.add("Aantal spots mag niet leeg zijn.");

        } catch (DomainException exc) {
            errors.add(exc.getMessage());

        }
    }


    private String removeConfirmPage(HttpServletRequest request){
        request.setAttribute("id", request.getParameter("id"));
        return "deleteConfirmation.jsp";
    }
    private String updateConfirmPage(HttpServletRequest request){
        request.setAttribute("id", request.getParameter("id"));
        Auto updateAuto=autodb.updateAuto(Integer.parseInt(request.getParameter("id")));
        int updateAutoSpots= updateAuto.getAantalSpots();
        request.setAttribute("updateAutoSpots", updateAutoSpots);
        return "updateConfirmation.jsp";
    }

    private String remove(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("id"));
        Auto verwijderdeAuto= autodb.vindAuto(id);
        autodb.deleteAuto(id);
        HttpSession session= request.getSession();
        session.setAttribute("laatstVerwijderdeAuto", verwijderdeAuto);
        return overzicht(request);
    }

    private String update(HttpServletRequest request, HttpServletResponse response){

        ArrayList<String> errors3 = new ArrayList<>();
        int id= Integer.parseInt(request.getParameter("id"));
        Auto updateAuto=autodb.updateAuto(id);


        Cookie c = new Cookie("laatstAangepast", String.valueOf(id));
        response.addCookie(c);


        setAantalSpots(updateAuto, request, errors3);

        if (errors3.size() == 0) {
            try {
                return overzicht(request);
            } catch (DomainException exc) {
                errors3.add(exc.getMessage());
            }
        }
        request.setAttribute("errors3", errors3);
        return updateConfirmPage(request);
    }

    private String zoek(HttpServletRequest request) {

        ArrayList<String> errors2 = new ArrayList<>();
       try {
           String model = request.getParameter("input_model_zoek");
           Auto vindModel= autodb.vind(model);
           request.setAttribute("auto", vindModel);
           return "result.jsp";
       }
       catch (Exception e){
            errors2.add(e.getMessage());
            request.setAttribute("errors2", errors2);
            return "zoekFormulier.jsp";
        }
    }

    private String zoekFormulier(HttpServletRequest request, HttpServletResponse response) {
        return "zoekFormulier.jsp";
    }
    private String addMetVerwijderSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        Auto item = (Auto) session.getAttribute("laatstVerwijderdeAuto");
        autodb.add(item, item.getId());
        session.setAttribute("laatstVerwijderdeAuto", null);
        return overzicht(request);
    }



}