package client;

import basic.eng.low_level.Message;
import basic.eng.low_level.PrivateMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientPeer {
    private ObjectOutputStream outputStream;
    private String sender;

    public ClientPeer(String senderName, Socket socket) throws IOException {
        sender = senderName;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendMessage(String message) throws IOException {
    outputStream.writeObject(new Message(sender,message));
    }

    public void sendMessage(String message, String recipient) throws IOException{
        outputStream.writeObject(new PrivateMessage(recipient,sender,message));
    }

}
