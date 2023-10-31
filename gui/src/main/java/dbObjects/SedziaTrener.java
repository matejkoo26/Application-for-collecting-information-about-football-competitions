package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SedziaTrener {
    SimpleIntegerProperty id;
    SimpleStringProperty imie;
    SimpleStringProperty nazwisko;
    SimpleStringProperty licencja;
    SimpleIntegerProperty narodowosc;
    SimpleStringProperty nazwaNarodowosci;


    public SedziaTrener(Integer id, String imie, String nazwisko, String licencja, Integer narodowosc) {
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.licencja = new SimpleStringProperty(licencja);
        this.narodowosc = new SimpleIntegerProperty(narodowosc);
    }

    public SedziaTrener(Integer id, String imie, String nazwisko, String licencja, Integer narodowosc, String nazwaNarodowosci) {
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.licencja = new SimpleStringProperty(licencja);
        this.narodowosc = new SimpleIntegerProperty(narodowosc);
        this.nazwaNarodowosci = new SimpleStringProperty(nazwaNarodowosci);

    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getImie() {
        return imie.get();
    }

    public SimpleStringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public SimpleStringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getLicencja() {
        return licencja.get();
    }

    public SimpleStringProperty licencjaProperty() {
        return licencja;
    }

    public void setLicencja(String licencja) {
        this.licencja.set(licencja);
    }

    public int getNarodowosc() {
        return narodowosc.get();
    }

    public SimpleIntegerProperty narodowoscProperty() {
        return narodowosc;
    }

    public void setNarodowosc(int narodowosc) {
        this.narodowosc.set(narodowosc);
    }

    public String getNazwaNarodowosci() {
        return nazwaNarodowosci.get();
    }

    public SimpleStringProperty nazwaNarodowosciProperty() {
        return nazwaNarodowosci;
    }

    public void setNazwaNarodowosci(String nazwaNarodowosci) {
        this.nazwaNarodowosci.set(nazwaNarodowosci);
    }

    @Override
    public String toString() {
        return imie.get()+nazwisko.get();
    }
}
