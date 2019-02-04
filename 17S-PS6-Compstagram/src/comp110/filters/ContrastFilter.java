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
public class ContrastFilter implements Filter {

	public Image process(Image input) {
		// TODO:
		Image output = input.copy();
		for (int x = 0; x < output.getWidth(); x++) {
			for (int y = 0; y < output.getHeight(); y++) {

				Color pixel = output.getPixel(x, y);

				// factor contrast
				double factorcontrast = (0.5 - _amount) * 2.0;

				// target
				Color color = new Color(0.5, 0.5, 0.5);

				double deltared, deltagreen, deltablue;
				deltared = (pixel.getRed() - color.getRed()) * factorcontrast;
				deltagreen = (pixel.getGreen() - color.getGreen()) * factorcontrast;
				deltablue = (pixel.getBlue() - color.getBlue()) * factorcontrast;

				double outputred, outputgreen, outputblue;
				outputred = (pixel.getRed() - deltared);
				outputgreen = (pixel.getGreen() - deltagreen);
				outputblue = (pixel.getBlue() - deltablue);

				// options for setting output:
				pixel.setRed(outputred);
				pixel.setGreen(outputgreen);
				pixel.setBlue(outputblue);
			}
		}

		return output;
	}

	/*
	 * 110-provided code below. You should understand what it all does but you
	 * should not modify.
	 */

	private double _amount;

	public ContrastFilter(double amount) {
		_amount = amount;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String toString() {
		return "Contrast";
	}

}