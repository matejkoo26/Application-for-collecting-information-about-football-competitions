package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Stadion {
    SimpleIntegerProperty id;
    SimpleStringProperty nazwa;
    SimpleStringProperty miasto;
    SimpleStringProperty ulica;
    SimpleIntegerProperty numer;
    SimpleIntegerProperty pojemnosc;

    public Stadion(Integer id, String nazwa, String miasto, String ulica, Integer numer, Integer pojemnosc) {
        this.id = new SimpleIntegerProperty(id);
        this.nazwa = new SimpleStringProperty(nazwa);
        this.miasto = new SimpleStringProperty(miasto);
        this.ulica = new SimpleStringProperty(ulica);
        this.numer = new SimpleIntegerProperty(numer);
        this.pojemnosc = new SimpleIntegerProperty(pojemnosc);
    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNazwa() {
        return nazwa.get();
    }

    public SimpleStringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    public String getMiasto() {
        return miasto.get();
    }

    public SimpleStringProperty miastoProperty() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto.set(miasto);
    }

    public String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public int getNumer() {
        return numer.get();
    }

    public SimpleIntegerProperty numerProperty() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer.set(numer);
    }

    public int getPojemnosc() {
        return pojemnosc.get();
    }

    public SimpleIntegerProperty pojemnoscProperty() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc.set(pojemnosc);
    }

    @Override
    public String toString() {
        return nazwa.get();
    }
}
