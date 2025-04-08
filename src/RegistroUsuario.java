import java.util.ArrayList;

public class RegistroUsuario {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Usuario> usuarios = new ArrayList<>();

        agregarUsuario(usuarios, "12345678Z", "Ana", "López", 30, "612345678", "ana@gmail.com", "ana@gmail.com");
        agregarUsuario(usuarios, "87654321X", "Pedro", "Martínez", 17, "723456789", "pedro@gmail.com", "pedro@gmail.com");
        agregarUsuario(usuarios, "11223344A", "Laura", "Gómez", 25, "634567890", "laura@gmail.com", "laura123@gmail.com");
        agregarUsuario(usuarios, "99887766B", "Carlos", "Sánchez", 40, "699876543", "carlos@gmail.com", "carlos@gmail.com");

        System.out.println("\nUsuarios registrados correctamente:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public static void agregarUsuario(ArrayList<Usuario> lista, String dni, String nombre, String apellidos, int edad, String movil, String email, String emailConfirmacion) {
        System.out.println("\nValidando usuario: " + nombre + " " + apellidos);

        boolean dniOk = Validador.validarDNI(dni);
        boolean edadOk = Validador.validarEdad(edad);
        boolean emailOk = Validador.validarEmail(email, emailConfirmacion);
        boolean movilOk = Validador.validarMovil(movil);

        if (dniOk && edadOk && emailOk && movilOk) {
            Usuario nuevo = new Usuario(dni, nombre, apellidos, edad, movil, email);
            lista.add(nuevo);
            System.out.println("✔ Usuario registrado.");
        } else {
            System.out.println("❌ Error en los datos:");
            if (!dniOk) System.out.println("  - DNI inválido");
            if (!edadOk) System.out.println("  - Edad fuera de rango (18-65)");
            if (!emailOk) System.out.println("  - Email no válido o no coincide");
            if (!movilOk) System.out.println("  - Móvil inválido");
        }
    }
}

