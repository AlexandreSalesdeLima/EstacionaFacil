package Repositorio;

import ClassesBasicas.Movimentacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Danillo,Alexandre
 */
public class RepositorioMovimentacao extends RepositorioConectaDB {

    ResultSet ret;
    boolean retorno = false;
    boolean retorno1 = false;
    Movimentacao impressao = new Movimentacao();

    public boolean PlacaExiste(Movimentacao movimentacao) throws ExceptionGeral, SQLException {
        try {
            String sqlplaca = "Select * from Veiculo where Placa = '" + movimentacao.getCliente().getVeiculo().getPlaca() + "'";
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

    public boolean PlacaEntrou(Movimentacao movimentacao) throws ExceptionGeral, SQLException {
        try {
            retorno = false;
            String sqlmovimento = "Select* from movimentacao where Placa = '" + movimentacao.getCliente().getVeiculo().getPlaca() + "'and saiu ='n'";
            conectar();
            ret = stm.executeQuery(sqlmovimento);
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

    public boolean PlacaSaiu(Movimentacao movimentacao) throws ExceptionGeral, SQLException {
        try {
            retorno = false;
            String sqlplaca = "Select saiu='n' from Movimentacao where Placa = '" + movimentacao.getCliente().getVeiculo().getPlaca() + "'";
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

    public void Entrada(Movimentacao movimentacao) throws ExceptionGeral, SQLException {


        try {

            String sqlMovimentacao = "insert into Movimentacao(Funcionario,Placa,dt_entrada,hr_entrada,saiu)values('" + movimentacao.getFuncionario().getLogin() + "','" + movimentacao.getCliente().getVeiculo().getPlaca() + "',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'N');";

            conectar().execute(sqlMovimentacao);
            desconectar();
            try {
                conectar();
                PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from Movimentacao where Placa = '" + movimentacao.getCliente().getVeiculo().getPlaca() + "' and saiu='n'");
                ret = pstm.executeQuery();
                if (ret.next()) {
                    impressao.getCliente().getVeiculo().setPlaca(ret.getString(2));
                    impressao.setDt_entrada(ret.getDate(3).toString());
                    impressao.setHorario_entrada(ret.getTime(4).toString());

                    JOptionPane.showMessageDialog(null, "EstacionaFacil\nSistema de Gerênciamento de Estacionamento\n\nPlaca:" + impressao.getCliente().getVeiculo().getPlaca() + "\n Data de Entrada:" + impressao.getDt_entrada() + "\nHora de entrada:" + impressao.getHorario_entrada() + "\n\n\nDesejamos a todos um Feliz Natal!!!\nBoas Festas");

                } else {
                    throw new ExceptionGeral("");
                }
                desconectar();
                retorno = false;
                retorno1 = false;
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    //fechar coneccao com o banco de dados   
                    ret.close();
                } catch (Exception e) {
                    System.out.println("Erro" + e);
                }

            }
        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Movimentacao: " + e.getMessage());
        }

    }

    public void Saida(Movimentacao movimentacao) throws ExceptionGeral, SQLException {

        try {
            conectar();
            PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from Movimentacao where Placa ='" + movimentacao.getCliente().getVeiculo().getPlaca() + "' and saiu='n'");
            ret = pstm.executeQuery();
            if (ret.next()) {
                impressao.getCliente().getVeiculo().setPlaca(ret.getString(2));
                impressao.setDt_entrada(ret.getDate(3).toString());
                impressao.setHorario_entrada(ret.getTime(4).toString());

            } else {
                throw new ExceptionGeral("erro no banco de dados");
            }

            try {
                Date saida = new Date();
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatador1 = new SimpleDateFormat("HH:mm:ss");
                String DataSaida = formatador.format(saida).toString();
                String HoraSaida = formatador1.format(saida).toString();
                impressao.setDt_saida(DataSaida);
                impressao.setHorario_saida(HoraSaida);
                int hora_entrada = Integer.parseInt(impressao.getHorario_entrada().substring(0, 2));
                int minuto_entrada = Integer.parseInt(impressao.getHorario_entrada().substring(3, 5));
                int segundo_entrada = Integer.parseInt(impressao.getHorario_entrada().substring(6, 8));
                int tempo_entrada = (hora_entrada * 60) + minuto_entrada;
                int hora_saida = Integer.parseInt(impressao.getHorario_saida().substring(0, 2));
                int minuto_saida = Integer.parseInt(impressao.getHorario_saida().substring(3, 5));
                int segundo_saida = Integer.parseInt(impressao.getHorario_saida().substring(6, 8));
                int tempo_saida = (hora_saida * 60) + minuto_saida;
                Double valor = 0.00;
                int tempo_permanencia = tempo_saida - tempo_entrada;
                if (tempo_permanencia <= 15) {
                    valor = 0.00;
                } else if (tempo_permanencia > 15) {
                    valor = 3.00;
                }

                String sqlMovimentacao = "update Movimentacao set dt_saida= CURRENT_TIMESTAMP, hr_saida = CURRENT_TIMESTAMP,valor=" + valor + " where placa='" + movimentacao.getCliente().getVeiculo().getPlaca() + "' and saiu='n';";

                conectar().execute(sqlMovimentacao);
                desconectar();


                String sqlSaida = "update Movimentacao set saiu='S' where placa='" + movimentacao.getCliente().getVeiculo().getPlaca() + "'and saiu = 'n'";
                conectar().execute(sqlSaida);

                JOptionPane.showMessageDialog(null, "EstacionaFacil\nSistema de Gerênciamento de Estacionamento\n\nPlaca:" + impressao.getCliente().getVeiculo().getPlaca() + "\n Data de Entrada:" + impressao.getDt_entrada() + "\nHora de entrada:" + impressao.getHorario_entrada() + "\nData de saída: " + impressao.getDt_saida() + "\n Hora de Saída" + impressao.getHorario_saida() + "\nValor:" + valor + "\n\n\nDesejamos a todos um Feliz Natal!!!\nBoas Festas");

                desconectar();
                retorno = false;
                retorno1 = false;
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    //fechar coneccao com o banco de dados   
                    ret.close();
                } catch (Exception e) {
                    System.out.println("Erro" + e);
                }

            }
        } catch (SQLException e) {
            throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Movimentacao: " + e.getMessage());
        }


    }

    public ArrayList<Movimentacao> Listar() throws ExceptionGeral, SQLException {
        ArrayList<Movimentacao> listaMovimentacao = new ArrayList<Movimentacao>();
        try {
            conectar();
            PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from Movimentacao");
            ret = pstm.executeQuery();
            while (ret.next()) {

                Movimentacao movimentacao = new Movimentacao();
                movimentacao.getFuncionario().setLogin(ret.getString(1));
                movimentacao.getCliente().getVeiculo().setPlaca(ret.getString(2));
                movimentacao.setDt_entrada(ret.getString(3));
                movimentacao.setHorario_entrada(ret.getString(4));
                movimentacao.setDt_saida(ret.getString(5));
                movimentacao.setHorario_saida(ret.getString(6));
                movimentacao.setRetornoValor(ret.getString(8));
                listaMovimentacao.add(movimentacao);
            }
            desconectar();
        } catch (SQLException e) {

            throw new ExceptionGeral("Ocorreu um erro no retorno de Movimentacao: " + e.getMessage());

        }
        return listaMovimentacao;
    }
}
