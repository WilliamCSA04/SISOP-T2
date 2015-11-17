/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author 14201805
 */
public interface IModificadorDeStrings extends Remote{
    
    public String reverterString(String sentenca) throws RemoteException;
    public String contaVogais(String sentenca) throws RemoteException;
    
}
