
class Edge {
	private Stad dest;
	private String namn;
	private int vikt;
	
	public Edge(Stad dest, String namn, int vikt){
		this.dest = dest;
		this.namn = namn;
		this.vikt = vikt; //tiden det tar
	}
	
	public Stad getDestination(){
		return dest;
	}
	
	//presenterar vägen till noden
	public String toString(){
		return "med " + namn + " till " + dest + " tar " + vikt;
	}
}
