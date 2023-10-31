import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import fxUtils.FxmlUtils;

public class Main extends Application {

    public static final String MAIN_FXML_BORDER_PANE = "/fxml/MainWindow.fxml";

    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage primaryStage) throws Exception {
        Pane borderPane = FxmlUtils.fxmlLoader(MAIN_FXML_BORDER_PANE);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja do gromadzenia informacji na temat rozgrywek piłkarskich");
        primaryStage.show();
    }

}
