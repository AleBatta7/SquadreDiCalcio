/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.squadredicalcio;
import eccezioni.NumeroMagliaNonValido;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CalciatoreTest {

    @Test
    public void testCostruttoreEGetters() {
        LocalDate dataNascita = LocalDate.of(1990, 5, 15);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", dataNascita, 10, "Juve");

        assertEquals("Mario", calciatore.getNome());
        assertEquals("Rossi", calciatore.getCognome());
        assertEquals(dataNascita, calciatore.getDataNascita());
        assertEquals(10, calciatore.getNumeroMaglia());
        assertEquals("Juve", calciatore.getSquadra());
    }

    @Test
    public void testSetNome() {
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        calciatore.setNome("Luigi");
        assertEquals("Luigi", calciatore.getNome());
    }

    @Test
    public void testSetCognome() {
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        calciatore.setCognome("Bianchi");
        assertEquals("Bianchi", calciatore.getCognome());
    }

    @Test
    public void testSetDataNascita() {
        LocalDate newDataNascita = LocalDate.of(1995, 8, 25);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        calciatore.setDataNascita(newDataNascita);
        assertEquals(newDataNascita, calciatore.getDataNascita());
    }

    @Test
    public void testSetNumeroMagliaValido() {
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        try {
            calciatore.setNumeroMaglia(7);
            assertEquals(7, calciatore.getNumeroMaglia());
        } catch (NumeroMagliaNonValido e) {
            fail("Eccezione inaspettata durante il test.");
        }
    }

    @Test
    public void testSetNumeroMagliaNonValido() {
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        assertThrows(NumeroMagliaNonValido.class, () -> calciatore.setNumeroMaglia(150));
    }

    @Test
    public void testSetSquadra() {
        Calciatore calciatore = new Calciatore("Mario", "Rossi", LocalDate.of(1990, 5, 15), 10, "Juve");
        calciatore.setSquadra("Inter");
        assertEquals("Inter", calciatore.getSquadra());
    }

    @Test
    public void testToString() {
        LocalDate dataNascita = LocalDate.of(1990, 5, 15);
        Calciatore calciatore = new Calciatore("Mario", "Rossi", dataNascita, 10, "Juve");
        String expectedString = "Calciatore{nome='Mario', cognome='Rossi', dataNascita=1990-05-15, numeroMaglia=10, squadra='Juve'}";
        assertEquals(expectedString, calciatore.toString());
    }
}
