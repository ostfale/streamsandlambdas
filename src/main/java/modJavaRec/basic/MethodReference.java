package modJavaRec.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
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

	public static void main(String[] args) {
		new MethodReference().doIt();
	}

	private void doIt() {
		simpleExample();
		usingVariable();
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
