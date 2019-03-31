package models;


public class Ubicacion {

    private static int indice;
    private final Cementerio cementerio;
    public static Ubicacion Ubicaciones[];

    public Ubicacion(int indice, Cementerio cementerio) {
        this.indice = indice;
        this.cementerio = cementerio;
        Ubicacion.anadirUbicacion(this);
    }

    public static int getIndice() {
        return indice;
    }
    
    public static void anadirUbicacion(Ubicacion ubicacion){
        Ubicaciones[ubicacion.getIndice()] = ubicacion;
    }
    
    public static void limpiarUbicacion(Ubicacion ubicacion){
        Ubicaciones[Ubicacion.getIndice()] = null;
    }
    
    public static boolean revisarDisponibilidadUbicacion(Cementerio cementerio,int indice){
        if(Ubicaciones[indice]==null){
            return true;
        }else{
            return false;
        }
    }

}
