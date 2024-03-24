/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.la_chat;

/**
 *
 * @author raino
 */
//package la_chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ChatServer extends JFrame {
    public ChatServer() {
        super("Server di Chat");
        this.setSize(new Dimension(500, 300)); // imposto le dimensioni della finestra
        this.setLocationRelativeTo(null); // la posiziono al centro dello schermo
        this.setEnabled(true); // imposto la proprietà abilitata
        this.setBackground(Color.blue); // imposto il colore di sfondo
        // creo il pannello per l'inserimento e la visualizzazione dei messaggi
        PannelloChatServer pan = new PannelloChatServer();
        this.getContentPane().add(pan);
        this.setVisible(true);
    }
}

    public PannelloChatServer() {
        super();
        this.setBackground(new Color(50, 100, 255));
        // pannello superiore: lista messaggi
        JPanel panLista = new JPanel(new BorderLayout(20, 5));
        panLista.setBackground(new Color(50, 100, 255));
        lista = new List();
        lista.setBackground(Color.lightGray);
        lista.setSize(100, 50);
        lista.setVisible(true);
        // etichette laterali
        JLabel chat1 = new JLabel(" Chat ", JLabel.CENTER);
        chat1.setForeground(new Color(200, 100, 100));
        JLabel chat2 = new JLabel(" Chat ", JLabel.CENTER);
        chat2.setForeground(new Color(200, 100, 100));
        // aggiungiamo gli oggetti sul pannello
        panLista.add(chat1, BorderLayout.WEST);
        panLista.add(lista, BorderLayout.CENTER);
        panLista.add(chat2, BorderLayout.EAST);
        // pannello inserimento nuovo messaggio
        JPanel nuovoMex = new JPanel(new BorderLayout(20, 5));
        nuovoMex.setBackground(new Color(50, 100, 255));

        JLabel labNuovo = new JLabel("Nuovo Messaggio -> ", JLabel.CENTER);
        labNuovo.setForeground(new Color(255, 255, 0));

        textNuovo = new JTextField("");

        JButton buttonInvia = new JButton("Invia");
        buttonInvia.addActionListener(this);
        // aggiungiamo gli oggetti sul pannello
        nuovoMex.add(labNuovo, BorderLayout.WEST);
        nuovoMex.add(textNuovo, BorderLayout.CENTER);
        nuovoMex.add(buttonInvia, BorderLayout.EAST);

        this.setLayout(new BorderLayout(0,5));
        add(panLista, BorderLayout.CENTER);
        add(nuovoMex, BorderLayout.SOUTH);

        connetti();
    } // fine costruttore classe PannelloChat

    public void connetti() {
        // instanzio il Thread per le connessioni: numero massimo giocatori = 10
        gestioneServizio = new ThreadGestioneServizioChat(10, lista);
    }

    public void actionPerformed(ActionEvent e) {
        String bottone = e.getActionCommand();
        if (bottone.equals("Invia")) {
            gestioneServizio.spedisciMessaggio(textNuovo.getText());
            textNuovo.setText("");
        }
    }

