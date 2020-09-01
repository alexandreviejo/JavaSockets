package aar;

public class MainServerTCPConcurrente {
    public static void main(String[] args) {
        ServerTCPConcurrente objetoServer= new ServerTCPConcurrente(4444);
        objetoServer.run();
    }
    
}
