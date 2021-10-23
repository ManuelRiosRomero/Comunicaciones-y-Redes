
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
        // recibir inputs del cliente
        Scanner scan = new Scanner(System.in);
        // enviar al servidor
        PrintStream out = new PrintStream(socket.getOutputStream());
        // recibir del servidor
        Scanner in = new Scanner(socket.getInputStream());

        // ciclo de comunicacion cliente servidor
        while (true) {
            System.out.println("> ");
            String comando = scan.nextLine();
            if (comando.equals("salir")) {
                break;
            } else {
                comando = scan.nextLine();
                // enviar comando al servidor
                out.println(comando);
            }
            String respuesta = in.nextLine();
            System.out.println(respuesta);
        }

        // terminar cliente
        socket.close();
        scan.close();
        in.close();
        out.close();
    }
}