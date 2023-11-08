package edu.unisinos;

import edu.unisinos.service.SocketListener;

public class Main {
    public static void main(String[] args) {

        SocketListener socketListener = new SocketListener();
        while(true) {
            socketListener.basicTcpServer();
        }

    }

}
