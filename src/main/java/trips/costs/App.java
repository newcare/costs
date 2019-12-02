package trips.costs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trips.costs.databind.CustomerSummaries;
import trips.costs.databind.CustomerSummary;
import trips.costs.databind.Tap;
import trips.costs.databind.Taps;
import trips.costs.databind.Trip;

/**
 * Main Class
 *
 */

public class App {

	static Rules rules = new Rules();
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) {

		if (args.length > 1) {

			try {

				// JSON file to Java Taps object
				Taps tapsRecord = mapper.readValue(new File(args[0]), Taps.class);

				List<Tap> allTaps = tapsRecord.getTaps();

				Collections.sort(allTaps);

				List<CustomerSummary> customerSummariesList = new ArrayList<CustomerSummary>();

				int sizeAllTaps = allTaps.size();
				for (int i = 0; i < sizeAllTaps; i += 2) {

					Trip trip = addNewTrip(allTaps.get(i), allTaps.get(i + 1));
					
					
					// if the CustomerId does not exist we create a new
					// CustomerSummary
					if (i == 0 || isNonExistantCustomer(allTaps, i)) {

						CustomerSummary summary = addNewCustomerSummary(allTaps.get(i), trip);

						customerSummariesList.add(summary);

					}

					else {//the CustomerId  exists we retrieve the CustomerSummary object and add a trip
						
						CustomerSummary summary = customerSummariesList.get(customerSummariesList.size() - 1);
						summary.getTrips().add(trip);

					}

				}

				calculateTotalCostInCents(customerSummariesList);

				writeValueToFile(customerSummariesList, args[1]);

				System.out.println("Program executed with success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static boolean isNonExistantCustomer(List<Tap> allTaps, int index) {
		return allTaps.get(index - 1).getCustomerId() != allTaps.get(index).getCustomerId();

	}

	private static void calculateTotalCostInCents(List<CustomerSummary> customerSummariesList) {
		for (CustomerSummary summary : customerSummariesList) {

			summary.calculateTotalCostInCents();

		}

	}

	private static void writeValueToFile(List<CustomerSummary> customerSummariesList, String filePath)
			throws JsonGenerationException, JsonMappingException, IOException {
		CustomerSummaries summaries = new CustomerSummaries();
		summaries.setCustomerSummaries(customerSummariesList);

		mapper.writeValue(new File(filePath), summaries);

	}

	private static Trip addNewTrip(Tap fromTap, Tap toTap) {
		Trip trip = new Trip();
		trip.setStartedJourneyAt(fromTap.getUnixTimestamp());
		trip.setStationStart(fromTap.getStation());
		trip.setStationEnd(toTap.getStation());

		List<Integer> zones = rules.calculatefromAndToZones(fromTap.getStation(), toTap.getStation());

		trip.setCostInCents(rules.calculateCost(zones));
		trip.setZoneFrom(zones.get(0));
		trip.setZoneTo(zones.get(1));
		return trip;
	}

	private static CustomerSummary addNewCustomerSummary(Tap tap, Trip trip) {
		CustomerSummary summary = new CustomerSummary();
		summary.setCustomerId(tap.getCustomerId());
		List<Trip> tripList = new ArrayList<Trip>();

		tripList.add(trip);

		summary.setTrips(tripList);

		return summary;
	}
}
