package models;

import java.util.*;

public class Lapida {

    private String nombreDueno;
    private int documentoDueno;
    private String fechaNacDueno;
    private String fechaDef;
    public String epitafio;
    public static Ubicacion ubicacion;
    private boolean privacidad;
    private Persona dueno;
    private Cementerio cementerio;
    public static ArrayList<Lapida> lapidas = new ArrayList<>();

    public Lapida(Persona persona, boolean privacidad, Ubicacion ubicacion, Cementerio cementerio, String epitafio, String fechaDef) {
        this.nombreDueno = persona.getNombre(); //Nombre de dueño de la lápida.
        this.documentoDueno = persona.getDocumento(); //Documento dueño de lápida.
        this.fechaNacDueno = persona.getFechaNac(); //Fecha de Nacimiento dueño de lápida.
        this.fechaDef = fechaDef;  //Fecha de defunción de dueño(Puede estar vacía)
        this.epitafio = epitafio; //Epitafio de lápida(Puede estar vacío)
        this.privacidad = privacidad; //Privacidad de lápida
        this.dueno = persona; //Dueño de lápida
        this.ubicacion = ubicacion; //Ubicacion de lápida
        this.cementerio = cementerio; //Cementerio donde está la lápida
        ArrayList<Memoria> Memorias = new ArrayList<>(); //Lista de memorias
        lapidas.add(this);
    }

    public Cementerio getCementerio() {
        return cementerio;
    }

    public String getFechaDef() {
        return fechaDef;
    }

    public void setFechaDef(String fechaDef) {
        this.fechaDef = fechaDef;
    }

    public String getEpitafio() {
        return epitafio;
    }

    public void setEpitafio(String epitafio) {
        this.epitafio = epitafio;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public static int getIndiceU() {
        Ubicacion u = ubicacion;
        return u.getIndice();
    }

    public boolean getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(boolean privacidad) {
        this.privacidad = privacidad;
    }

    public Persona getDueno() {
        return dueno;
    }

    public void setDueno(Persona dueño) {
        this.dueno = dueño;
    }

}
