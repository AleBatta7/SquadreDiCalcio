package com.mycompany.squadredicalcio;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;

public class SquadraTest {
    
    @Test
    public void testCostruttoreAndGetters() {
        // Creazione di una squadra
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");

        // Verifica dei valori restituiti dai getters
        assertEquals("Juve", squadra.getNome());
        assertEquals("Torino", squadra.getCitta());
        assertEquals("Serie A", squadra.getCategoria());
    }

    @Test
    public void testAggiungiCalciatore() {
        // Creazione di una squadra
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");

        // Creazione di un calciatore
        LocalDate dataNascita = LocalDate.of(1990, 5, 15);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", dataNascita, 10, "Juve");

        // Aggiunta del calciatore alla squadra
        squadra.setCalciatore(calciatore);

        // Verifica che il calciatore sia stato aggiunto correttamente
        ArrayList<Calciatore> calciatori = squadra.visualizzaGiocatori();
        assertEquals(1, calciatori.size());
        assertEquals(calciatore, calciatori.get(0));
    }

    @Test
    public void testEsportaCalciatori() {
        // Creazione di due squadre
        Squadra juve = new Squadra("Juve", "Torino", "Serie A");
        Squadra inter = new Squadra("Inter", "Milano", "Serie A");

        // Creazione di calciatori
        LocalDate dataNascitaMario = LocalDate.of(1990, 5, 15);
        Calciatore mario = new Calciatore("Mario", "Rossi", dataNascitaMario, 10, "Juve");
        LocalDate dataNascitaLuigi = LocalDate.of(1995, 8, 25);
        Calciatore luigi = new Calciatore("Luigi", "Verdi", dataNascitaLuigi, 7, "Inter");

        // Aggiunta dei calciatori alle squadre
        juve.setCalciatore(mario);
        inter.setCalciatore(luigi);

        // Creazione dell'elenco delle squadre
        ArrayList<Squadra> elencoSquadre = new ArrayList<>(Arrays.asList(juve, inter));

        // Esportazione dei calciatori
        Squadra.EsportaCalciatori(elencoSquadre);

        // TODO: Verifica che l'esportazione sia avvenuta correttamente
        // Non è possibile testare l'output su file in un ambiente di test, quindi si dovrebbe verificare manualmente
    }
}
