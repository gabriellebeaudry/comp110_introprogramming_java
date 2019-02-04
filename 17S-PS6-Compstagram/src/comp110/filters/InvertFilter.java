package comp110.filters;

import comp110.Color;
import comp110.Image;

public class InvertFilter implements Filter {

	/*
	 * The method of each effect *you* will get to implement is the process
	 * method.
	 * 
	 * The Invert Effect's process method is provided to you as an example for
	 * some ideas on how to implement an image processing algorithm given an input
	 * image. All of yours will also create a copy, iterate through each pixel
	 * using a nested for loop, and get/set each pixel applying some logic and/or
	 * math to manipulate it.
	 */
	public Image process(Image input) {
		// First we'll setup our output image by copying the input image.
		Image output = input.copy();

		// We'll work our way through the image one pixel at a time
		for (int x = 0; x < output.getWidth(); x++) {
			for (int y = 0; y < output.getHeight(); y++) {

				// Grab the pixel at x, y and store it in a local variable named pixel
				Color pixel = output.getPixel(x, y);

				// Setup some local variables to store the R, G, B values for easier
				// access than having to call the getter methods each time.
				double red, green, blue;
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();

				// The goal of this effect, when applied with an amount of 1.0 or 100%,
				// is for black to become white, red to become cyan, green to become
				// purple, blue to become yellow, etc. Coming in, we know our component
				// values *must* be between 0.0 and 1.0. Thus, we can "invert" a
				// component by subtracting it from 1.0:
				//
				// Original Formula Inverted
				// ======== ======= ========
				// 0.00 -> 1.0 - 0.00 -> 1.00
				// 0.25 -> 1.0 - 0.25 -> 0.75
				// 0.50 -> 1.0 - 0.50 -> 0.50
				// 0.75 -> 1.0 - 0.75 -> 0.25
				// 1.00 -> 1.0 - 1.00 -> 0.00
				double redInverted, greenInverted, blueInverted;
				redInverted = 1.0 - red;
				greenInverted = 1.0 - green;
				blueInverted = 1.0 - blue;

				// This is Carolina. We're not making effects that are merely "on"
				// or "off" -- nope -- we're making effects that can be applied
				// with a variable amount between 0.0 and 1.0. QR credit FTW.
				//
				// For the invert effect, an `amount` of 0.0 means 0% inverted,
				// 0.5 means 50% inverted, and 1.0 means 100% inverted.
				//
				// The way we'll do this is first figure out how far apart our
				// original component is from our fully inverted component with
				// subtraction.
				// Then we'll take that distance and multiply it by the percentage
				// *amount*.
				//
				// This will give us a delta we can subtract from our original value.
				double redDelta, greenDelta, blueDelta;
				redDelta = (red - redInverted) * _amount;
				greenDelta = (green - greenInverted) * _amount;
				blueDelta = (blue - blueInverted) * _amount;

				// Finally, we'll subtract that delta from our original component
				// value and we have a completed parametric invert effect!
				pixel.setRed(red - redDelta);
				pixel.setGreen(green - greenDelta);
				pixel.setBlue(blue - blueDelta);
			}
		}

		return output;
	}

	/*
	 * The _amount instance variable holds
	 */
	private double _amount;

	/* Constructors */
	public InvertFilter(double amount) {
		_amount = amount;
	}

	/* Instance Methods */
	public String toString() {
		return "Invert";
	}

	/* Accessor Methods */
	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

}