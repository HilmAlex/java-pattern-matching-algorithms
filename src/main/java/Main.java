import java.io.File;
import java.util.List;
import java.util.function.Consumer;

import data.PersonData;
import model.Person;
import services.PersonService;
import utils.Performance;

public class Main {
    public static void main(String[] args) {
        PersonService service = PersonService.getInstance();
        PersonData data = PersonData.getInstance();
        String src = new File(".").getAbsolutePath() + "/src/main/resources/LeakedData.txt";

        // Lectura del archivo y almacenamiento de cada registro en un objeto, tomando
        // en cuenta los 3 primeros datos
        service.read(src);

        // Emails a buscar
        String[] emails = { "gmail.com", "yahoo.com" };

        // Obtencion de datos
        List<Person> dataBruteForce = data.getByEmailsUsingBruteForce(emails);
        List<Person> dataKMP = data.getByEmailsUsingKMP(emails);
        List<Person> dataBoyerMoore = data.getByEmailsUsingBoyerMoore(emails);

        // Impresion
        System.out.println("Personas que tienen un correo en gmail: " + dataKMP.size());
        System.out.println("Nombres y apellidos de dichas personas");
        dataKMP.forEach(person -> {
            System.out.println(person.getName() + " " + person.getLastName());
        });

        /* Rendimiento */
        System.out.println("\nTiempo de ejecucion de cada algoritmo - Promedio de 1 millon de ejecuciones");

        // Brute Force
        System.out.println("\nFuerza Bruta");
        Performance.time(domains -> data.getByEmailsUsingBruteForce(emails), emails);

        // KMP
        System.out.println("\nKMP");
        Performance.time(domains -> data.getByEmailsUsingKMP(emails), emails);

        // Boyer Moore
        System.out.println("\nBoyer Moore");
        Performance.time(domains -> data.getByEmailsUsingBoyerMoore(emails), emails);
    }
}
