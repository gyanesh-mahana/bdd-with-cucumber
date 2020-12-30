package shouty;

import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StepDefinitions {

	private String messageFromShouter;
	private Network network;
	// private Network network = new Network();
	private HashMap<String, Person> personMap;

	// Whereabout Class (not a part of business rule)
	// for internal use in testing only
	static class Whereabouts {
		public String name;
		public Integer location;

		public Whereabouts(String name, Integer location) {
			this.name = name;
			this.location = location;
		}
	}

	// DataTableType hook is used to transform the DataTable into desired Class type
	@DataTableType
	public Whereabouts definewhereabouts(Map<String, String> entry) {
		return new Whereabouts(entry.get("name"), Integer.parseInt(entry.get("location")));
	}

	// @Before hook to replace
	@Before
	public void createNetwork() {
		// network = new Network(0);
		personMap = new HashMap<String, Person>();
		// messageFromPerson = new ArrayList<String>();
	}

	@Given("the range is {int}")
	public void the_range_is(Integer distance) throws Throwable {
		network = new Network(distance);
	}

	@Given("a person named {word} is located at {int}")
	public void a_person_named_is_located_at(String name, Integer location) throws Throwable {
		personMap.put(name, new Person(network, location));
	}

	@Given("persons are located at")
	public void persons_are_located(List<Whereabouts> whereabouts) {

//		io.cucumber.datatable.DataTable dataTable
//		//Way 1: Using Cell data 
//		personMap.put(dataTable.cell(1, 0), new Person(network, Integer.parseInt(dataTable.cell(1, 1))));
//		personMap.put(dataTable.cell(2, 0), new Person(network, Integer.parseInt(dataTable.cell(2, 1))));

//		//Way 2: Using Maps
//		for(Map<String, String> person : dataTable.asMaps()) {
//			personMap.put(person.get("name"), new Person(network, Integer.parseInt(person.get("location"))));
//		}

		// Way 3: After transforming data into Person object
		for (Whereabouts whereabout : whereabouts) {
			personMap.put(whereabout.name, new Person(network, whereabout.location));
		}
	}

	@When("{word} shouts {string}")
	public void person_shouts(String name, String message) throws Throwable {
		personMap.get(name).shout(message);
		// messageFromPerson.add(message);
		messageFromShouter = message;
	}

	@Then("{word} should hear {word}('s) message")
	public void listener_hears_shouter_message(String listenerName, String shouterName) throws Throwable {
		assertEquals(asList(messageFromShouter), personMap.get(listenerName).getMessagesHeard());
	}

	@Then("{word} should not hear {word}('s) message")
	public void listener_should_not_hear_shouter_message(String listenerName, String shouterName) throws Throwable {
		assertNotEquals(asList(messageFromShouter), personMap.get(listenerName).getMessagesHeard());

	}
}
