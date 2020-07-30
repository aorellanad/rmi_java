/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axl Orellana
 */
public class conexion {
    Connection cn=null;
    Statement st=null;
    
    public void conectar()
    {   String url="jdbc:mysql://localhost/credit_bureau";
        String user="root";
        String pass="";
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            cn=DriverManager.getConnection(url, user,pass);
            if(cn!=null)
            {
                st=cn.createStatement();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void desconectar() throws SQLException
    {
        if(st!=null)
        {
            st.close();
        }
        if(cn!=null)
        {
            cn.close();
        }
    }

    public Connection getCn() {
        return cn;
    }

    public Statement getSt() {
        return st;
    }
}
