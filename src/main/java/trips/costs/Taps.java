package trips.costs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Taps {
	
	@JsonProperty("taps")
	  private List<Tap> taps;

	
	 public List<Tap> getTaps() {
		return taps;
	}

	public void setTaps(List<Tap> taps) {
		this.taps = taps;
	}

	
}