/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import ClassesBasicas.Funcionario;
import Interface.InterfaceFuncionario;
import Repositorio.RepositorioFuncionario;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class NegocioFuncionario implements InterfaceFuncionario {

    private RepositorioFuncionario repositorio = new RepositorioFuncionario();

    @Override
    public void cadastrar(Funcionario funcionario) throws Exception {
        if (funcionario == null) {
            throw new Exception("O funcionário não foi estanciado.");
        }
        if (funcionario.getCpf() == null | funcionario.getCpf().trim().equals("")) {
            throw new Exception("O campo cpf não pode está vazio.");
        }
        if (funcionario.getNome() == null | funcionario.getNome().trim().equals("")) {
            throw new Exception("O campo nome não pode está vazio.");
        }
        if (funcionario.getEndereco() == null | funcionario.getEndereco().trim().equals("")) {
            throw new Exception("O campo Endereço não pode está vazio.");
        }
        if (funcionario.getBairro() == null | funcionario.getBairro().trim().equals("")) {
            throw new Exception("O campo Bairro não pode está vazio.");
        }
        if (funcionario.getCidade() == null | funcionario.getCidade().trim().equals("")) {
            throw new Exception("O campo Cidade não pode está vazio.");
        }
        if (funcionario.getTelefone() == null | funcionario.getTelefone().trim().equals("")) {
            throw new Exception("O campo Telefone não pode está vazio.");
        }
        if (funcionario.getLogin() == null | funcionario.getLogin().trim().equals("")) {
            throw new Exception("O campo login não pode estar vazio");
        }
        if (funcionario.getSenha() == null | funcionario.getSenha().trim().equals("")) {
            throw new Exception("O campo senha não pode estar vazio");
        }

        if (repositorio.CpfExiste(funcionario) == true) {
            throw new Exception("Já existe um Funcionário com o CPF informado.");
        }
        if (repositorio.UsuarioExiste(funcionario) == true) {
            throw new Exception("O login informado não está disponível.");
        }
        this.repositorio.cadastrar(funcionario);
    }

    @Override
    public void Remover(Funcionario funcionario) throws Exception {
        if (funcionario == null) {
            throw new Exception("O funcionário não foi estanciado.");
        }
        if (funcionario.getCpf() == null | funcionario.getCpf().trim().equals("")) {
            throw new Exception("O campo cpf não pode está vazio.");
        }
        if (repositorio.CpfExiste(funcionario) == false) {
            throw new Exception("Não existe nenhum funcionário cadastrado com este cpf.");
        }
         if (repositorio.MovimentacaoExiste(funcionario) == true) {
            throw new Exception("Erro! O Funcionário possui movimentação. Impossível de excluir");
        }
        this.repositorio.Remover(funcionario);
    }

    @Override
    public void Alterar(Funcionario funcionario) throws Exception {
        if (funcionario == null) {
            throw new Exception("O funcionário não foi estanciado.");
        }
        if (funcionario.getCpf() == null | funcionario.getCpf().trim().equals("")) {
            throw new Exception("O campo cpf não pode está vazio.");
        }
        if (funcionario.getNome() == null | funcionario.getNome().trim().equals("")) {
            throw new Exception("O campo nome não pode está vazio.");
        }
        if (funcionario.getEndereco() == null | funcionario.getEndereco().trim().equals("")) {
            throw new Exception("O campo Endereço não pode está vazio.");
        }
        if (funcionario.getBairro() == null | funcionario.getBairro().trim().equals("")) {
            throw new Exception("O campo Bairro não pode está vazio.");
        }
        if (funcionario.getCidade() == null | funcionario.getCidade().trim().equals("")) {
            throw new Exception("O campo Cidade não pode está vazio.");
        }
        if (funcionario.getTelefone() == null | funcionario.getTelefone().trim().equals("")) {
            throw new Exception("O campo Telefone não pode está vazio.");
        }
        if (repositorio.CpfExiste(funcionario) == false) {
            throw new Exception("Não existe nenhum funcionário cadastrado com este cpf.");
        }
        this.repositorio.Alterar(funcionario);
    }

    public ArrayList<Funcionario> ListarFuncionario() throws Exception {
        return this.repositorio.ListarFuncionario();
    }

    @Override
    public ArrayList<Funcionario> SelectFuncionario(Funcionario filtro) throws Exception {
        if (filtro == null) {
            throw new Exception("O Funcionário não foi estanciado.");//Informa que o cliente não foi estanciado
        }
        if (filtro.getCpf() == null | filtro.getCpf().trim().equals("")) {//informa que o cpf não pode estar vazio
            throw new Exception("O campo CPF não pode estar vazio");
        }
        if (repositorio.CpfExiste(filtro) == false) {
            throw new Exception("Não existe nenhum Funcionário cadastrado com este cpf.");
        }
        return this.repositorio.SelectFuncionario(filtro);


    }

    @Override
    public boolean VerificaLogin(Funcionario filtro) throws Exception {
        if (filtro.getLogin() == null | filtro.getLogin().trim().equals("")) {//Informa que o campo não pode estar vazio
            throw new Exception("Usuário ou senha inválido");
        }
        if (filtro.getSenha() == null | filtro.getSenha().trim().equals("")) {//informa que o campo não pode estar vazio
            throw new Exception("Usuário ou senha inválido");
        }
        return this.repositorio.VerificaLogin(filtro);
    }
}
