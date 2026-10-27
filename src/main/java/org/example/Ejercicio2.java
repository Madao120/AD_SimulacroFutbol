package org.example;
/*
Partiendo del alumnos.txt del ejercicio anterior:

Escribe inicialmente:
Juan
        María
Pedro
Después añade al final:
Ana
        Luis
Finalmente, lee el archivo y muestra todas las líneas por pantalla.

El resultado debería ser:

Juan
María
Pedro
Ana
Luis

Pistas: FileWriter, BufferedWriter, FileReader, BufferedReader.
*/

import java.io.*;

public class Ejercicio2 {
    static String contenido = "Juan\n" +
            "María\n" +
            "Pedro\n" +
            "Ana\n" +
            "Luis";
    static String ruta = "C:\\Users\\DIEGO CURRAS\\Desktop\\Carpeta_FP\\DAM\\AD\\1_Trimestre\\examen\\alumnos.txt";
    public static void main(String[] args) throws IOException {

    // Añadir Texto
        try (BufferedWriter escritor =
                     new BufferedWriter(new FileWriter(ruta))) {
            escritor.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Añadir texto al archivo, ponemos la misma ruta en el in y en out
        try (BufferedWriter escritor =
                     new BufferedWriter(new FileWriter(ruta, true))) {

            escritor.newLine();
            escritor.write(contenido);

        } catch (IOException e) {
            e.printStackTrace();
        }

    // Leer Texto
        try (BufferedReader lector =
                     new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
