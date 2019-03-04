package strategy;

import de.ostfale.strategy.Asset.AssetType;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Some util functions
 * <p>
 * Created : 01.03.2019
 *
 * @author : usauerbrei
 */
@Slf4j
public class AssetUtil {

	static final List<de.ostfale.strategy.Asset> assets = Arrays.asList(
			new de.ostfale.strategy.Asset(AssetType.BOND, 1000),
			new de.ostfale.strategy.Asset(AssetType.BOND, 2000),
			new de.ostfale.strategy.Asset(AssetType.STOCK, 3000),
			new de.ostfale.strategy.Asset(AssetType.STOCK, 4000)
	);
	private Predicate<de.ostfale.strategy.Asset> bondPredicate = (de.ostfale.strategy.Asset asset) -> asset.getType() == AssetType.BOND;

	public static void main(String[] args) {
		new AssetUtil().doIt();
	}

	public static int totalAssetValues(final List<de.ostfale.strategy.Asset> assets, final Predicate<de.ostfale.strategy.Asset> assetSelector) {
		return assets.stream()
				       .filter(assetSelector)
				       .mapToInt(de.ostfale.strategy.Asset::getValue)
				       .sum();
	}

	private static int totalStockValues(final List<de.ostfale.strategy.Asset> assets) {
		return assets.stream()
				       .mapToInt(asset -> asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
				       .sum();
	}

	private static int totalBondValues(final List<de.ostfale.strategy.Asset> assets) {
		return assets.stream()
				       .mapToInt(asset -> asset.getType() == AssetType.BOND ? asset.getValue() : 0)
				       .sum();
	}

	private static int totalAssetValues(final List<de.ostfale.strategy.Asset> assets) {
		return assets.stream()
				       .mapToInt(de.ostfale.strategy.Asset::getValue)
				       .sum();
	}

	private void doIt() {
		log.info("Total of all assets:  {} €", totalAssetValues(assets));
		log.info("Total of all Bond assets::  {} €", totalBondValues(assets));
		log.info("Total of all Stock assets::  {} €", totalStockValues(assets));
		log.info("Total of all assets with HO function:  {} €", totalAssetValues(assets, asset -> true));
		log.info("Total of all Bond assets with HO function:  {} €", totalAssetValues(assets, asset -> asset.getType() == de.ostfale.strategy.Asset.AssetType.BOND));
		log.info("Total of all Bond assets with predicate:  {} €", totalAssetValues(assets, bondPredicate));
		log.info("Total of all Stock assets with HO function:  {} €", totalAssetValues(assets, asset -> asset.getType() == de.ostfale.strategy.Asset.AssetType.STOCK));
	}
}
