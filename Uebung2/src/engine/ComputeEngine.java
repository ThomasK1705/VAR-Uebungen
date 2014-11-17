package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import compute.Compute;
import compute.Task;

public class ComputeEngine implements Compute{
	
	public ComputeEngine() {
		super();
	}
	
	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}
	
	public static void main(String[] args){
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "Compute";
			//System.setProperty("java.security.policy","file:///C:/Users/thomaskaemmerling/Dropbox/HS Mannheim/VAR/VAR-Uebungen/Uebung2/policy.txt");
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(name, engine);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}

}
