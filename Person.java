public class Person implements Comparable<Person> {
	private int startNr;
	private String namn;
	private String land;
	private int alder;
	private double tid;
	public static int antalDeltagare = 1;
	
	public Person(int startNr, String namn, String land, int alder) {
		this.startNr = startNr;
		this.namn = namn;
		this.land = land;
		this.alder = alder;
		tid = Double.MAX_VALUE;
	}

	int getStartNr(){
		return startNr;
	}
	
	void setStartNr(int startNr){
		this.startNr = startNr; 
	}
	
	String getNamn(){
		return namn;
	}
	
	void setNamn(String namn){
		this.namn = namn;
	}
	
	String getLand(){
		return land;
	}
	
	void setLand(String land){
		this.land = land;
	}
	
	int getAlder(){
		return alder;
	}
	
	void setAlder(int alder){
		this.alder = alder;
	}
	
	double getTid(){
		return tid;
	}
	
	void setTid(double tid){
		this.tid = tid;
	}
	
	public String toString(){
		if (tid == Double.MAX_VALUE)
			return startNr + "   " + namn + " " + land + " (" + alder + " år)  " + "--";
		else
			return startNr + "   " + namn + " " + land + " (" + alder + " år)  " + tid;
	}

	public int compareTo(Person o) {
		return 0;
	}
}
