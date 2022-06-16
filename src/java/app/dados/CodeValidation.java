package app.dados;

import app.classes.Funcionario;

public class CodeValidation {

    public static boolean funcionarioExist(String codigo) {
        return FuncionarioDAO.getFuncionarios().stream()
                .map(Funcionario::getCodigo)
                .toList()
                .contains(codigo);
    }

}
