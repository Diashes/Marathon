import java.util.*;

public class Deltagare {
	
	private int startNr;
	private String namn;
	private double tid;
	private String alder;
	private String land;
	
	public Deltagare(String namn, String alder, String land, int startNr){
		this.namn = namn;
		this.alder = alder;
		this.land = land;
		this.startNr = startNr;
	}
	
	public String getLand(){
		return land;
	}
	
	public String getNamn(){
		return namn;
	}
	
	public double getTid(){
		return tid;
	}
	
	public String getAlder(){
		return alder;
	}
	
	public void setLand(String l){
		land = l;
	}
	
	public void setNamn(String n){
		namn = n;
	}
	
	public void setTid(double t){
		tid = t;
	}
	
	public void setAlder(String a){
		alder = a;
	}
	
	public String toString(){
		if (tid != 0)
		return startNr + " " + namn + " " + alder + " " + land + " " + tid;
		else
			return startNr + " " + namn + " " + alder + " " + land;
	}

}
