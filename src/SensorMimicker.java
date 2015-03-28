import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Gray on 28.03.2015.
 */
public class SensorMimicker {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Sensor Mimicker!");

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected");

        InputStream inStream = clientSocket.getInputStream();
        OutputStream outStream = clientSocket.getOutputStream();

        DataInputStream in = new DataInputStream(inStream);
        DataOutputStream out = new DataOutputStream(outStream);

        String request = null;
        String response = null;

        while (true) {
            request = in.readUTF();
            System.out.println("Client -> Server: " + request);
            response = "Request confirmed";
            out.writeUTF(response);
            System.out.println("Client <- Server: " + response);
            out.flush();
        }
    }
}
