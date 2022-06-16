package app.controllers;

import app.App;
import app.classes.Funcionario;
import app.dados.FuncionarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class viewListController implements Initializable {

    final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @FXML
    private Button btApagarFuncionario;
    @FXML
    private Button btNovoFuncionario;
    @FXML
    private TableView<Funcionario> viewFuncionario;
    @FXML
    private TableColumn<Funcionario, String> funcionarioNome;
    @FXML
    private TableColumn<Funcionario, String> funcionarioCodigo;

    @FXML
    void abrirCadastro(ActionEvent event) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("novo_cadastro.fxml"));
        final Parent parent = fxmlLoader.load();
        final Scene scene = new Scene(parent, 800, 450);

        final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Cadastro de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void apagarFuncionario() {
        final Funcionario funcionario = viewFuncionario.getSelectionModel().getSelectedItem();

        if (Objects.nonNull(funcionario)) {
            FuncionarioDAO.deleteFuncionario(funcionario);
            viewFuncionario.getItems().remove(funcionario);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Atenção! É necessário escolher um funcionário para apagar.");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        funcionarioNome.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        funcionarioCodigo.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("codigo"));
        viewFuncionario.getItems().setAll(parseFuncionarioList());
    }

    private List<Funcionario> parseFuncionarioList() {
        return FuncionarioDAO.getFuncionarios();
    }
}
