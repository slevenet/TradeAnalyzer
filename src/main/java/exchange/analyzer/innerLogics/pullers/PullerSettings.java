package exchange.analyzer.innerLogics.pullers;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Component
public class PullerSettings {

    private static String[] granularities;
    private static String[] currencies;

    public PullerSettings() {
    }

    public static String[] getGranularities() {
        return granularities;
    }

    public static void setGranularities(String[] granularities) {
        PullerSettings.granularities = granularities;
    }

    public static String[] getCurrencies() {
        return currencies;
    }

    public static void setCurrencies(String[] currencies) {
        PullerSettings.currencies = currencies;
    }
}
