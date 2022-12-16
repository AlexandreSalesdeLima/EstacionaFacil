/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ClassesBasicas.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public interface InterfaceFuncionario {

    void cadastrar(Funcionario funcionario) throws Exception;

    void Remover(Funcionario funcionario) throws Exception;

    void Alterar(Funcionario funcionario) throws Exception;

    ArrayList<Funcionario> ListarFuncionario() throws Exception;

    ArrayList<Funcionario> SelectFuncionario(Funcionario filtro) throws Exception;
    
    public boolean VerificaLogin(Funcionario usuario) throws Exception;
}
