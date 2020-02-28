
class MatrixGraph {
	private Edge[][] data;
	
	public MatrixGraph(int maxNodes){
		data = new Edge[maxNodes][maxNodes];
	}
	
	public void connect(int from, int to, String namn, int vikt){
		data[from][to] = new Edge(to, namn, vikt);
		data[to][from] = new Edge(from, namn, vikt);
	}
}
