/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverimpl;

import java.rmi.RemoteException;
import Interface.IModificadorDeStrings;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author 14201805
 */
public class ModifServerImpl extends UnicastRemoteObject implements IModificadorDeStrings{
    
    private static final long serialVersionUID = -578077740786022145L;
    
    
    public ModifServerImpl() throws RemoteException{
        super();
    }
    
    
    @Override
    public String reverterString(String sentenca) throws RemoteException{
        if(sentenca.isEmpty()){
            return sentenca;
        }
        return reverterString(sentenca.substring(1))+sentenca.charAt(0);
    }


    @Override
    public String contaVogais(String sentenca) throws RemoteException{

        int vogais=0;
        while(!sentenca.isEmpty()){
            char c = sentenca.charAt(0);
            if(c=='a'||c=='e' ||c=='i' ||c=='o' ||c=='u') vogais++;
            sentenca=sentenca.substring(1);
        }
        return "Esta sentença possui: " + vogais + " vogais";
    }
}
