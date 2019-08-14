import java.util.HashSet;
import java.util.Set;

public class Vertice {
	private Integer id;
	private String info;
	private Integer valor;
	private Boolean marcado;
	private Set<Vertice> sucessores ;
	private Set<Vertice> antecessores ;
	
	public Vertice(Integer id, String info, Integer valor){
		this.id = id;
		this.info = info;
		this.valor = valor;
		this.sucessores = new HashSet<>();
		this.antecessores = new HashSet<>();
		this.marcado = false;
	}
	
	public void marca(){
		marcado = true;
	}
	
	public Boolean isMarcado(){
		return marcado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public Integer getValor() {
		return valor;
	}

	public Set<Vertice> getSucessores() {
		return sucessores;
	}
	
	public void addSucessor(Vertice sucessor){
		this.sucessores.add(sucessor);
	}
	
	public void removeSucessor(Vertice sucessor){
		this.sucessores.remove(sucessor);
	}
	
	public void addAntecessor(Vertice antecessor){
		this.antecessores.add(antecessor);
	}
	
	public void removeAntecessor(Vertice antecessor){
		this.antecessores.remove(antecessor);
	}
	

	public Set<Vertice> getAntecessores() {
		return antecessores;
	}
	
	
}