package delegate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test for {@link CalculateNAV}
 * <p>
 * Created : 05.03.2019
 *
 * @author : usauerbrei
 */
class CalculateNAVTest {

	@Test
	@DisplayName("Test calculation with stubbed values")
	void computeStockWorth() {

		// given
		Function<String, BigDecimal> priceFinder = ticker -> new BigDecimal("6.01");
	//	Function<String, BigDecimal> priceFinder = ticker -> YahooFinance.getPrice("GOOG");
		BigDecimal expected = new BigDecimal("6010.00");

		// when
		final CalculateNAV calculateNAV = new CalculateNAV(priceFinder);

		// then
		assertEquals(0, calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expected), 0.001);
	}
}
