package org.example;

import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@Getter

@JacksonXmlRootElement(localName = "atleta")
public class AtletaFemenina {
    @JacksonXmlProperty(isAttribute = true)
    private String nombre;
    @JacksonXmlElementWrapper(localName = "pruebas")
    @JacksonXmlProperty(localName = "prueba")
    private List<String> prueba;
    @JacksonXmlProperty(localName = "edad")
    private int edad;
    @JacksonXmlProperty(localName = "pais")
    private String pais;

    public AtletaFemenina() {
    }

    public AtletaFemenina(String nombre, List<String> prueba, int edad, String pais) {
        this.nombre = nombre;
        this.prueba = prueba;
        this.edad = edad;
        this.pais = pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrueba(List<String> prueba) {
        this.prueba = prueba;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "AtletaFemenina{" +
                "nombre='" + nombre + '\'' +
                ", prueba=" + prueba +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                '}';
    }
}
