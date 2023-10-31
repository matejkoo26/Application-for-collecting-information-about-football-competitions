package controllers;


import dbObjects.*;
import dbUtils.CallableStatementParameter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeczeController {

    public ComboBox<Klub> comboGospodarz;
    public ComboBox<Klub> comboGość;
    public ComboBox<Stadion> comboStadion;
    public ComboBox<SedziaTrener> comboSedzia;
    public DatePicker datePicker;
    public Text info;
    public TabPane tabPane;
    public TableView<Mecz> tablicaMeczy;
    public TableColumn<Mecz, String> ColGospodarze;
    public TableColumn<Mecz, String> ColGoscie;
    public TableColumn<Mecz, String> ColStadion;
    public TableColumn<Mecz, String> ColSedzia;
    public TableColumn<Mecz, Date> ColData;
    public TableColumn<Mecz, String> ColWynik;
    public TableColumn<Mecz, Integer> ColFrekwencja;
    public ListView<Zawodnik> listaGospodarzy;
    public ListView<Zawodnik> listaGosci;
    public Text textSzczegolyMeczu;
    public TextField textFieldGoleGospodarz;
    public Text textFieldGoleGoscie;
    public Tab tabStatystyki;
    public Text textStatystyki;
    public TextField textFieldMinuty;
    public TextField textFieldGole;
    public TextField textFieldasysty;
    public ComboBox comboZolta;
    public ComboBox comboCzerwona;
    public TextField inputGoleGoscie;
    public TextField inputFrekwencja;
    public Text textFieldGoleGoscie1;
    public Tab tabMecze;
    public Tab twTab;
    public Text infov2;
    public Text infov3;
    CallableStatementParameter cspie = new CallableStatementParameter();
    Mecz aktualnieWybranyMecz;
    Zawodnik aktualnieWybranyZawodnik;
    Statystyka statystyka;
    private List yesOrNo =  new ArrayList();
    int czerwona;
    int zolta;

    public void initialize(){
        comboGospodarz.setItems(FXCollections.observableArrayList(cspie.widokKlubow()));
        comboGość.setItems(comboGospodarz.getItems());
        comboSedzia.setItems(FXCollections.observableArrayList(cspie.widokSedziow()));
        comboStadion.setItems(FXCollections.observableArrayList(cspie.widokStadionów()));
        loadListaMeczy();

        ColGospodarze.setCellValueFactory(new PropertyValueFactory<>("nazwa_klubu_gospodarzy"));
        ColGoscie.setCellValueFactory(new PropertyValueFactory<>("nazwa_klubu_gości"));
        ColStadion.setCellValueFactory(new PropertyValueFactory<>("nazwa_stadionu"));
        ColSedzia.setCellValueFactory(new PropertyValueFactory<>("nazwa_sedziego"));
        ColData.setCellValueFactory(new PropertyValueFactory<>("data"));
        ColWynik.setCellValueFactory(new PropertyValueFactory<>("wynik"));
        ColFrekwencja.setCellValueFactory(new PropertyValueFactory<>("frekwencja"));
        loadListaMeczy();

        twTab.setDisable(true);
        tabStatystyki.setDisable(true);

        yesOrNo.clear();
        yesOrNo.add("Tak");
        yesOrNo.add("Nie");
        comboZolta.setItems(FXCollections.observableArrayList(yesOrNo));
        comboCzerwona.setItems(FXCollections.observableArrayList(yesOrNo));
        comboZolta.getSelectionModel().select(1);
        comboCzerwona.getSelectionModel().select(1);


    }


    public void dodajMecz(ActionEvent actionEvent) {
        if (comboGospodarz.getSelectionModel().getSelectedItem() == null){
            info.setText("Musisz wybrać gospodarza meczu");
        }else if (comboGość.getSelectionModel().getSelectedItem() == null){
            info.setText("Musisz wybrać gościa meczu");
        }else if(comboStadion.getSelectionModel().getSelectedItem() == null){
            info.setText("Na jakim stadionie odbędzie się mecz?");
        }else if(comboSedzia.getSelectionModel().getSelectedItem() == null){
            info.setText("Ktoś musi być sędzią na tym meczu");
        }else if(datePicker.getValue() == null){
            info.setText("Kiedy odbędzie się to spotkanie?");
        }else{
            info.setText(cspie.proceduraZapiszMecz(comboStadion.getSelectionModel().getSelectedItem().getId(),
                    comboGospodarz.getSelectionModel().getSelectedItem().getId(),
                    comboGość.getSelectionModel().getSelectedItem().getId(),
                    comboSedzia.getSelectionModel().getSelectedItem().getId(),
                    java.sql.Date.valueOf(datePicker.getValue())));
            loadListaMeczy();
        }
    }

    private void loadListaMeczy() {
        tablicaMeczy.setItems(FXCollections.observableArrayList(cspie.widokMeczow()));
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        try {
            aktualnieWybranyMecz = tablicaMeczy.getSelectionModel().getSelectedItem();
            textFieldGoleGospodarz.setText(String.valueOf(aktualnieWybranyMecz.getIloscGoliGospodarz()));
            inputGoleGoscie.setText(String.valueOf(aktualnieWybranyMecz.getIloscGoliGosc()));
            inputFrekwencja.setText(String.valueOf(aktualnieWybranyMecz.getFrekwencja()));
            twTab.setDisable(false);

            twTab.setText("Szczegóły meczu " + aktualnieWybranyMecz.getData().toString());
            textSzczegolyMeczu.setText(aktualnieWybranyMecz.getNazwa_klubu_gospodarzy() + " - " + aktualnieWybranyMecz.getNazwa_klubu_gości() + " " + aktualnieWybranyMecz.getData().toString());
            listaGospodarzy.setItems(FXCollections.observableArrayList(cspie.widokZawodnikKonkretnyKlub(aktualnieWybranyMecz.getId_klubu_gospodarzy())));
            listaGosci.setItems(FXCollections.observableArrayList(cspie.widokZawodnikKonkretnyKlub(aktualnieWybranyMecz.getId_klubu_gości())));
        }catch(NullPointerException ex){
            System.out.println("brak meczu do wybrania");

        }
    }

    public void usunMecz(ActionEvent actionEvent) {
        info.setText(cspie.usunMecz(tablicaMeczy.getSelectionModel().getSelectedItem().getId()));
        loadListaMeczy();
        twTab.setDisable(true);
        tabStatystyki.setDisable(true);
    }

    public void onListaGospodarzyClicked(MouseEvent mouseEvent) {
        try {
            aktualnieWybranyZawodnik = listaGospodarzy.getSelectionModel().getSelectedItem();
            textStatystyki.setText(aktualnieWybranyZawodnik.getImie() + " " + aktualnieWybranyZawodnik.getNazwisko());
            tabStatystyki.setText(aktualnieWybranyZawodnik.getImie() + " " + aktualnieWybranyZawodnik.getNazwisko() + " - statystyki");
            statystyka = cspie.widokStatystyka(aktualnieWybranyZawodnik.getId(), aktualnieWybranyMecz.getId()).get(0);
            textFieldMinuty.setText(String.valueOf(statystyka.getP_minuty()));
            textFieldGole.setText(String.valueOf(statystyka.getP_gole()));
            textFieldasysty.setText(String.valueOf(statystyka.getP_asysty()));
            if (statystyka.getP_red() == 0) {
                comboCzerwona.getSelectionModel().select(1);
            } else {
                comboCzerwona.getSelectionModel().select(0);
            }
            if (statystyka.getP_yellow() == 0) {
                comboZolta.getSelectionModel().select(1);
            } else {
                comboZolta.getSelectionModel().select(0);
            }
            tabStatystyki.setDisable(false);
        }catch (NullPointerException e){
            tabStatystyki.setDisable(true);
        }catch (IndexOutOfBoundsException  ee){
            tabStatystyki.setDisable(false);
            textFieldMinuty.setText("");
            textFieldGole.setText("");
            textFieldasysty.setText("");
            comboZolta.getSelectionModel().select(1);
            comboCzerwona.getSelectionModel().select(1);
            System.out.println("nie ma statystyk w tym meczu");
        }
    }

    public void onListaGosciClicked(MouseEvent mouseEvent) {
        try {
        aktualnieWybranyZawodnik = listaGosci.getSelectionModel().getSelectedItem();

        textStatystyki.setText(aktualnieWybranyZawodnik.getImie()+" "+aktualnieWybranyZawodnik.getNazwisko());
        tabStatystyki.setText(aktualnieWybranyZawodnik.getImie()+" "+aktualnieWybranyZawodnik.getNazwisko()+" - statystyki");

        statystyka = cspie.widokStatystyka(aktualnieWybranyZawodnik.getId(),aktualnieWybranyMecz.getId()).get(0);
        textFieldMinuty.setText(String.valueOf(statystyka.getP_minuty()));
        textFieldGole.setText(String.valueOf(statystyka.getP_gole()));
        textFieldasysty.setText(String.valueOf(statystyka.getP_asysty()));
        if (statystyka.getP_red()==0){
            comboCzerwona.getSelectionModel().select(1);
        }else{
            comboCzerwona.getSelectionModel().select(0);
        }
        if (statystyka.getP_yellow()==0){
            comboZolta.getSelectionModel().select(1);
        }else{
            comboZolta.getSelectionModel().select(0);
        }
            tabStatystyki.setDisable(false);
        }catch (NullPointerException e){
            tabStatystyki.setDisable(true);
        }catch (IndexOutOfBoundsException  ee){
            tabStatystyki.setDisable(false);
            textFieldMinuty.setText("");
            textFieldGole.setText("");
            textFieldasysty.setText("");
            comboZolta.getSelectionModel().select(1);
            comboCzerwona.getSelectionModel().select(1);
            System.out.println("nie ma statystyk w tym meczu");
        }

    }

    public void onAktualizujGole(ActionEvent actionEvent) {
        try {
            cspie.proceduraUpdateWynik(aktualnieWybranyMecz.getId_wyniku(), Integer.valueOf(textFieldGoleGospodarz.getText()), Integer.valueOf(inputGoleGoscie.getText()));
            loadListaMeczy();
            tabPane.getSelectionModel().select(tabMecze);
        }catch(NumberFormatException e){
            infov2.setText("Wartości muszą być liczbowe");
        }

    }

    public void onAktualizujStatystyki(ActionEvent actionEvent) {
        if (comboZolta.getSelectionModel().getSelectedItem().toString() == "Tak"){
            zolta = 1;
            System.out.println("zolta 1");
        }else{
            zolta = 0;
        }
        if (comboCzerwona.getSelectionModel().getSelectedItem() == "Tak"){
            System.out.println("czerwona 1");
            czerwona = 1;
        }else{
            czerwona = 0;
        }
        try {
            cspie.proceduraZapiszStatystyke(
                    aktualnieWybranyZawodnik.getId(),
                    aktualnieWybranyMecz.getId(),
                    Integer.valueOf(textFieldMinuty.getText()),
                    Integer.valueOf(textFieldGole.getText()),
                    Integer.valueOf(textFieldasysty.getText()), zolta, czerwona);
            listaGospodarzy.setItems(FXCollections.observableArrayList(cspie.widokZawodnikKonkretnyKlub(aktualnieWybranyMecz.getId_klubu_gospodarzy())));
            listaGosci.setItems(FXCollections.observableArrayList(cspie.widokZawodnikKonkretnyKlub(aktualnieWybranyMecz.getId_klubu_gości())));
            infov3.setText("Statystyki gracza zaktualizowane");
        }catch(NumberFormatException ex){
            infov3.setText("Pole minuty, gole oraz asysty musi posiadać wartości liczbowe!");
        }
    }

    public void onAktualizujFrekwencje(ActionEvent actionEvent) {
        try {
            cspie.proceduraUpdateFrekwencja(aktualnieWybranyMecz.getId(), Integer.valueOf(inputFrekwencja.getText()));
            loadListaMeczy();
            tabPane.getSelectionModel().select(tabMecze);
        }catch(NumberFormatException e){
            infov2.setText("W polu frekwencja podaj liczbę osób");
        }
    }
}
