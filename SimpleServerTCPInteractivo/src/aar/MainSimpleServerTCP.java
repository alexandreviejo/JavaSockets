package aar;

public class MainSimpleServerTCP {
    public static void main(String[] args) {
        SimpleServerTCPInteractivo objetoServer= new SimpleServerTCPInteractivo(4444);
        objetoServer.run();
    }   
}
