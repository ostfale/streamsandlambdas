package modJavaRec.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Examples for method references
 * <p>
 * Created : 17.04.2019
 *
 * @author : usauerbrei
 */
@Slf4j
public class MethodReference {

	private static final List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

	public static void main(String[] args) {
		new MethodReference().doIt();
	}

	private void doIt() {
		simpleExample();
		usingVariable();
		compareWithCompareTo();
		compareWithMethodReference();
		usingLengthExample();
	}

	private void usingLengthExample() {
		strings.stream().map(String::length).forEach(System.out::println);
	}

	private void compareWithMethodReference() {
		List<String> sortetString = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
		log.info("List of sorted string with method reference {}" + sortetString.toString());
	}

	private void compareWithCompareTo() {
		List<String> sortetString = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		log.info("List of sorted string with compareTo: {}" + sortetString.toString());
	}

	private void usingVariable() {
		Consumer<Integer> printer = System.out::println;
		Stream.of(3, 1, 4, 5, 9).forEach(printer);
	}

	private void simpleExample() {
		Stream.of(3, 1, 4, 1, 5, 9).forEach(x -> System.out.println("Val sout: " + x));
		Stream.of(3, 1, 4, 1, 5, 9).forEach(System.out::println);
	}
}
