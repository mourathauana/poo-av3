package app.classes;

import app.dados.CodeValidation;

import java.util.ArrayList;
public class Funcionario {

    private String nome;
    private String codigo;
    private String cargo;
    private int dependentes;
    private double salario;
    private double bonus;

    //lista de dependentes para o funcionário
    private ArrayList<Dependente> dependentesList = new ArrayList<>();

    public Funcionario(String nome, String codigo, String cargo, double salario) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargo = cargo;
        this.salario = salario;
        this.bonus = 0;
    }

    public Funcionario(String nome, String codigo, String cargo, int dependentes, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.codigo = codigo;


        if(dependentes >= 0)
        {
            this.dependentes = dependentes;
            setBonus(dependentes);
        }
        else
        {
            throw new IllegalArgumentException("A quantidade de dependentes deve ser >= 0");
        }

        //setando salario
        if(salario >=0) {
            this.salario = salario;
        }
        else {
            throw new IllegalArgumentException("O valor do salário deve ser >= 0.0");
        }
        setBonus(dependentes);
    }

    public Funcionario(String name, String codigo, String cargo, ArrayList<Dependente> dependentes, double salary) {
        this(name, codigo,cargo,dependentes.size(),salary);
        this.dependentesList = dependentes;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCodigo()
    {
        return codigo;
    }

    //codigo deve ser único, implementar verificação
    public void setCodigo(String codigo)
    {
        if(CodeValidation.funcionarioExist(codigo))
        {
            this.codigo = codigo;
        }
        else
        {
            throw new IllegalArgumentException("Código já existente");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {

        if(salario >=0)
        {
            this.salario = salario;
        }
        else
        {
            throw new IllegalArgumentException("O valor do salário deve ser >= 0.0");
        }

    }

    public void setDependentes(int dependentes) {

        if(dependentes >= 0)
        {
            this.dependentes = dependentes;
            setBonus(dependentes);
        }
        else
        {
            throw new IllegalArgumentException("A quantidade de dependentes deve ser >= 0");
        }

    }

    public int getDependentes()
    {
        return dependentes;
    }

    public void setBonus(int dependentes)
    {
        this.bonus = 2 * dependentes;
    }

    public double getBonus()
    {
        return this.bonus;
    }

    public ArrayList<Dependente> getDependentesList() {
        return dependentesList;
    }

    public void setDependentesList(ArrayList<Dependente> dependentesList) {
        this.dependentesList = dependentesList;
    }

}
