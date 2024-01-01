import java.io.*; 
import java.net.*;
import java.util.*; 
class TCPClient { 
    public static void main(String argv[]) throws Exception 
    { 
        Scanner inFromUser = null;
        Socket clientSocket = null;
        DataOutputStream outToServer = null;
        Scanner inFromServer = null;
        try {
            
		    inFromUser = new Scanner(System.in);
            clientSocket = new Socket("localhost", 1667); 
            outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
			inFromServer = new Scanner(clientSocket.getInputStream());

            System.out.println(inFromServer.nextLine());
            outToServer.writeBytes(inFromUser.nextLine() + '\n');
            //outToServer.flush(); // Flush output stream

            System.out.println(inFromServer.nextLine());
            outToServer.writeBytes(inFromUser.nextLine() + '\n');
            //outToServer.flush(); // Flush output stream

            System.out.println("The result is " + inFromServer.nextLine());
            inFromUser.close();
        }
        catch (IOException e) {
            System.out.println("Error occurred: Closing the connection");
        }
        finally {
            try {
                while (inFromServer.hasNextLine()) {
                    String message = inFromServer.nextLine();
                    System.out.println(message);
                    if (message.startsWith("Connection closed")) {
                        break;
                    }
                }
                if (inFromServer != null)
                    inFromServer.close();
                if (outToServer != null)
                    outToServer.close();
                if (clientSocket != null)
                    clientSocket.close();
            }
            catch (IOException e) {
               e.printStackTrace();
            }
        } 
    } 
} 