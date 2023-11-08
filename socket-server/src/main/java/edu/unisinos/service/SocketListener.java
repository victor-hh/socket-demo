package edu.unisinos.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Date;

public class SocketListener {

//    public void basicTcpServer() {
//        try {
//            // Instancia o ServerSocket ouvindo a porta 12345
//            ServerSocket servidor = new ServerSocket(12345);
//            System.out.println("Servidor ouvindo a porta 12345");
//            while (true) {
//                Socket cliente = servidor.accept();
//
////                ServerSocket servidor2 = new ServerSocket(12346);
//                Socket socket = new Socket("localhost", 12346);
//
//
//                cliente.bind(socket.getLocalSocketAddress());
//
//
//
////                FileService = new FileService();
//                // quando aceita uma nova conexão, inicia nova thread para aceitar novas conexões enquanto processa a request atual.
////                new Thread(this::basicTcpServer);
//
//                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
//                InputStreamReader input = new InputStreamReader(cliente.getInputStream());
//
//                StringBuilder textBuilder = new StringBuilder();
//                try (Reader reader = new BufferedReader(input)) {
//                    int c = 0;
//                    while ((c = reader.read()) != -1) {
//                        textBuilder.append((char) c);
//                    }
//                }
//                System.out.println(textBuilder);
//
//
//                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
//                saida.flush();
//                saida.writeObject(new Date());
//                saida.close();
//                cliente.close();
//            }
//        } catch (Exception e) {
//            System.out.println("Erro: " + e.getMessage());
//        }
//    }

    public void basicTcpServer() {
        int portaInicial = 12345;
        int portaSecundaria = 54321;

        try {
            ServerSocket servidorSocket = new ServerSocket(portaInicial);
            System.out.println("Servidor esperando por conexões na porta " + portaInicial);

            while (true) {

                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Conexão recebida de " + clienteSocket.getInetAddress());

                Thread thread = new Thread(new ConexaoHandler(clienteSocket, portaSecundaria));

                thread.start();
//                while(!servidorSocket.isClosed()) {
//
//                }

                servidorSocket = new ServerSocket(portaInicial);

                System.out.println("Servidor esperando por novas conexões na porta " + portaInicial);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
