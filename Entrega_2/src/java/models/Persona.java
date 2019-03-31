package models;

import java.util.*;

public class Persona {

    private String nombre;
    private int documento;
    private String fechaNac;
    private Cementerio cementerio;
    Scanner intro = new Scanner(System.in);
    public static ArrayList<Persona> visitantes = new ArrayList<>();

    public Persona(String nombre, int documento, String fechaNac, Cementerio cementerio) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNac = fechaNac;
        this.cementerio = cementerio;
        visitantes.add(this);
    }

    public static void mostrarPersona(Persona p) {
        System.out.println("");
        Cementerio cementerio = p.getCementerio();
        if (visitantes.contains(p)) {
            System.out.println("---DATOS DE PERSONA---");
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Documento: " + p.getDocumento());
            System.out.println("Fecha de Nacimiento: " + p.getFechaNac());
            // Datos guardados dentro de los datos ficticios, Ricardo encargado.
        } else {
            System.out.println("Esta no es una Persona registrada.");
        }

    }
    
    public static boolean visitanteExiste(int documento,Cementerio cementerio) {
        for (Persona p : visitantes) {
            if ((p.getDocumento() == documento)&&(p.getCementerio() == cementerio)){
                return true;
            }
        }
        return false;
    }
    
    public static Persona buscarPersona(int documento) { 
        for (Persona p : visitantes){
            if (p.getDocumento() ==  documento){
                return p;
            }
        }
        return null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDocument(int documento) {
        this.documento = documento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public Cementerio getCementerio() {
        return cementerio;
    }

    public void setCementerio(Cementerio cementerio) {
        this.cementerio = cementerio;
    }



}
/*
    public static void imprimirPersonas(){
        int key;
        int numeroPersonas = 
        Iterator it = ListaPersonas.keySet().iterator();
        System.out.println("");
        System.out.println("---LISTADO DE PERSONAS---");
        if(numeroPersonas>0){
            while(it.hasNext()){
                key = (int)it.next();
                System.out.println("-Nombre: "+ ListaPersonas.get(key)+"   -Documento: "+ key);
            }
        }
        else {
            System.out.println("No hay personas inscritas.");
        }
    }
    */
