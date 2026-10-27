package org.example;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;

public class FileService {
    public static void serial(String ruta, Jugador jugador) throws IOException {

        File archivo = new File(ruta);
        FileOutputStream FoS = new FileOutputStream(archivo);
        ObjectOutputStream OoS = new ObjectOutputStream(FoS);

        OoS.writeObject(jugador);
    }

    public static Jugador desSerial(String ruta) throws IOException, ClassNotFoundException {

        File archivo = new File(ruta);
        FileInputStream FiS = new FileInputStream(archivo);
        ObjectInputStream OiS = new ObjectInputStream(FiS);

        Jugador j1 = (Jugador) OiS.readObject();
        return j1;
    }

    public static void paraXML(ArrayList<Jugador> jugadores, String ruta){
        XMLOutputFactory XOF = XMLOutputFactory.newInstance();

        try{
            XMLStreamWriter XSW = XOF.createXMLStreamWriter(new FileWriter(ruta));

            XSW.writeStartDocument("1.0");
            XSW.writeCharacters("\n");
            XSW.writeStartElement("Jugadores");
            XSW.writeCharacters("\n");

            for (Jugador jugador : jugadores){
                XSW.writeStartElement("jugador");
                XSW.writeAttribute("posicion", jugador.posicion);
                XSW.writeAttribute("año", String.valueOf(jugador.año));
                XSW.writeCharacters("\n");
                XSW.writeStartElement("nombre");
                XSW.writeCharacters(jugador.getNombre());
                XSW.writeEndElement();
                XSW.writeCharacters("\n");
                XSW.writeStartElement("descripcion");
                XSW.writeCharacters(jugador.descricion);
                XSW.writeEndElement();
                XSW.writeCharacters("\n");
                XSW.writeEndElement();
                XSW.writeCharacters("\n");
            }
            XSW.writeEndElement();
            XSW.writeEndDocument();

            XSW.flush();
            XSW.close();

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
