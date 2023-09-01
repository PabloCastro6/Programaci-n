import java.sql.SQLException;
import java.util.Scanner;

import dto.AlumnoDTO;
import model.AlumnoModelo;



public class Principal {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        menuPrincipal(sc);
        sc.close();
    }

    public static void menuPrincipal(Scanner sc) throws ClassNotFoundException {
        int accion = 0;
        do {
            System.out.flush();
            System.out.println("\nAPLICACIÓN ALUMNOS");
            System.out.println("1. Crear alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Borrar alumno");
            System.out.println("5. Salir");
            System.out.print("¿Qué acción deseas ejecutar?: ");
            accion = sc.nextInt();
            sc.nextLine();
            try {
                switch (accion) {
                    case 1:
                        crearAlumno(sc);
                        break;
                    case 2:
                        buscarAlumno(sc);
                        break;
                    case 3:
                        actualizarAlumno(sc);
                        break;
                    case 4:
                        borrarAlumno(sc);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
                }
            } catch (SQLException exception) {
                exception.printStackTrace(); 
            }
        } while (accion != 5);
    }

    public static void crearAlumno(Scanner sc) throws SQLException {
        AlumnoDTO alumno = new AlumnoDTO();
        System.out.flush();
        System.out.println("\nCREAR ALUMNO");
        System.out.print("Nombre: ");
        alumno.setNombre(sc.nextLine());
        System.out.print("id_municipio: ");
        alumno.setIdMunicipio(sc.nextLine());
        System.out.print("familia_numerosa: ");
        alumno.setFamiliaNumerosa(sc.nextLine());
        
        boolean exito = AlumnoModelo.crear(alumno);
        if (exito) {
            System.out.println("Cliente creado correctamente.");
        } else {
            System.out.println("Cliente no creado.");
        }
    }

    public static void buscarAlumno(Scanner sc) throws SQLException, ClassNotFoundException {
        System.out.flush();
        System.out.println("\nBUSCAR ALUMNO");
        System.out.print("Introduce el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        AlumnoDTO alumno = null;
		try {
			alumno = (AlumnoDTO) AlumnoModelo.buscar(id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        if (alumno != null) {
            System.out.println("ID: " + alumno.getId());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("id_municipio: " + alumno.getIdMunicipio());
            System.out.println("familia_numerosa: " + alumno.getFamiliaNumerosa());
     
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public static void actualizarAlumno(Scanner sc) throws SQLException {
    	AlumnoDTO alumno = new AlumnoDTO();
        String input;
        System.out.flush();
        System.out.println("\nACTUALIZAR ALUMNO");
        System.out.print("Introduce el id: ");
        int id = sc.nextInt();
        alumno.setId(id);
        sc.nextLine();
        System.out.print("Nombre: ");
        input = sc.nextLine();
        alumno.setNombre(input);
        System.out.print("id_municipio: ");
        input = sc.nextLine();
        alumno.setIdMunicipio(input);
        System.out.print("familia_numerosa: ");
        input = sc.nextLine();
        alumno.setFamiliaNumerosa(input);
        
        boolean exito = AlumnoModelo.actualizar(alumno);
        if (exito) {
            System.out.println("Alumno actualizado correctamente.");
        } else {
            System.out.println("Alumno no actualizado.");
        }
    }

    public static void borrarAlumno(Scanner sc) throws SQLException, ClassNotFoundException {
        System.out.flush();
        System.out.println("\nBORRAR ALUMNO");
        System.out.print("Introduce el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean exito = AlumnoModelo.borrar(id);
        if (exito) {
            System.out.println("Alumno borrado correctamente.");
        } else {
            System.out.println("Alumno no borrado.");
        }
    }
}
