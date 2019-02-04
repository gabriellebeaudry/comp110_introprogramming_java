package comp110.filters;

import comp110.Color;
import comp110.Image;

/**
 * Author: Gabrielle Beaudry
 *
 * ONYEN: gabbeau
 *
 * Collaborator(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class BrightnessFilter implements Filter {

	public Image process(Image input) {
		// TODO
		double brightness = ((_amount - 0.5) * 2.0);

		Image output = input.copy();
		for (int x = 0; x < output.getWidth(); x++) {
			for (int y = 0; y < output.getHeight(); y++) {

				Color pixel = output.getPixel(x, y);
				double red, green, blue;
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();

				Color inpixel = input.getPixel(x, y);
				double inputred, inputgreen, inputblue;
				inputred = inpixel.getRed();
				inputgreen = inpixel.getGreen();
				inputblue = inpixel.getBlue();

				pixel.setRed(inputred + (brightness * inputred));
				pixel.setGreen(inputgreen + (brightness * inputgreen));
				pixel.setBlue(inputblue + (brightness * inputblue));

			}
		}
		return output;
		// brightness shows up in the pull down but doesn't do anything
	}

	/*
	 * 110-provided code below. You should understand what it all does but you
	 * should not modify.
	 */

	private double _amount;

	public BrightnessFilter(double amount) {
		_amount = amount;
	}

	public String toString() {
		return "Brightness";
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

}