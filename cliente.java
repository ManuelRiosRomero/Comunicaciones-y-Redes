
/*
1. javac cliente.java
4. java cliente
*/
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) throws IOException {
        // Crear el socket de cliente ("direccion ip", puerto)
        Socket socket = new Socket("localhost", 4999);

        // recibir inputs del cliente
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa un numero: ");
        int numero = scan.nextInt();

        // enviar el numero al servidor
        PrintStream p = new PrintStream(socket.getOutputStream());
        p.println(numero);

        // recibir del servidor servidor
        Scanner scanAux = new Scanner(socket.getInputStream());
        int temp = scanAux.nextInt();
        System.out.println(temp);
    }
}