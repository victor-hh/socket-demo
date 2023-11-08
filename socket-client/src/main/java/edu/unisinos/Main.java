package edu.unisinos;

import edu.unisinos.dto.FileDto;
import edu.unisinos.service.SocketClient;

public class Main {
    public static void main(String[] args) {
        FileDto fileDto = new FileDto();
        fileDto.setFileName("123456");

        SocketClient socketClient = new SocketClient();
        socketClient.sendFile(fileDto);

        System.out.println("Hello world!");
    }
}