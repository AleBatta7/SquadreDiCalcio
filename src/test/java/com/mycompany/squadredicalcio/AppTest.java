/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.squadredicalcio;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testVisualizzaGiocatori() {
        // Setup
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        ArrayList<Calciatore> elencoCalciatori = new ArrayList<>();
        Calciatore calciatore1 = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        Calciatore calciatore2 = new Calciatore("Luigi", "Verdi", LocalDate.of(1995, 8, 25), 7, "Inter");
        elencoCalciatori.add(calciatore1);
        elencoCalciatori.add(calciatore2);
        squadra.setCalciatore(calciatore1);
        squadra.setCalciatore(calciatore2);

        // Esecuzione
        ArrayList<Calciatore> risultato = squadra.visualizzaCalciatori();

        // Verifica
        assertEquals(2, risultato.size());
        assertEquals(calciatore1, risultato.get(0));
        assertEquals(calciatore2, risultato.get(1));
    }

    @Test
    public void testAggiungiGiocatore() {
        // Setup
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        Calciatore nuovoCalciatore = new Calciatore("Giovanni", "Bianchi", LocalDate.of(1998, 3, 10), 9, "Juve");

        // Esecuzione
        squadra.setCalciatore(nuovoCalciatore);
        ArrayList<Calciatore> elencoCalciatori = squadra.visualizzaCalciatori();

        // Verifica
        assertEquals(1, elencoCalciatori.size());
        assertEquals(nuovoCalciatore, elencoCalciatori.get(0));
    }

    // Altri test possono essere aggiunti per coprire ulteriori funzionalità dell'applicazione
}
