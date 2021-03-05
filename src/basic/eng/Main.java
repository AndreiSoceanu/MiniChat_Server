package basic.eng;

import basic.eng.low_level.Message;

public class Main {

    public static void main(String[] args) {
	    Message m1 = new Message("John Doe", "Hello, Jane Doe!");
	    Message m2 = new Message("Jane Doe", "Hi darling");
	    Message m3 = new Message("Dragnea", "Vreau sa ies");

	    System.out.println(m1.toString());
	    System.out.println(m2.toString());
	    System.out.println(m3.toString());
    }
}
