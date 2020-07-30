/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Client;

/**
 *
 * @author Axl Orellana
 */
public class ClientDao {

    public boolean saveClient(String idCard, String name, String email, String cellphone, String birthdate) throws RemoteException {
        Client client = new Client(idCard, name, email, cellphone, birthdate);
        boolean resp;
        DBClient cn = new DBClient();
        String sql = "Insert into client (id_card, name, email, cellphone, birth_date) values (?, ? , ?, ?, ?)";
        try {
            PreparedStatement ps = cn.connect().prepareStatement(sql);
            ps.setString(1, client.getIdCard());
            ps.setString(2, client.getName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getCellphone());
            ps.setString(5, client.getBirthdate());
            ps.executeUpdate();
            resp = true;
            cn.disconnect();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resp = false;
        }
        return resp;
    }

}
