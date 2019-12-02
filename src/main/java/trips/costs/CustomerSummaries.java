package trips.costs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerSummaries {
	
	@JsonProperty("customerSummaries")
	  private List<CustomerSummary> customerSummaries;

	public List<CustomerSummary> getCustomerSummaries() {
		return customerSummaries;
	}

	public void setCustomerSummaries(List<CustomerSummary> customerSummaries) {
		this.customerSummaries = customerSummaries;
	}
	
	
	

}
