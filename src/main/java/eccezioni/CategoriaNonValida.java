/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eccezioni;

/**
 *
 * @author Studente
 */
public class CategoriaNonValida extends Exception 
{
    public CategoriaNonValida(){
        System.out.println("La categoria inserita non è valida!!!");
    }
}
