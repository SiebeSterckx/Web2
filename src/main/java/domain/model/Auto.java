package domain.model;
import domain.DomainException;
public class Auto {
    private int id;
    private String model;
    private String merk;
    private int pk;
    private int aantalSpots;

    public Auto(String merk, String model, int aantalSpots){
        this.model=model;
        this.merk=merk;
        this.aantalSpots=aantalSpots;
        this.pk = 0;
    }

    public Auto(String merk, String model, int Pk, int aantalSpots){
        this.model=model;
        this.merk=merk;
        this.pk =Pk;
        this.aantalSpots=aantalSpots;
    }

    public Auto() {

    }

    public String getModel(){
        return model;
    }

    public String getMerk(){

        return merk;
    }

    public int getPk() {
        return pk;
    }

    public int getAantalSpots(){

        return aantalSpots;
    }

    public int getId() {
        return id;
    }


    public void setId(int id){

        this.id= id;
    }

    public void setMerk(String merk){
        if (merk == null || merk.isEmpty()) {
            throw new DomainException("Merk mag niet leeg zijn.");
        }
        this.merk= merk;
    }
    public void setModel(String model){
        if (model == null || model.isEmpty()) {
            throw new DomainException("Model mag niet leeg zijn.");
        }
        this.model= model;
    }
        public void setPk(int Pk){
        if (Pk<0) {
            throw new DomainException("Pk mag niet negatief zijn.");
        }
            this.pk = Pk;
    }
    public void setAantalSpots(int aantalSpots){
        if (aantalSpots<=0) {
            throw new DomainException("Aantal spots mag niet 0 of negatief zijn.");
        }
        this.aantalSpots= aantalSpots;
    }

}




