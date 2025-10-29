package chatGPT.dataStructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 그래프 - 도로 연결 상태
 */
public class RoadGraph {
	private Map<Integer, Set<Integer>> connection;

	public RoadGraph(int count) {
		this.connection = new HashMap<>(count);
	}

	public void addRoad(int cityA, int cityB) {
		connection.putIfAbsent(cityA, new HashSet<>());
		connection.putIfAbsent(cityB, new HashSet<>());

		connection.get(cityA).add(cityB);
	}

	public boolean isConnected(int cityA, int cityB) {
		return connection.containsKey(cityA) && connection.get(cityA).contains(cityB);
	}

	public static void main(String[] args) {
		RoadGraph graph = new RoadGraph(3);

		graph.addRoad(0, 1);
		graph.addRoad(1, 2);

		System.out.println(graph.isConnected(0, 1));
		System.out.println(graph.isConnected(0, 2));
	}
}