package services;

import data.PersonData;
import models.Person;

import java.io.File;
import java.util.Scanner;

public class PersonService {

    private static PersonService instance = null;

    private PersonService() {
    }

    public static PersonService getInstance() {
        if (instance == null)
            instance = new PersonService();

        return instance;
    }

    public void read(String src) {
        try {
            PersonData persons = PersonData.getInstance();
            File file = new File(src);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                String[] currentData = currentLine.split(",");

                Person currentPerson = new Person(currentData);

                // Añadir la persona de la linea actual a la clase PersonsData
                persons.add(currentPerson);

            }

            myReader.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            throw new Error(e.getMessage());
        }
    }
}
