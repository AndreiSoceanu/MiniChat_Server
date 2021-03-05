package basic.eng.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServerConfig {
    private String configFile;

    int TCP_PORT;
    int MAX_CLIENTS;

    public ServerConfig(){
        this("values/server.conf");
    }

    public ServerConfig(String filepath){
        configFile = filepath;
        try {
            parseConfigFile();
        } catch(Exception e){
            System.err.println(e.toString());
        }
    }

    private void parseConfigFile() throws Exception {
        Scanner scan = new Scanner(new File(configFile));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("#")) continue;
            if(line.startsWith("TCP")){
                TCP_PORT = Integer.parseInt(line.split("=")[1]);
                /**
                 * TODO @Andreea:
                 * Please add some mechanism to make sure that only 1 line containing TCP_PORT is being read, no more
                 * Suggestion: add 2 more boolean vars for max clients and for tcp port, set them true when they are read.
                 */
            } else if(line.startsWith("MAX")){
                MAX_CLIENTS = Integer.parseInt(line.split("=")[1]);
                /**
                 * TODO @Andreea:
                 * Please add some mechanism to make sure that only 1 line containing MAX_CLIENTS is being read, no more
                 */
            } else throw new Exception("Invalid config file!\n");
        }


    }

    public String toString(){
        return "MAX CLIENTS: " + MAX_CLIENTS + "\nTCP_PORT: " + TCP_PORT + "\n";
    }

}
