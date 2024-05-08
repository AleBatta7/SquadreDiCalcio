package com.mycompany.squadredicalcio;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SquadraTest {

    @Test
    public void testCostruttoreEGetters() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        assertEquals("Juve", squadra.getNome());
        assertEquals("Torino", squadra.getCitta());
        assertEquals("Serie A", squadra.getCategoria());
    }

    @Test
    public void testSetNome() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        squadra.setNome("Inter");
        assertEquals("Inter", squadra.getNome());
    }

    @Test
    public void testSetCitta() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        squadra.setCitta("Milano");
        assertEquals("Milano", squadra.getCitta());
    }

    @Test
    public void testSetCategoria() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        squadra.setCategoria("Serie B");
        assertEquals("Serie B", squadra.getCategoria());
    }

    @Test
    public void testSetCalciatore() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        squadra.setCalciatore(calciatore);
        assertEquals(1, squadra.visualizzaGiocatori().size());
        assertTrue(squadra.visualizzaGiocatori().contains(calciatore));
    }

    @Test
    public void testVisualizzaCalciatori() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        Calciatore calciatore1 = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        Calciatore calciatore2 = new Calciatore("Luigi", "Bianchi", LocalDate.of(1995, 8, 25), 7, "Inter");
        squadra.setCalciatore(calciatore1);
        squadra.setCalciatore(calciatore2);
        assertEquals(2, squadra.visualizzaGiocatori().size());
    }

    @Test
    public void testOrdinaCalciatoriNumero() {
        Squadra squadra = new Squadra("Juve", "Torino", "Serie A");
        Calciatore calciatore1 = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        Calciatore calciatore2 = new Calciatore("Luigi", "Bianchi", LocalDate.of(1995, 8, 25), 7, "Inter");
        squadra.setCalciatore(calciatore2);
        squadra.setCalciatore(calciatore1);
        ArrayList<Calciatore> eleCalciatori=squadra.visualizzaCalciatori();
        ArrayList<Calciatore> calciatoriOrdinati = squadra.ordinaCalciatoriNumero(eleCalciatori);
        assertEquals(2, calciatoriOrdinati.size());
        assertEquals(7, calciatoriOrdinati.get(0).getNumeroMaglia());
        assertEquals(10, calciatoriOrdinati.get(1).getNumeroMaglia());
    }
}

