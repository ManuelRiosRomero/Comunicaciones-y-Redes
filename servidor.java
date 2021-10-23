
/*
2. javac servidor.java
3. java servidor
*/
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class servidor {
    public static void main(String[] args) throws IOException {
        // Crear el socket de Servidor y los streams
        ServerSocket serversocket = new ServerSocket(4999);
        Socket socket = serversocket.accept();
        Scanner scanAux = new Scanner(socket.getInputStream());
        PrintStream p = new PrintStream(socket.getOutputStream());

        // Recibir del cliente
        int numero = scanAux.nextInt();
        System.out.println("Conectado con el Cliente: " + numero);
        int temp = numero * 2;

        // Enviar al cliente
        p.println(temp);
    }
}