package example.Hola;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hola {

    public Server() {}

  
    public String decirHola() {
        System.out.println("¡Petición recibida del cliente!");
        return "¡Hola, mundo desde el Servidor RMI!";
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            

            Hola stub = (Hola) UnicastRemoteObject.exportObject(obj, 0);

            
            Registry registry = LocateRegistry.createRegistry(1099);
            
           
            registry.rebind("Hola", stub);

            System.err.println("Servidor listo (Servicio 'Hola' registrado)...");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}