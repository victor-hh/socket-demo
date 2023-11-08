package edu.unisinos.service;

import edu.unisinos.dto.FileDto;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class SocketClient {

    public void execute() {
        try {
            Socket cliente = new Socket("localhost", 12345);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date data_atual = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Data recebida do servidor:" + data_atual.toString());
            entrada.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendFile(FileDto data) {
        try {
            Socket client = new Socket("localhost", 12345);
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeBytes(data.toString() + "\n");

//            ObjectInputStream input = new ObjectInputStream(client.getInputStream());

//            InputStreamReader input = new InputStreamReader(client.getInputStream());
//            StringBuilder textBuilder = new StringBuilder();
//            Reader reader = new BufferedReader(input);
//
//            int c = 0;
//
//            while ((c = reader.read()) != -1) {
//                textBuilder.append((char) c);
//            }

//            System.out.println(textBuilder);
            client.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
