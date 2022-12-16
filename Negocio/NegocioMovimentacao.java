/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import ClassesBasicas.Movimentacao;
import Interface.InterfaceMovimentacao;
import Repositorio.RepositorioMovimentacao;
import java.util.ArrayList;

/**
 *
 * @author Danillo
 */
public class NegocioMovimentacao implements InterfaceMovimentacao {

    private RepositorioMovimentacao repositorio = new RepositorioMovimentacao();

    @Override
    public void Entrada(Movimentacao entrada) throws Exception {
        if (entrada == null) {
            throw new Exception("A movimentação não foi instanciada");
        }
        if (entrada.getCliente().getVeiculo().getPlaca() == null | entrada.getCliente().getVeiculo().getPlaca().trim().equals("")) {
            throw new Exception("A placa não foi informada");
        }
        if (repositorio.PlacaExiste(entrada) == false) {
            throw new Exception("Não existe nenhum cadastro ativo para a placa informada.");
        }
         if (repositorio.PlacaEntrou(entrada) == true) {
            throw new Exception(" A placa informada já se encontra no estacionamento.");

        }
        this.repositorio.Entrada(entrada);
    }

    @Override
    public void Saida(Movimentacao saida) throws Exception {
        if (saida == null) {
            throw new Exception("A movimentação não foi instanciada");
        }
        if (saida.getCliente().getVeiculo().getPlaca() == null | saida.getCliente().getVeiculo().getPlaca().trim().equals("")) {
            throw new Exception("A placa não foi informada");
        }
         if (repositorio.PlacaExiste(saida) == false) {
            throw new Exception("Não existe nenhum cadastro ativo para a placa informada.");
        }
          if (repositorio.PlacaEntrou(saida) == false) {
            throw new Exception(" Este veículo não entrou");
        }
        this.repositorio.Saida(saida);
    }

    @Override
    public ArrayList<Movimentacao> ListarMovimentacao() throws Exception {
        return this.repositorio.Listar();
    }
}
