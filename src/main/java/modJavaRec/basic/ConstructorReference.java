package modJavaRec.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example for a constructor reference
 * <p>
 * Created : 18.04.2019
 *
 * @author : usauerbrei
 */
@Slf4j
public class ConstructorReference {

	final List<String> names = Arrays.asList("alpha", "beta", "gamma", "delta");

	public static void main(String[] args) {
		new ConstructorReference().doIt();
	}

	private void doIt() {
		createObjectsWithLambda();
		createObjectsWithConstructorReference();
		convertToStreamAndBackWithSameObject();
		convertToStreamAndBackWithCopyConstructorAndDifferentObject();
	}

	// uses constructor from context
	private void convertToStreamAndBackWithCopyConstructorAndDifferentObject() {
		Person before = new Person("Louis");
		List<Person> person = Stream.of(before).map(Person::new).collect(Collectors.toList());
		Person after = person.get(0);
		log.info("Person before and after is equal: {}", before == after);
	}

	private void convertToStreamAndBackWithSameObject() {
		Person before = new Person("Louis");
		List<Person> person = Stream.of(before).collect(Collectors.toList());
		Person after = person.get(0);
		log.info("Person before and after is equal: {}", before == after);
	}

	private void createObjectsWithConstructorReference() {
		final List<Person> people = names.stream().map(Person::new).collect(Collectors.toList());
		log.info("Created people with constructor reference {}", people.toString());
	}

	private void createObjectsWithLambda() {
		final List<Person> people = names.stream().map(name -> new Person(name)).collect(Collectors.toList());
		log.info("Created people with lambda {}", people.toString());
	}
}
