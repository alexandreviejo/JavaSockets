package aar;

public class MainServerTCPInteractivo {
    public static void main(String[] args) {
        ServerTCPInteractivo objetoServer= new ServerTCPInteractivo(4444);
        objetoServer.run();
    }   
}
