package com.unitconverter.pojo;

public class ConversionFact {
	private String from;
	private String to;
	private Double factor;

	public ConversionFact(String from, String to, Double factor) {
		this.from = from;
		this.to = to;
		this.factor = factor;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

}
