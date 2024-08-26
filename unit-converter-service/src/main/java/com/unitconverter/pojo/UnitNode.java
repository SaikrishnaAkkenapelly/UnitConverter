package com.unitconverter.pojo;

import java.util.HashMap;
import java.util.Map;

/** Node class to store the unit and edges as part of the UnitGraph. */
public class UnitNode {
	private String unit;
	private Map<String, Double> edges;

	public UnitNode(String unit) {
		this.unit = unit;
		this.edges = new HashMap<>();
	}

	public void addEdge(String unit, Double conversionFactor) {
		this.edges.put(unit, conversionFactor);
	}

	public Map<String, Double> getEdges() {
		return edges;
	}

	public String getUnit() {
		return unit;
	}
}
