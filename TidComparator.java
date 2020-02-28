import java.util.*;

public class TidComparator implements Comparator<Deltagare> {
	
	public int compare(Deltagare o1, Deltagare o2) {
		
		Deltagare de1 = (Deltagare) o1;
		Deltagare  de2 = (Deltagare) o2;
		
		return (int) ((de1.getTid() - de2.getTid()) * 100);
	}

}
