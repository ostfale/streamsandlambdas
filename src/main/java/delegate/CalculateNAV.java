package delegate;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Perform financial calculations with data from a webservice
 * <p>
 * Created : 05.03.2019
 *
 * @author : usauerbrei
 */
public class CalculateNAV {

	private Function<String, BigDecimal> priceFinder;

	public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
		this.priceFinder = aPriceFinder;
	}

	public BigDecimal computeStockWorth(final String ticker, final int shares) {
		return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}
}
