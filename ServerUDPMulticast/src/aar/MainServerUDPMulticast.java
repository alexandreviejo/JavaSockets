package aar;

public class MainServerUDPMulticast {
    public static void main(String[] args) {
        ServerUDPMulticast objetoServer = 
                new ServerUDPMulticast("230.0.0.1", 4444);
        objetoServer.run();
    }
    
}
