package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Alexa on 04/03/2016.
 */
public class ClientRMI {
    public static void main(String[] args) {
        int port = 10000;
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(port);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        ServeurRMI srmi = null;
        try {
            srmi = (ServeurRMI)registry.lookup("ServeurRMI");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        try {
            String res = srmi.meth();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
