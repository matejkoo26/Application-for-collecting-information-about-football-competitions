package controllers;

import dbObjects.Klub;
import dbObjects.Narodowosc;
import dbObjects.Pozycja;
import dbObjects.Zawodnik;
import dbUtils.CallableStatementParameter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.Date;

public class ZawodnicyController {
    public ComboBox<Narodowosc> commboNarodowosc;
    public ComboBox<Klub> comboKlub;
    public ComboBox<Pozycja> comboPozycja;
    public DatePicker datePicker;
    public TextField inputImie;
    public TextField inputNazwisko;
    public TextField inputPensja;
    public TextField inputWzrost;
    public Text info;
    public TabPane tabPane;
    public TableView<Zawodnik> tablicaZawodnikow;
    public TableColumn colImie;
    public TableColumn colNazwisko;
    public TableColumn colPensja;
    public TableColumn colData;
    public TableColumn colWzrost;
    public TableColumn colPozycja;
    public TableColumn colKlub;
    public Tab tabPozycjeNarodowosci;
    public ListView<Pozycja> listaPozycji;
    public ListView<Narodowosc> listaNarodowosci;
    public TextField inputPozycja;
    public TextField inputNarodowosc;
    public Text textFieldGoleGoscie;
    public TableColumn colNarodowosc;
    CallableStatementParameter cspie = new CallableStatementParameter();


    public void initialize(){
        loadListaNarodowosci();
        loadListaPozycji();
        loadKluby();

        colImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        colNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        colKlub.setCellValueFactory(new PropertyValueFactory<>("nazwa_klubu"));
        colPozycja.setCellValueFactory(new PropertyValueFactory<>("nazwa_pozycji"));
        colNarodowosc.setCellValueFactory(new PropertyValueFactory<>("nazwa_narodowosci"));
        colPensja.setCellValueFactory(new PropertyValueFactory<>("pensja"));
        colWzrost.setCellValueFactory(new PropertyValueFactory<>("wzrost"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataUrodzenia"));

        loadTabZawodnikow();

    }

    public void loadTabZawodnikow(){
        tablicaZawodnikow.setItems(FXCollections.observableArrayList(cspie.widokZawodnik()));

    }

    public void loadListaNarodowosci(){
        listaNarodowosci.setItems(FXCollections.observableArrayList(cspie.widokNarodowosci()));
        commboNarodowosc.setItems(listaNarodowosci.getItems());
    }

    public void loadKluby(){
        comboKlub.setItems(FXCollections.observableArrayList(cspie.widokKlubow()));
    }

    public void dodajZawodnika(ActionEvent actionEvent) {
        if(commboNarodowosc.getSelectionModel().getSelectedItem() == null){
            info.setText("Z kąd pochodzi ten zawodnik?");

        }else if(comboKlub.getSelectionModel().getSelectedItem() == null){
            info.setText("Zawodnik musi należeć do klubu");
        }else if(comboPozycja.getSelectionModel().getSelectedItem() == null){
            info.setText("Wybierz pozycję zawodnika");

        }else{
            try {
                info.setText(
                        cspie.proceduraZapiszZawodnik(
                                comboKlub.getSelectionModel().getSelectedItem().getId(),
                                inputImie.getText(),
                                inputNazwisko.getText(),
                                comboPozycja.getSelectionModel().getSelectedItem().getId(),
                                Integer.valueOf(inputPensja.getText()),
                                java.sql.Date.valueOf(datePicker.getValue()),
                                Integer.valueOf(inputWzrost.getText()),
                                commboNarodowosc.getSelectionModel().getSelectedItem().getId()));
                loadTabZawodnikow();
            }catch (NumberFormatException ex){
                info.setText("Pole pensja oraz wzrost musi zawierać wartości liczbowe");
            }catch (NullPointerException e){
                info.setText("Wybierz datę urodzenia");
            }
        }
    }

    public void usunMecz(ActionEvent actionEvent) {
        info.setText(cspie.usunZawodnik(tablicaZawodnikow.getSelectionModel().getSelectedItem().getId()));
        loadTabZawodnikow();
    }

    public void onDodajNarodowosc(ActionEvent actionEvent) {
        info.setText(cspie.proceduraZapiszNarodowosc(inputNarodowosc.getText()));
        loadListaNarodowosci();
        inputNarodowosc.setText("");
    }

    public void onDodajPozycje(ActionEvent actionEvent) {
        info.setText(cspie.proceduraZapiszPozycje(inputPozycja.getText()));
        loadListaPozycji();
        inputPozycja.setText("");
    }

    private void loadListaPozycji() {
        listaPozycji.setItems(FXCollections.observableArrayList(cspie.widokPozycji()));
        comboPozycja.setItems(listaPozycji.getItems());
    }

    public void usunPozycje(ActionEvent actionEvent) {
        info.setText(cspie.usunPozycje(listaPozycji.getSelectionModel().getSelectedItem().getId()));
        loadListaPozycji();
    }

    public void usunNarodowosc(ActionEvent actionEvent) {
        info.setText(cspie.usunNarodowosc(listaNarodowosci.getSelectionModel().getSelectedItem().getId()));
        loadListaNarodowosci();
    }
}
