package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);

        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("Connesso");

        do {
            String n1String = in.readLine();
            if (n1String.equals("!")) {
                s.close();
                break; 
            }
            String operatore = in.readLine();
            String n2String = in.readLine();
            
            Double n1 = Double.parseDouble(n1String);
            Double n2 = Double.parseDouble(n2String);
            
            if(operatore.equals("+")) {
                out.println(n1 + n2);
            }

            if(operatore.equals("-")) {
                out.println(n1 - n2);
            }

            if(operatore.equals("*")) {
                out.println(n1 * n2);
            }

            if(operatore.equals("/")) {
                out.println(n1 / n2);
            }
            
        } while (true);
    }
}
