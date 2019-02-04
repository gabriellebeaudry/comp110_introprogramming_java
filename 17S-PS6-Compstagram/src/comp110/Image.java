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
public class Image {

	// TODO: 2.1 Declare _pixels array
	private Color[][] _pixels;

	// TODO: 2.2 Declare & define constructor
	public Image(int width, int height) {
		_pixels = new Color[width][height];

		for (int x = 0; x < _pixels.length; x++) {
			for (int y = 0; y < _pixels[x].length; y++) {
				_pixels[x][y] = new Color(1.0, 1.0, 1.0);
			}
		}
	}

	// TODO: 2.3 Define width / height getters
	public int getWidth() {
		return _pixels.length;
	}

	public int getHeight() {
		return _pixels[0].length;
	}
	// test in ImageTests??

	// TODO: 2.4 Define pixel getter/setter
	public Color getPixel(int x, int y) {
		return _pixels[x][y];
	}

	public void setPixel(int x, int y, Color color) {
		_pixels[x][y] = color;
	}

	// TODO: 2.5 Define copy method
	public Image copy() {
		Image newimage = new Image(this.getWidth(), this.getHeight());
		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {
				// set the pixels to be the same color as "this"
				newimage.setPixel(x, y, this.getPixel(x, y).copy());
			}
		}
		return newimage;
	}

}
