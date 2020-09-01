package aar;

import java.net.*;
import java.io.*;

public class SimpleServerTCPInteractivo {
    
    private int puerto = 0;
    
    public SimpleServerTCPInteractivo(int puerto) {
        this.puerto = puerto; 
    }
    
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(puerto);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+puerto);
            System.exit(1);
        }
        
        while(true) {
        	Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = null;
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
    				new InputStreamReader(
    				clientSocket.getInputStream()));
            } catch (IOException e) {
                System.err.println("Create streams failed.");
                System.exit(1);
            }
                  
            try {
            	out.println("Hello.");
            	String inputLine = in.readLine();
            	System.out.println("Recibo de cliente: "+inputLine);
                out.println("Bye.");
            } catch (IOException e) {
                System.err.println("Read failed.");
                System.exit(1);
            }
            
            try {
                out.close();
                in.close();
                clientSocket.close();  
            } catch (IOException e) {
                System.err.println("Close failed.");
                System.exit(1);
            }     
        }
        
    } 
}
