package aar;

public class MainClienteUDP {
    public static void main(String[] args) {
        ClienteUDP objetoCliente= new ClienteUDP("127.0.0.1",4444);
        objetoCliente.run();
    }
}

