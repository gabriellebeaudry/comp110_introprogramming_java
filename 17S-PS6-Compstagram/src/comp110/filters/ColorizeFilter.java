package comp110.filters;

import comp110.Color;
import comp110.Image;

/**
 * Author: Gabrielle Beaudry
 *
 * ONYEN:gabbeau
 *
 * Collaborator(s):
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class ColorizeFilter implements Filter {

	public Image process(Image input) {
		// TODO:
		Image output = input.copy();
		for (int x = 0; x < output.getWidth(); x++) {
			for (int y = 0; y < output.getHeight(); y++) {

				Color pixel = output.getPixel(x, y);

				double deltared, deltagreen, deltablue;

				deltared = (pixel.getRed() - _color.getRed()) * _amount;
				deltagreen = (pixel.getGreen() - _color.getGreen()) * _amount;
				deltablue = (pixel.getBlue() - _color.getBlue()) * _amount;

				double outputred, outputgreen, outputblue;
				outputred = (pixel.getRed() - deltared);
				outputgreen = (pixel.getGreen() - deltagreen);
				outputblue = (pixel.getBlue() - deltablue);

				// options for setting output:
				pixel.setRed(outputred);
				pixel.setGreen(outputgreen);
				pixel.setBlue(outputblue);

				// another equivilant option
				// Color color = new Color(outputred, outputgreen, outputblue);
				// output.setPixel(x, y, color);

			}
		}
		return output;
	}

	/*
	 * 110-provided code below. You should understand what it all does but you
	 * should not modify.
	 */

	private double _amount;

	private Color _color;

	public ColorizeFilter(double amount, Color color) {
		this._amount = amount;
		this._color = color;
	}

	public double getAmount() {
		return this._amount;
	}

	public void setAmount(double amount) {
		this._amount = amount;
	}

	public Color getColor() {
		return this._color;
	}

	public void setColor(Color color) {
		this._color = color;
	}

	public String toString() {
		return "Colorize";
	}

}