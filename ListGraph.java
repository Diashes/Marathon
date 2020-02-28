import java.util.*;

class ListGraph {
	private Map<Stad, List<Edge>> data = new HashMap<Stad, List<Edge>>();
	
	public void add(Stad ny){
		data.put(ny, new ArrayList<Edge>());
	}
	
	public void connect(Stad from, Stad to, String namn, int vikt){
		Edge e = new Edge(to, namn, vikt);
		List<Edge> fromVagar = data.get(from);
		fromVagar.add(e);
		
		Edge e2 = new Edge(from, namn, vikt));
		List<Edge> tillVagar = data.get(to);
		tillVagar.add(e2);
	}
	
	public String toString(){
		String str = "";
		
		for (Map.Entry<Stad, List<Edge>> me : data.entrySet()){
			Stad staden = me.getKey();
			List<Edge> bågar = me.getValue();
			str += staden + bågar + "\n";
		}
		return str;
			
	}
}
