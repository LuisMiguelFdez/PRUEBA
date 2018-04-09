/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils78;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Miguel
 */
public class Miscelanea {

    public static <T> T containsColecciones(T emp, Collection<T> c) {
        T siguiente;

        if (c.contains(emp)) {

            Iterator it = c.iterator();
            while (it.hasNext()) {
                siguiente = (T) it.next();
                if (siguiente.equals(emp)) {
                    return siguiente;
                }
            }
        }
        return null;
    }

    public static void listarDirectorio(String directorio) {
        File f = new File(directorio);
        File[] listaRutas = f.listFiles();

        for (int i = 0; i < listaRutas.length; i++) {
            if (listaRutas[i].isFile()) {
                System.out.println("\t" + listaRutas[i]);
            } else {
                System.err.println(listaRutas[i]); //ponerlas en err es solo para que salgan de color diferente.
                listarDirectorio(listaRutas[i].getPath());
            }
        }

    }

    public static void imprimeFichero(String nombreFich) {

        try {
            FileReader lee = new FileReader(nombreFich);
            Scanner lineaString = new Scanner(lee);
            while (lineaString.hasNextLine()) {
                System.out.println(lineaString.nextLine());
            }
            lineaString.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido encontrar el archivo = " + nombreFich);
        }
    }

    public static void buscaEimprime(String nombreFich) {
        File f = new File("/");
        File[] listaRutas = f.listFiles();

        for (int i = 0; i < listaRutas.length; i++) {
            if (listaRutas[i].isFile()) {
                System.out.println("\t" + listaRutas[i]);
            } else {
                System.err.println(listaRutas[i]); //ponerlas en err es solo para que salgan de color diferente.
                listarDirectorio(listaRutas[i].getPath());
            }
        }

    }

    static void leeDeTeclado(String mensaje) throws IOException {

        int c, contador = 0;

        System.out.println(mensaje);
        while ((c = System.in.read()) != '\n') { //Aqui se leen las cosas
            contador++;
            System.out.print((char) c);
        }
        System.out.println("Has escrito: "); // Se escribe el cambio de línea

        // Se escribe el cambio de linea
        System.out.println("Contados " + contador + " bytes en total.");
    }

}
