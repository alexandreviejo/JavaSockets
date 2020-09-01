package aar;

public class MainClienteUDPMulticast {
    public static void main(String[] args) {
        ClienteUDPMulticast objetoCliente = 
                new ClienteUDPMulticast("230.0.0.1",4444);
        objetoCliente.run();
    }
    
}
