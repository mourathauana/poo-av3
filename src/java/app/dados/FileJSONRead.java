package app.dados;

import app.classes.Dependente;
import app.classes.Funcionario;
import javafx.scene.control.Alert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class FileJSONRead {

    public void loadJSON(){

        File path = new File("database.json");

        if(!path.exists())
        {
            FileJSONWrite.createJSON();
        }
        else
        {

            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader(path)) {
                // Read JSON file

                Object obj = jsonParser.parse(reader);

                JSONArray userList = (JSONArray) obj;

                // Iterate over employee array
                userList.forEach(user -> parseUserObject((JSONObject) user));

            } catch (ParseException | IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.toString());
            }
        }
    }


    private void parseUserObject(JSONObject jsonObject) {

        ArrayList<Dependente> dependentes = new ArrayList<>();
        //Obtém os dados do atributo pedido em JSON
        String name = (String) jsonObject.get("name");
        String code = (String) jsonObject.get("code");
        String cargo = (String) jsonObject.get("cargo");
        double salario = (double) jsonObject.get("salary");

        //Recebe o Array guardado no objeto e armazena em um JSONArray
        JSONArray jsonArray = (JSONArray) jsonObject.get("dependentes");

        //Instancia e adiciona os dependentes armazenados no JSONArray
        jsonArray.forEach(obj -> {dependentes.add(new Dependente(obj.toString()));});

        //Instancia e adiciona o objeto armazenado no json para o UsuariosListArray
        FuncionarioDAO.createFuncionario(name,code,cargo,dependentes,salario);
    }

}
