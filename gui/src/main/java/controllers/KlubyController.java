package controllers;


import dbObjects.Klub;
import dbObjects.SedziaTrener;
import dbObjects.Stadion;
import dbUtils.CallableStatementParameter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class KlubyController {

    public TextField inputNazwa;
    public Button onDodaj;
    public TextField inputMiasto;
    public ComboBox<SedziaTrener> comboTrener;
    public ComboBox<Stadion> comboStadion;
    public Text info;
    public TableView<Klub> tableKluby;
    public TableColumn colNazwa;
    public TableColumn colMiasto;
    public TableColumn colTrener;
    public TableColumn colStadion;
    private ObservableList<Klub> listaKlubow;
    CallableStatementParameter cspie = new CallableStatementParameter();

    public void initialize(){
        colNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        colMiasto.setCellValueFactory(new PropertyValueFactory<>("miasto"));
        colTrener.setCellValueFactory(new PropertyValueFactory<>("nazwa_trenera"));
        colStadion.setCellValueFactory(new PropertyValueFactory<>("nazwa_stadionu"));
        loadStadiony();
        loadTrenerzy();
        loadTabKlubow();
    }

    public void loadTabKlubow(){
        listaKlubow = FXCollections.observableArrayList(cspie.widokKlubow());

        tableKluby.setItems(listaKlubow);
    }

    public void loadStadiony(){
        comboStadion.setItems(FXCollections.observableArrayList(cspie.widokStadionów()));
    }

    public void loadTrenerzy(){
        comboTrener.setItems(FXCollections.observableArrayList(cspie.widokTrenerow()));
    }

    public void dodaj(ActionEvent actionEvent) {
        if (comboStadion.getSelectionModel().getSelectedItem()!=null) {
            if (comboTrener.getSelectionModel().getSelectedItem() != null) {
                info.setText(cspie.proceduraZapiszKlub(inputNazwa.getText(), inputMiasto.getText(), comboStadion.getSelectionModel().getSelectedItem().getId(), comboTrener.getSelectionModel().getSelectedItem().getId()));
                loadTabKlubow();
            } else {
                info.setText("Musisz wybrać treneara");
            }
        }else{
            info.setText("Musisz wybrać stadion");
        }
    }

    public void usun(ActionEvent actionEvent) {
        info.setText(cspie.usunKlub(tableKluby.getSelectionModel().getSelectedItem().getId()));
        loadTabKlubow();
    }
}
