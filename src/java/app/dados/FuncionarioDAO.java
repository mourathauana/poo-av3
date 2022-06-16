package app.dados;

import app.classes.Dependente;
import app.classes.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static final ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    //this method will add new Employees to the array
    private static void addFuncionario(Funcionario funcionario){
        // funcionarios.add(funcionario);
        funcionarios.add(funcionario);
        FileJSONWrite.createJSON();
        //call method to reload the txt file with new clients
    }

    //este método receberá os funcionários da lista
    private static void createFuncionario(Funcionario funcionario) {

        if(CodeValidation.funcionarioExist(funcionario.getCodigo()))
        {
            throw new RuntimeException("Já existe funcionário com este código!");
        }
        else
        {
            System.out.println("Funcionário criado com sucesso");
            addFuncionario(funcionario);
        }
    }

    public static void createFuncionario(String nome, String codigo, String cargo, double salario) {
        final Funcionario funcionario = new Funcionario(nome, codigo, cargo, salario);
        createFuncionario(funcionario);
    }

    public static void createFuncionario(String nome, String codigo, String cargo, ArrayList<Dependente> dependenteList, double salario) {
        final Funcionario funcionario = new Funcionario(nome, codigo, cargo, dependenteList, salario);
        createFuncionario(funcionario);
    }

    public static void deleteFuncionario(Funcionario funcionario)
    {
        funcionarios.remove(funcionario);
    }

}