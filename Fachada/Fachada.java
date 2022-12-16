/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClassesBasicas.Cliente;
import ClassesBasicas.Funcionario;
import ClassesBasicas.Movimentacao;
import Interface.InterfaceCliente;
import Interface.InterfaceFuncionario;
import Interface.InterfaceMovimentacao;
import Negocio.NegocioCliente;
import Negocio.NegocioFuncionario;
import Negocio.NegocioMovimentacao;

import java.util.ArrayList;

/**
 *
 * @author Danillo, Alexandre
 */
public class Fachada implements InterfaceCliente, InterfaceFuncionario, InterfaceMovimentacao {

    private NegocioCliente negociocliente;
    private NegocioFuncionario negociofuncionario;
    private NegocioMovimentacao negociomovimentacao;
    private static Fachada instancia;

    public static Fachada obterInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public Fachada() {
        negociocliente = new NegocioCliente();
        negociofuncionario = new NegocioFuncionario();
        negociomovimentacao = new NegocioMovimentacao();
    }

    @Override
    public void Cadastrar(Cliente cliente) throws Exception {
        this.negociocliente.Cadastrar(cliente);
    }

    @Override
    public void cadastrar(Funcionario funcionario) throws Exception {
        this.negociofuncionario.cadastrar(funcionario);
    }



    @Override
    public void Remover(Funcionario funcionario) throws Exception {
        this.negociofuncionario.Remover(funcionario);
    }

    @Override
    public void Entrada(Movimentacao veiculo) throws Exception {
        this.negociomovimentacao.Entrada(veiculo);
    }

    @Override
    public void Saida(Movimentacao veiculo) throws Exception {
        this.negociomovimentacao.Saida(veiculo);
    }

    @Override
    public void Alterar(Cliente cliente) throws Exception {
       this.negociocliente.Alterar(cliente);
    }

    @Override
    public ArrayList<Cliente> ListarCliente() throws Exception {
    return this.negociocliente.ListarCliente();
    }

    @Override
    public void Remover(Cliente cliente) throws Exception {
        this.negociocliente.Remover(cliente);
    }

    @Override
    public void Alterar(Funcionario funcionario) throws Exception {
        this.negociofuncionario.Alterar(funcionario);
    }

    @Override
    public ArrayList<Funcionario> ListarFuncionario() throws Exception {
        return this.negociofuncionario.ListarFuncionario();
    }

    @Override
    public ArrayList<Movimentacao> ListarMovimentacao() throws Exception {
        return this.negociomovimentacao.ListarMovimentacao();
    }

    @Override
    public ArrayList<Cliente> SelectCliente(Cliente filtro) throws Exception {
      return this.negociocliente.SelectCliente(filtro);
    }

    @Override
    public ArrayList<Funcionario> SelectFuncionario(Funcionario filtro) throws Exception {
       return this.negociofuncionario.SelectFuncionario(filtro);
    }

    @Override
    public boolean VerificaLogin(Funcionario usuario) throws Exception {
     return this.negociofuncionario.VerificaLogin(usuario);
    }




}
