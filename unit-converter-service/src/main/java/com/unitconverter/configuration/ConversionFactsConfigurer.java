package com.unitconverter.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.unitconverter.pojo.ConversionFact;

@Component
@ConfigurationProperties("conversion")
public class ConversionFactsConfigurer {
	public List<ConversionFact> facts;

	public List<ConversionFact> getFacts() {
		return facts;
	}

	public void setFacts(List<ConversionFact> facts) {
		this.facts = facts;
	}

}
