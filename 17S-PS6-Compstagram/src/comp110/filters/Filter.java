package comp110.filters;

import comp110.Image;

public interface Filter {

	/* Implement toString to give a Filter a name. */
	public String toString();

	/*
	 * The amount property controls the intensity with which a filter is applied.
	 */
	public double getAmount();

	public void setAmount(double amount);

	/*
	 * The process method takes in an Image and returns a clone of the Image that
	 * has been fully processed by the filter based on its amount.
	 */
	public Image process(Image image);

}