package aar;

public class MainServerUDPInteractivo {
    public static void main(String[] args) {
        ServerUDPInteractivo objetoServer= new ServerUDPInteractivo(4444);
        objetoServer.run();
    }
}
