import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ManejadorCliente implements Runnable {
    private Socket cliente;
    private PrintStream out;
    private Scanner in;

    public ManejadorCliente(Socket socketCliente) throws IOException {
        this.cliente = socketCliente;
        // recibir inputs del cliente
        Scanner scan = new Scanner(System.in);
        // enviar al servidor
        PrintStream out = new PrintStream(socketCliente.getOutputStream());
        // recibir del servidor
        Scanner in = new Scanner(socketCliente.getInputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    String solicitud = in.nextLine();

                    if (solicitud.contains("multiplicar")) {

                    } else {
                        System.out.println("[Servidor] Los comandos disponibles son: multiplicar");
                    }
                    // Enviar al cliente
                    out.println();
                }
            } finally {
                // Cerrar el servidor
                System.out.println("[Manejador Clientes] Cerrando Manejador Cliente...");

                try {
                    cliente.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                in.close();
                out.close();
            }
        }
    }

}
