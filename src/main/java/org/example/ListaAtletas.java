package org.example;

import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@Getter

@JacksonXmlRootElement(localName ="atletas")
public class ListaAtletas {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "atleta")
    private List<AtletaFemenina> atletas;

    public ListaAtletas(List<AtletaFemenina> atletas) {
        this.atletas = atletas;
    }

    public void setAtletas(List<AtletaFemenina> atletas) {
        this.atletas=atletas;
    }

    @Override
    public String toString() {
        return "ListaAtletas{" +
                "atletas="+atletas+
                "}";
    }
}
