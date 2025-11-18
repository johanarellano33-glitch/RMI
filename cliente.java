package example.Hola;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class cliente {

    private cliente() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        
        try {
            
            Registry registry = LocateRegistry.getRegistry(host);
            
           
            Hola stub = (Hola) registry.lookup("Hola");
            
          
            String response = stub.decirHola();
            System.out.println("Respuesta del servidor: " + response);
            
        } catch (Exception e) {
            System.err.println("Excepción del cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}