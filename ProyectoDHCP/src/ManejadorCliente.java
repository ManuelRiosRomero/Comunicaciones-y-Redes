import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

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
                if (solicitud.equals("nueva_IP")) {
                    out.println("se entro al comando de dar ips");
                    String direccion = IPs("darIP");
                    out.println(direccion);
                }
                if (solicitud.equals("comando 2")) {
                    out.println("se entro al comando 2");
                } else {
                    out.println("Comandos Aceptados:  'Comando 1', 'comando 2' ");
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

    public String IPs(String comando) {
        // List<String> Direcciones =
        // Arrays.asList("192.168.56.50","192.168.56.51","192.168.56.52","192.168.56.53");
        String[] Direcciones = { "192.168.56.50", "192.168.56.51", "192.168.56.52", "192.168.56.53" };
        Boolean ip1 = true;
        Boolean ip2 = true;
        Boolean ip3 = true;
        Boolean ip4 = true;
        String direccionIP = "";

        if (comando.equals("darIP")) {
            if (ip1 == true) {
                direccionIP = Direcciones[0];
                ip1 = false;
                return direccionIP;
            }
            if (ip2 == true) {
                direccionIP = Direcciones[1];
                ip2 = false;
                return direccionIP;
            }
            if (ip3 == true) {
                direccionIP = Direcciones[2];
                ip3 = false;
                return direccionIP;
            }
            if (ip4 == true) {
                direccionIP = Direcciones[3];
                ip4 = false;
                return direccionIP;
            }
        }

        else {
            if (comando.equals(Direcciones[0])) {
                ip1 = true;
                return null;
            }
            if (comando.equals(Direcciones[1])) {
                ip2 = true;
                return null;
            }
            if (comando.equals(Direcciones[2])) {
                ip3 = true;
                return null;
            }
            if (comando.equals(Direcciones[3])) {
                ip4 = true;
                return null;
            }

        }

        return direccionIP;
    }

}