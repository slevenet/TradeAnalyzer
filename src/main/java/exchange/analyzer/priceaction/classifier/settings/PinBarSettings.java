package exchange.analyzer.priceaction.classifier.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties
@PropertySource("classpath:/pin_bar.properties")
@Component
public class PinBarSettings {

	@Value("${include_custom_settings}")
	private boolean includeCustomSettings;
	@Value("${max_nose_body_size}")
	private float maxNoseBodySize;
	@Value("${nose_body_position}")
	private float noseBodyPosition;
	@Value("${left_eye_opposite_direction}")
	private boolean leftEyeOppositeDirection;
	@Value("${nose_body_inside_left_eye_body}")
	private boolean noseBodyInsideLeftEyeBody;
	@Value("${left_eye_min_body_size}")
	private float leftEyeMinBodySize;
	@Value("${nose_protruding}")
	private float noseProtruding;
	@Value("${nose_body_to_left_eye_body}")
	private float noseBodyToLeftEyeBody;
	@Value("${nose_length_to_left_eye_length}")
	private float noseLengthToLeftEyeLength;
	@Value("${left_eye_depth}")
	private float leftEyeDepth;

	public boolean isIncludeCustomSettings() {
		return includeCustomSettings;
	}

	public float getMaxNoseBodySize() {
		return maxNoseBodySize;
	}

	public float getNoseBodyPosition() {
		return noseBodyPosition;
	}

	public boolean isLeftEyeOppositeDirection() {
		return leftEyeOppositeDirection;
	}

	public boolean isNoseBodyInsideLeftEyeBody() {
		return noseBodyInsideLeftEyeBody;
	}

	public float getLeftEyeMinBodySize() {
		return leftEyeMinBodySize;
	}

	public float getNoseProtruding() {
		return noseProtruding;
	}

	public float getNoseBodyToLeftEyeBody() {
		return noseBodyToLeftEyeBody;
	}

	public float getNoseLengthToLeftEyeLength() {
		return noseLengthToLeftEyeLength;
	}

	public float getLeftEyeDepth() {
		return leftEyeDepth;
	}

	public void setIncludeCustomSettings(boolean includeCustomSettings) {
		this.includeCustomSettings = includeCustomSettings;
	}

	public void setMaxNoseBodySize(float maxNoseBodySize) {
		this.maxNoseBodySize = maxNoseBodySize;
	}

	public void setNoseBodyPosition(float noseBodyPosition) {
		this.noseBodyPosition = noseBodyPosition;
	}

	public void setLeftEyeOppositeDirection(boolean leftEyeOppositeDirection) {
		this.leftEyeOppositeDirection = leftEyeOppositeDirection;
	}

	public void setNoseBodyInsideLeftEyeBody(boolean noseBodyInsideLeftEyeBody) {
		this.noseBodyInsideLeftEyeBody = noseBodyInsideLeftEyeBody;
	}

	public void setLeftEyeMinBodySize(float leftEyeMinBodySize) {
		this.leftEyeMinBodySize = leftEyeMinBodySize;
	}

	public void setNoseProtruding(float noseProtruding) {
		this.noseProtruding = noseProtruding;
	}

	public void setNoseBodyToLeftEyeBody(float noseBodyToLeftEyeBody) {
		this.noseBodyToLeftEyeBody = noseBodyToLeftEyeBody;
	}

	public void setNoseLengthToLeftEyeLength(float noseLengthToLeftEyeLength) {
		this.noseLengthToLeftEyeLength = noseLengthToLeftEyeLength;
	}

	public void setLeftEyeDepth(float leftEyeDepth) {
		this.leftEyeDepth = leftEyeDepth;
	}
}
