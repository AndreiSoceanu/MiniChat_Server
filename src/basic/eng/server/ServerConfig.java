package basic.eng.server;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class ServerConfig {
    private String configFile;

    private int TCP_PORT;
    private int MAX_CLIENTS;

    public ServerConfig() {
        this("values/server.conf");
    }

    public ServerConfig(String filepath) {
        configFile = filepath;
        try {
            parseConfigFile();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    private void parseConfigFile() {
        try {
            Scanner scan = new Scanner(new File(configFile));
            boolean haveTCP = false, haveClients = false;
            int unknownFormatLine = 0;
            while (scan.hasNextLine()) {

                if (haveTCP && haveClients)
                    break;

                String line = scan.nextLine();
                /**
                 * for valid properties
                 */
                if (line.contains("=")) {
                    if (line.split("=")[0].compareTo("TCP_PORT") != 0
                            && line.split("=")[0].compareTo("MAX_CLIENTS") != 0) {
                        throw new UnknownKeyException("Unknown property!");
                    }
                }
                /**
                 * for invalid format
                 */

                if (!line.contains("#") && !line.contains("="))
                    unknownFormatLine += 1;

                if (line.startsWith("#"))
                    continue;
              
                if (line.startsWith("TCP")) {
                    TCP_PORT = Integer.parseInt(line.split("=")[1]);
                    haveTCP = true;
                    /**
                     * TODO @Andreea:
                     * Please add some mechanism to make sure that only 1 line containing TCP_PORT is being read, no more
                     * Suggestion: add 2 more boolean vars for max clients and for tcp port, set them true when they are read.
                     */
                } else if (line.startsWith("MAX")) {
                    MAX_CLIENTS = Integer.parseInt(line.split("=")[1]);
                    haveClients = true;
                    /**
                     * TODO @Andreea:
                     * Please add some mechanism to make sure that only 1 line containing MAX_CLIENTS is being read, no more
                     */
                }
            }
            if (unknownFormatLine != 0)
                throw new UnknownFormatException("Unknown format! Verify server.config file");

            if (!haveClients || !haveTCP)
                throw new MissingKeyException("Missing one or more properties. " +
                        "Verify TCP_PORT or MAX_CLIENTS!");
        } catch (IOException | MissingKeyException | UnknownKeyException | UnknownFormatException e) {
            e.printStackTrace();
        }
    }

    public int getTCP_PORT() {
        return TCP_PORT;
    }

    public int getMAX_CLIENTS() {
        return MAX_CLIENTS;
    }

    public String toString() {
        return "MAX CLIENTS: " + MAX_CLIENTS + "\nTCP_PORT: " + TCP_PORT + "\n";
    }

}
