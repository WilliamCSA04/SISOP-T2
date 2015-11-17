package main;

import util.PolicyFileLocator;

public abstract class ServerMainBase {
	
	@SuppressWarnings("rawtypes")
	public ServerMainBase(Class clazzToAddToServerCodebase) {
		
		
		System.setProperty("java.rmi.server.codebase", clazzToAddToServerCodebase.getProtectionDomain().getCodeSource().getLocation().toString());

                System.setProperty("java.security.policy", PolicyFileLocator.getLocationOfPolicyFile());

                if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		doCustomRmiHandling();
	}

        public abstract void doCustomRmiHandling();
}
