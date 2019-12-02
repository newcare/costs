package trips.costs.databind;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tap implements Comparable<Tap>{
	
	
	@JsonProperty("unixTimestamp") 
	 private long unixTimestamp;
	
	@JsonProperty("customerId") 
	private long customerId;
	  
	@JsonProperty("station") 
	private String station;
	
	
	 public long getUnixTimestamp() {
		return unixTimestamp;
	}

	public void setUnixTimestamp(long unixTimestamp) {
		this.unixTimestamp = unixTimestamp;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public int compareTo(Tap anotherTap) {
		if (customerId == anotherTap.getCustomerId()) {
            return (int) (unixTimestamp-anotherTap.getUnixTimestamp());
        } else {
            return (int) (customerId-anotherTap.getCustomerId());
        }
	}

	

}
