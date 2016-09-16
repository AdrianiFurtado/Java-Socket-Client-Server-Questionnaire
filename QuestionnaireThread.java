import java.net.*;
import java.io.*;

public class QuestionnaireThread extends Thread {
    private Socket socket = null;

    public QuestionnaireThread(Socket socket) {
	super("QuestionnaireThread");
	this.socket = socket;
    }

    public void run() {

	try {
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));

	    String inputLine, outputLine;
	    QuestionnaireProtocol qp = new QuestionnaireProtocol();
	    outputLine = qp.processInput(null);
	    out.println(outputLine);
	    inputLine = in.readLine();
		int count = 0;

	    while (true){
		outputLine = qp.processInput(inputLine);
		if(outputLine != ""){
			out.println(outputLine);
			inputLine = in.readLine();
		}
		if (outputLine.equals("BYE"))
		    break;
	    }
	    out.close();
	    in.close();
	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}

