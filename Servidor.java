import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        // Establece el puerto a utilizar
        int puerto = 8080;
        try {
            // Se crea un objeto socket de servidor
            ServerSocket ss = new ServerSocket(puerto);
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");

            // Cuando un cliente se conecta se abre el puerto a escuchar conexiones de cliente
            // AQUI SE CREA EL SOCKET EN EL SO
            Socket ch = ss.accept();

            // Establece el stream de salida
            PrintWriter out = new PrintWriter(ch.getOutputStream(), true);
            // Establece el stream de entrada
            BufferedReader in = new BufferedReader(new InputStreamReader(ch.getInputStream()));

            // Envía Hola Mundo
            out.println("Hola ");
            out.println("Mundo ");
            out.println("Fabiola Narayani Guzman Figueroa");
            out.println("del servidor al cliente!");
            out.println("Adios");

            // Luego espera por el cliente
            System.out.println("Cliente: " + in.readLine());

            // Cierra las conexiones
            out.close();
            in.close();
            ch.close();
            ss.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}