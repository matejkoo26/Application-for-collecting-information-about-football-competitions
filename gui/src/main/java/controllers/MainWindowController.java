package controllers;

import fxUtils.FxmlUtils;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MainWindowController {
    @FXML
    private BorderPane mainWindowBorderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    void initialize(){
        this.topMenuButtonsController.setMainWindowController(this);
    }

    public void setCenter(String fxmlPath) {
        mainWindowBorderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }
}
