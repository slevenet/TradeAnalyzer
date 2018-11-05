package exchange.analyzer.model.autochartist;

import org.springframework.util.StringUtils;

public class PatternRequest {

    private static final String URL = "https://api-fxpractice.oanda.com/labs/v1/signal/autochartist";

    private final String  instrument;
    private final int     period;
    private final int     quality;
    private final String  type;
    private final String  direction;

    private PatternRequest(Builder builder) {
        this.instrument = builder.instrument;
        this.period     = builder.period;
        this.quality    = builder.quality;
        this.type       = builder.type;
        this.direction  = builder.direction;
    }

    public static class Builder{
        private String  instrument;
        private int     period;
        private int     quality;
        private String  type;
        private String  direction;

        public PatternRequest build(){
            return new PatternRequest(this);
        }

        public Builder instrument(String instrument){
            this.instrument = instrument;
            return this;
        }

        public Builder period(int period){
            this.period = period;
            return this;
        }

        public Builder quality(int quality){
            this.quality = quality;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder direction(String direction){
            this.direction = direction;
            return this;
        }
    }

    @Override
    public String toString() {

        if (StringUtils.isEmpty(instrument)
                && StringUtils.isEmpty(period)
                && StringUtils.isEmpty(quality)
                && StringUtils.isEmpty(type)
                && StringUtils.isEmpty(direction))
            return URL;

        StringBuilder requestBuilder = new StringBuilder(URL).append("?");

        if (!StringUtils.isEmpty(instrument))
            requestBuilder.append("instrument=").append(instrument).append("&");
        if (!StringUtils.isEmpty(period))
            requestBuilder.append("period=").append(period).append("&");
        if (!StringUtils.isEmpty(quality))
            requestBuilder.append("quality=").append(quality).append("&");
        if (!StringUtils.isEmpty(type))
            requestBuilder.append("type=").append(type).append("&");
        if (!StringUtils.isEmpty(direction))
            requestBuilder.append("direction=").append(direction).append("&");

        return requestBuilder.deleteCharAt(requestBuilder.length() - 1).toString();
    }
}
