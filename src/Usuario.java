public class Usuario {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String movil;
    private final String email;


    // Constructor
    public Usuario(String dni, String nombre, String apellido, int edad, String movil, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.movil = movil;
        this.email = email;
    }

    // To String
    @Override
    public String toString() {
        return "\n[Usuario" +
                "\nDni: " + dni +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nEdad: " + edad +
                "\nMovil: " + movil +
                "\nEmail: " + email + "]";
    }
}
