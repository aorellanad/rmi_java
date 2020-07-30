/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axl Orellana
 */
public class DBClient {
    Connection cn;
    
    public Connection connect()
    {   
        String url="jdbc:mysql://localhost/credit_system";
        String user="root";
        String pass="";
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            cn = DriverManager.getConnection(url, user,pass);
            return cn;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBClient.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }
    
    public void disconnect() throws SQLException
    {
        if(cn!=null) cn.close();
    }
}
