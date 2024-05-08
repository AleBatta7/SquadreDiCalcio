package com.mycompany.squadredicalcio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static Utilita.Ordinatore.scambia;
import Utilita.TextFile;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Rappresenta una squadra di calcio.
 */
public class Squadra {

    static Squadra caricaDati(String nomeFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private ArrayList<Calciatore> calciatori;
    private long codice;
    private static long nextCodice = 1;
    private String nome;
    private String citta;
    private String categoria;

    /**
     * Costruisce una nuova squadra con il nome, la città e la categoria specificati.
     * @param nome Il nome della squadra.
     * @param citta La città della squadra.
     * @param categoria La categoria della squadra.
     */
    public Squadra(String nome, String citta, String categoria) {
        this.codice = nextCodice++;
        this.calciatori = new ArrayList<>();
        this.nome = nome;
        this.citta = citta;
        this.categoria = categoria;
    }

    /**
     * Costruisce una copia della squadra specificata.
     * @param squadra La squadra da copiare.
     */
    public Squadra(Squadra squadra) {
        this.categoria = squadra.getCategoria();
        this.citta = squadra.getCitta();
        this.nome = squadra.getNome();
        this.calciatori = new ArrayList<>();
        for (Calciatore calciatore : squadra.calciatori) {
            this.calciatori.add(new Calciatore(calciatore));
        }
    }

    /**
     * Aggiunge un calciatore alla squadra.
     * @param giocatore Il calciatore da aggiungere.
     */
    public void setCalciatore(Calciatore giocatore) {
        calciatori.add(giocatore);
    }

    /**
     * Restituisce la lista dei calciatori della squadra.
     * @return La lista dei calciatori della squadra.
     */
    public ArrayList<Calciatore> visualizzaGiocatori() {
        return calciatori;
    }

    /**
     * Restituisce il nome della squadra.
     * @return Il nome della squadra.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome della squadra.
     * @param nome Il nuovo nome della squadra.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce la città della squadra.
     * @return La città della squadra.
     */
    public String getCitta() {
        return citta;
    }

    /**
     * Imposta la città della squadra.
     * @param citta La nuova città della squadra.
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }

    /**
     * Restituisce la categoria della squadra.
     * @return La categoria della squadra.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Imposta la categoria della squadra.
     * @param categoria La nuova categoria della squadra.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Restituisce il codice univoco della squadra.
     * @return Il codice univoco della squadra.
     */
    public long getCodice() {
        return codice;
    }
    
    /**
     * Restituisce una copia della lista dei calciatori della squadra.
     * @return Una copia della lista dei calciatori della squadra.
     */
    public ArrayList<Calciatore> visualizzaCalciatori() {
        return new ArrayList<>(calciatori);
    }
    
    /**
     * Ordina i calciatori della squadra per numero di maglia.
     * @return Una lista ordinata dei calciatori della squadra per numero di maglia.
     */
    public ArrayList<Calciatore> ordinaCalciatoriNumero(ArrayList<Calciatore> elencoCalciatori) {
        ArrayList<Calciatore> calciatoriOrdinati = new ArrayList<>(calciatori);

        for (int i = 0; i < calciatoriOrdinati.size() - 1; i++) {
            for (int j = 0; j < calciatoriOrdinati.size() - i - 1; j++) {
                if (calciatoriOrdinati.get(j).getNumeroMaglia() > calciatoriOrdinati.get(j + 1).getNumeroMaglia()) {
                    // Scambia i calciatori
                    Calciatore temp = calciatoriOrdinati.get(j);
                    calciatoriOrdinati.set(j, calciatoriOrdinati.get(j + 1));
                    calciatoriOrdinati.set(j + 1, temp);
                }
            }
        }

        return calciatoriOrdinati;
    }
    
    

    /**
     * Restituisce una rappresentazione in stringa della squadra.
     * @return Una stringa che rappresenta la squadra.
     */
    @Override
    public String toString() {
        return "Squadra{" +
                "giocatori=" + calciatori +
                ", codice=" + codice +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
    
    

public static void EsportaCalciatori(ArrayList<Squadra> elencoSquadre) {
    String nomeFileCalciatori = "calciatori.csv";
    try {
        TextFile fileDesignatori = new TextFile(nomeFileCalciatori, 'W');
        String datiCalciatore;
        for (Squadra squadra : elencoSquadre) {
            for (Calciatore calciatore : squadra.visualizzaGiocatori()) {
                datiCalciatore = calciatore.getNome() + ";" + calciatore.getCognome() + ";";
                fileDesignatori.toFile(datiCalciatore);
            }
        }
        fileDesignatori.closeFile();
        System.out.println("Esportazione avvenuta correttamente.");
    } catch (IOException e) {
        System.out.println("ERROR IOException: Impossibile accedere al file");
    } catch (FileException e) {
        System.out.println("ERROR FileException: Impossibile accedere al file");
    }
    
}

    void salvaDati(String nomeFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    ArrayList<Calciatore> ordinaCalciatoriNumero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



public class GestoreFile {

    public void salvaDati(Squadra squadra, String nomeFile) throws FileNotFoundException, IOException {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(nomeFile));
        writer.writeObject(squadra);
        writer.flush();
        writer.close();
    }

    public Squadra caricaDati(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        Squadra squadra;
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(nomeFile));
        squadra = (Squadra) reader.readObject();
        reader.close();
        return squadra;
    }
    
   

}

}
