package exchange.analyzer.model.autochartist.keylevel;

import exchange.analyzer.model.autochartist.Pattern;

import java.util.List;

public class KLPattern extends Pattern<KLSignal> {

	public KLPattern() {}

	public KLPattern(List<KLSignal> signals) {
		super(signals);
	}
}
