package edu.unisinos.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConexaoHandler implements Runnable {
    private Socket clienteSocket;
    private int portaSecundaria;

    public ConexaoHandler(Socket clienteSocket, int portaSecundaria) {
        this.clienteSocket = clienteSocket;
        this.portaSecundaria = portaSecundaria;
    }

    @Override
    public void run() {
        try {
            clienteSocket.close();


            ServerSocket novoServidorSocket = new ServerSocket(portaSecundaria);
            System.out.println("Thread tratando conexão na porta " + portaSecundaria);


            novoServidorSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}