/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ClassesBasicas.Movimentacao;
import java.util.ArrayList;

/**
 *
 * @author Danillo
 */
public interface InterfaceMovimentacao {

    void Entrada(Movimentacao veiculo) throws Exception;

    void Saida(Movimentacao veiculo) throws Exception;
    
    ArrayList<Movimentacao>ListarMovimentacao()throws Exception;

}
