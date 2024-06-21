package domain.db;

import domain.model.Auto;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import domain.DomainException;

public class Auto_db {
    private int sequence = 0;
    private final List<Auto> autos = new ArrayList<>();

    public Auto_db() {
        this.add(new Auto("Porsche", "911 GT3 RS", 50));
        this.add(new Auto("BMW", "M4", 480, 45));
        this.add(new Auto("Ferrari", "Enzo", 660, 2));
    }

    public void add(Auto auto) {
        if (auto == null) {
            throw new DomainException("Ongeldige auto om toe te voegen.");
        }
        else if (vind(auto.getModel()) != null){
            throw new DomainException("Je mag een auto maar één keer toevoegen.");
        }
        this.sequence++;
        auto.setId(sequence);
        autos.add(auto);
    }

    public void add(Auto auto, int id) {

        auto.setId(id);
        autos.add(auto);
    }




    public Auto vind(String model) {
        if (model == null || model.isEmpty())
            throw new DomainException("Model mag niet leeg zijn.");
        for (Auto auto : autos) {
            if (auto.getModel().contains(model))

                return auto;
        }
        return null;
    }


    public void deleteAuto(int id) {
        for (int i = 0; i < autos.size(); i++) {
            if(id == autos.get(i).getId()){
                autos.remove(i);
            }
        }
    }
    public Auto vindAuto(int id) {
        for (int i = 0; i < autos.size(); i++) {
            if (id == autos.get(i).getId()) {
                return autos.get(i);
            }
        }
        return null;
    }

    public Auto updateAuto(int id){
        for (Auto auto : autos) {
            if (id== auto.getId()) {
                return auto;
            }
        }
        return null;
    }


    public List<Auto> getAutos() {
        return autos;
    }


    public String getMeestGespotteAuto(){
        if(autos.size()==0){
            String niets="Geen informatie beschikbaar";
            return niets;
        }
        Auto meestGespot = autos.get(0);

        for(Auto auto: autos){
            if(auto.getAantalSpots()>meestGespot.getAantalSpots()){
                meestGespot= auto;
            }
        }
        return meestGespot.getMerk()+" "+meestGespot.getModel();
    }



}




