package com.unitconverter.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitconverter.graph.UnitGraph;
import com.unitconverter.services.UnitConverterService;

/** Service class for the UnitConverter. */
@Service
public class UnitConverterServiceImpl implements UnitConverterService {
	private static final Logger logger = LoggerFactory.getLogger(UnitConverterServiceImpl.class);

	@Autowired
	private UnitGraph unitGraph;

	@Override
	public Double convert(String fromUnit, String toUnit, Double value) {
		Double cummulativeConversionFactor = unitGraph.getCummulativeConversionFactor(fromUnit, toUnit);
		if (cummulativeConversionFactor != null) {
			return value * cummulativeConversionFactor;
		} else {
			logger.error("Invalid inputs, conversion not possible.");
			throw new UnsupportedOperationException("Conversion between given units is not supported.");
		}
	}

}
