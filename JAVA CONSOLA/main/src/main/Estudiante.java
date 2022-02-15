/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author cindybohorquezsantana
 */
public class Estudiante {

    ArrayList<Libro> librosprestados = new ArrayList<Libro>();
    Administrador admin = new Administrador();

    public void verLibrosDisponibles(ArrayList<Libro> biblioteca) {
        for (int i = 0; i < biblioteca.size(); i++) {
            System.out.println("Item  :   " + i + "\n"
                    + "Codigo:   " + biblioteca.get(i).getCodigo() + "\n"
                    + "Titulo:   " + biblioteca.get(i).getTitulo() + "\n"
                    + "Autor :   " + biblioteca.get(i).getAutor() + "\n"
                    + "Cantidad: " + biblioteca.get(i).getCant_disp() + "\n");
        }
        prestarLibro(biblioteca);
    }

    public void prestarLibro(ArrayList<Libro> biblioteca) {
        this.librosprestados = librosprestados;
        int item;
        System.out.println("Ingrese el item del libro a prestar");
        Scanner input_item = new Scanner(System.in);
        item = input_item.nextInt();

        System.out.println("Desea confirmar el préstamo? (y/n)");
        Scanner input_resp = new Scanner(System.in);
        String respi = input_resp.nextLine();
        char resp = respi.charAt(0);
        int b = 0;
        if (resp == 'y') {
            //librosprestados.add(biblioteca.get(item));

            if (biblioteca.get(item).getCant_disp() > 1) {

                if (librosprestados.size() > 0) {
                    System.out.println("entro 48");
                    if (estaprestado(biblioteca, librosprestados, item) == true) {
                        System.out.println("Ya no puede prestar mas libros con el mismo codigo");
                    } else {
                        biblioteca.get(item).setCant_disp((biblioteca.get(item).getCant_disp()) - 1);
                        librosprestados.add(biblioteca.get(item));
                    }
                } else {
                    //biblioteca.get(item).setCant_disp((biblioteca.get(item).getCant_disp()) - 1);
                    librosprestados.add(biblioteca.get(item));
                    biblioteca.get(item).setCant_disp((biblioteca.get(item).getCant_disp()) - 1);
                    System.out.println("entro 58");
                }
            } else {
                
                
                if(biblioteca.get(item).getCant_disp()==1){
                 biblioteca.get(item).setCant_disp(0);
                librosprestados.add(biblioteca.get(item));
                }
                else{
                    System.out.println("No hay libros disponibles");
                }
            }
        } else {
            System.out.println("No se confirmó el préstamo");

        }

    }

    public void verLibrosPrestados(ArrayList<Libro> librosprestados) {
        for (int i = 0; i < librosprestados.size(); i++) {
            System.out.println("Item: "+i+"\n"+
                               "Codigo: "+librosprestados.get(i).getCodigo()+"\n"+
                               "Titulo: "+librosprestados.get(i).getTitulo()+"\n"+
                               "Autor: "+librosprestados.get(i).getAutor()+"\n"+
                               "Cantidad: "+librosprestados.get(i).getCant_disp()+"\n");
            
        }
    }

    public boolean estaprestado(ArrayList<Libro> biblioteca, ArrayList<Libro> librosprestados, int item) {
        for (int i = 0; i < librosprestados.size(); i++) {
            if (librosprestados.get(i).getCodigo() == biblioteca.get(item).getCodigo()) {
                System.out.println("Si coinciden");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Libro> getLibrosprestados() {
        return librosprestados;
    }
    
}
