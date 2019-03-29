package decorator;

import java.awt.*;
import java.util.function.Consumer;

/**
 * Main class
 * <p>
 * Created : 12.03.2019
 *
 * @author : usauerbrei
 */
public class Main {

	public static void main(String[] args) {
		new Main().doIt();

	}

	private void doIt() {
		printFilter();
	}

	private void printFilter() {

		final Camera camera = new Camera();
		final Consumer<String> printCaptured = (filterInfo) -> System.out.println(String.format("with %s: %s", filterInfo, camera.capture((new Color(200, 100, 200)))));

		printCaptured.accept("No Filter ");

		camera.setFilters(Color::brighter);
		printCaptured.accept("Brighter Filter ");

		camera.setFilters(Color::darker);
		printCaptured.accept("Darker Filter ");

		camera.setFilters(Color::brighter, Color::darker);
		printCaptured.accept("Brighter -> Darker Filter (Chained)");
	}
}
