package com.mycompany.squadredicalcio;

import eccezioni.NumeroMagliaNonValido;
import java.time.LocalDate;

/**
 * Questa classe rappresenta un calciatore.
 */
public class Calciatore {
    private long codice;
    private static long nextCodice = 1;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private int numeroMaglia;
    private String squadra;

    /**
     * Costruttore della classe Calciatore.
     * @param nome Il nome del calciatore.
     * @param cognome Il cognome del calciatore.
     * @param dataNascita La data di nascita del calciatore.
     * @param numeroMaglia Il numero di maglia del calciatore.
     * @param squadra La squadra di appartenenza del calciatore.
     */
    public Calciatore(String nome, String cognome, LocalDate dataNascita, int numeroMaglia, String squadra) {
        codice = nextCodice;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroMaglia = numeroMaglia;
        this.squadra = squadra;
        nextCodice++;
    }

    /**
     * Costruttore di copia della classe Calciatore.
     * @param calciatore Il calciatore da copiare.
     */
    public Calciatore(Calciatore calciatore) {
        this.nome = calciatore.getNome();
        this.cognome = calciatore.getCognome();
        this.dataNascita = calciatore.getDataNascita();
        this.numeroMaglia = calciatore.getNumeroMaglia();
        this.squadra = calciatore.getSquadra();
    }

    /**
     * Restituisce il codice del calciatore.
     * @return Il codice del calciatore.
     */
    public long getCodice() {
        return codice;
    }

    /**
     * Restituisce il nome del calciatore.
     * @return Il nome del calciatore.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del calciatore.
     * @param nome Il nuovo nome del calciatore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome del calciatore.
     * @return Il cognome del calciatore.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del calciatore.
     * @param cognome Il nuovo cognome del calciatore.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce la data di nascita del calciatore.
     * @return La data di nascita del calciatore.
     */
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta la data di nascita del calciatore.
     * @param dataNascita La nuova data di nascita del calciatore.
     */
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }/*
    
    /**
    * Restituisce il numero di maglia del calciatore.
    * @return Il numero di maglia del calciatore.
    */
    public int getNumeroMaglia() {
        return numeroMaglia;
    }
    
    /**
     * Imposta il numero di maglia del calciatore.
     * @param numeroMaglia Il nuovo numero di maglia del calciatore.
     * @throws eccezioni.NumeroMagliaNonValido
     */
    public void setNumeroMaglia(int numeroMaglia) throws NumeroMagliaNonValido {
        if (numeroMaglia < 0 || numeroMaglia > 99) {
            throw new NumeroMagliaNonValido();
        }
        this.numeroMaglia = numeroMaglia;
    }

    /**
     * Restituisce la squadra di appartenenza del calciatore.
     * @return La squadra di appartenenza del calciatore.
     */
    public String getSquadra() {
        return squadra;
    }

    /**
     * Imposta la squadra di appartenenza del calciatore.
     * @param squadra La nuova squadra di appartenenza del calciatore.
     */
    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }
    
    /**
     * Restituisce una rappresentazione in stringa del calciatore.
     * @return Una stringa che rappresenta il calciatore.
     */
    @Override
    public String toString() {
        return "Calciatore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroMaglia=" + numeroMaglia +
                ", squadra='" + squadra + '\'' +
                '}';
    }
}
