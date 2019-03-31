package models;

import java.util.*;

public class Cliente extends Persona {

    private String contrasena;
    private Lapida lapida;
    private Cementerio cementerio;
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(Persona persona, String contrasena, Lapida lapida) {
        super(persona.getNombre(), persona.getDocumento(), persona.getFechaNac(), lapida.getCementerio());
        this.cementerio = lapida.getCementerio();
        this.lapida = lapida;
        this.contrasena = contrasena;
        clientes.add(this);
    }

    public static Cliente buscarCliente(int documento) {
        for (Cliente c : clientes) {
            if (c.getDocumento() == documento) {
                return c;
            }
        }
        return null;
    }

    public Lapida getLapida() {
        return lapida;
    }

    public static boolean clienteExiste(int documento,Cementerio cementerio) {
        for (Cliente c : clientes) {
            if ((c.getDocumento() == documento)&&(c.getCementerio()==cementerio)) {
                return true;
            }
        }
        return false;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}

/*
    public static void mostrarCliente(Cliente c){

        System.out.println("");
        if((ListaClientes.containsKey(doc))==true){
            System.out.println("---DATOS DE CLIENTE---");
            System.out.println("Nombre: "+c.getNombre());
            System.out.println("Documento: "+c.getDocumento());
            System.out.println("Fecha de Nacimiento: "+c.getFechaNac());
            // Datos guardados dentro de los datos ficticios, Ricardo encargado.
        }
        else {
            System.out.println("Esta no es Cliente registrado.");
        }

    }

    public static void imprimirClientes(){
        int key;
        int numeroClientes = ListaClientes.size();
        Iterator it = ListaClientes.keySet().iterator();
        if(numeroClientes>0){
            while(it.hasNext()){
                key = (int)it.next();
                System.out.println("Nombre: "+ ListaClientes.get(key)+" Documento: "+ key);
            }
        }
        else {
            System.out.println("No hay Clientes inscritos.");
        }
    }


/*

 */
