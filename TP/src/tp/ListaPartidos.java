/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListaPartidos {

    // atributo
    private List<Partido> partidos;
    private Strinnd PartidosCSV;

    public ListaPartidos(List<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }

    public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();
        this.partidosCSV = "partidos.csv";
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partido = partidos;
    }

    public String getPartidoCSV() {
        return partidosCSV;
    }

    public void setPartidosCSV(String partidoCSV) {
        this.partidosCSV = partidosCSV;
    }

    // add y remove elementos
    public void addPartidos(Partido p) {
        this.partido.add(p);
    }

    public void removePartido(Partido p) {
        this.partido.remove(p);
    }

    @Override
    public String toString() {
        return "ListaPartidos{" + "partido=" + partidos + '}';
    }

    public String listar() {
        String lista = "";
        for (Partido partido : partidos) {
            lista += "\n" + partido;
        }
        return lista;
    }

    // Cargar desde el archivo, filtrando solamente aquellos pronósticos
    // cuyo idParticipante coincide con el indicado
    // De esa forma todos los pronósticos de la lista pertenecen al mismo participante.
    public void cargarDeArchivo(
            int idEquipo, // id del participante que realizó el pronóstico
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        // para las lineas del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPartidosCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartido = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosPronostico);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartido = datosPartido.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int readidPartido = Integer.parseInt(vectorPartido[0]);
                int readidEquipo1 = Integer.parseInt(vectorPartido[1]);
                int readidEquipo2 = Integer.parseInt(vectorPartido[2]);
                int readidGolesEquipo1 = Integer.parseInt(vectorPartido[3]);
                int readidGolesEquipo2 = Integer.parseInt(vectorPartido[4]);
                  // El primer caracter es una comilla delimitadora de campo
                // Si coincide el idPpronostico con el que estoy queriendo cargar,
                // sigo, si no, salteo el registro y voy al siguiente
                if (readidPartido == idPartido) {
                    // Obtener los objetos que necesito para el constructor
                    Partido partido = listapartidos.getPartido(readidPartido);
                    Equipo equipo = listaequipos.getEquipo(readidEquipo);
                    // crea el objeto en memoria
                    Partido partido = new Partido(
                            readidPartido, // El id leido del archivo
                            readidEquipo1,
                            readidEquipo2,
                            readidGolesEquipo1,
                            readidGolesEquipo2
                           
                    );

                    // llama al metodo add para grabar el equipo en la lista en memoria
                    this.addPartido(partido);
                }
            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }
        
    public void cargarDeArchivoTodos(
            ListaEquipos listaequipos, // lista de equipos
            ListaPartidos listapartidos // lista de partidos
    ) {
        // para las lineas del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];

        int fila = 0;

        try {
            Scanner sc = new Scanner(new File(this.getPartidsCSV()));
            sc.useDelimiter("\n");   //setea el separador de los datos

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartido = sc.next();
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosPronostico);  //muestra los datos levantados 
                fila++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1) {
                    continue;
                }

                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartido = datosPartido.split(",");

                // graba el equipo en memoria
                //convertir un string a un entero;
                int readidPartido = Integer.parseInt(vectorPartido[0]);
                int readidEquipo1 = Integer.parseInt(vectorPartido[1]);
                int readidEquipo2 = Integer.parseInt(vectorPartido[2]);
                int readidGolesEquipo1= Integer.parseInt(vectorPartido[3]);
                int readidGolesEquipo2 = Integer.parseInt(vectorPartido[4])
                
              // El primer caracter es una comilla delimitadora de campo
                
                // Obtener los objetos que necesito para el constructor
                Partido partido = listapartidos.getPartido(readidPartido);
                Partido partido = listapartidos.get(readidPartido);
                // crea el objeto en memoria
                Partido partido = new Partido(
                    readidPartido, // El id leido del archivo
                    readidEquipo1,
                   readidEquipo2,
                   readidGolesEquipo1,
                   readidGolesEquipo2
                );

                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addPartido(partido);

            }
            //closes the scanner
        } catch (IOException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
    }