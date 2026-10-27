package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Jugador j1 = new Jugador("Cristiano Ronaldo", "Delantero", 1985, "Jugador de fútbol portugués");
        Jugador j2 = new Jugador("Lionel Messi", "Delantero", 1987, "Jugador de fútbol argentino");
        Jugador j3 = new Jugador("Neymar Jr.", "Delantero", 1992, "Jugador de fútbol brasileño");

        JugadorService.insertar(j1);
        JugadorService.insertar(j2);
        JugadorService.insertar(j3);

        ArrayList<Jugador> jugadores = JugadorService.leerTodo();

        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }

        MercadoFichajes m1 = new MercadoFichajes(jugadores.get(0).getId(), 1900000, 1900000, 0);
        MercadoFichajes m2 = new MercadoFichajes(jugadores.get(1).getId(), 2000000, 2000000, 0);
        MercadoFichajes m3 = new MercadoFichajes(jugadores.get(2).getId(), 1800000, 1800000, 0);

        MercadoFichajesService.insertar(m1);
        MercadoFichajesService.insertar(m2);
        MercadoFichajesService.insertar(m3);

        ArrayList<MercadoFichajes> mercados = MercadoFichajesService.leerTodo();

        for (MercadoFichajes mercado : mercados) {
            System.out.println(mercado);
        }

        for (MercadoFichajes mercado : mercados) {
            MercadoFichajesService.updateComision(15, mercado.getId());
        }

        mercados = MercadoFichajesService.leerTodo();

        for (MercadoFichajes mercado : mercados) {
            System.out.println(mercado);
        }

        String ruta = "C:\\Users\\DIEGO CURRAS\\Desktop\\Carpeta_FP\\DAM\\AD\\1_Trimestre\\Simulacro2Futbol\\archivos";

        File directorio = new File(ruta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        String rutaSerial = ruta + "\\jugador.txt";
        String rutaXML = ruta + "\\jugadores.xml";

        FileService.serial(rutaSerial, jugadores.get(0));
        Jugador jSerial = FileService.desSerial(rutaSerial);

        System.out.println(jSerial);

        FileService.paraXML(jugadores, rutaXML);

        MercadoFichajesService.deleteAll();
        JugadorService.deleteAll();

    }
}