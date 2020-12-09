package shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import java.util.ArrayList;
import java.util.HashMap;
import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;


public class StepDefinitions {

    private Person person;
    private Person lucy;
    private String messageFromPerson;
    private Network network;
    //private Network network = new Network();
    private HashMap<String, Person> personMap;
    
    //@Before hook to replace 
    @Before
    public void createNetwork() {
    	network = new Network(); 
    	personMap = new HashMap<String, Person>();
    	//messageFromPerson = new ArrayList<String>();
    }
    
    @Given("a person named {word}")
    public void a_person_named(String name) throws Throwable {
        //create a person named Lucy
    	personMap.put(name, new Person(network));
    }

    @When("{word} shouts {string}")
    public void person_shouts(String name, String message) throws Throwable {
        personMap.get(name).shout(message);
        //messageFromPerson.add(message);
        messageFromPerson = message;
    }

    @Then("{word} should hear {word}'s message")
    public void lucy_hears_Sean_s_message(String name1, String name2) throws Throwable {
        assertEquals(asList(messageFromPerson), personMap.get(name1).getMessagesHeard());
    }
}
