package controllers;

import dialogsUtil.DialogsUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class TopMenuButtonsController {
    public static final String MECZE_FXML = "/fxml/Mecze.fxml";
    public static final String KLUBY_FXML = "/fxml/Kluby.fxml";
    public static final String STADIONY_FXML = "/fxml/Stadiony.fxml";
    public static final String ZAWODNICY_FXML = "/fxml/Zawodnicy.fxml";
    public static final String SEDZIOWIE_TRENERZY_FXML = "/fxml/SedziowieTrenerzy.fxml";
    private MainWindowController mainWindowController;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    public void openMecze(ActionEvent actionEvent) {
        mainWindowController.setCenter(MECZE_FXML);
    }

    public void openKluby(ActionEvent actionEvent) {
        mainWindowController.setCenter(KLUBY_FXML);
    }

    public void openStadiony(ActionEvent actionEvent) {
        mainWindowController.setCenter(STADIONY_FXML);
    }

    public void openZawodnicy(ActionEvent actionEvent) {
        mainWindowController.setCenter(ZAWODNICY_FXML);
    }

    public void openSedziowieTrenerzy(ActionEvent actionEvent) {
        mainWindowController.setCenter(SEDZIOWIE_TRENERZY_FXML);
    }
    @FXML
    public void exit(ActionEvent actionEvent) {
        Optional<ButtonType> resoult = DialogsUtil.dialogConfirm();
        if (resoult.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
}
