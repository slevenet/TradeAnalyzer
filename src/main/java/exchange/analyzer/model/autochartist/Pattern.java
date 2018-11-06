package exchange.analyzer.model.autochartist;

import java.io.Serializable;
import java.util.List;

public abstract class Pattern<S extends Signal> implements Serializable {

	private List<S> signals;

	protected Pattern() {}

	protected Pattern(List<S> signals) {
		this.signals = signals;
	}

	public List<S> getSignals() {
		return signals;
	}

	public void setSignals(List<S> signals) {
		this.signals = signals;
	}
}
