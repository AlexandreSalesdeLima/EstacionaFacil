/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import ClassesBasicas.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Danillo, Alexandre
 */
public class RepositorioCliente extends RepositorioConectaDB {

    Statement stm;
    ResultSet ret;
    boolean retorno = false;

    public boolean MovimentacaoExiste(Cliente cliente) throws ExceptionGeral, SQLException {

        try {
            String sql = "Select placa from veiculo where cpf_cliente = '" + cliente.getCpf() + "'";
            stm = conectar();
            ret = stm.executeQuery(sql);
            while (ret.next()) {
                cliente.getVeiculo().setPlaca(ret.getString(1));
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela Movimentação: " + e);
        }
        try {
            retorno = false;
            String sql = "Select * from Movimentacao where placa = '" + cliente.getVeiculo().getPlaca() + "'";
            stm = conectar();
            ret = stm.executeQuery(sql);
            while (ret.next()) {
                retorno = true;
                break;
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela Movimentação: " + e);
        }
        return retorno;
    }

    public boolean CpfExiste(Cliente cliente) throws ExceptionGeral, SQLException {
        try {
            retorno = false;
            String sql = "Select * from Cliente where cpf_cliente = '" + cliente.getCpf() + "'";
            stm = conectar();
            ret = stm.executeQuery(sql);
            while (ret.next()) {
                retorno = true;
                break;
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela cliente: " + e);
        }
        return retorno;
    }

    public boolean PlacaExiste(Cliente cliente) throws ExceptionGeral, SQLException {
        try {
            String sqlplaca = "Select * from Veiculo where Placa = '" + cliente.getVeiculo().getPlaca() + "'";
            stm = conectar();
            ret = stm.executeQuery(sqlplaca);
            while (ret.next()) {
                retorno = true;
                break;
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela clienteveiculo: " + e);
        }
        return retorno;
    }

    public void Cadastrar(Cliente cliente) throws ExceptionGeral, SQLException {

        try {

            String sqlCliente = "insert into Cliente(cpf_cliente,nome_cliente,endereco_cliente,numero_cliente,complemento_cliente,bairro_cliente,cidade_cliente,telefone_cliente)values('" + cliente.getCpf() + "', '" + cliente.getNome() + "','" + cliente.getEndereco() + "'," + cliente.getNumero() + ",'" + cliente.getComplemento() + "','" + cliente.getBairro() + "','" + cliente.getCidade() + "','" + cliente.getTelefone() + "')";
            conectar().execute(sqlCliente);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Cliente: " + e.getMessage());
        }
        try {

            String sqlVeiculo = "insert into Veiculo(cpf_cliente,placa,tipo)values('" + cliente.getCpf() + "', '" + cliente.getVeiculo().getPlaca() + "','" + cliente.getVeiculo().getModelo() + "')";
            conectar().execute(sqlVeiculo);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Veiculo: " + e.getMessage());
        }

        desconectar();
    }

    public void Alterar(Cliente cliente) throws ExceptionGeral, SQLException {

        try {

            String sqlalterarCliente = "update Cliente set nome_cliente='" + cliente.getNome() + "',endereco_cliente='" + cliente.getEndereco() + "',numero_cliente=" + cliente.getNumero() + ",complemento_cliente='" + cliente.getComplemento() + "',bairro_cliente='" + cliente.getBairro() + "',cidade_cliente='" + cliente.getCidade() + "',telefone_cliente='" + cliente.getTelefone() + "'where cpf_cliente='" + cliente.getCpf() + "';";
            conectar().execute(sqlalterarCliente);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de Alteração na tabela Cliente: " + e.getMessage());
        }

    }

    public void Remover(Cliente cliente) throws ExceptionGeral, SQLException {
        try {

            String sqlusuario = "delete Veiculo where CPF_cliente ='" + cliente.getCpf() + "';";
            conectar().execute(sqlusuario);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de remoção na tabela Veículo: " + e.getMessage());
        }

        try {

            String sqlcliente = "delete Cliente where CPF_cliente ='" + cliente.getCpf() + "';";
            conectar().execute(sqlcliente);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de remoção na tabela Cliente: " + e.getMessage());

        }
        desconectar();
    }

    public ArrayList<Cliente> Listar() throws ExceptionGeral, SQLException {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        try {
            conectar();
            PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from Cliente");
            ret = pstm.executeQuery();
            while (ret.next()) {

                Cliente cliente = new Cliente();
                cliente.setCpf(ret.getString(1));
                cliente.setNome(ret.getString(2));
                cliente.setEndereco(ret.getString(3));
                cliente.setNumero(ret.getInt(4));
                cliente.setComplemento(ret.getString(5));
                cliente.setBairro(ret.getString(6));
                cliente.setCidade(ret.getString(7));
                cliente.setTelefone(ret.getString(8));
                listaCliente.add(cliente);
            }
            desconectar();
        } catch (SQLException e) {

            throw new ExceptionGeral("Ocorreu um erro no retorno de cliente: " + e.getMessage());

        }
        return listaCliente;
    }

    public ArrayList<Cliente> Select(Cliente filtro) throws SQLException, ExceptionGeral {
        ArrayList<Cliente> listafiltro = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
conectar();
            PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("select* from cliente where cpf_cliente ='" + filtro.getCpf() + "';");
            
        try {

            ret = pstm.executeQuery();
            while (ret.next()) {
                cliente.setCpf(ret.getString(1));
                cliente.setNome(ret.getString(2));
                cliente.setEndereco(ret.getString(3));
                cliente.setNumero(ret.getInt(4));
                cliente.setComplemento(ret.getString(5));
                cliente.setBairro(ret.getString(6));
                cliente.setCidade(ret.getString(7));
                cliente.setTelefone(ret.getString(8));
                listafiltro.add(cliente);
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro no retorno de cliente: " + e.getMessage());
        }
        try {

            conectar();
           pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from veiculo where cpf_cliente = '" + filtro.getCpf() + "';");
            ret = pstm.executeQuery();
            if (ret.next()) {
                cliente.getVeiculo().setPlaca(ret.getString(2));
                listafiltro.add(cliente);
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro no retorno de veiculo: " + e.getMessage());
        }

        return listafiltro;
    }
}
