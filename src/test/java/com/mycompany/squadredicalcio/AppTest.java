/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.squadredicalcio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AppTest {

    @Test
    public void testImportaCalciatoriDaCSV() {
        ArrayList<Calciatore> elencoCalciatori = new ArrayList<>();
        App.importaCalciatoriDaCSV("test.csv", elencoCalciatori);

        // Assicurati di verificare che l'elencoCalciatori sia stato popolato correttamente
        assertEquals(3, elencoCalciatori.size());

        // Verifica il contenuto di un calciatore
        Calciatore calciatore = elencoCalciatori.get(0);
        assertEquals("Mario", calciatore.getNome());
        assertEquals("Rossi", calciatore.getCognome());
        assertEquals(LocalDate.of(1990, 5, 15), calciatore.getDataNascita());
        assertEquals(10, calciatore.getNumeroMaglia());
        assertEquals("Juve", calciatore.getSquadra());

        // Verifica il contenuto di un altro calciatore
        calciatore = elencoCalciatori.get(1);
        assertEquals("Luigi", calciatore.getNome());
        assertEquals("Verdi", calciatore.getCognome());
        assertEquals(LocalDate.of(1992, 8, 25), calciatore.getDataNascita());
        assertEquals(7, calciatore.getNumeroMaglia());
        assertEquals("Inter", calciatore.getSquadra());

        // Aggiungi ulteriori verifiche per gli altri calciatori se necessario
    }
}
