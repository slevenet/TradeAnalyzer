package exchange.analyzer.model.autochartist.keylevel;

import com.fasterxml.jackson.annotation.JsonProperty;
import exchange.analyzer.model.autochartist.chartpattern.AbstractPoint;

public class KLPoint extends AbstractPoint {

	@JsonProperty("1")
	private long t1;
	@JsonProperty("2")
	private long t2;
	@JsonProperty("3")
	private long t3;
	@JsonProperty("4")
	private long t4;
	@JsonProperty("5")
	private long t5;
	@JsonProperty("6")
	private long t6;
	@JsonProperty("7")
	private long t7;
	@JsonProperty("8")
	private long t8;
	@JsonProperty("9")
	private long t9;
	@JsonProperty("10")
	private long t10;

	public KLPoint() {}

	public KLPoint(long x0, long x1, long t1, long t2, long t3, long t4, long t5, long t6, long t7, long t8, long t9, long t10) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
		this.t7 = t7;
		this.t8 = t8;
		this.t9 = t9;
		this.t10 = t10;
	}

	public long getT1() {
		return t1;
	}

	public long getT2() {
		return t2;
	}

	public long getT3() {
		return t3;
	}

	public long getT4() {
		return t4;
	}

	public long getT5() {
		return t5;
	}

	public long getT6() {
		return t6;
	}

	public long getT7() {
		return t7;
	}

	public long getT8() {
		return t8;
	}

	public long getT9() {
		return t9;
	}

	public long getT10() {
		return t10;
	}

	public void setT1(long t1) {
		this.t1 = t1;
	}

	public void setT2(long t2) {
		this.t2 = t2;
	}

	public void setT3(long t3) {
		this.t3 = t3;
	}

	public void setT4(long t4) {
		this.t4 = t4;
	}

	public void setT5(long t5) {
		this.t5 = t5;
	}

	public void setT6(long t6) {
		this.t6 = t6;
	}

	public void setT7(long t7) {
		this.t7 = t7;
	}

	public void setT8(long t8) {
		this.t8 = t8;
	}

	public void setT9(long t9) {
		this.t9 = t9;
	}

	public void setT10(long t10) {
		this.t10 = t10;
	}
}
