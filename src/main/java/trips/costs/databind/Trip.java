package trips.costs.databind;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trip {
	
	@JsonProperty("stationStart") 
	 private String stationStart;
	
	@JsonProperty("stationEnd") 
	private String stationEnd;
	  
	@JsonProperty("startedJourneyAt") 
	private long startedJourneyAt;
	
	@JsonProperty("costInCents") 
	 private int costInCents;
	
	@JsonProperty("zoneFrom") 
	private int zoneFrom;
	  
	@JsonProperty("zoneTo") 
	private int zoneTo;

	public String getStationStart() {
		return stationStart;
	}

	public void setStationStart(String stationStart) {
		this.stationStart = stationStart;
	}

	public String getStationEnd() {
		return stationEnd;
	}

	public void setStationEnd(String stationEnd) {
		this.stationEnd = stationEnd;
	}

	public long getStartedJourneyAt() {
		return startedJourneyAt;
	}

	public void setStartedJourneyAt(long startedJourneyAt) {
		this.startedJourneyAt = startedJourneyAt;
	}

	public int getCostInCents() {
		return costInCents;
	}

	public void setCostInCents(int costInCents) {
		this.costInCents = costInCents;
	}

	public int getZoneFrom() {
		return zoneFrom;
	}

	public void setZoneFrom(int zoneFrom) {
		this.zoneFrom = zoneFrom;
	}

	public int getZoneTo() {
		return zoneTo;
	}

	public void setZoneTo(int zoneTo) {
		this.zoneTo = zoneTo;
	}
	

}
