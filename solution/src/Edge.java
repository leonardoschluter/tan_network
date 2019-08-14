public class Edge {
    Vertice org;
    Vertice dest;
    Double weight;

    public Edge(Vertice org, Vertice dest){
        this.org = org;
        this.dest = dest;
        this.weight = calculateWeight(org, dest);
    }

    private Double calculateWeight(Vertice org, Vertice dest) {
        Double longDiff = dest.getLongitude()-org.getLongitude();
        Double latFactor = Math.cos((org.getLongitude() + dest.getLongitude())/2);
        Double x2 =Math.pow(longDiff*latFactor, 2);
        Double y2 = Math.pow(dest.getLatitude() - org.getLatitude(), 2);
        Double distInRadians = Math.sqrt(x2 +y2);

        return distInRadians * 6371;
    }
}
