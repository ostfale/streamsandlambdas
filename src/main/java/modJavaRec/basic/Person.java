package modJavaRec.basic;

import lombok.Data;

/**
 * Simple pojo
 * <p>
 * Created : 18.04.2019
 *
 * @author : usauerbrei
 */
@Data
public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	public Person(Person person) {
		this.name = person.name;
	}
}
