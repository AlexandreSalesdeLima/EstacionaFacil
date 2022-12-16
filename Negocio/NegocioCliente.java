/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import ClassesBasicas.Cliente;
import Interface.InterfaceCliente;
import Repositorio.RepositorioCliente;
import java.util.ArrayList;

/**
 *
 * @author Danillo
 */
public class NegocioCliente implements InterfaceCliente {

    private RepositorioCliente repositorio = new RepositorioCliente();

    @Override
    public void Cadastrar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("O cliente não foi estanciado.");//Informa que o cliente não foi estanciado
        }
        if (cliente.getCpf() == null | cliente.getCpf().trim().equals("")) {//informa que o cpf não pode estar vazio
            throw new Exception("O campo CPF não pode estar vazio");
        }
        if (cliente.getNome() == null | cliente.getNome().trim().equals("")) {//informa que o nome não pode estar vazio
            throw new Exception("O campo nome não pode estar vazio.");
        }
        if (cliente.getEndereco() == null | cliente.getEndereco().trim().equals("")) {//informa que o endereço não pode estar vazio
            throw new Exception("O campo Endereço não pode estar vazio.");
        }
        if (cliente.getBairro() == null | cliente.getBairro().trim().equals("")) {//informa que o bairro não pode estar vazio
            throw new Exception("O campo Bairro não pode estar vazio.");
        }
        if (cliente.getCidade() == null | cliente.getCidade().trim().equals("")) {//informa que a cidade não pode estar vazio
            throw new Exception("O campo cidade não pode estar vazio.");
        }

        if (cliente.getTelefone() == null | cliente.getTelefone().trim().equals("")) {//informa que o telefone não pode estar vazio
            throw new Exception("O campo telefone não pode estar vazio");

        }
        if (cliente.getVeiculo().getPlaca() == null | cliente.getVeiculo().getPlaca().trim().equals("")) {//informa que a placa não pode estar vazio
            throw new Exception("O veículo não foi informado.");

        }
        if (repositorio.CpfExiste(cliente) == true) {
            throw new Exception("Já existe um cliente com o CPF informado.");
        }
        if (repositorio.PlacaExiste(cliente) == true) {
            throw new Exception("Já existe um Veículo com a placa informada.");
        }
        this.repositorio.Cadastrar(cliente); // Se passo por todas as etapas e não encontrou erro envia para o banco de dados.
    }

    @Override
    public void Alterar(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("O cliente não foi estanciado.");//Informa que o cliente não foi estanciado
        }
        if (cliente.getCpf() == null | cliente.getCpf().trim().equals("")) {//informa que o cpf não pode estar vazio
            throw new Exception("O campo CPF não pode estar vazio");
        }
        if (cliente.getNome() == null | cliente.getNome().trim().equals("")) {//informa que o nome não pode estar vazio
            throw new Exception("O campo nome não pode estar vazio.");
        }
        if (cliente.getEndereco() == null | cliente.getEndereco().trim().equals("")) {//informa que o endereço não pode estar vazio
            throw new Exception("O campo Endereço não pode estar vazio.");
        }
        if (cliente.getBairro() == null | cliente.getBairro().trim().equals("")) {//informa que o bairro não pode estar vazio
            throw new Exception("O campo Bairro não pode estar vazio.");
        }
        if (cliente.getCidade() == null | cliente.getCidade().trim().equals("")) {//informa que a cidade não pode estar vazio
            throw new Exception("O campo cidade não pode estar vazio.");
        }

        if (cliente.getTelefone() == null | cliente.getTelefone().trim().equals("")) {//informa que o telefone não pode estar vazio
            throw new Exception("O campo telefone não pode estar vazio");
        }
        if (repositorio.CpfExiste(cliente) == false) {
            throw new Exception("Não existe nenhum cliente cadastrado com este cpf.");
        }
        this.repositorio.Alterar(cliente);

    }

    @Override
    public ArrayList<Cliente> ListarCliente() throws Exception {
        return this.repositorio.Listar();
    }

    @Override
    public void Remover(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("O cliente não foi estanciado.");//Informa que o cliente não foi estanciado
        }
        if (cliente.getCpf() == null | cliente.getCpf().trim().equals("")) {//informa que o cpf não pode estar vazio
            throw new Exception("O campo CPF não pode estar vazio");
        }
        if (repositorio.CpfExiste(cliente) == false) {
            throw new Exception("Não existe nenhum cliente cadastrado com este cpf.");
        }
        if (repositorio.MovimentacaoExiste(cliente) == true) {
            throw new Exception("Erro! O cliente possui movimentação. Impossível de excluir");
        }
        this.repositorio.Remover(cliente);

    }

    @Override
    public ArrayList<Cliente> SelectCliente(Cliente filtro) throws Exception {
        if (filtro == null) {
            throw new Exception("O cliente não foi estanciado.");//Informa que o cliente não foi estanciado
        }
        if (filtro.getCpf() == null | filtro.getCpf().trim().equals("")) {//informa que o cpf não pode estar vazio
            throw new Exception("O campo CPF não pode estar vazio");
        }
        if (repositorio.CpfExiste(filtro) == false) {
            throw new Exception("Não existe nenhum cliente cadastrado com este cpf.");
        }
        return this.repositorio.Select(filtro);
    }
}
