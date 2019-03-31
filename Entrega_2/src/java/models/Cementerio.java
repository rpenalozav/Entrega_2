package models;
import java.util.ArrayList;


public class Cementerio {
    
    private short capacidad;
    private String nombre;
    private String direccion;
    private int id;
    
    
    public static ArrayList<Cementerio> cementerios = new ArrayList<>();

    Cementerio(int id, String nombre, short capacidad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.direccion = direccion;
        Ubicacion.Ubicaciones = new Ubicacion[capacidad];
        cementerios.add(this);
    }
    


    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getId(){
        return id;
    }
    
    public static Cementerio buscarCementerio(int id){
        for(Cementerio c:cementerios){
            if (c.getId() == id){
                return c;
            }
        }
    return null;
    }
    
    public static boolean comprobarCementerio(Cementerio cementerio) { 
        for (Cementerio cm : cementerios){
            if (cm ==  cementerio){
                return true;
            }
        }
        return false;
    }
    
}
