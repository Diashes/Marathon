
class GraphTest {
	ListGraph g = new ListGraph();
	
	stad s1 = new Stad("Tensta");
	stad s2 = new Stad("Kista");
	stad s3 = new Stad("Akalla");
	
	g.add(s1);
	g.add(s2);
	g.add(s3);
	
	g.connect(s1, s2, "Buss", 25);
	g.connect(s2,s3, "Tunnelbana", 5);
}
