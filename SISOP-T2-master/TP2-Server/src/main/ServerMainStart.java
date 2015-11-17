package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interface.IModificadorDeStrings;
import serverimpl.ModifServerImpl;

public class ServerMainStart extends ServerMainBase{

	private static final int port = 1099;

	public ServerMainStart() {
		super(IModificadorDeStrings.class);
	}

	@Override
	public void doCustomRmiHandling() {
		try {
			

			IModificadorDeStrings frase = (IModificadorDeStrings) new ModifServerImpl();

			Registry registry = LocateRegistry.createRegistry(port);
			
			registry.bind("modif", frase);
                        
			
			System.out.println(frase + "\n");
			System.out.println(registry + "\n");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		new ServerMainStart();
	}

}
