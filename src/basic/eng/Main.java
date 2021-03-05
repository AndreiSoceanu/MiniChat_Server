package basic.eng;

import basic.eng.low_level.Message;
import basic.eng.low_level.PrivateMessage;

public class Main {

    public static void main(String[] args) {
	    Message m1 = new Message("John Doe", "Hello, Jane Doe!");
	    Message m2 = new Message("Jane Doe", "Hi darling");
	    Message m3 = new Message("Dragnea", "Vreau sa ies");

	    System.out.println(m1.toString());
	    System.out.println(m2.toString());
	    System.out.println(m3.toString());

		PrivateMessage pm1 = new PrivateMessage("Jane Doe", "John Doe", "Ce faci fa");
		PrivateMessage pm2 = new PrivateMessage("John Doe", "Jane Doe", "tereacu");

		System.out.println(pm1.toString());
		System.out.println(pm2.toString());
    }
}
