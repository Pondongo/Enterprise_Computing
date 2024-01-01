import java.io.*; 
import java.net.*;
import java.util.*; 
class UDPClient { 
   public static void main(String args[]) throws Exception { 
      DatagramSocket clientSocket = new DatagramSocket(); 
      InetAddress IPAddress = InetAddress.getByName("localhost"); 
      byte[] sendData = new byte[1024]; 
      byte[] receiveData = new byte[1024]; 

      String msg = "MESSAGE FROM CLIENT";
      sendData = msg.getBytes();  
		DatagramPacket sendPacket = 
         new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
      clientSocket.send(sendPacket); 

      DatagramPacket receivePacket = 
         new DatagramPacket(receiveData, receiveData.length); 
      clientSocket.receive(receivePacket); 
      String DateNTime = new String(receivePacket.getData()); 
      System.out.println("FROM SERVER:" + DateNTime.trim()); 
	   clientSocket.close(); 
   } 
} 
