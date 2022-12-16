/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ClassesBasicas.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danillo
 */
public interface InterfaceCliente {

    void Cadastrar(Cliente cliente) throws Exception;

    void Alterar(Cliente cliente) throws Exception;

    void Remover(Cliente cliente) throws Exception;

    ArrayList<Cliente> ListarCliente() throws Exception;
    
    ArrayList<Cliente> SelectCliente(Cliente filtro)throws Exception;
}
