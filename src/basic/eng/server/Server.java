package basic.eng.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerConfig serverConfig = new ServerConfig();
        ServerSocket serverSocket =
                new ServerSocket(serverConfig.getTCP_PORT());
        ServerPeer serverPeer = new ServerPeer(serverSocket.accept());
        serverPeer.run();
    }
}
