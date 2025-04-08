public class Validador {
    public static boolean validarDNI(String dni) {

        if (dni.length() != 9) return false;
        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);
        for (int i = 0; i < numeros.length(); i++) {
            if (!Character.isDigit(numeros.charAt(i))) return false;

        }
        return Character.isLetter(letra);
    }

    // Para poder validar la edad, email y el telefono movil
    public static boolean validarEdad(int edad) {
        return edad >= 18 && edad <= 65;
    }

    public static boolean validarEmail(String email, String confirmacion) {
        return email.equals(confirmacion);
    }

    public static boolean validarMovil(String movil) {
        return movil.length() == 9 && (movil.charAt(0) == '6' || movil.charAt(0) == '7'); // los numeros de telefono son con 6, 7, 8 o 9
    }
}
