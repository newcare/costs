package trips.costs;

public class PairZones implements Comparable<PairZones> {
	
	private int fromZone;
	private int toZone;
	
	public PairZones(int fromZone, int toZone) {
		
		this.fromZone = fromZone;
		this.toZone = toZone;
	}

	public int getFromZone() {
		return fromZone;
	}

	
	public int getToZone() {
		return toZone;
	}

	@Override
	public int compareTo(PairZones otherPairZones) {
		
		int val=Math.abs(fromZone-toZone);
		int valOther=Math.abs(otherPairZones.getFromZone()-otherPairZones.getToZone());
		if(val==valOther){
			
			return fromZone-otherPairZones.getToZone();
			
			
			
		}
		return val-valOther;
	}

	

}
