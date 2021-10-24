
/*
1. javac cliente.java
4. java cliente
*/
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class cliente {
    private static final String IpServidor = "LocalHost";
    private static final int PuertoServidor = 4999;

    public static void main(String[] args) throws IOException {
        // Crear el socket de cliente ("direccion ip", puerto)
        // "localhost" en misma maquina.... IP compu personal 192.168.20.21
        Socket socket = new Socket(IpServidor, PuertoServidor);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // ciclo de comunicacion cliente servidor
        while (true) {
            System.out.println("\n> ");
            String comando = keyboard.readLine();
            if (comando.equals("salir"))
                break;
            out.println(comando);

            String respuestaServidor = input.readLine();
            System.out.print("Respuesta del Servidor: " + respuestaServidor);
        }
        socket.close();
        System.exit(0);
    }
}