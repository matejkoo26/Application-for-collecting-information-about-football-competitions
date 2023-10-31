package controllers;

import dbObjects.Stadion;
import dbUtils.CallableStatementParameter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class StadionyController {
    public TextField inputNazwa;
    public TextField inputMiasto;
    public TextField inputUlica;
    public TextField inputNumer;
    public TextField inputPojemnosc;
    public Text info;
    public TableView<Stadion> tabStadiony;
    public TableColumn<Stadion, String> colNazwa;
    public TableColumn<Stadion, String> colMiasto;
    public TableColumn<Stadion, String> colUlica;
    public TableColumn<Stadion, Integer> colNumer;
    public TableColumn<Stadion, Integer> colPojemnosc;
    CallableStatementParameter cspie = new CallableStatementParameter();
    private ObservableList<Stadion> listaStadionow;

    public void initialize(){
        colNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        colMiasto.setCellValueFactory(new PropertyValueFactory<>("miasto"));
        colUlica.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        colNumer.setCellValueFactory(new PropertyValueFactory<>("numer"));
        colPojemnosc.setCellValueFactory(new PropertyValueFactory<>("pojemnosc"));
        listaStadionow = FXCollections.observableArrayList(cspie.widokStadionów());

        tabStadiony.setItems(listaStadionow);

    }

    public void onDodaj(ActionEvent actionEvent) {
        try{
            info.setText(cspie.proceduraZapiszStadion(inputNazwa.getText(),inputMiasto.getText(),inputUlica.getText(),
                    Integer.valueOf(inputNumer.getText()), Integer.valueOf(inputPojemnosc.getText())));
        }catch(NumberFormatException e){
            //e.printStackTrace();
            info.setText("W polu numer oraz pojemność muszą znajdować się wartości liczbowe!");
        }

        initialize();
    }

    public void usun(ActionEvent actionEvent) {
        info.setText(cspie.usunStadion(tabStadiony.getSelectionModel().getSelectedItem().getId()));
        initialize();
    }
}
