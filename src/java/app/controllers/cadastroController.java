package app.controllers;

import app.App;
import app.dados.FuncionarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class cadastroController {

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField entradaCargo;

    @FXML
    private TextField entradaCodigo;

    @FXML
    private TextField entradaNome;

    @FXML
    private TextField entradaSalario;

    @FXML
    void criarFuncionario(ActionEvent event) {
        try {
            FuncionarioDAO.createFuncionario(entradaNome.getText(), entradaCodigo.getText(), entradaCargo.getText(), Double.parseDouble(entradaSalario.getText()));
            goToList(event);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (e instanceof NumberFormatException) {
                alert.setContentText("Formato de número inválido para o SALÁRIO!");
            } else {
                alert.setContentText(e.getMessage());
            }
            alert.show();
        }
    }

    private void goToList(ActionEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_list.fxml"));
        final Parent parent = fxmlLoader.load();
        final Scene scene = new Scene(parent, 800, 450);

        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

}