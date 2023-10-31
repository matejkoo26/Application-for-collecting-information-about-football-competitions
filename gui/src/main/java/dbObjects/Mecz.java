package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Mecz {
    SimpleIntegerProperty id;
    SimpleIntegerProperty id_stadionu;
    SimpleStringProperty nazwa_stadionu;
    SimpleIntegerProperty id_klubu_gospodarzy;
    SimpleStringProperty nazwa_klubu_gospodarzy;
    SimpleIntegerProperty id_klubu_gości;
    SimpleStringProperty nazwa_klubu_gości;
    SimpleIntegerProperty id_wyniku;
    SimpleIntegerProperty iloscGoliGospodarz;
    SimpleIntegerProperty iloscGoliGosc;
    SimpleIntegerProperty id_sedziego;
    SimpleStringProperty nazwa_sedziego;
    SimpleIntegerProperty frekwencja;
    SimpleObjectProperty<Date> data;
    SimpleStringProperty wynik;


    public Mecz(Integer id, Integer id_stadionu, String nazwa_stadionu, Integer id_klubu_gospodarzy,
                String nazwa_klubu_gospodarzy, Integer id_klubu_gości, String nazwa_klubu_gości,
                Integer id_wyniku, Integer iloscGoliGospodarz, Integer iloscGoliGosc, Integer id_sedziego,
                String nazwa_sedziego, Integer frekwencja, Date data) {
        this.id = new SimpleIntegerProperty (id);
        this.id_stadionu = new SimpleIntegerProperty (id_stadionu);
        this.nazwa_stadionu = new SimpleStringProperty (nazwa_stadionu);
        this.id_klubu_gospodarzy = new SimpleIntegerProperty (id_klubu_gospodarzy);
        this.nazwa_klubu_gospodarzy = new SimpleStringProperty (nazwa_klubu_gospodarzy);
        this.id_klubu_gości = new SimpleIntegerProperty (id_klubu_gości);
        this.nazwa_klubu_gości = new SimpleStringProperty (nazwa_klubu_gości);
        this.id_wyniku = new SimpleIntegerProperty (id_wyniku);
        this.iloscGoliGospodarz = new SimpleIntegerProperty (iloscGoliGospodarz);
        this.iloscGoliGosc = new SimpleIntegerProperty (iloscGoliGosc);
        this.id_sedziego = new SimpleIntegerProperty (id_sedziego);
        this.nazwa_sedziego = new SimpleStringProperty (nazwa_sedziego);
        this.frekwencja = new SimpleIntegerProperty (frekwencja);
        this.data = new SimpleObjectProperty<Date> (data);
        this.wynik = new SimpleStringProperty (iloscGoliGospodarz+" : "+iloscGoliGosc);
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

    public int getId_klubu_gospodarzy() {
        return id_klubu_gospodarzy.get();
    }

    public SimpleIntegerProperty id_klubu_gospodarzyProperty() {
        return id_klubu_gospodarzy;
    }

    public void setId_klubu_gospodarzy(int id_klubu_gospodarzy) {
        this.id_klubu_gospodarzy.set(id_klubu_gospodarzy);
    }

    public String getNazwa_klubu_gospodarzy() {
        return nazwa_klubu_gospodarzy.get();
    }

    public SimpleStringProperty nazwa_klubu_gospodarzyProperty() {
        return nazwa_klubu_gospodarzy;
    }

    public void setNazwa_klubu_gospodarzy(String nazwa_klubu_gospodarzy) {
        this.nazwa_klubu_gospodarzy.set(nazwa_klubu_gospodarzy);
    }

    public int getId_klubu_gości() {
        return id_klubu_gości.get();
    }

    public SimpleIntegerProperty id_klubu_gościProperty() {
        return id_klubu_gości;
    }

    public void setId_klubu_gości(int id_klubu_gości) {
        this.id_klubu_gości.set(id_klubu_gości);
    }

    public String getNazwa_klubu_gości() {
        return nazwa_klubu_gości.get();
    }

    public SimpleStringProperty nazwa_klubu_gościProperty() {
        return nazwa_klubu_gości;
    }

    public void setNazwa_klubu_gości(String nazwa_klubu_gości) {
        this.nazwa_klubu_gości.set(nazwa_klubu_gości);
    }

    public int getId_wyniku() {
        return id_wyniku.get();
    }

    public SimpleIntegerProperty id_wynikuProperty() {
        return id_wyniku;
    }

    public void setId_wyniku(int id_wyniku) {
        this.id_wyniku.set(id_wyniku);
    }

    public int getIloscGoliGospodarz() {
        return iloscGoliGospodarz.get();
    }

    public SimpleIntegerProperty iloscGoliGospodarzProperty() {
        return iloscGoliGospodarz;
    }

    public void setIloscGoliGospodarz(int iloscGoliGospodarz) {
        this.iloscGoliGospodarz.set(iloscGoliGospodarz);
    }

    public int getIloscGoliGosc() {
        return iloscGoliGosc.get();
    }

    public SimpleIntegerProperty iloscGoliGoscProperty() {
        return iloscGoliGosc;
    }

    public void setIloscGoliGosc(int iloscGoliGosc) {
        this.iloscGoliGosc.set(iloscGoliGosc);
    }

    public int getId_sedziego() {
        return id_sedziego.get();
    }

    public SimpleIntegerProperty id_sedziegoProperty() {
        return id_sedziego;
    }

    public void setId_sedziego(int id_sedziego) {
        this.id_sedziego.set(id_sedziego);
    }

    public String getNazwa_sedziego() {
        return nazwa_sedziego.get();
    }

    public SimpleStringProperty nazwa_sedziegoProperty() {
        return nazwa_sedziego;
    }

    public void setNazwa_sedziego(String nazwa_sedziego) {
        this.nazwa_sedziego.set(nazwa_sedziego);
    }

    public int getFrekwencja() {
        return frekwencja.get();
    }

    public SimpleIntegerProperty frekwencjaProperty() {
        return frekwencja;
    }

    public void setFrekwencja(int frekwencja) {
        this.frekwencja.set(frekwencja);
    }

    public Date getData() {
        return data.get();
    }

    public SimpleObjectProperty<Date> dataProperty() {
        return data;
    }

    public void setData(Date data) {
        this.data.set(data);
    }

    public String getWynik() {
        return wynik.get();
    }

    public SimpleStringProperty wynikProperty() {
        return wynik;
    }

    public void setWynik(String wynik) {
        this.wynik.set(wynik);
    }
}
