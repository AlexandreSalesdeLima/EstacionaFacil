/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Danillo
 */
public class RepositorioConectaDB {

    private static Connection con;
    public Statement stm;

    public static Connection getConnection() {
        try {
     
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            DriverManager.getConnection("jdbc:odbc:dbEstacionaFacil");
            return con;
        } catch (Exception x) {
            return null;
        }

    }

    public Statement conectar() {
        try {


            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con= DriverManager.getConnection("jdbc:odbc:dbEstacionaFacil");
            stm = con.createStatement();
        } catch (ClassNotFoundException e) {
        } catch (SQLException sqle) {
        }
        return stm;
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException sqle) {
        }
    }
}