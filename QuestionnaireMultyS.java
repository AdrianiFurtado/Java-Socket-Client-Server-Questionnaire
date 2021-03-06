import java.net.*;
import java.io.*;

public class QuestionnaireMultyS {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client...");
		
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            
            System.exit(-1); 
        }

        while (listening)
	    new QuestionnaireThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}

