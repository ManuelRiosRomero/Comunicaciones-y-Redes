import java.io.*;
import java.net.Socket;

public class ManejadorCliente implements Runnable {
    private Socket cliente;
    private BufferedReader in;
    private PrintWriter out;

    public ManejadorCliente(Socket socketCliente) throws IOException {
        this.cliente = socketCliente;
        in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        out = new PrintWriter(cliente.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String solicitud = in.readLine();
                if (solicitud.equals("comando 1")) {
                    out.println("se entro al comando 1");
                } else {
                    out.println("Comandos Aceptados: \n 'Comando 1' ");
                }
            }
        } catch (IOException e) {
            System.err.println("IOException en ManejadorCliente");
            System.err.println(e.getStackTrace());
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}