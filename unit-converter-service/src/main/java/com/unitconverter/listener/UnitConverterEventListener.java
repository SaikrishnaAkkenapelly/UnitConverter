package com.unitconverter.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.unitconverter.configuration.ConversionFactsConfigurer;
import com.unitconverter.graph.UnitGraph;
import com.unitconverter.pojo.ConversionFact;

/** Listener class to perform specific activities on events. */
@Component
public class UnitConverterEventListener {
	private static final Logger logger = LoggerFactory.getLogger(UnitConverterEventListener.class);

	@Autowired
	public ConversionFactsConfigurer conversionFactsConfigurer;

	@Autowired
	private UnitGraph unitGraph;

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		logger.info("Initialization started to setup the conversion facts for the converter");
		for (ConversionFact fact : conversionFactsConfigurer.getFacts()) {
			unitGraph.addNode(fact.getFrom());
			unitGraph.addNode(fact.getTo());
			unitGraph.addEdge(fact.getFrom(), fact.getTo(), fact.getFactor());
		}
		logger.info("Initialization done and ready to accept requests.");
	}

}
