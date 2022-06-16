package app.controllers;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class openningController {

    @FXML
    private Button btCriarLogiin;

    @FXML
    private Button btEntrar;

    @FXML
    private TextField entradaCodigoCadastrado;

    @FXML
    private TextField entradaNomeCadastrado;

    @FXML
    void abrirCadastro(ActionEvent event) throws IOException {
        abrirNovoCadastro(event);

    }

    @FXML
    void abrirViewFuncionario(ActionEvent event) {

    }

    private void abrirNovoCadastro(ActionEvent event) throws IOException {
            final FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("novo_cadastro.fxml"));
            final Parent parent = fxmlLoader.load();
            final Scene scene = new Scene(parent, 800, 450);

            final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Sistemas de Funcionários");
            stage.setScene(scene);
            stage.show();
    }

}

