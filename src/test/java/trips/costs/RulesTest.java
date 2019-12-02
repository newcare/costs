package trips.costs;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RulesTest {
	
	Rules rules;
	@BeforeTest
    public void setUp() {
        rules=new Rules();
    }
	
	
	@Test
    private void testCalculatefromAndToZones() {
        rules=new Rules();
        List<String> fromStationList=Arrays.asList("A","C","D","E","F","H","G","B","A","D");
        List<String> toStationList=Arrays.asList("B","A","C","F","D","I","E","E","H","F");
        List<List<Integer>> zonesListExpected=Arrays.asList(Arrays.asList(1,1),Arrays.asList(2,1),Arrays.asList(2,2),Arrays.asList(3,3),Arrays.asList(3,2),Arrays.asList(4,4),Arrays.asList(4,3),Arrays.asList(1,2),Arrays.asList(1,4),Arrays.asList(2,3));
        int size=fromStationList.size();
        
        for(int i=0;i<size;i++){
        	
        	
        	Assert.assertEquals(rules.calculatefromAndToZones(fromStationList.get(i), toStationList.get(i)), zonesListExpected.get(i));
        	
        	
        	
        	
        }
        
    }
	
	

}
