package basic.eng.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerPeer {
    private final Socket socket;
    public ServerPeer(Socket socket) {
        this.socket = socket;

    }
    public void run() {
        try {
            ObjectInputStream inputStream =
                    new ObjectInputStream(socket.getInputStream());
            System.out.println(inputStream.read());
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
