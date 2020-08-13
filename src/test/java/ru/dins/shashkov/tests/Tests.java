package ru.dins.shashkov.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.dins.shashkov.tests.steps.ChangeUserSteps;
import ru.dins.shashkov.tests.steps.GetNewUserSteps;
import ru.dins.shashkov.tests.steps.PostNewContactSteps;
import ru.dins.shashkov.tests.steps.PostNewUserSteps;
import ru.dins.shashkov.tests.users.Contact;
import ru.dins.shashkov.tests.users.User;

@RunWith(SerenityRunner.class)
public class Tests {
    private User newUser = new User(3, "Tyrion", "Lannister");
    private Contact newContact = new Contact(1,3, "Daenerys",
            "Targaryen","1234567891","No_I_Am_queen@queenmail.com");

    //negative test
    @Steps
    PostNewUserSteps postNewUserSteps;

    @Test
    public void verifyThatWeCantPostUserWhenIdIsWord(){
        postNewUserSteps.addNewUserToPhoneBook();
        postNewUserSteps.isFailed();
    }

    @Steps
    ChangeUserSteps putUserSteps;

    @Test
    public void verifyThatWeCantChangeUserWhenIdIsWord(){
        putUserSteps.changeUserData();
        putUserSteps.isFailed();
    }

    //positive test
    @Steps
    GetNewUserSteps getNewUserSteps;

    @Test
    public void verifyThatWeCanSearchNewUserById(){
        getNewUserSteps.postNewUser(newUser);
        getNewUserSteps.searchNewUserById(newUser.getId());
        getNewUserSteps.isExecutedSuccesfully();
    }

    @Steps
    PostNewContactSteps postNewContactSteps;

    @Test
    public void verifyThatWeCanAddNewContactForUser(){
        postNewContactSteps.addNewContact(newContact);
        postNewContactSteps.isExecutedSuccesfully(newContact);
    }
}
