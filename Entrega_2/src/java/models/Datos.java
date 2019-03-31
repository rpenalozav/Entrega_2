/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Datos {
    public Datos(){
        Cementerio cementerio1 = new Cementerio(1, "Beyond Memories", (short) 50, "Calle 24 #45a-54 ");
        Cementerio cementerio2 = new Cementerio(2, "San Lorenzo", (short) 50, "Boston/Prado");
        Persona persona1 = new Persona("Simona", 1, "19/06/2017", cementerio1);
        Persona persona2 = new Persona("Luna", 2, "18/02/2013", cementerio1);
        Persona persona3 = new Persona("Leonor", 3, "Defuncion", cementerio1);
        Persona persona4 = new Persona("Francisco", 4, "Defunción", cementerio1);
        Persona persona5 = new Persona("Fidel", 5, "Defunción", cementerio1);
        Moderador moderador1 = new Moderador("David", 1090514247, "23/02/1998", "456", cementerio1);
        Moderador moderador2 = new Moderador("Mario", 1010215392, "13/06/1994", "666", cementerio2);
        Moderador moderador3 = new Moderador("Marcos", 1090514246, "23/02/1998", "123", cementerio1);
        Ubicacion ubicacion1 = new Ubicacion(1, cementerio1);
        Ubicacion ubicacion2 = new Ubicacion(2, cementerio1);
        Lapida lapida1 = new Lapida(persona3, true, ubicacion1, cementerio1, "", "");
        Lapida lapida2 = new Lapida(moderador2, true, ubicacion2, cementerio1, "", "");
        Cliente cliente1 = new Cliente(moderador1, "789", lapida1);
        Cliente cliente2 = new Cliente(persona1, "963", lapida2);
    }
       
}
