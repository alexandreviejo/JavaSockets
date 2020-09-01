package aar;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerUDPMulticast {
    private InetAddress groupAddress = null;
    private int groupPuerto = 0;
    private long FIVE_SECONDS = 5000;
    
    public ServerUDPMulticast(String IP, int puerto) {
        try {
            this.groupAddress = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.err.println("Unknown Host Exception");
            System.exit(1);
        }
        this.groupPuerto = puerto;
    }
    
    public void run() {       
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (IOException e) {
            System.err.println("Could not open socket");
            System.exit(1);
        }
               
        for (int i = 0; i < 30; i++) {    
            byte[] buf = new byte[256];
            String sdate = new Date().toString();
            buf = sdate.getBytes();

            DatagramPacket packet = new DatagramPacket(buf, buf.length, 
                    groupAddress, groupPuerto);
            try {
                socket.send(packet);
            } catch (IOException e) {
                System.err.println("Error when sending");
                System.exit(1);
            }
           
            System.out.println("Multicast numero: " + i);
            
            try {
                Thread.sleep(FIVE_SECONDS);
            } catch (InterruptedException ex) {
                System.err.println("Error when pausing thread");
                System.exit(1);
            }
        }   
    }
    
}
