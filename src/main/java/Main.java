import java.io.File;
import java.util.List;
import java.util.function.Consumer;

import data.PersonData;
import models.Person;
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

        // Impresión de valores
        List<Person> dataBM = data.getByEmailsUsingBoyerMoore(emails);

        /* Rendimiento */

        // Brute Force
        Performance.time(domains -> data.getByEmailsUsingBoyerMoore(emails), emails);

        // KMP
        Performance.time(domains -> data.getByEmailsUsingBoyerMoore(emails), emails);
        
        // Boyer Moore
        Performance.time(domains -> data.getByEmailsUsingBoyerMoore(emails), emails);

        

        
    }
}
