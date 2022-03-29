
/*
2. javac servidor.java
3. java servidor
*/
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class servidor {
    private static final int Puerto = 4999;
    private static ArrayList<ManejadorCliente> clientes = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        // Crear el socket de Servidor y los streams
        ServerSocket listener = new ServerSocket(Puerto);

        // Recibir del cliente

        while (true) {
            System.out.println("[Servidor] Esperando Cliente...");
            Socket cliente = listener.accept();
            System.out.println("[Servidor] Cliente Conectado");

            ManejadorCliente threadsCliente = new ManejadorCliente(cliente);
            clientes.add(threadsCliente);
            pool.execute(threadsCliente);
        }
        //taskkill -pid Puerto /f;
    }
}