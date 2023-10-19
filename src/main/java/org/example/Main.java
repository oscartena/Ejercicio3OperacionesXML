package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static String escribirListaObjetosXml(ListaAtletas atletas) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el XML se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(atletas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void escribirListaObjetosXml(ListaAtletas atletas, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), atletas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    public static List<AtletaFemenina> leerObjetosXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path ficheroXml = Path.of("src","main","resources","atletas.xml");


        AtletaFemenina atleta1 = new AtletaFemenina("Lucia",List.of("salto altura","100 metros lisos"),24,"España");
        AtletaFemenina atleta2 = new AtletaFemenina("Marta",List.of("natacion","100 metros lisos"),28,"Nigeria");

        List<AtletaFemenina> atletas = List.of(atleta1,atleta2);

        ListaAtletas listaAtletas = new ListaAtletas(atletas);

        escribirListaObjetosXml(listaAtletas, ficheroXml);

        //System.out.println(escribirListaObjetosXml(listaAtletas));

        leerObjetosXml(ficheroXml).forEach(System.out::println);
         }
}