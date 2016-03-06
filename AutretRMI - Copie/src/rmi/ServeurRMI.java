package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Alexa on 04/03/2016.
 */
public interface ServeurRMI extends Remote {
    public String meth() throws RemoteException;
}

