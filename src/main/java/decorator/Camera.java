package decorator;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Example for delegates in a decorator pattern
 * <p>
 * Created : 06.03.2019
 *
 * @author : usauerbrei
 */
public class Camera {

	private Function<Color, Color> filter;

	public Camera() {
		setFilters();
	}

	public void setFilters(final Function<Color, Color>... filters) {
		filter = Stream.of(filters)
				         .reduce((filter, next) -> filter.compose(next))
				         .orElse(color -> color);
	}

	public Color capture(final Color inputColor) {
		return filter.apply(inputColor);
	}
}
