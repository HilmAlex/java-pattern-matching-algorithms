package models;

import lombok.Data;

@Data
public class Person {
    private String id;
    private String name;
    private String lastName;
    private String email;

    public Person(String[] data){
        this.id = data[0];
        this.name = data[1];
        this.lastName = data[2];
        this.email = data[3];
    }
}
