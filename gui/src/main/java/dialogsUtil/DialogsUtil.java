package dialogsUtil;

import fxUtils.FxmlUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogsUtil {

    public static Optional<ButtonType> dialogConfirm() {
        Alert dialogConfirm = new Alert(Alert.AlertType.CONFIRMATION);
        dialogConfirm.setTitle("Alert!");
        dialogConfirm.setHeaderText("Czy chcesz wyjść z aplikacji?");
        Optional<ButtonType> result = dialogConfirm.showAndWait();
        return result;
    }


}

