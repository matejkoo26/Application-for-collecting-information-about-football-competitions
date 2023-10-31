package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Zawodnik {
    SimpleIntegerProperty id;
    SimpleStringProperty imie;
    SimpleStringProperty nazwisko;
    SimpleIntegerProperty id_klubu;
    SimpleStringProperty nazwa_klubu;
    SimpleIntegerProperty id_pozycji;
    SimpleStringProperty nazwa_pozycji;
    SimpleIntegerProperty id_narodowosci;
    SimpleStringProperty nazwa_narodowosci;
    SimpleIntegerProperty pensja;
    SimpleIntegerProperty wzrost;
    SimpleObjectProperty<Date> dataUrodzenia;


    public Zawodnik(Integer id, String imie, String nazwisko, Integer id_klubu, Integer id_pozycji,Integer id_narodowosci, Integer pensja, Integer wzrost, Date dataUrodzenia) {
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.id_klubu = new SimpleIntegerProperty(id_klubu);
        this.id_pozycji = new SimpleIntegerProperty(id_pozycji);
        this.id_narodowosci = new SimpleIntegerProperty(id_narodowosci);
        this.pensja = new SimpleIntegerProperty(pensja);
        this.wzrost = new SimpleIntegerProperty(wzrost);
        this.dataUrodzenia = new SimpleObjectProperty<>(dataUrodzenia);
    }

    public Zawodnik(Integer id, String imie, String nazwisko, Integer id_klubu, Integer id_pozycji,Integer id_narodowosci, Integer pensja, Integer wzrost, Date dataUrodzenia, String nazwa_klubu,String nazwa_narodowosci, String nazwa_pozycji) {
        this.id = new SimpleIntegerProperty(id);
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
        this.id_klubu = new SimpleIntegerProperty(id_klubu);
        this.id_pozycji = new SimpleIntegerProperty(id_pozycji);
        this.id_narodowosci = new SimpleIntegerProperty(id_narodowosci);
        this.pensja = new SimpleIntegerProperty(pensja);
        this.wzrost = new SimpleIntegerProperty(wzrost);
        this.dataUrodzenia = new SimpleObjectProperty<>(dataUrodzenia);
        this.nazwa_klubu = new SimpleStringProperty(nazwa_klubu);
        this.nazwa_pozycji = new SimpleStringProperty(nazwa_pozycji);
        this.nazwa_narodowosci = new SimpleStringProperty(nazwa_narodowosci);
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

    public int getId_klubu() {
        return id_klubu.get();
    }

    public SimpleIntegerProperty id_klubuProperty() {
        return id_klubu;
    }

    public void setId_klubu(int id_klubu) {
        this.id_klubu.set(id_klubu);
    }

    public String getNazwa_klubu() {
        return nazwa_klubu.get();
    }

    public SimpleStringProperty nazwa_klubuProperty() {
        return nazwa_klubu;
    }

    public void setNazwa_klubu(String nazwa_klubu) {
        this.nazwa_klubu.set(nazwa_klubu);
    }

    public int getId_pozycji() {
        return id_pozycji.get();
    }

    public SimpleIntegerProperty id_pozycjiProperty() {
        return id_pozycji;
    }

    public void setId_pozycji(int id_pozycji) {
        this.id_pozycji.set(id_pozycji);
    }

    public String getNazwa_pozycji() {
        return nazwa_pozycji.get();
    }

    public SimpleStringProperty nazwa_pozycjiProperty() {
        return nazwa_pozycji;
    }

    public void setNazwa_pozycji(String nazwa_pozycji) {
        this.nazwa_pozycji.set(nazwa_pozycji);
    }

    public int getId_narodowosci() {
        return id_narodowosci.get();
    }

    public SimpleIntegerProperty id_narodowosciProperty() {
        return id_narodowosci;
    }

    public void setId_narodowosci(int id_narodowosci) {
        this.id_narodowosci.set(id_narodowosci);
    }

    public String getNazwa_narodowosci() {
        return nazwa_narodowosci.get();
    }

    public SimpleStringProperty nazwa_narodowosciProperty() {
        return nazwa_narodowosci;
    }

    public void setNazwa_narodowosci(String nazwa_narodowosci) {
        this.nazwa_narodowosci.set(nazwa_narodowosci);
    }

    public int getPensja() {
        return pensja.get();
    }

    public SimpleIntegerProperty pensjaProperty() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja.set(pensja);
    }

    public int getWzrost() {
        return wzrost.get();
    }

    public SimpleIntegerProperty wzrostProperty() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost.set(wzrost);
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia.get();
    }

    public SimpleObjectProperty<Date> dataUrodzeniaProperty() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia.set(dataUrodzenia);
    }

    @Override
    public String toString() {
        return imie.get()+" "+nazwisko.get();
    }
}
