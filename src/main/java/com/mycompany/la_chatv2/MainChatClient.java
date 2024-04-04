package com.mycompany.la_chatv2;

import java.util.Scanner;


public class MainChatClient {
   public static void main(String args[]) {
       
       Scanner scanner = new Scanner(System.in);  // Create a Scanner object
       System.out.println("Enter username");
        
       String nome_utente = scanner.nextLine();  // Read user input
       
       ChatClient chat = new ChatClient(nome_utente);
   }  
}
