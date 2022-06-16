package app.dados;

import app.classes.Funcionario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FileJSONWrite {

    public static void createJSON(){

        JSONArray funcionarioArray = new JSONArray();


        for(Funcionario funcionario : FuncionarioDAO.getFuncionarios())
        {
            JSONObject funcionarioOBJ = new JSONObject();

             /*   //Percorre o array de dependentes e guarda em um JSONArray
                funcionario.getDependentesList().forEach(dependente ->{
                    dependentesList.add(dependente.getName().toLowerCase());
                });*/

            //Cria os atributos do JSONObject
            funcionarioOBJ.put("name", funcionario.getNome());
            funcionarioOBJ.put("code", funcionario.getCodigo());
            funcionarioOBJ.put("cargo", funcionario.getCargo());
            funcionarioOBJ.put("salary", funcionario.getSalario());
            funcionarioOBJ.put("dependentes", funcionario.getDependentesList());

            funcionarioArray.add(funcionarioOBJ);
        }

        try {
            //Método para criação e escrita do arquivo .json
            FileWriter wF = new FileWriter("database.json");
            wF.write(funcionarioArray.toJSONString());
            wF.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}