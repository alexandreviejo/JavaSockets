package aar;

import java.io.*;
import java.net.*;

public class ClienteUDPMulticast {
    private InetAddress groupAddress = null;
    private int groupPuerto = 0;
    
    public ClienteUDPMulticast(String IP, int puerto) {
        try {
            this.groupAddress = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.err.println("Unknown Host Exception");
            System.exit(1);
        }
        this.groupPuerto = puerto;
    }
    
    public void run() {
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket(groupPuerto);
            socket.joinGroup(groupAddress);
        } catch (IOException e) {
            System.err.println("Could not connect to the multicast group");
            System.exit(1);
        }
          
        DatagramPacket packet = null;
        
        for (int i = 0; i < 10; i++) {
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                System.err.println("Error when receiving");
                System.exit(1);
             }
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Fecha actual: " + received);
		}
        socket.close();
    } 
   
}