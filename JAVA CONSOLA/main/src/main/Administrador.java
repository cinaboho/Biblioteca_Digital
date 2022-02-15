/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author cindybohorquezsantana
 */
public class Administrador {
ArrayList<Libro> biblioteca = new ArrayList<Libro>();
    public void agregarlibro( int codigo, String titulo, String autor, int cantidad) {
                this.biblioteca=biblioteca;
                Libro libro = new Libro();
                int cantidad_antesdeguardar = biblioteca.size();
                
                if(cantidad_antesdeguardar==0){
                libro.setCodigo(codigo);
                libro.setTitulo(titulo);
                libro.setAutor(autor);
                libro.setCant_disp(cantidad);
                biblioteca.add(libro);
//                System.out.println("El tamaño de la biblioteca 26 es: "+biblioteca.size());
                }
                else{ // si existen libros en la biblioteca
//                    System.out.println("El codigo por teclado es: "+codigo);
//                    System.out.println("El tamaño de la biblioteca 30 es: "+biblioteca.size());
                    int val= validarAdmin(biblioteca, codigo);
//                    System.out.println("Validar= "+val); // si es 0 noo hay otro librro con el mismo codigo
//                    System.out.println("entro a la 33 ");
                    
                    if(val==1){ //Si el libro esta en la biblioteca 
//                        System.out.println("Reecorreer biblio 36");
//                        for (int i = 0; i < biblioteca.size(); i++) {
//                            System.out.println("biblio "+i+":"+biblioteca.get(i).getCodigo());
//                        }
                        //System.out.println("entro a la 40 ");
                        Libro librito= encuentralibro(biblioteca, codigo); //Devueelve el libro que tieenee el codigo existente en la biblioteca
                         if( librito !=null){//setear el libro existente
                             //System.out.println("entro a la 43 ");
                             int cantna=librito.getCant_disp();
//                             int suma = cantna+cantidad;
//                             System.out.println("Suma: "+suma);
                             librito.setCant_disp(librito.getCant_disp()+cantidad);
                         }
                         else{
                             System.out.println("entro a la 50 ");
                         }
                    }
                    else{
//                        System.out.println("Reecorreer biblio 54");
//                        for (int i = 0; i < biblioteca.size(); i++) {
//                            System.out.println("biblio "+i+":"+biblioteca.get(i).getCodigo());
//                        }
//                        System.out.println("entro a la 58 ");
                    libro.setCodigo(codigo);
                    libro.setTitulo(titulo);
                    libro.setAutor(autor);
                    libro.setCant_disp(cantidad);
                    biblioteca.add(libro);
                    //System.out.println("El tamaño de la biblioteca 55 es: "+biblioteca.size());
                    }
                }
            }
 public int validarAdmin(ArrayList<Libro> biblioteca, int codigo){
        int validar = 0;
        int n=0;

 
        while(n<biblioteca.size()){

                           if (biblioteca.get(n).getCodigo() == codigo) {
//                               for (int i = 0; i < biblioteca.size(); i++) {
//                               System.out.println("metodo validar 77| biblioteca.get("+n+")"+".getCodigo() = "+biblioteca.get(n).getCodigo() );
//                                   System.out.println("metodo validar 77 | codigo= "+codigo);
//                               }
                               validar=1;

                           }
                           n++;

                           }
        
        return validar;
    }
 
 public Libro encuentralibro(ArrayList<Libro> biblioteca, int codigo) {
     Libro libro =null;
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).getCodigo() == codigo) {
                libro = biblioteca.get(i);
                break;
            }
        }
        return libro;
    }
    public void buscarlibro(int codigo) {
        this.biblioteca=biblioteca;
        int h=0;
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).getCodigo() == codigo) {
                System.out.println("Codigo:" + codigo + "\n"
                        + "Titulo:" + biblioteca.get(i).getTitulo() + "\n"
                        + "Autor: " + biblioteca.get(i).getAutor() + "\n");
                h=1;
                break;
            }
            
        }
        if(h==0){
            System.out.println("El codigo ingresado no existe");
        }
    }

    public ArrayList<Libro> getBiblioteca() {
        return biblioteca;
    }

   
    
    

}
