package models;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static boolean privacidad;
    public static boolean a = true;
    public static boolean existeCementerio = false;
    public static boolean noValido = true;
    public static boolean excluido = true;
    public static boolean valido;
    public static boolean pedirCementerio = true;
    public static boolean realizarIngreso = true;
    public static boolean doit;
    public static int id;
    public static int entrada;
    public static String idiom;
    public static int contadorIntentos = 3;

    public static void main(String[] args) {

        //DATOS FICTICIOS:
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

        //Marcos tuve que cambiar lo del orden de las cosas aquí...más que nada para hacer más legible el código.
        //No cambié nada de funcionalidad.
        //Tratemos de que solo haya un Try por While dentro de este Main.
        //Se pueden crear 2 clientes con la misma lápida.
        //Guardar datos en archivos txt.
        //Terminar Menú de Moderador.
        Texto.presentacion();
        idiom = input.next();
        Texto.setIdiom(idiom);
        Cementerio cementerio = null;

        while (a == true) {

            if (pedirCementerio == true) {
                cementerio = Main.ingresoCementerio();
            }

            if (realizarIngreso == true) {
                Main.ingresoID();
            }

            if (Moderador.modExiste(id, cementerio) == true) {
                Moderador mod = Moderador.buscarModerador(id);
                if (Cliente.clienteExiste(id, cementerio)) {
                    System.out.println(" ");
                    System.out.println("Ud es Moderador y Cliente:");
                    System.out.println(" ");
                    System.out.println("1.Moderador.");
                    System.out.println("2.Cliente.");
                    System.out.println(" ");
                    System.out.println("Selecione un rol:");
                    try {
                        int e = input.nextInt();
                        switch (e) {
                            case 1:
                                Main.menuMod(mod);
                                break;
                            case 2:
                                Cliente cli = Cliente.buscarCliente(id);
                                Main.menuCliente(cli);
                                break;
                        }

                    } catch (Exception e) {
                        System.out.println("Ese no es un comando válido.");
                    }

                    a = false;//Este solo se colocó para que rompa el ciclo.
                } else {
                    Main.menuMod(mod);//Si solo es moderador.
                }

                // Lanzamiento para Menú de Clientes.
            } else if (Cliente.clienteExiste(id, cementerio) == true) {
                Cliente cliente = Cliente.buscarCliente(id);
                Main.menuCliente(cliente);

                //Lanzamiento para Menú de Visitante.TERMINADO CON BUGS.
            } else if (Persona.visitanteExiste(id, cementerio) == true) {
                Persona visitante = Persona.buscarPersona(id);
                Main.menuVisitante(visitante);

            } else {
                noValido = true;
                Main.nuevoIngreso(id, cementerio);
            }
        }
    }

    public static void ingresoID() {
        valido = false;
        while (valido == false) {
            System.out.println(" ");
            System.out.println("Por favor ingrese el número de su documento de identificación a continuación: ");
            System.out.println(" ");
            try {
                id = input.nextInt();
                realizarIngreso = false;
                valido = true;
            } catch (Exception e) {
                System.out.println("Dato ingresado no valido");
                System.out.println(" ");
            }

        }
    }

    public static void menuMod(Moderador mod) {//Esto no ha sido modificado todavía.
        doit = comprobarCredenciales(mod.getContrasena());
        while (doit == true) {
            System.out.println(" ");
            System.out.println("---MENU MODERADOR CEMENTERIO: " + mod.getCementerio() + "---");
            System.out.println(" ");
            System.out.println("1. Ver Tumbas."); // Solo muestra la información de mi tumba(Lapida y Ubicación).
            System.out.println("2. Agregar Moderador");// Muestra otro menú para acciones con la propia tumba.
            System.out.println("3. Mostrar Moderadores."); //Método por confirmar.
            System.out.println("4. Reportar Muerte de Ciente"); // 
            System.out.println("5. Clientes a tu cargo.");
            System.out.println("6. Despedir Moderador.");
            System.out.println("7. Renunciar al cargo de Moderador.");
            System.out.println("8. Ingresar con otro documeto.");
            System.out.println("9. Ingresar a otro cementerio.");
            System.out.println("10. Salir");
            System.out.println(" ");
            System.out.println("Su Seleccion:");
            try {
                int opcion = input.nextInt();
                Cementerio cementerio = mod.getCementerio();
                if (opcion <= 0 || opcion > 10) {
                    throw new Exception();
                } else {
                    switch (opcion) {
                        case 1:
                            Main.imprimirLapidas(cementerio);
                        case 2:
                            System.out.println("Agregar Moderador.");
                        case 3:
                            System.out.println("Imprimir Moderadores.");
                            break;
                        case 4:
                            System.out.println("Reportar Muerte de Cliente.");//Todavía estoy pensando si añadirlo o no.
                            break;
                        case 5:
                            System.out.println("Clientes a tu cargo.");
                            break;
                        case 6:
                            System.out.println("Despedir Moderador.");
                            break;
                        case 7:
                            System.out.println("Renunciar al cargo de Moderador.");
                            break;
                        case 8:
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = true;
                            break;
                        case 9:
                            doit = false;
                            realizarIngreso = true;
                            pedirCementerio = true;
                            break;
                        case 10:
                            doit = false;
                            a = false;
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opción valida por favor");
            }
        }
    }

    public static void menuCliente(Cliente cliente) {
        comprobarCredenciales(cliente.getContrasena());
        while (doit) {
            System.out.println(" ");
            System.out.println("---MENU CLIENTE CEMENTERIO: " + cliente.getCementerio() + "---");
            System.out.println(" ");
            System.out.println("1. Ver mi Tumba."); // Solo muestra la información de mi tumba(Lapida y Ubicación).
            System.out.println("2. Modificar mi Tumba.");// Bugueado, está cambiando la clase y no la instancia.
            System.out.println("3. Mapa del Cementerio");//Sólo está imprimiendo las lápidas.
            System.out.println("4. Leer Lapida del cementerio.");
            System.out.println("5. Escribir Memoria");
            System.out.println("6. Menú Allegados."); //Todavía está por confirmarse.
            System.out.println("7. Saber más acerca de mi cementerio.");
            System.out.println("8. Ingresar con otro documento.");
            System.out.println("9. Ingresar a otro cementerio.");
            System.out.println("10. Salir");
            System.out.println(" ");
            System.out.println("Su Seleccion:");
            try {
                int opcion = input.nextInt();
                Cementerio cementerio = cliente.getCementerio();
                if (opcion <= 0 || opcion > 10) {
                    throw new Exception();
                } else {
                    switch (opcion) {
                        case 1:
                            Lapida l = cliente.getLapida();
                            Main.miLapida(cliente, l);
                            break;
                        case 2:
                            Main.menuMiTumba(cliente, cementerio);
                            break;
                        case 3:
                            Main.imprimirLapidas(cementerio);
                            break;
                        case 4:
                            Main.mostrarLapida(cementerio);
                            break;
                        case 5:
                            Main.escribirMemoria(cementerio);
                            break;
                        case 6:
                            System.out.println("Menú allegados.");//Por verse si se implemente o no.
                            break;
                        case 7:
                            System.out.println("Saber más acerca de mi cementerio, descripción blablabla.");//Por hacer texto.
                            break;
                        case 8:
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = true;
                            break;
                        case 9:
                            doit = false;
                            realizarIngreso = true;
                            pedirCementerio = true;
                            break;
                        case 10:
                            doit = false;
                            a = false;
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opción valida por favor");
            }
        }
    }

    public static void menuVisitante(Persona persona) {
        doit = true;
        while (doit == true) {
            System.out.println(" ");
            System.out.println("Ingrese el numero de la opción a realizar");
            System.out.println(" ");
            System.out.println("1. Adquirir Lapida");//Está el problema de los NextLine...porque también está tomando el "Enter" como un comando de entrada y está dejando vacío los epitafios. Si se pone como Next está el problema del interespaciado.
            System.out.println("2. Mapa del Cementerio");
            System.out.println("3. Escribir Memoria");
            System.out.println("4. Leer Lapida");//Acá hay un bug cuando se coloca un dato invalido en documento, imprime luego dos veces este el MenuVisitante.
            System.out.println("5. Saber más acerca del cementerio.");//Este lo coloco porque nos va a ser de utilidad en un futuro en la aplicación Web.
            System.out.println("6. Ingresar a otro perfil con otro documento.");//Dentro del mismo cementerio.
            System.out.println("7. Ingresar a otro cementerio.");
            System.out.println("8. Salir");
            System.out.println(" ");
            System.out.println("Su Seleccion:");
            try {
                int opcion = input.nextInt();
                Cementerio cementerio = persona.getCementerio();
                if (opcion <= 0 || opcion > 8) {
                    throw new Exception();
                } else {
                    switch (opcion) {
                        case 1:
                            Cliente nuevoCliente = Main.adquirirLapida(cementerio, persona);
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = false;

                            break;
                        case 2:
                            Main.imprimirLapidas(cementerio);
                            break;
                        case 3:
                            Main.escribirMemoria(cementerio);
                            break;
                        case 4:
                            Main.mostrarLapida(cementerio);//Hay un error cuando se ingresa un dato invalido, imprime dos veces el menúVisitante.
                            break;
                        case 5:
                            System.out.println("Imprime información del cementerio...blablabla");
                            break;
                        case 6:
                            doit = false;
                            pedirCementerio = false;
                            realizarIngreso = true;
                            break;
                        case 7:
                            doit = false;
                            realizarIngreso = true;
                            pedirCementerio = true;
                            break;
                        case 8:
                            doit = false;
                            a = false;
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("Ingrese una opción valida por favor");
            }
        }

    }

    public static void nuevoIngreso(int documento, Cementerio cementerio) {
        while (noValido == true) {
            try {
                if (documento <= 0) {
                    throw new Exception();
                } else {
                    System.out.println(" ");
                    System.out.println("---BIENVENIDO POR PRIMERA VEZ A BEYOND'S MEMORIES---");
                    System.out.println(" ");
                    System.out.println("1.Crear una Nueva Cuenta.");
                    System.out.println("2.Ingresar con un documento distinto.");
                    System.out.println("3.Ingresar a otro cementerio.");
                    System.out.println(" ");
                    excluido = true;
                    while (excluido == true) {
                        entrada = input.nextInt();
                        if (entrada == 1 || entrada == 2 || entrada == 3) {
                            switch (entrada) {
                                case 1:
                                    while (true) {
                                        System.out.println("Ingrese su nombre completo por favor");
                                        String nombre = input.nextLine();
                                        System.out.println("Ingrese su fecha de nacimiento en formato dd/mm/yyyy");
                                        String fechaNac = input.nextLine();

                                        if (!fechaNac.isEmpty() && !nombre.isEmpty()) {
                                            Persona visitante = new Persona(nombre, documento, fechaNac, cementerio);
                                            Persona.mostrarPersona(visitante);
                                            menuVisitante(visitante);
                                            noValido = false;
                                            excluido = false;
                                            a = false;
                                            break;
                                        } else {
                                            System.out.println("Por favor ingrese los datos completos");
                                            System.out.println("  ");
                                        }
                                    }
                                case 2:
                                    realizarIngreso = true;
                                    pedirCementerio = false;
                                    excluido = false;
                                    noValido = false;
                                    break;

                                case 3:
                                    cementerio = Main.ingresoCementerio();
                                    noValido = false;
                                    excluido = false;
                                    realizarIngreso = true;
                                    pedirCementerio = false;
                                    break;
                            }
                        } else {
                            System.out.println(" ");
                            System.out.println("Ingrese una opción válida por favor.");
                            excluido = false;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Ingrese un documento valido");
            }
        }
    }

    public static void miLapida(Persona persona, Lapida lapida) {
        System.out.println(" ");
        System.out.println("---LAPIDA DE " + persona.getNombre() + " ---");
        System.out.println("Epitafio: " + lapida.getEpitafio());
        System.out.println(persona.getFechaNac() + " - " + lapida.getFechaDef());
        System.out.println("Indice: " + lapida.getUbicacion().getIndice());
        System.out.println("Cementerio: " + persona.getCementerio().getNombre());
        System.out.println(" ");
        //Adicionar las memorias aquí.
    }

    public static void mostrarLapida(Cementerio cementerio) {
        while (true) {
            System.out.println("Por favor ingrese el documento de la persona dueña de la tumba que desea ver:");
            int doc = input.nextInt();
            if (Cliente.clienteExiste(doc, cementerio)) {
                Cliente c = Cliente.buscarCliente(doc);
                Lapida l = c.getLapida();
                System.out.println(" ");
                System.out.println("---LAPIDA DE: " + c.getNombre() + " ---");
                System.out.println("Epitafio: " + l.getEpitafio());
                System.out.println(c.getFechaNac() + " - " + l.getFechaDef());
                System.out.println("Indice: " + l.getUbicacion().getIndice());
                System.out.println("Cementerio: " + c.getCementerio().getNombre());
                System.out.println(" ");
                break;
            } else {
                System.out.println("No hay nadie registrado con esta tumba.");
                break;
            }

        }
    }

    public static void menuMiTumba(Cliente cliente, Cementerio cementerio) {
        System.out.println(" ");
        System.out.println("----BIENVENIDO A LA MODIFICACIÓN DE SU TUMBA----");
        System.out.println(" ");
        System.out.println("1. Modificar mi Epitafio.");
        System.out.println("2. Cambiar la ubicación de mi tumba.");
        System.out.println("3. Cambiar privacidad.");
        System.out.println("4. Volver al Menú de Cliente.");
        System.out.println(" ");
        System.out.println("Su selección: ");
        System.out.println(" ");
        Lapida l = cliente.getLapida();
        try {
            int opcion = input.nextInt();
            if (opcion <= 0 || opcion > 4) {
                throw new Exception();
            } else {
                switch (opcion) {
                    case 1:
                        Main.modificarEpitafio(cliente, cementerio);
                        Main.miLapida(cliente, l);
                        break;
                    case 2:
                        Main.cambiarUbicacion(l, cementerio);
                        Main.miLapida(cliente, l);
                        break;
                    case 3:
                        Main.cambiarPrivacidad(l, cementerio);
                        Main.miLapida(cliente, l);
                        break;
                    case 4:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ingrese una opción válida por favor.");
        }
    }

    public static void imprimirLapidas(Cementerio cementerio) {

        System.out.println("----LISTADO DE LAPIDAS EN EL CEMENTERIO " + cementerio.getNombre() + "----");
        System.out.println(" ");
        for (Lapida l : Lapida.lapidas) {
            System.out.println("Aquí yace:" + l.getDueno().getDocumento() + "---" + l.getDueno().getNombre() + " --- Ubicado en la cripta Número: " + l.getIndiceU());
        }
    }

    public static void mostrarCliente(Cliente cliente, Cementerio cementerio) {
        if (Cliente.clientes.contains(cliente)) {
            Persona.mostrarPersona(cliente);
            System.out.println("Tipo de perfil: Cliente");
            //Main.mostrarLapida(cliente, cliente.getLapida());
        } else {
            System.out.println("No existe información de este cliente en este cementerio");
        }
    }

    public static void escribirMemoria(Cementerio cementerio) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el documento de la persona dueña de la lapida");
        String entrada = input.nextLine();
        try {
            int documento = Integer.parseInt(entrada);
            if (documento <= 0) {
                throw new Exception();
            }
            Cliente cliente = Cliente.buscarCliente(documento);
            if (cliente == null) {
                System.out.println("No existe un cliente con ese documento");
            } else {

            }
        } catch (Exception e) {
            System.out.println("Ingrese un documento valido");
        }

    }

    public static Cliente adquirirLapida(Cementerio cementerio, Persona persona) {
        System.out.println(" ");
        System.out.println("---BIENVENIDO A LA CREACION DE LAPIDA---");
        System.out.println(" ");
        System.out.println("Ingrese la contraseña que desea para su lapida: ");
        while (true) {
            String contrasena = input.next();
            System.out.println(" ");
            System.out.println("Ingrese el epitafio que desea para su lapida");
            String epitafio = input.next();
            System.out.println(" ");
            System.out.println("Ingrese la privacidad que desea para su lapida:");
            System.out.println(" ");
            System.out.println("   0. para publica.");
            System.out.println("   1. para privado.");
            System.out.println(" ");
            System.out.println("Su Selección: ");
            while (true) {
                String entrada = input.next();
                if (!entrada.isEmpty() && entrada.equals("1") || entrada.equals("0")) {
                    if (entrada == "1") {
                        privacidad = true;
                        break;
                    } else {
                        privacidad = false;
                        break;
                    }
                } else {
                    System.out.println("Ingrese una opción valida.");
                }
            }

            System.out.println("Ingrese la ubicación donde desea que esté su lapida.");
            while (true) {
                try {
                    int indice = input.nextInt();
                    if (Ubicacion.revisarDisponibilidadUbicacion(cementerio, indice)) {
                        Ubicacion ubicacion = new Ubicacion(indice, cementerio);
                        Lapida lapida = new Lapida(persona, privacidad, ubicacion, cementerio, epitafio, "");
                        Cliente cliente = new Cliente(persona, contrasena, lapida);
                        Main.mostrarCliente(cliente, cementerio);
                        System.out.println("");
                        Main.miLapida(cliente, lapida);
                        return cliente;
                    } else {
                        System.out.println("Esta ubicación no está disponible, ingrese una distinta");
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese una ubicación valida");
                }
            }
        }

    }

    public static void modificarEpitafio(Cliente cliente, Cementerio cementerio) {
        Lapida l = cliente.getLapida();
        if (l.getEpitafio() != null) {
            System.out.println(" ");
            System.out.println("Su actual epitafio es: " + l.getEpitafio());
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println("Su tumba actualmente no tiene epitafio.");
            System.out.println(" ");
        }
        System.out.println("Ingrese a continuación la leyenda de su nuevo epitafio:");
        String epitaf = input.next();
        l.setEpitafio(epitaf);
    }

    public static void cambiarPrivacidad(Lapida l, Cementerio cementerio) {
        String privAntes;
        String privDespues;
        boolean priv = l.getPrivacidad();
        if (priv) {
            privAntes = "publica";
            privDespues = "privada";
            l.setPrivacidad(false);
        } else {
            privAntes = "privada";
            privDespues = "publica";
            l.setPrivacidad(true);
        }
        System.out.println(" ");
        System.out.println("Anteriormente su tumba era " + privAntes);
        System.out.println("De ahora en adelante su tumba será " + privDespues);
        System.out.println(" ");

    }

    public static void cambiarUbicacion(Lapida l, Cementerio cementerio) {
        System.out.println(" ");
        System.out.println("La ubicación actual de su tumba es " + l.getUbicacion().getIndice() + " en el cementerio " + cementerio.getNombre());
        System.out.println(" ");
        System.out.println("Ingrese un número del 1 al 50 donde desee ubicar su Lápida en e cementerio " + cementerio.getNombre());
        System.out.println(" ");
        try {
            int nuevoIndice = input.nextInt();
            Ubicacion nuevaUbicacion = new Ubicacion(nuevoIndice, cementerio);
            Ubicacion.limpiarUbicacion(l.getUbicacion());
            l.getUbicacion().anadirUbicacion(nuevaUbicacion);
            System.out.println(" ");
            System.out.println("Se cambió su ubicación satisfactoriamente.");
            System.out.println(" ");
        } catch (Exception e) {
            System.out.println(" Ingrese una ubicación válida. ");
        }

    }

    public static Cementerio ingresoCementerio() {
        while (true) {
            Main.imprimirCementerios();
            System.out.println("Ingrese el id del cementerio al cual desea entrar");
            try {
                int idCementerio = input.nextInt();
                Cementerio cementerio = Cementerio.buscarCementerio(idCementerio);
                if (cementerio == null) {
                    throw new Exception();
                } else {
                    System.out.println("Ha ingresado a la base de datos del cementerio: " + cementerio.getNombre());
                    pedirCementerio = false;
                    return cementerio;
                }
            } catch (Exception x) {
                System.out.println("Ingrese un id de cementerio valido por favor");
            }
        }
    }

    public static void imprimirCementerios() {
        System.out.println(" ");
        System.out.println("---LISTADO DE CEMENTERIOS---");
        System.out.println(" ");
        for (Cementerio c : Cementerio.cementerios) {
            System.out.println(c.getId() + ". " + c.getNombre());
            System.out.println(" ");
        }
    }

    public static void Escribir() {
        FileWriter texto = null;
        System.out.println("Llega1");
        try {
            texto = new FileWriter("Archivo1.txt");
            int[] imprimir = {1, 2, 3};
            System.out.println("Llega2");
            for (int i : imprimir) {
                texto.write(" Dato " + i);
                System.out.println("LlegaMultiple");
            }
            texto.close();
        } catch (Exception e) {
            System.out.println("Mal metido.");
        }
    }

    public static boolean comprobarCredenciales(String contrasena) {
        while (contadorIntentos > 0) {
            System.out.println(" ");
            System.out.println("Por favor ingrese su contraseña de usuario:");
            String password;

            try {
                password = input.next();
                if (password.equals(contrasena)) {
                    System.out.println("Credenciales autorizadas.");
                    doit = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error en las credenciales, tiene " + contadorIntentos + "intento(s).");
                contadorIntentos--;
                doit = false;
            }
        }
        return doit;
    }
}
