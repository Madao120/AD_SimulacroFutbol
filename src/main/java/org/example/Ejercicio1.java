package org.example;
/*
Ejercicio 1 — Directorios y archivos

Crea un programa Java que:

Cree una carpeta llamada examen.
Dentro cree un archivo llamado alumnos.txt.
Compruebe si la carpeta ya existe antes de crearla.
Compruebe si el archivo ya existe antes de crearlo.
Muestre por pantalla:
Si la carpeta existe.
Si el archivo existe.
El nombre del archivo.
El tamaño del archivo.

Pistas: File, exists(), mkdir(), createNewFile(), getName(), length().
*/

import java.io.File;
import java.io.IOException;

public class Ejercicio1 {
    static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\DIEGO CURRÁS\\Desktop\\DAM2\\Acceso_Datos\\Trimestre_1\\AD_Practica1_Ex1\\examen");
        // En caso de hacer un archivo podemos especificar el method con 2 argumentos, (ruta, archivo)
        File file = new File(folder,"alumnos.txt");

        // CreaciOn de carpeta, comprobamos que no exista, luego la creamos
        if (folder.exists()){
            System.out.println("Ya existe esta carpeta");
        }
        else {
            folder.mkdir();
        }

        // Crear archivo, para esto debemos de comprobar que no exista, y que la ruta del directorio donde se va a insertar sea un directorio y exista, luego se crea
        if (file.exists()){
            System.out.println("Ya existe este archivo");
        } else if (folder.exists()&&folder.isDirectory()) {
            file.createNewFile();
        } else {
            System.out.println("Parece que hubo un error en la creaci´ni del archivo");
        }

        // Ahora mostraremos las características de el archivo
        System.out.println(file.getName());
        System.out.println(file.getTotalSpace());
    }
}
