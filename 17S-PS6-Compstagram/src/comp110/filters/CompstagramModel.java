package comp110.filters;

import java.util.ArrayList;
import java.util.List;

import comp110.Color;
import comp110.Image;

public class CompstagramModel {

	private Image _input;

	private List<Filter> _filters;

	public CompstagramModel() {
		_filters = new ArrayList<Filter>();

		Color carolinaBlue = new Color(0.482, 0.686, 0.831);

		// TODO: Uncomment each Filter as you work on it.

		// TODO: 3.7 - Saturation
		_filters.add(new SaturationFilter(0.5));

		// TODO: 3.6 - Contrast
		_filters.add(new ContrastFilter(0.5));

		// TODO: 3.5 - Colorize
		_filters.add(new ColorizeFilter(0.0, carolinaBlue));

		// TODO: 3.4 - Brightness
		_filters.add(new BrightnessFilter(0.5));

		// TODO: 3.3 - Border
		_filters.add(new BorderFilter(0.0, carolinaBlue));

		// TODO: 3.2 - Invert
		_filters.add(new InvertFilter(0.0));

	}

	public void setInput(Image input) {
		_input = input;
	}

	public Image getInput() {
		return _input;
	}

	public List<Filter> getFilters() {
		return _filters;
	}

}