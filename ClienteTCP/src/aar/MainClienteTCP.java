package aar;

public class MainClienteTCP {

	public static void main(String[] args) {
        ClienteTCP objetoCliente= new ClienteTCP("127.0.0.1",4444);
        objetoCliente.run();
	}

}
