package exchange.analyzer.innerLogics.keyManager;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.InstrumentName;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KeyManager {

    private static List<CurrencyKey> keys = new ArrayList<>();

    private KeyManager() {
    }

    public static CurrencyKey getKey(InstrumentName instrumentName, CandlestickGranularity granularity) {
        Optional<CurrencyKey> key = keys.stream()
                .filter(currencyKey -> currencyKey.getCurrency()
                        .equals(instrumentName))
                .filter(currencyKey -> currencyKey.getGranularity().equals(granularity))
                .findAny();

        CurrencyKey currencyKey;

        if (!key.isPresent())
        {
            currencyKey = new CurrencyKey(instrumentName, granularity);
            keys.add(currencyKey);
        }
        else
        {
            currencyKey = key.get();
        }

        return currencyKey;
    }
}
