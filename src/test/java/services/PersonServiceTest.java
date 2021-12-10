package services;

import data.PersonData;
import models.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    PersonService service = PersonService.getInstance();
    @Test
    void read() {
        String src = "C:\\Users\\perso\\IdeaProjects\\demo-pattern-matching-algorithms\\src\\main\\resources\\LeakedData.txt";
        service.read(src);

        PersonData data = PersonData.getInstance();
    }
}