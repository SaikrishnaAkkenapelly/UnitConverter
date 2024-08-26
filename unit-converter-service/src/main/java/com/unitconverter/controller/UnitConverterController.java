package com.unitconverter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitconverter.constants.UnitConverterConstants;
import com.unitconverter.services.UnitConverterService;

/** Controller class for the unit converter service. */
@RestController
@RequestMapping(UnitConverterConstants.UNIT_CONVERTER_BASE_URI)
public class UnitConverterController {
	private static final Logger logger = LoggerFactory.getLogger(UnitConverterController.class);

	@Autowired
	UnitConverterService unitConverterService;

	@GetMapping("/{from}/{to}/{value}")
	public ResponseEntity<Double> convert(@PathVariable("from") String fromUnit, @PathVariable("to") String toUnit,
			@PathVariable Double value) {
		try {
			Double output = unitConverterService.convert(fromUnit, toUnit, value);
			return ResponseEntity.status(HttpStatus.OK).body(output);
		} catch (Exception exception) {
			logger.error("Failed to convert from {} to {}.", fromUnit, toUnit);
			logger.error(exception.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
