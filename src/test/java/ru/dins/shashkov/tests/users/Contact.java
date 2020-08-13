package ru.dins.shashkov.tests.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Contact {
    private int userId;
    private int contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
