/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.NotBoundException;
import views.creditForm;

/**
 *
 * @author vjurado
 */
public class consulta {
    public static void main(String[] args) throws NotBoundException {
        new creditForm().setVisible(true);
        // new dataForm().setVisible(true);
    }
}