
/*
1. javac cliente.java
4. java cliente
*/
import java.net.*;
import java.io.*;

public class cliente {
    private static final String IpServidor = "LocalHost";
    private static final int PuertoServidor = 4999;
    public static String IpAddress;
    // byte[] MacAddress;
    // byte[] port;

    public static void main(String[] args) throws IOException {
        // Crear el socket de cliente ("direccion ip", puerto)
        // "localhost" en misma maquina.... IP compu personal 192.168.20.21
        Socket socket = new Socket(IpServidor, PuertoServidor);
        // manejador del tiempo limite del cliente
        socket.setSoTimeout(60 * 1000);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("\nIngrese el comando 'ayuda' para ver los comandos...");

        // ciclo de comunicacion cliente servidor

        try {
            while (true) {
                System.out.println("\n> ");
                String comando = keyboard.readLine();

                String respuestaServidor = "";

                // ------Comando Asignar IPs---------
                if (comando.equals("nueva_IP")) {
                    System.out.print("Entro al comando de IPS");
                    out.println(comando);
                    respuestaServidor = input.readLine();
                    IpAddress = String.valueOf(respuestaServidor);
                    System.out.print("Dirección IP recibida: " + respuestaServidor);
                    System.out.print("Dirección IP almacenada: " + IpAddress);
                }

                if (comando.equals("salir")) {
                    break;
                }
                // out.println(comando);
                // System.out.print("Respuesta del Servidor: " + respuestaServidor);
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Tiempo límite alcanzado");
            socket.close();
        }
        socket.close();
        System.exit(0);
    }
}