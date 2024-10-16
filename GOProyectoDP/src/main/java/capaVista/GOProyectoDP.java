
package capaVista;

import capaModelo.*;
import CapaControl.ControlFacade;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class GOProyectoDP {

    public static void main(String[] args) throws SQLException {
        // Obtener la instancia de ControlFacade
        ControlFacade controlFacade = new ControlFacade();
        

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        int opcion = -1;

        while (opcion != 0) {
            // Mostrar el menú de opciones
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Consultar usuario por ID");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Registrar nueva medición");
            System.out.println("5. Consultar mediciones de un usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción seleccionada
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarNuevoUsuario(controlFacade, scanner);
                    break;
                case 2:
                    consultarUsuario(controlFacade, scanner);
                    break;
                case 3:
                    actualizarUsuario(controlFacade, scanner);
                    break;
                case 4:
                    registrarNuevaMedicion(controlFacade, scanner);
                    break;
                case 5:
                    consultarMediciones(controlFacade, scanner);
                    break;
                
                case 0:
                    System.out.println("¡Hasta luego!");
                    
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    
                    break;
            }
        }

        // Cerrar el scanner al final
        scanner.close();
    }

    // Método para registrar un nuevo usuario
    private static void registrarNuevoUsuario(ControlFacade controlFacade, Scanner scanner) {
        System.out.println("\n--- Registrar Nuevo Usuario ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el sexo (M/F): ");
        char sexo = scanner.nextLine().toUpperCase().charAt(0);

        Date fechaRegistro = new Date(Calendar.getInstance().getTimeInMillis());

        Usuario nuevoUsuario = new Usuario(0, nombre, edad, sexo, fechaRegistro);

        controlFacade.registrarUsuario(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente.");
    }

    // Método para consultar un usuario por ID
    private static void consultarUsuario(ControlFacade controlFacade, Scanner scanner) {
        System.out.println("\n--- Consultar Usuario ---");
        System.out.print("Ingrese el ID del usuario: ");
        int id = Integer.parseInt(scanner.nextLine());

        Usuario usuario = controlFacade.obtenerUsuario(id);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("No se encontró un usuario con el ID proporcionado.");
        }
    }

    // Método para actualizar un usuario
    private static void actualizarUsuario(ControlFacade controlFacade, Scanner scanner) {
        System.out.println("\n--- Actualizar Usuario ---");
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Usuario usuario = controlFacade.obtenerUsuario(id);
        if (usuario != null) {
            System.out.print("Ingrese el nuevo nombre (actual: " + usuario.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                usuario.setNombre(nombre);
            }

            System.out.print("Ingrese la nueva edad (actual: " + usuario.getEdad() + "): ");
            String edadStr = scanner.nextLine();
            if (!edadStr.isEmpty()) {
                int edad = Integer.parseInt(edadStr);
                usuario.setEdad(edad);
            }

            System.out.print("Ingrese el nuevo sexo (actual: " + usuario.getSexo() + "): ");
            String sexoStr = scanner.nextLine();
            if (!sexoStr.isEmpty()) {
                char sexo = sexoStr.toUpperCase().charAt(0);
                usuario.setSexo(sexo);
            }

            // Actualizar el usuario
            controlFacade.actualizarUsuario(usuario);
            System.out.println("Usuario actualizado exitosamente.");
        } else {
            System.out.println("No se encontró un usuario con el ID proporcionado.");
        }
    }
    

    // Método para registrar una nueva medición
    private static void registrarNuevaMedicion(ControlFacade controlFacade, Scanner scanner) {
        

        System.out.println("\n--- Registrar Nueva Medición ---");
        System.out.print("Ingrese el ID del usuario: ");
        int userId = Integer.parseInt(scanner.nextLine());

        Usuario usuario = controlFacade.obtenerUsuario(userId);
        System.out.println("Registrando medición para userId: " + userId);

        if (usuario != null) {
            System.out.print("Ingrese el peso (kg): ");
            double peso = Double.parseDouble(scanner.nextLine());

             System.out.print("Ingrese la estatura (cm): ");
            int tallaCm = Integer.parseInt(scanner.nextLine());
            
             double tallaMetros = tallaCm / 100.0;

            Medicion nuevaMedicion = new Medicion(0, userId, peso, tallaMetros);
            controlFacade.registrarMedicion(nuevaMedicion);
            System.out.println("Medición registrada exitosamente.");
        } else {
            System.out.println("No se encontró un usuario con el ID proporcionado.");
        }
    }

    // Método para consultar mediciones de un usuario
    private static void consultarMediciones(ControlFacade controlFacade, Scanner scanner) {
        System.out.println("\n--- Consultar Mediciones ---");
        System.out.print("Ingrese el ID del usuario: ");
        int userId = Integer.parseInt(scanner.nextLine());

        List<Medicion> mediciones = controlFacade.obtenerMediciones(userId);
        if (mediciones != null && !mediciones.isEmpty()) {
            System.out.println("Mediciones encontradas:");
            for (Medicion medicion : mediciones) {
                System.out.println(medicion);
            }
        } else {
            System.out.println("No se encontraron mediciones para el usuario.");
        }
    }
}
