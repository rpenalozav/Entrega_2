package models;

import java.util.Scanner;

public class Texto {
    
    public static int idiom;
    
    public static void presentacion(){
        System.out.println(" "+"\n"
                + "Bienvenido a Beyonds Memories: "+"\n"
                + " "+"\n"
                + "0.Español"+"\n"
                + "1.Inglés."+"\n"
                + " "+"\n"
                + "Seleccionar/Select: ");
    }
    
    public static void setIdiom(String a){
        Scanner input = new Scanner(System.in);
        while(true){
            try{
                int idioma = Integer.parseInt(a);
                if(idioma == 0 ){
                    System.out.println("Seleccionó el idioma Español");
                }
                else if(idioma == 1){
                    System.out.println("Seleccionó el idioma Inglés");
                }
                else{
                throw new Exception();
                }
                break;
            }catch(Exception e){
                System.out.println("Por favor ingrese una opción valida");
                a = input.next();
            }
            }
    }
}
