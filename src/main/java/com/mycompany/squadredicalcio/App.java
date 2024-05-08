/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.squadredicalcio;


import Utilita.ConsoleInput;
import Utilita.Menu;
import Utilita.TextFile;
import eccezioni.FileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) throws FileException {
        
        ConsoleInput tastiera = new ConsoleInput();
        String nome, cognome, squadraDiAppartenenza;
        int numeroMaglia;
        
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        
        
        int numeroVociMenu = 7;
        String[] vociMenu = new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu = null;
        
        ArrayList<Calciatore> elencoCalciatori = squadra.visualizzaCalciatori();
        
        vociMenu[0] = "0 -->\tArrivederci";
        vociMenu[1] = "1 -->\tVisualizza i giocatori";
        vociMenu[2] = "2 -->\tAggiungi un giocatore";
        vociMenu[3] = "3 -->\tCerca giocatore per nome";
        vociMenu[4] = "4 -->\tElimina giocatore dalla squadra";
        vociMenu[5] = "5 -->\tSerializzazione";
        vociMenu[6] = "6 -->\tDeserializzazione";
        
        menu = new Menu(vociMenu);
        
        do {
            menu.visualizzaMenu();
            voceMenuScelta = menu.sceltaMenu();
            
            try {
                switch(voceMenuScelta) {
                    case 0 -> System.out.println("Arrivederci");
                    case 1 -> {
                        try {
                            System.out.println("Elenco dei giocatori:");
                            for (Calciatore giocatore : elencoCalciatori) {
                                System.out.println(giocatore);
                            }
                        } catch (Exception ex) {
                            System.out.println("Errore durante la visualizzazione dei giocatori: " + ex.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Nome --> ");
                        try {
                            nome = tastiera.readString();
                            System.out.println("Cognome --> ");
                            cognome = tastiera.readString();
                            System.out.println("Numero Maglia (1-99) -->");
                            numeroMaglia = tastiera.readInt();
                            
                        }
                        catch(IOException | NumberFormatException e){
                            
                        }
                    }
                    case 3 -> {
                        // Cerca giocatore per nome
                        System.out.println("Inserisci il nome del giocatore da cercare: ");
                        try {
                            String nomeCercato = tastiera.readString();
                            boolean trovato = false;
                            for (Calciatore calciatore : elencoCalciatori) {
                                if (calciatore.getNome().equalsIgnoreCase(nomeCercato)) {
                                    System.out.println(calciatore);
                                    trovato = true;
                                    break;
                                }
                            }
                            if (!trovato)
                                System.out.println("Giocatore non trovato.");
                        } catch (IOException ex) {
                            System.out.println("Errore di input.");
                        }
                    }
                    case 4 -> {
                        // Elimina giocatore dalla squadra
                        System.out.println("Inserisci il numero di maglia del giocatore da eliminare: ");
                        try {
                            int numeroMagliaDaEliminare = tastiera.readInt();
                            boolean eliminato = false;
                            for (Calciatore calciatore : elencoCalciatori) {
                                if (calciatore.getNumeroMaglia() == numeroMagliaDaEliminare) {
                                    elencoCalciatori.remove(calciatore);
                                    eliminato = true;
                                    break;
                                }
                            }
                            if (eliminato)
                                System.out.println("Giocatore eliminato con successo.");
                            else
                                System.out.println("Giocatore non trovato.");
                        } catch (IOException | NumberFormatException ex) {
                            System.out.println("Errore durante la lettura del numero di maglia. Assicurati di inserire un numero valido.");
                        }
                    }
                    case 5 -> {
                        // Serializzazione
                        String nomeFile = "SquadreDiCalcio.bin";
                        squadra.salvaDati(nomeFile); // Chiamata al metodo salvaDati sull'oggetto squadra
                        System.out.println("Salvataggio avvenuto correttamente");
                    }


                    case 6 -> {
                        String nomeFile = "SquadreDiCalcio.bin";
                        squadra = Squadra.caricaDati(nomeFile); // Chiamata al metodo statico caricaDati della classe Squadra
                        System.out.println("Caricamento effettuato correttamente");
                    }
                    
                    case 7 -> {
                        ArrayList<Calciatore>elencoCalciatoriOrdinato=squadra.visualizzaCalciatori();
                        squadra.ordinaCalciatoriNumero(elencoCalciatori);
                        for(Calciatore calciatore : elencoCalciatori)
                        {
                            System.out.println(calciatore);
                        }
                    }

                
                }
            } catch (NumberFormatException ex) {
                System.out.println("Errore generale: " + ex.getMessage());
            }
            
        } while (voceMenuScelta != 0);
        exportCalciatore(elencoCalciatori);
    }
    
    public static void exportCalciatore(ArrayList<Calciatore> elencoCalciatori) throws FileException{
        String nomeFileCalciatori = "calciatori.csv";
        try{
            TextFile fileCalciatori = new TextFile(nomeFileCalciatori, 'W');
            String datiCalciatore;
            for(Calciatore calciatore : elencoCalciatori){
                datiCalciatore = calciatore.getNome() + ";" + calciatore.getCognome() + ";" + calciatore.getSquadra() + ";" + calciatore.getNumeroMaglia() + ";";
                fileCalciatori.toFile(datiCalciatore);
            }
            fileCalciatori.closeFile();
            System.out.println("Esportazione avvenuta correttamente.");
        }
        catch(IOException e){
            System.out.println("ERROR IOException::Impossibile accedere al file");
        }
        catch(FileException e){
            System.out.println("ERROR FileException::Impossibile accedere al file");
        }
    }
    public static void importaCalciatoriDaCSV(String nomeFile, ArrayList<Calciatore> elencoCalciatori) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String nome = data[0];
                String cognome = data[1];
                LocalDate dataNascita = LocalDate.parse(data[2]); // Assicurati che il formato della data nel file CSV sia corretto
                int numeroMaglia = Integer.parseInt(data[3]);
                String squadra = data[4];
                Calciatore calciatore = new Calciatore(nome, cognome, dataNascita, numeroMaglia, squadra);
                // Aggiungi il calciatore alla squadra appropriata
                
                 
            }
            System.out.println("Importazione da CSV completata.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Errore durante l'importazione da CSV: " + e.getMessage());
        }
    }
   }





    
   
    

