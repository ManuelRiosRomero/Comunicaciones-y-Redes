
/*
Comentario: Traté de efectuar en cada direccion ip un tiempo limite pero el codigo no me permitía hacerlo. Este codigo solo establece un tiempo de 1 minuto para introducir un comando por cliente. Si se pasa genera el catch TimeoutException.
1. javac cliente.java
4. java cliente
 */
import java.net.*;
import java.io.*;

public class cliente {

    private static final String IpServidor = "LocalHost";
    private static final int PuertoServidor = 4999;

    public static void main(String[] args) throws IOException {
        // Crear el socket de cliente ("direccion ip", puerto)
        // "localhost" en misma maquina.... IP compu personal 192.168.20.21
        Socket socket = new Socket(IpServidor, PuertoServidor);
        socket.setSoTimeout(60 * 1000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // ciclo de comunicacion cliente servidor
        try {
            while (true) {
                System.out.println("\n> ");
                String comando = keyboard.readLine();
                if (comando.equals("salir")) {
                    break;
                }
                out.println(comando);

                String respuestaServidor = input.readLine();
                System.out.print("Respuesta del Servidor: " + respuestaServidor);

            }
        } catch(SocketTimeoutException st){
            System.out.println("Tiempo límite alcanzado");
        }
        socket.close();
        System.exit(0);
    }
}
