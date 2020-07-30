/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axl Orellana
 */
class Servidor extends UnicastRemoteObject implements Interfaz {

    public Servidor() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Datos> Consulta() throws RemoteException {
        ArrayList<Datos> objDatos = new ArrayList<>();
        conexion cn = new conexion();
        cn.conectar();
        Statement st = cn.getSt();
        try {
            ResultSet rs = st.executeQuery("Select * from datos");
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String descrip = rs.getString("descripcion");
                Datos dato = new Datos(codigo, descrip);
                objDatos.add(dato);
            }
            cn.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return objDatos;
    }

    @Override
    public boolean existInTheCreditBureau(String idCard) throws RemoteException {
        boolean isExist;
        conexion cn = new conexion();
        cn.conectar();
        String sql = "Select * from history where id_card = ? ";
        try {
            PreparedStatement ps = cn.getCn().prepareStatement(sql);
            ps.setString(1, idCard);
            ResultSet rs = ps.executeQuery();
            isExist = rs.first();
            cn.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            isExist = false;
        }
        return isExist;
    }

    @Override
    public boolean Grabar(String descrip) throws RemoteException {
        conexion cn = new conexion();
        boolean resp;
        cn.conectar();
        Statement st = cn.getSt();
        String sentencia = "Insert into datos (descripcion) values ('" + descrip + "')";
        try {
            st.executeUpdate(sentencia);
            resp = true;
            cn.desconectar();
        } catch (SQLException ex) {
            resp = false;
        }

        return resp;
    }

    public static void main(String[] args) {

        try {
            Registry registro = LocateRegistry.createRegistry(1000);
            registro.rebind("rmi://localhost:1000/Interfaz", new Servidor());
            System.out.println("Servidor Activo");
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
