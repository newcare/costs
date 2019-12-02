package trips.costs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main Class
 *
 */

public class App {

	public static void main(String[] args) {
		
		if(args.length>1){

		Rules rules = new Rules();

		ObjectMapper mapper = new ObjectMapper();
		try {

			// JSON file to Java Taps object
			Taps tapsRecord = mapper.readValue(new File(args[0]), Taps.class);

			

			List<Tap> allTaps = tapsRecord.getTaps();

			Collections.sort(allTaps);

			List<CustomerSummary> customerSummariesList = new ArrayList<CustomerSummary>();

			int sizeAllTaps = allTaps.size();
			for (int i = 0; i < sizeAllTaps; i += 2) {

				Trip trip = new Trip();
				trip.setStartedJourneyAt(allTaps.get(i).getUnixTimestamp());
				trip.setStationStart(allTaps.get(i).getStation());
				trip.setStationEnd(allTaps.get(i + 1).getStation());

				List<Integer> zones = rules.calculatefromAndToZones(allTaps.get(i).getStation(),
						allTaps.get(i + 1).getStation());

				trip.setCostInCents(rules.calculateCost(zones));
				trip.setZoneFrom(zones.get(0));
				trip.setZoneTo(zones.get(1));

				if (i == 0 || allTaps.get(i - 1).getCustomerId() != allTaps.get(i).getCustomerId()) {
					CustomerSummary summary = new CustomerSummary();
					summary.setCustomerId(allTaps.get(i).getCustomerId());
					List<Trip> tripList = new ArrayList<Trip>();

					tripList.add(trip);

					summary.setTrips(tripList);
					customerSummariesList.add(summary);

				}

				else {

					CustomerSummary summary = customerSummariesList.get(customerSummariesList.size() - 1);
					summary.getTrips().add(trip);

				}

				

			}

			for (CustomerSummary summary : customerSummariesList) {

				summary.calculateTotalCostInCents();

			}

			CustomerSummaries summaries = new CustomerSummaries();
			summaries.setCustomerSummaries(customerSummariesList);

			mapper.writeValue(new File(args[1]), summaries);
			
			System.out.println("Program executed with success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
}
