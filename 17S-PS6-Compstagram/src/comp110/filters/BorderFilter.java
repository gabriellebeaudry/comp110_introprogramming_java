package comp110.filters;

import comp110.Color;
import comp110.Image;

/**
 * Author:Gabrielle Beaudry
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
public class BorderFilter implements Filter {

	public Image process(Image input) {
		// TODO:
		double holder = _amount / 2;
		int thickness = (int) ((input.getWidth()) * holder);

		Image output = input.copy();
		for (int x = 0; x < output.getWidth(); x++) {
			for (int y = 0; y < output.getHeight(); y++) {
				Color pixel = output.getPixel(x, y);
				if (x < thickness || x >= output.getWidth() - thickness || y < thickness
						|| y >= output.getHeight() - thickness) {
					output.setPixel(x, y, _color);
				}

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

	public BorderFilter(double amount, Color color) {
		_amount = amount;
		_color = color;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public Color getColor() {
		return _color;
	}

	public void setColor(Color color) {
		_color = color;
	}

	public String toString() {
		return "Border";
	}

}