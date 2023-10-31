package controllers;

import dbObjects.Narodowosc;
import dbObjects.SedziaTrener;
import dbObjects.Stadion;
import dbUtils.CallableStatementParameter;
import fxUtils.FxmlUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class SedziowieTrenerzyController {
    public TextField inputImie;
    public TextField inputNazwisko;
    public TextField inputLicencja;
    public ComboBox<Narodowosc> commboNarodowosc;
    public ComboBox comboZawod;
    public Text info;
    public TabPane tabPane;
    public Tab sedziowieTab;
    public TableView<SedziaTrener> tablicaSedziow;
    public TableColumn<SedziaTrener, String> colImie;
    public TableColumn<SedziaTrener, String> colNazwisko;
    public TableColumn<SedziaTrener, String> colLicencja;
    public TableColumn<SedziaTrener, Integer> colnarodowosc;
    public Tab tabTrenerzy;
    public TableView<SedziaTrener> tablicaTrenerów;
    public TableColumn<SedziaTrener, String> colImieSe;
    public TableColumn<SedziaTrener, String> colNazwiskoSe;
    public TableColumn<SedziaTrener, String> colLicencjaSe;
    public TableColumn<SedziaTrener, Integer> colnarodowoscSe;
    public Tab tabNarodowosc;
    public ListView<Narodowosc> listaNarodowosci;
    public TextField inputNarodowosc;
    public Text textFieldGoleGoscie;
    private List listaZawodow =  new ArrayList();
    CallableStatementParameter cspie = new CallableStatementParameter();
    private ObservableList<SedziaTrener> listaTrenerow;
    private ObservableList<SedziaTrener> listaSedziow;

    public void initialize(){
        listaZawodow.clear();
        listaZawodow.add("Sędzia");
        listaZawodow.add("Trener");
        comboZawod.setItems(FXCollections.observableArrayList(listaZawodow));
        loadListaNarodowosci();

        colImieSe.setCellValueFactory(new PropertyValueFactory<>("imie"));
        colNazwiskoSe.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        colLicencjaSe.setCellValueFactory(new PropertyValueFactory<>("licencja"));
        colnarodowoscSe.setCellValueFactory(new PropertyValueFactory<>("nazwaNarodowosci"));
        loadTabTrenerow();

        colImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        colNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        colLicencja.setCellValueFactory(new PropertyValueFactory<>("licencja"));
        colnarodowosc.setCellValueFactory(new PropertyValueFactory<>("nazwaNarodowosci"));
        loadTabSedziow();

    }

    public void loadListaNarodowosci(){
        listaNarodowosci.setItems(FXCollections.observableArrayList(cspie.widokNarodowosci()));
        commboNarodowosc.setItems(listaNarodowosci.getItems());
    }
    public void loadTabTrenerow(){
        listaTrenerow = FXCollections.observableArrayList(cspie.widokTrenerow());

        tablicaTrenerów.setItems(listaTrenerow);
    }
    public void loadTabSedziow(){
        listaSedziow = FXCollections.observableArrayList(cspie.widokSedziow());

        tablicaSedziow.setItems(listaSedziow);
    }

    public void onDodajNarodowosc(ActionEvent actionEvent) {
        info.setText(cspie.proceduraZapiszNarodowosc(inputNarodowosc.getText()));
        loadListaNarodowosci();
        inputNarodowosc.setText("");
    }

    public void dodajOsobe(ActionEvent actionEvent) {
        if (comboZawod.getSelectionModel().getSelectedItem()!=null){
            if (commboNarodowosc.getSelectionModel().getSelectedItem()!=null){
                if (comboZawod.getSelectionModel().getSelectedItem()=="Sędzia"){
                    info.setText(cspie.proceduraZapiszSedziego(inputImie.getText(),inputNazwisko.getText(),inputLicencja.getText(), commboNarodowosc.getSelectionModel().getSelectedItem().getId()));
                    loadTabSedziow();
                    tabPane.getSelectionModel().select(sedziowieTab);
                }else{
                    info.setText(cspie.proceduraZapiszTrenera(inputImie.getText(),inputNazwisko.getText(),inputLicencja.getText(), commboNarodowosc.getSelectionModel().getSelectedItem().getId()));
                    loadTabTrenerow();
                    tabPane.getSelectionModel().select(tabTrenerzy);
                }
            }else{
                info.setText("Wybierz narodowosc osoby");
            }
        }else{
            info.setText("Wybierz zawód osoby");
        }
    }

    public void usunSedziego(ActionEvent actionEvent) {
        info.setText(cspie.usunSedziego(tablicaSedziow.getSelectionModel().getSelectedItem().getId()));
        loadTabSedziow();
    }

    public void usunTrenera(ActionEvent actionEvent) {
        info.setText(cspie.usunTrenerow(tablicaTrenerów.getSelectionModel().getSelectedItem().getId()));
        loadTabTrenerow();
    }

    public void usunNarodowosc(ActionEvent actionEvent) {
        info.setText(cspie.usunNarodowosc(listaNarodowosci.getSelectionModel().getSelectedItem().getId()));
        loadListaNarodowosci();
    }
}
