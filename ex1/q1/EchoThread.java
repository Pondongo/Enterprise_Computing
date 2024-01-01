import java.io.*; 
import java.net.*; 
import java.util.*;

public class EchoThread extends Thread {
    private Socket connectionSocket;

    public EchoThread(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    public void run() {
        Scanner inFromClient = null;
        DataOutputStream outToClient = null;
        try {
            inFromClient = new Scanner(connectionSocket.getInputStream());
			outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            System.out.println("wait for first input");
            outToClient.writeBytes("enter number 1 (to end just press enter): \n");
            if (inFromClient.hasNextLine()) {
                String userInput = inFromClient.nextLine().trim();

                if (userInput.isEmpty()) {
                    // User pressed Enter without entering anything, close the connection
                    outToClient.writeBytes("Connection closed.\n");
                } else {
                    try {
                        // Attempt to parse the input as an integer
                        int firstNumber = Integer.parseInt(userInput);
                        System.out.println("wait for second input");
                        outToClient.writeBytes("enter number 2 (to end just press enter): \n");

                        if (inFromClient.hasNextLine()) {
                            userInput = inFromClient.nextLine().trim();

                            try {
                                int secondNumber = Integer.parseInt(userInput);
                                int sum = firstNumber + secondNumber;
                                outToClient.writeBytes("" + sum);
                            } catch (NumberFormatException e) {
                                outToClient.writeBytes("Invalid second integer.\n");
                            }
                        } else {
                            outToClient.writeBytes("Connection closed.\n");
                        }
                    } catch (NumberFormatException e) {
                        outToClient.writeBytes("Invalid input. Please enter an integer.\n");
                    }
                }
            }
        }
        catch (IOException e) {
            System.err.println("Closing Socket connection");
        }
        finally {
            try {
            System.out.println("Client ended");
               if (inFromClient != null)
                  inFromClient.close();
               if (outToClient != null)
                  outToClient.close();
               if (connectionSocket != null)
                  connectionSocket.close();
               }
            catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
}
