package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TextClient {
    static final String localHost = "127.0.0.1";
    static final int port = 9000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senderName = scanner.nextLine();
        try {
            Socket socket = new Socket(localHost, port);
            ClientPeer clientPeer = new ClientPeer(senderName, socket);

            while (true) {
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(System.in));
                String input = in.readLine();
                if (input.startsWith("/w")) {
                    /**
                     * for private message -> /w recipientName Message
                     */
                    String tokens[] = input.split(" ", 3);
                    clientPeer.sendMessage(tokens[1], tokens[2]);
                }
                if (input.startsWith("/q")) {
                    socket.close();
                    break;
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}