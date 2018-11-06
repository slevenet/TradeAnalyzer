package exchange.analyzer.model.autochartist.keylevel;

import exchange.analyzer.model.autochartist.AbstractPoints;

public class KLPoints extends AbstractPoints {

	private KLPoint keytime;

	public KLPoints() {}

	public KLPoints(KLPoint keytime) {
		this.keytime = keytime;
	}

	public KLPoint getKeytime() {
		return keytime;
	}

	public void setKeytime(KLPoint keytime) {
		this.keytime = keytime;
	}
}
