import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class QuestionClient extends JFrame {
	
	public static void main(String[] args) throws IOException {

		Socket kkSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		//GUI
		/*JFrame f1 = new JFrame();
		JPanel topPanel = new JPanel();
		Font font1 = new Font("Serif", Font.BOLD,13);

		JTextArea ta1;// = new JTextArea(fromServer,5,30);
		ta1 = new JTextArea("not Working",10,20);
		f1.setLayout(new FlowLayout());
		JScrollPane ssPane = new JScrollPane(ta1);
		topPanel.add(ssPane,BorderLayout.CENTER);
		//ta1.setFont(font1);	
		topPanel.add(ta1);
		f1.add(topPanel);
		f1.setVisible(true);
		f1.setSize(600,300);
		f1.setTitle("Questionnaire Client");
		f1.setLocation(250,250);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		//GUI END
		
		try {
			    kkSocket = new Socket("localhost", 4444);
			    out = new PrintWriter(kkSocket.getOutputStream(), true);
			    in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		} catch (UnknownHostException e) {
		    System.err.println("Don't know about host: localhost.");
		    System.exit(1);
		} catch (IOException e) {
		    System.err.println("Couldn't get I/O for the connection to: localhost.");
		    System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser;
		fromUser = null;
		out.println(fromUser);
		int lool = 0;
			
	while (lool <=23){
		fromServer = in.readLine();
            	System.out.println("Server: " + fromServer);
		if (fromServer.equals("Bye"))
		     	break;
			lool++;	

		if (lool == 5) {
			fromUser = stdIn.readLine();
	      		System.out.println("\n");
		        out.println(fromUser);
			lool = 6;
		}
		if (lool ==10) {
			fromUser = stdIn.readLine();
	      		System.out.println("\n");
		        out.println(fromUser);
			lool = 11;
		}
		if (lool ==15) {
			fromUser = stdIn.readLine();
	      		System.out.println("\n");
		        out.println(fromUser);
			lool = 16;
		}
		if (lool ==23){ 
			System.out.println("Bye!");	
				break;
		}
		
	}	
			
        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }
}

