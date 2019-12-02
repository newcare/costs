package trips.costs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerSummary {
	
	
	@JsonProperty("customerId") 
	 private long customerId;
	
	@JsonProperty("totalCostInCents") 
	private int totalCostInCents=0;
	  
	@JsonProperty("trips")
	  private List<Trip> trips;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getTotalCostInCents() {
		return totalCostInCents;
	}

	public void setTotalCostInCents(int totalCostInCents) {
		this.totalCostInCents = totalCostInCents;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
	public void calculateTotalCostInCents(){
		
		 for(Trip trip:trips){
         	
         	
			 totalCostInCents+=trip.getCostInCents();
         	
         	
         }
		
		
		
	}
	

}
