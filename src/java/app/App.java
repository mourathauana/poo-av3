package app;

import app.dados.FileJSONRead;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    final FileJSONRead fileJSONRead = new FileJSONRead();

    @Override
    public void start(Stage stage) throws IOException {
        fileJSONRead.loadJSON();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800 , 500);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}