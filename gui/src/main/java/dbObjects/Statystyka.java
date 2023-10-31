package dbObjects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;
//(p_zawodnik IN NUMBER,p_mecz IN NUMBER,p_minuty IN NUMBER,p_gole IN NUMBER,p_asysty IN NUMBER,p_yellow IN NUMBER,p_red IN NUMBER,crit_error_message OUT VARCHAR2);
public class Statystyka {
    SimpleIntegerProperty p_zawodnik;
    SimpleIntegerProperty p_mecz;
    SimpleIntegerProperty p_minuty;
    SimpleIntegerProperty p_gole;
    SimpleIntegerProperty p_asysty;
    SimpleIntegerProperty p_yellow;
    SimpleIntegerProperty p_red;



    public Statystyka(int p_zawodnik, int p_mecz, int p_minuty, int p_gole,int p_asysty, int p_yellow, int p_red) {
        this.p_zawodnik = new SimpleIntegerProperty (p_zawodnik);
        this.p_mecz = new SimpleIntegerProperty (p_mecz);
        this.p_minuty = new SimpleIntegerProperty (p_minuty);
        this.p_gole = new SimpleIntegerProperty (p_gole);
        this.p_asysty = new SimpleIntegerProperty (p_asysty);
        this.p_yellow = new SimpleIntegerProperty (p_yellow);
        this.p_red = new SimpleIntegerProperty (p_red);

    }


    public int getP_zawodnik() {
        return p_zawodnik.get();
    }

    public SimpleIntegerProperty p_zawodnikProperty() {
        return p_zawodnik;
    }

    public void setP_zawodnik(int p_zawodnik) {
        this.p_zawodnik.set(p_zawodnik);
    }

    public int getP_mecz() {
        return p_mecz.get();
    }

    public SimpleIntegerProperty p_meczProperty() {
        return p_mecz;
    }

    public void setP_mecz(int p_mecz) {
        this.p_mecz.set(p_mecz);
    }

    public int getP_minuty() {
        return p_minuty.get();
    }

    public SimpleIntegerProperty p_minutyProperty() {
        return p_minuty;
    }

    public void setP_minuty(int p_minuty) {
        this.p_minuty.set(p_minuty);
    }

    public int getP_gole() {
        return p_gole.get();
    }

    public SimpleIntegerProperty p_goleProperty() {
        return p_gole;
    }

    public void setP_gole(int p_gole) {
        this.p_gole.set(p_gole);
    }

    public int getP_asysty() {
        return p_asysty.get();
    }

    public SimpleIntegerProperty p_asystyProperty() {
        return p_asysty;
    }

    public void setP_asysty(int p_asysty) {
        this.p_asysty.set(p_asysty);
    }

    public int getP_yellow() {
        return p_yellow.get();
    }

    public SimpleIntegerProperty p_yellowProperty() {
        return p_yellow;
    }

    public void setP_yellow(int p_yellow) {
        this.p_yellow.set(p_yellow);
    }

    public int getP_red() {
        return p_red.get();
    }

    public SimpleIntegerProperty p_redProperty() {
        return p_red;
    }

    public void setP_red(int p_red) {
        this.p_red.set(p_red);
    }
}
