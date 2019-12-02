package trips.costs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trips.costs.utils.PairZones;

public class Rules {

	private static Map<Integer, List<String>> zonesToStations;
	private static Map<String, List<Integer>> stationsToZones;
	private static Map<List<Integer>, Integer> costs;
	

	static {

		zonesToStations = new HashMap<Integer, List<String>>();

		List<String> zone1 = Arrays.asList("A", "B");

		List<String> zone2 = Arrays.asList("C", "D", "E");

		List<String> zone3 = Arrays.asList("C", "E", "F");

		List<String> zone4 = Arrays.asList("F", "G", "H", "I");

		zonesToStations.put(1, zone1);
		zonesToStations.put(2, zone2);
		zonesToStations.put(3, zone3);
		zonesToStations.put(4, zone4);
		
		costs=new HashMap<List<Integer>, Integer>();
		costs.put(Arrays.asList(1, 1), 240);
		costs.put(Arrays.asList(1, 2), 240);
		costs.put(Arrays.asList(1, 3), 280);
		costs.put(Arrays.asList(1, 4), 300);
		costs.put(Arrays.asList(2, 1), 240);
		costs.put(Arrays.asList(2, 2), 240);
		costs.put(Arrays.asList(2, 3), 280);
		costs.put(Arrays.asList(2, 4), 300);
		costs.put(Arrays.asList(3, 1), 280);
		costs.put(Arrays.asList(3, 2), 280);
		costs.put(Arrays.asList(3, 3), 200);
		costs.put(Arrays.asList(3, 4), 200);
		costs.put(Arrays.asList(4, 1), 300);
		costs.put(Arrays.asList(4, 2), 300);
		costs.put(Arrays.asList(4, 3), 200);
		costs.put(Arrays.asList(4, 4), 200);

		calculateStationsToZones();

	}

	

	public int calculateCost(List<Integer> zones) {

		
		return costs.get(zones);
		

	}

	protected static void calculateStationsToZones() {

		stationsToZones = new HashMap<String, List<Integer>>();
		for (Map.Entry<Integer, List<String>> entry : zonesToStations.entrySet()) {

			for (String station : entry.getValue()) {
				if (stationsToZones.containsKey(station)) {

					stationsToZones.get(station).add(entry.getKey());

				} else {
					List<Integer> zones = new ArrayList<Integer>();
					zones.add(entry.getKey());
					stationsToZones.put(station, zones);

				}

			}

		}

	}

	

	

	public List<Integer> calculatefromAndToZones(String fromStation, String toStation) {

		List<Integer> fromZones = stationsToZones.get(fromStation);
		List<Integer> toZones = stationsToZones.get(toStation);
		int formZonesSize = fromZones.size();
		int toZonesSize = toZones.size();

		List<PairZones> pairZonesList = new ArrayList<PairZones>();

		for (int i = 0; i < formZonesSize; i++) {

			for (int j = 0; j < toZonesSize; j++) {

				pairZonesList.add(new PairZones(fromZones.get(i), toZones.get(j)));

			}

		}

		Collections.sort(pairZonesList);

		List<Integer> result = new ArrayList<Integer>();
		result.add(pairZonesList.get(0).getFromZone());
		result.add(pairZonesList.get(0).getToZone());

		return result;
	}

}
