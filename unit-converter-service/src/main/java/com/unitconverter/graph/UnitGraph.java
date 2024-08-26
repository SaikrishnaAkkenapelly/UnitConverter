package com.unitconverter.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.unitconverter.pojo.UnitNode;

/** Graph data structure to deal with unit conversions. */
@Component
public class UnitGraph {
	private static final Logger logger = LoggerFactory.getLogger(UnitGraph.class);

	Map<String, UnitNode> nodes;

	public UnitGraph() {
		this.nodes = new HashMap<>();
	}

	public Map<String, UnitNode> getNodes() {
		return nodes;
	}

	public void addNode(String unit) {
		UnitNode node = new UnitNode(unit);
		nodes.putIfAbsent(unit, node);
	}

	public void addEdge(String fromUnit, String toUnit, Double conversionFactor) {
		UnitNode fromNode = nodes.get(fromUnit);
		UnitNode toNode = nodes.get(toUnit);
		fromNode.addEdge(toUnit, conversionFactor);
		toNode.addEdge(fromUnit, 1 / conversionFactor);
	}

	public Double getCummulativeConversionFactor(String fromUnit, String toUnit) {
		logger.info("Getting cummulative conversion factor from {}, to {}", fromUnit, toUnit);
		Queue<String> processingNodes = new LinkedList<>();
		Set<String> visitedNodes = new HashSet<>();
		Map<String, Double> cummulativeFactors = new HashMap<>();

		if (nodes.containsKey(fromUnit) && nodes.containsKey(toUnit)) {
			processingNodes.add(fromUnit);
			visitedNodes.add(fromUnit);
			cummulativeFactors.put(fromUnit, 1d);

			while (!processingNodes.isEmpty()) {
				String sourceUnit = processingNodes.remove();
				UnitNode sourceNode = nodes.get(sourceUnit);
				Map<String, Double> edges = sourceNode.getEdges();
				Double cummulativeFactor = cummulativeFactors.get(sourceUnit);
				if (edges.containsKey(toUnit)) {
					cummulativeFactor = cummulativeFactor * edges.get(toUnit);
					logger.info("Cummulative conversion factor from {}, to {} is {}", fromUnit, toUnit,
							cummulativeFactor);
					return cummulativeFactor;
				} else {
					for (Map.Entry<String, Double> edge : edges.entrySet()) {
						if (!visitedNodes.contains(edge.getKey())) {
							processingNodes.add(edge.getKey());
							visitedNodes.add(edge.getKey());
							cummulativeFactors.put(edge.getKey(), cummulativeFactor * edge.getValue());
						}
					}
				}
			}
		}
		return null;
	}

}
