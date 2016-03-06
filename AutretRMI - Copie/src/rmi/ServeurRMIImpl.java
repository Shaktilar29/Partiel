package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Alexa on 04/03/2016.
 */
public class ServeurRMIImpl implements ServeurRMI {

    @Override
        public String meth() throws RemoteException {
            return "reponse du serveur rmi";
        }

    public static void main(String[] args) {
        int port = 10000;
        Registry registry = null;
        try {
            LocateRegistry.createRegistry(port);
            registry = LocateRegistry.getRegistry(port);
        } catch (RemoteException e) {
            System.out.println("Erreur RMI CreateRegistry");
            e.printStackTrace();
        }

        ServeurRMIImpl srmii = new ServeurRMIImpl();
        ServeurRMI srmi = null;

        try {
            srmi = (ServeurRMI) UnicastRemoteObject.exportObject(srmii,0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            registry.rebind("ServeurRMI",srmi);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Serveur RMI Lancé");
    }

}

