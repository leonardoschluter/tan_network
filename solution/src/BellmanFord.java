import exceptions.NegativeWeightException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BellmanFord {

    private Vertice source;
    List<Vertice> vertices;
    List<Edge> edges;
    private HashMap<Vertice, Double> distances;
    private HashMap<Vertice, Vertice> predecessors;

    public BellmanFord(Vertice source,List<Vertice> vertices, List<Edge> edges){
        this.source = source;
        this.vertices = vertices;
        this.edges = edges;
        this.initDistances(vertices, source);
    }

    private void initDistances(List<Vertice> vertices, Vertice source) {
        this.distances = new HashMap<>();
        this.predecessors = new HashMap<>();

        //TODO export to static object
        Vertice vertice = new Vertice((double) 0, (double) 0, "NONE", "THE DEFAULT STATION");
        for (Vertice key: vertices){
            this.distances.put(key, Double.MAX_VALUE);
            this.predecessors.put(key, vertice);
        }
        this.distances.put(source, (double) 0);
    }

    public void exec() throws NegativeWeightException {
        for(int i = 0; i < vertices.size() -1; i ++){
            for(Edge edge: edges){
                Vertice org = edge.getOrg();
                Vertice dest = edge.getDest();
                Double newDistance = distances.get(org) + edge.getWeight();
                if(newDistance < distances.get(dest)){
                    distances.put(dest, newDistance);
                    predecessors.put(dest, org);
                }
            }
        }
        for(Edge edge: edges){
            Vertice org = edge.getOrg();
            Vertice dest = edge.getDest();
            Double newDistance = distances.get(org) + edge.getWeight();
            if(newDistance < distances.get(dest)){
               throw new NegativeWeightException();
            }
        }

    }

    public HashMap<Vertice, Double> getDistances() {
        return distances;
    }

    public HashMap<Vertice, Vertice> getPredecessors() {
        return predecessors;
    }

    public void printRoutes(Vertice end) {
        List<String> route = new ArrayList<>();
        Vertice predecessor = end;
        while( predecessor != this.source) {
            route.add(predecessor.getFullName());
            predecessor = this.predecessors.get(predecessor);
        }
        route.add(source.getFullName());

        for(int i = route.size() -1; i >= 0; i--){
            System.out.println(route.get(i));
        }

    }
}
