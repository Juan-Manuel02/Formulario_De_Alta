import java.util.ArrayList;
import java.util.Scanner;

public class RegistroUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        System.out.println("****** REGISTRO DE USUARIOS ******");
        char continuar;

        // Registro interactivo
        do {
            System.out.println("Nombre completo: ");
            String nombre = sc.nextLine();

            System.out.println("Apellido completo: ");
            String apellido = sc.nextLine();

            System.out.println("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.println("DNI: ");
            String dni = sc.nextLine();

            System.out.println("Telefono: ");
            String movil = sc.nextLine();

            System.out.println("Email: ");
            String email = sc.nextLine();

            // Validaciones
            boolean dniOk = Validador.validarDNI(dni);
            boolean edadOk = Validador.validarEdad(edad);
            boolean emailOk = Validador.validarEmail(email, email);
            boolean movilOk = Validador.validarMovil(movil);

            if (dniOk && edadOk && emailOk && movilOk) {
                Usuario nuevo = new Usuario(dni, nombre, apellido, edad, movil, email);
                usuarios.add(nuevo);
                System.out.println("✔ Usuario registrado.");
            } else {
                System.out.println("❌ Error en los datos:");
                if (!dniOk) System.out.println("  - DNI inválido");
                if (!edadOk) System.out.println("  - Edad fuera de rango (18-65)");
                if (!emailOk) System.out.println("  - Email no válido o no coincide");
                if (!movilOk) System.out.println("  - Móvil inválido");
            }

            // Podemos preguntar al usuario si quiere registrar otro usuario
            System.out.println("¿Quieres registrar otro usuario? (s/n): ");
            continuar = sc.next().toLowerCase().charAt(0);

        } while (continuar == 's');

        // Mostramos los usuarios registrados
        System.out.println("\nUsuarios registrados correctamente:");

        agregarUsuario(usuarios, "12345678Z", "Ana", "López", 30, "612345678", "ana@gmail.com", "ana@gmail.com");
        agregarUsuario(usuarios, "87654321X", "Pedro", "Martínez", 17, "723456789", "pedro@gmail.com", "pedro@gmail.com");
        agregarUsuario(usuarios, "11223344A", "Laura", "Gómez", 25, "634567890", "laura123@gmail.com", "laura123@gmail.com");
        agregarUsuario(usuarios, "99887766B", "Carlos", "Sánchez", 40, "699876543", "carlos@gmail.com", "carlos@gmail.com");

        // Mostramos los usuarios registrados
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        System.out.println("\n******* GRACIAS POR REGISTRARSE, HASTA PRONTO *******");
        sc.close();
    }

    public static void agregarUsuario(ArrayList<Usuario> lista, String dni, String nombre, String apellidos, int edad, String movil, String email, String emailConfirmacion) {
        System.out.println("\nValidando usuario: " + nombre + " " + apellidos);

        boolean dniOk = Validador.validarDNI(dni);
        boolean edadOk = Validador.validarEdad(edad);
        boolean emailOk = Validador.validarEmail(email, email);
        boolean movilOk = Validador.validarMovil(movil);

        if (dniOk && edadOk && emailOk && movilOk) {
            Usuario nuevo = new Usuario(dni, nombre, apellidos, edad, movil, email);
            lista.add(nuevo);
            System.out.println("✔ Usuario registrado correctamente.");

        } else {
            // Mensajes si hay errores
            System.out.println("❌ No se pudo registrar:");
            if (!dniOk) System.out.println("  - DNI inválido");
            if (!edadOk) System.out.println("  - Edad fuera de rango (18-65)");
            if (!emailOk) System.out.println("  - Email inválido o no coincide");
            if (!movilOk) System.out.println("  - Móvil inválido");
        }
    }
}


