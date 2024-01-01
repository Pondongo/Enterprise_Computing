import java.io.*; 
import java.net.*;

public class TCPConcurrentServer { 
   public static void main(String argv[])  { 
      ServerSocket welcomeSocket = null;

      try {
         welcomeSocket = new ServerSocket(1667); 
      } // done
      catch (IOException e) {
         System.out.println("Cannot create a welcome socket");
         System.exit(1);
      }
      while(true) {
         try {	 
            System.out.println("Waiting for client connection at port number 1667");
			   Socket connectionSocket = welcomeSocket.accept(); 
            
            System.out.println("Client connected");
			   EchoThread echoThread = new EchoThread(connectionSocket);
            echoThread.start();
         }
         catch (IOException e) {
            System.out.println("Cannot create this connection");
         }
      }
   } 
} 