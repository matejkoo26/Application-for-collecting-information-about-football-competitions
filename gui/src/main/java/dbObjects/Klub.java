package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Klub {
    SimpleIntegerProperty id;
    SimpleStringProperty nazwa;
    SimpleStringProperty miasto;
    SimpleIntegerProperty id_trenera;
    SimpleStringProperty nazwa_trenera;
    SimpleIntegerProperty id_stadionu;
    SimpleStringProperty nazwa_stadionu;


    public Klub(Integer id, String nazwa, String miasto,  Integer id_trenera, Integer id_stadionu) {
        this.id = new SimpleIntegerProperty(id);
        this.nazwa = new SimpleStringProperty(nazwa);
        this.miasto = new SimpleStringProperty(miasto);
        this.id_trenera = new SimpleIntegerProperty(id_trenera);
        this.id_stadionu = new SimpleIntegerProperty(id_stadionu);
    }

    public Klub(Integer id, String nazwa, String miasto,  Integer id_trenera, Integer id_stadionu, String nazwa_trenera, String nazwa_stadionu) {
        this.id = new SimpleIntegerProperty(id);
        this.nazwa = new SimpleStringProperty(nazwa);
        this.miasto = new SimpleStringProperty(miasto);
        this.id_trenera = new SimpleIntegerProperty(id_trenera);
        this.id_stadionu = new SimpleIntegerProperty(id_stadionu);
        this.nazwa_trenera = new SimpleStringProperty(nazwa_trenera);
        this.nazwa_stadionu = new SimpleStringProperty(nazwa_stadionu);
    }



    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
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

    public int getId_trenera() {
        return id_trenera.get();
    }

    public SimpleIntegerProperty id_treneraProperty() {
        return id_trenera;
    }

    public void setId_trenera(int id_trenera) {
        this.id_trenera.set(id_trenera);
    }

    public String getNazwa_trenera() {
        return nazwa_trenera.get();
    }

    public SimpleStringProperty nazwa_treneraProperty() {
        return nazwa_trenera;
    }

    public void setNazwa_trenera(String nazwa_trenera) {
        this.nazwa_trenera.set(nazwa_trenera);
    }

    public int getId_stadionu() {
        return id_stadionu.get();
    }

    public SimpleIntegerProperty id_stadionuProperty() {
        return id_stadionu;
    }

    public void setId_stadionu(int id_stadionu) {
        this.id_stadionu.set(id_stadionu);
    }

    public String getNazwa_stadionu() {
        return nazwa_stadionu.get();
    }

    public SimpleStringProperty nazwa_stadionuProperty() {
        return nazwa_stadionu;
    }

    public void setNazwa_stadionu(String nazwa_stadionu) {
        this.nazwa_stadionu.set(nazwa_stadionu);
    }

    @Override
    public String toString() {
        return nazwa.get();
    }
}
