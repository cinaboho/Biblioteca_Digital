package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cindybohorquezsantana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int codigo;
        int validar = 0;
        String titulo;
        String autor;
        int cantidad;

        ArrayList<String> admin = new ArrayList<String>();
        ArrayList<String> estud = new ArrayList<String>();

        Administrador administrador = new Administrador();
        Estudiante estudiante = new Estudiante();

        administrador.agregarlibro(1, "titulo1", "autor1", 1);
        administrador.agregarlibro(2, "titulo2", "autor2", 5);
        administrador.agregarlibro(3, "titulo3", "autor3", 7);

        Scanner input_id = new Scanner(System.in);
        Scanner input_codigo = new Scanner(System.in);
        Scanner input_titulo = new Scanner(System.in);
        Scanner input_autor = new Scanner(System.in);
        Scanner input_cantidad = new Scanner(System.in);
        Scanner input_resp = new Scanner(System.in);
        Scanner input_dato = new Scanner(System.in);
        String id;
        int buscar_cod;
        Main main = new Main();
        admin.add("admin1");
        admin.add("admin2");
        admin.add("admin3");

        estud.add("estud1");
        estud.add("estud2");
        estud.add("estud3");

        System.out.println("Bienvenido");
        System.out.println("Ingrese su id: ");
        id = input_id.nextLine();

        if (main.EsAdmin(id, admin) == true) {
            int b = 0;
            while (b == 0) {
                int opcion = main.menuadmin();

                if (opcion == 1) {

                    System.out.println("Cuantos libros desea agregar");
                    int num_lib = 0;
                    int n = 0;
                    Scanner input_opcion = new Scanner(System.in);
                    num_lib = input_opcion.nextInt();

                    while (n < num_lib) {
                        System.out.println("Ingrese codigo: ");
                        codigo = input_codigo.nextInt();

                        System.out.println("Ingrese Titulo: ");
                        titulo = input_titulo.nextLine();

                        System.out.println("Ingrese Autor: ");
                        autor = input_autor.nextLine();

                        System.out.println("Ingrese cantidad: ");
                        cantidad = input_cantidad.nextInt();

                        administrador.agregarlibro(codigo, titulo, autor, cantidad);
                        n++;
                    }
                    //aqui ees

                } else if (opcion == 2) {

                    System.out.println("Ingrese el codigo del libro que desea buscar: ");
                    buscar_cod = input_dato.nextInt();

                    administrador.buscarlibro(buscar_cod);
                } else if (opcion == 3) {
                    System.exit(0);
                }
                System.out.println("Desea regresar al menu principal? (y/n)");
                String respi = input_resp.nextLine();
                char resp = respi.charAt(0);

                if (resp == 'y') {
                    b = 0;

                } else {
                    b = 1;
                }
            }

        } else if (main.Esestud(id, estud) == true) {
            int a=0;
            while(a==0){
              int op = main.menuestud();  
              
              if(op==1){
                  estudiante.verLibrosDisponibles(administrador.getBiblioteca());
              }
              else if(op ==2){
                  estudiante.verLibrosPrestados(estudiante.getLibrosprestados());
              }
              else if(op ==3){
                  
              }
              System.out.println("Desea regresar al menu principal? (y/n)");
                    String respi = input_resp.nextLine();
                    char resp = respi.charAt(0);

                    if (resp == 'y') {
                        a = 0;

                    } else {
                        a = 1;
                    }
            }
            

        } else {
            System.out.println("Id no registrado");
        }

    }

    public boolean EsAdmin(String id, ArrayList<String> admin) {
        boolean respuesta = false;
        for (int i = 0; i < admin.size(); i++) {
            if (admin.contains(id)) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        }
        return respuesta;
    }

    public boolean Esestud(String id, ArrayList<String> est) {
        boolean respuesta = false;
        for (int i = 0; i < est.size(); i++) {
            if (est.contains(id)) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        }
        return respuesta;
    }

    public int menuadmin() {
        System.out.println("1. Agregar nuevos Libros");
        System.out.println("2. Buscar Información del Libro");
        System.out.println("3. Salir");
        int opcion = 0;
        Scanner input_opcion = new Scanner(System.in);
        opcion = input_opcion.nextInt();
        return opcion;
    }

    public void recorrer(ArrayList<Libro> biblioteca) {
        for (int i = 0; i < biblioteca.size(); i++) {
            System.out.println("biblioteca.get(" + i + ").getCodigo()=" + biblioteca.get(i).getCodigo());

        }
    }

    public int menuestud() {
        System.out.println("1. Ver libros disponibles");
        System.out.println("2. Ver informacion de libros prestados");
        System.out.println("3. Salir");
        int opcion = 0;
        Scanner input_opcion = new Scanner(System.in);
        opcion = input_opcion.nextInt();
        return opcion;
    }
}
