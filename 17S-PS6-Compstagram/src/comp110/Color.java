package comp110;

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
public class Color {

	// TODO: 1.1 Declare instance variables
	private double _red;
	private double _green;
	private double _blue;

	// TODO: 1.4 Declare & define constructor
	public Color(double red, double green, double blue) {
		_red = this.limitValue(red);
		_green = this.limitValue(green);
		_blue = this.limitValue(blue);
	}

	// TODO: 1.2 Declare & define getters

	public double getRed() {
		return _red;
	}

	public double getGreen() {
		return _green;
	}

	public double getBlue() {
		return _blue;
	}

	// TODO: 1.3 Declare & define setters

	public void setRed(double value) {
		_red = this.limitValue(value);
	}

	public void setGreen(double value) {
		_green = this.limitValue(value);
	}

	public void setBlue(double value) {
		_blue = this.limitValue(value);
	}

	private double limitValue(double value) {
		if (value > 1.0) {
			return 1.0;
		} else if (value < 0.0) {
			return 0.0;
		} else {
			return value;
		}
	}

	// TODO: 1.5 Declare & define copy method
	public Color copy() {
		Color newinstance = new Color(_red, _green, _blue);
		return newinstance;
	}

}