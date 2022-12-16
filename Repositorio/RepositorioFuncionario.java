/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import ClassesBasicas.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Danillo, Alexandre
 */
public class RepositorioFuncionario extends RepositorioConectaDB {

    Statement stm;
    ResultSet ret;
    boolean retorno = false;

    public boolean MovimentacaoExiste(Funcionario funcionario) throws ExceptionGeral, SQLException {

        try {
            String sql = "Select login from Usuario where cpf_funcionario = '" + funcionario.getCpf() + "'";
            stm = conectar();
            ret = stm.executeQuery(sql);
            while (ret.next()) {
                funcionario.setLogin(ret.getString(1));
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela Movimentação: " + e);
        }
        try {
            retorno = false;
            String sql = "Select * from Movimentacao where funcionario = '" + funcionario.getLogin() + "'";
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

    public boolean CpfExiste(Funcionario funcionario) throws ExceptionGeral, SQLException {
        try {
            retorno = false;
            String sql = "Select * from Funcionario where cpf_funcionario = '" + funcionario.getCpf() + "'";
            stm = conectar();
            ret = stm.executeQuery(sql);
            while (ret.next()) {
                retorno = true;
                break;
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela Funcionário: " + e);
        }
        return retorno;

    }

    public boolean UsuarioExiste(Funcionario funcionario) throws ExceptionGeral, SQLException {
        try {
            String sqllogin = "Select * from Usuario where login = '" + funcionario.getLogin() + "'";
            stm = conectar();
            ret = stm.executeQuery(sqllogin);
            while (ret.next()) {
                retorno = true;
                break;
            }
            desconectar();
        } catch (SQLException e) {
            throw new ExceptionGeral("Erro de pesquisa na tabela Usuário: " + e);
        }
        return retorno;

    }

    public void cadastrar(Funcionario funcionario) throws ExceptionGeral, SQLException {

        try {

            String sqlFuncionario = "insert into Funcionario(Cpf_funcionario,Nome_funcionario,Endereco_funcionario,Numero_funcionario,Complemento_funcionario,Bairro_funcionario,Cidade_funcionario,Telefone_funcionario)values('" + funcionario.getCpf() + "', '" + funcionario.getNome() + "','" + funcionario.getEndereco() + "'," + funcionario.getNumero() + ",'" + funcionario.getComplemento() + "','" + funcionario.getBairro() + "','" + funcionario.getCidade() + "','" + funcionario.getTelefone() + "')";
            conectar().execute(sqlFuncionario);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Funcionário: " + e.getMessage());
        }
        try {

            String sqlsenha = "insert into Usuario(Cpf_funcionario,Login,Senha)values('" + funcionario.getCpf() + "', '" + funcionario.getLogin() + "','" + funcionario.getSenha() + "')";
            conectar().execute(sqlsenha);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Usuário: " + e.getMessage());
        }

        desconectar();
    }

    public void Alterar(Funcionario funcionario) throws ExceptionGeral, SQLException {

        try {

            String sqlalterarfuncionario = "update Funcionario set nome_funcionario='" + funcionario.getNome() + "',endereco_funcionario='" + funcionario.getEndereco() + "',numero_funcionario=" + funcionario.getNumero() + ",complemento_funcionario='" + funcionario.getComplemento() + "',bairro_funcionario='" + funcionario.getBairro() + "',cidade_funcionario='" + funcionario.getCidade() + "',telefone_funcionario='" + funcionario.getTelefone() + "'where cpf_funcionario='" + funcionario.getCpf() + "';";
            conectar().execute(sqlalterarfuncionario);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de Alteração na tabela Funcionario: " + e.getMessage());
        }
    }

    public void Remover(Funcionario funcionario) throws ExceptionGeral, SQLException {

        try {

            String sqlusuario = "delete Usuario where CPF_funcionario ='" + funcionario.getCpf() + "';";
            conectar().execute(sqlusuario);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de remoção na tabela Usuário: " + e.getMessage());
        }


        try {

            String sqlFuncionario = "delete Funcionario where CPF_funcionario ='" + funcionario.getCpf() + "';";
            conectar().execute(sqlFuncionario);
            desconectar();

        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de remoção na tabela Funcionário: " + e.getMessage());

        }
        desconectar();
    }

    public ArrayList<Funcionario> ListarFuncionario() throws ExceptionGeral, SQLException {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            conectar();
            PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from funcionario");
            ret = pstm.executeQuery();
            while (ret.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(ret.getString(1));
                funcionario.setNome(ret.getString(2));
                lista.add(funcionario);
            }
            desconectar();
        } catch (SQLException e) {

            throw new ExceptionGeral("Ocorreu um erro no retorno de Movimentacao: " + e.getMessage());

        }
        return lista;
    }

    public ArrayList<Funcionario> SelectFuncionario(Funcionario filtro) throws SQLException, ExceptionGeral {
        ArrayList<Funcionario> listafiltro = new ArrayList<Funcionario>();
        stm = conectar();
        String sql = "Select * from Funcionario where cpf_funcionario='" + filtro.getCpf() + "';";


        ret = stm.executeQuery(sql);
        if (ret.next()) {


            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(ret.getString(1));
            funcionario.setNome(ret.getString(2));
            funcionario.setEndereco(ret.getString(3));
            funcionario.setNumero(ret.getInt(4));
            funcionario.setComplemento(ret.getString(5));
            funcionario.setBairro(ret.getString(6));
            funcionario.setCidade(ret.getString(7));
            funcionario.setTelefone(ret.getString(8).trim());
            listafiltro.add(funcionario);

        }
        desconectar();
        return listafiltro;
    }

    public boolean VerificaLogin(Funcionario filtro) throws ExceptionGeral, SQLException {
        boolean retorno = false;
        String sql = "Select * from usuario where login = '" + filtro.getLogin() + "' and senha='" + filtro.getSenha() + "'";
        Statement stm = conectar();
        ResultSet ret = stm.executeQuery(sql);
        while (ret.next()) {
            retorno = true;
            break;
        }

        desconectar();
        return retorno;

    }
}
