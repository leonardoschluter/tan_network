import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Grafo {
	private Map<Integer, Vertice> vertices;
	
	public Grafo(){
		this.vertices = new HashMap<>();
	}
	
	public void adicionaVertice(Vertice v){
		vertices.put(v.getId(), v);
	}
	
	public void removeVertice(Vertice v){
		vertices.remove(v.getId());
	}
	
	public void conecta(Vertice origem, Vertice destino){
		// como � um grafo orientado, so adiciono num sentido. Se for um grafo n�o orientado, adicionar nos dois
		origem.addSucessor(destino);
		destino.addAntecessor(origem);
	}
	
	public void desconecta(Vertice origem, Vertice destino){
		origem.removeSucessor(destino);
		destino.removeAntecessor(origem);
	}
	
	public int ordem(){
		return vertices.size();
	}
	
	public Map<Integer,Vertice> getVertices(){
		return  vertices;
	}
	
	public Vertice umVertice(){
		Random rand = new Random();
		Integer  n = rand.nextInt(vertices.size()) + 1;
		return vertices.get(n);
	}
	
	public Set<Vertice> adjacentes(Vertice v){
		return v.getSucessores();
	}
	
	public int grau(Vertice v){
		return adjacentes(v).size();
	}

	public ArrayList<Vertice> fontes() {
		ArrayList<Vertice> fontes = new ArrayList<>(); 
		for (Map.Entry<Integer, Vertice> entry : vertices.entrySet())
		{
			if(entry.getValue().getAntecessores().isEmpty()){
				fontes.add(entry.getValue());
			}
		}
		return fontes;
	}

	public ArrayList<Vertice> sumidouros() {
		ArrayList<Vertice> sumidouros = new ArrayList<>(); 
		for (Map.Entry<Integer, Vertice> entry : vertices.entrySet())
		{
			if(entry.getValue().getSucessores().isEmpty()){
				sumidouros.add(entry.getValue());
			}
		}
		return sumidouros;
	}
}
