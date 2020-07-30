/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Axl Orellana
 */
public interface Interfaz extends Remote{
    public ArrayList<Datos> Consulta() throws RemoteException;
    public boolean Grabar(String descrip) throws RemoteException;
    public boolean existInTheCreditBureau(String idCard) throws RemoteException;
}
