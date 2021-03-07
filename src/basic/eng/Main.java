package basic.eng;

import basic.eng.low_level.Message;
import basic.eng.low_level.PrivateMessage;
import basic.eng.server.ServerConfig;

public class Main {

    public static void main(String[] args) {
	    Message m1 = new Message("John Doe", "Hello, Jane Doe!");
	    Message m2 = new Message("Jane Doe", "Hi darling");
	    Message m3 = new Message("Dragnea", "Vreau sa ies");

	    System.out.println(m1);
	    System.out.println(m2);
	    System.out.println(m3);

		PrivateMessage pm1 = new PrivateMessage("Jane Doe", "John Doe", "Ce faci fa");
		PrivateMessage pm2 = new PrivateMessage("John Doe", "Jane Doe", "tereacu");

		System.out.println(pm1);
		System.out.println(pm2);
		ServerConfig sc = new ServerConfig();
		System.out.println(sc);
    }
}
