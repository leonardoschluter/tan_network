import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Grafo {
	List<Vertice> vertices = new ArrayList<>();
	List<Edge> edges = new ArrayList<>();

	public void addVertice(Vertice vertice){
		vertices.add(vertice);
	}

	public void addEdge(Edge edge){
		edges.add(edge);
	}


}
