
/*
2. javac servidor.java
3. java servidor
*/
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class servidor {
    private static final int Puerto = 4999;
    private static ArrayList<ManejadorCliente> clientes = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        // Crear el socket de Servidor y los streams
        ServerSocket serversocket = new ServerSocket(Puerto);
        Socket socket = serversocket.accept();
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());

        // Recibir del cliente
        while (true) {
            System.out.println("[Servidor] Esperando Cliente...");
            System.out.println("[Servidor] Cliente Conectado");
            ManejadorCliente threadsCliente = new ManejadorCliente(socket);
            clientes.add(threadsCliente);

            pool.execute(threadsCliente);
        }

        /*
         * // Cerrar el servidor System.out.println("[Servidor] Cerrando Servidor...");
         * 
         * in.close(); out.close(); socket.close(); serversocket.close();
         */
    }
}