package de.ostfale.strategy;

/**
 * Simple pojoe
 * <p>
 * Created : 01.03.2019
 *
 * @author : usauerbrei
 */
public class Asset {

	private final AssetType type;
	private final int value;

	public Asset(AssetType type, int value) {
		this.type = type;
		this.value = value;
	}

	public AssetType getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	public enum AssetType {BOND, STOCK}
}
