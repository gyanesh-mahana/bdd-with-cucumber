package shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import java.util.ArrayList;
import java.util.HashMap;
import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StepDefinitions {

//	private Person person;
//	private Person lucy;
	private String messageFromShouter;
	private Network network;
	// private Network network = new Network();
	private HashMap<String, Person> personMap;

	// @Before hook to replace
	@Before
	public void createNetwork() {
		//network = new Network(0);
		personMap = new HashMap<String, Person>();
		// messageFromPerson = new ArrayList<String>();
	}

//	@Given("a person named {word}")
//	public void a_person_named(String name) throws Throwable {
//		// create a person named Lucy
//		personMap.put(name, new Person(network, 0));
//	}

	@When("{word} shouts {string}")
	public void person_shouts(String name, String message) throws Throwable {
		personMap.get(name).shout(message);
		// messageFromPerson.add(message);
		messageFromShouter = message;
	}

	@Then("{word} should hear {word}'s message")
	public void listener_hears_shouter_message(String listenerName, String shouterName) throws Throwable {
		assertEquals(asList(messageFromShouter), personMap.get(listenerName).getMessagesHeard());
	}
	
	@Given("the range is {int}")
	public void the_range_is(Integer distance) throws Throwable {
		network = new Network(distance);
	}

	@Given("a person named {word} is located at {int}")
	public void a_person_named_is_located_at(String name, Integer location) throws Throwable {
		personMap.put(name, new Person(network, location));
	}
	
	@Then("{word} should not hear {word}'s message")
	public void listener_should_not_hear_shouter_message(String listenerName, String shouterName) throws Throwable {
		assertNotEquals(asList(messageFromShouter), personMap.get(listenerName).getMessagesHeard());
		
	}

}
