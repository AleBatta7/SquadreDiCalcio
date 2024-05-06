/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.squadredicalcio;

import eccezioni.NumeroMagliaNonValido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class CalciatoreTest {
    
    @Test
    public void testCostruttoreAndGetters() {
        // Creazione di un calciatore
        LocalDate dataNascita = LocalDate.of(1990, 5, 15);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", dataNascita, 10, "Juve");

        // Verifica dei valori restituiti dai getters
        assertEquals("Mario", calciatore.getNome());
        assertEquals("Rossi", calciatore.getCognome());
        assertEquals(dataNascita, calciatore.getDataNascita());
        assertEquals(10, calciatore.getNumeroMaglia());
        assertEquals("Juve", calciatore.getSquadra());
    }

    @Test
    public void testSetters() throws NumeroMagliaNonValido {
        // Creazione di un calciatore
        LocalDate dataNascita = LocalDate.of(1990, 5, 15);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", dataNascita, 10, "Juve");

        // Impostazione di nuovi valori utilizzando i setters
        calciatore.setNome("Luigi");
        calciatore.setCognome("Verdi");
        calciatore.setDataNascita(LocalDate.of(1995, 8, 25));
        calciatore.setNumeroMaglia(7);
        calciatore.setSquadra("Inter");

        // Verifica dei nuovi valori impostati
        assertEquals("Luigi", calciatore.getNome());
        assertEquals("Verdi", calciatore.getCognome());
        assertEquals(LocalDate.of(1995, 8, 25), calciatore.getDataNascita());
        assertEquals(7, calciatore.getNumeroMaglia());
        assertEquals("Inter", calciatore.getSquadra());
    }

    @Test
    public void testToString() {
        // Creazione di un calciatore
        LocalDate dataNascita = LocalDate.of(1990, 5, 15);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", dataNascita, 10, "Juve");

        // Verifica della rappresentazione in stringa
        String expectedString = "Calciatore{nome='Mario', cognome='Rossi', dataNascita=1990-05-15, numeroMaglia=10, squadra='Juve'}";
        assertEquals(expectedString, calciatore.toString());
    }
}
