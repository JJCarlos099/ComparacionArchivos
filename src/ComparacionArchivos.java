import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ComparacionArchivos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del primer archivo: ");
        String archivo1 = scanner.nextLine();

        System.out.println("Ingrese el texto para el primer archivo: ");
        String contenido1 = scanner.nextLine();

        System.out.println("Ingrese el nombre del segundo archivo: ");
        String archivo2 = scanner.nextLine();

        System.out.println("Ingrese el texto para el segundo archivo: ");
        String contenido2 = scanner.nextLine();


        try {
            crearArchivo(archivo1, contenido1);
            crearArchivo(archivo2, contenido2);

            int resultado = compararCaracteres(contenido1, contenido2);

            if (resultado == 1) {
                System.out.println("El archivo '" + archivo1 + "' es mayor carácter a carácter que el archivo '" + archivo2 + "'.");
            } else if (resultado == -1) {
                System.out.println("El archivo '" + archivo2 + "' es mayor carácter a carácter que el archivo '" + archivo1 + "'.");
            } else {
                System.out.println("Los archivos tienen el mismo tamaño y los mismos caracteres.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear los archivos.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void crearArchivo(String nombreArchivo, String contenido) throws IOException {
        try (FileWriter archivo = new FileWriter(nombreArchivo + ".txt")) {
            archivo.write(contenido);
        }
    }

    private static int compararCaracteres(String contenido1, String contenido2) {
        int longitud1 = contenido1.length();
        int longitud2 = contenido2.length();
        int longitudMinima = Math.min(longitud1, longitud2);

        for (int i = 0; i < longitudMinima; i++) {
            char caracter1 = contenido1.charAt(i);
            char caracter2 = contenido2.charAt(i);

            if (caracter1 > caracter2) {
                return 1;
            } else if (caracter1 < caracter2) {
                return -1;
            }
        }

        if (longitud1 > longitud2) {
            return 1;
        } else if (longitud1 < longitud2) {
            return -1;
        } else {
            return 0;
        }
    }
}
