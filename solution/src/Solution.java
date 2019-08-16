import exceptions.NegativeWeightException;

import javax.crypto.spec.PSource;
import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        File text = new File("/Users/leonardoschluter/Documents/challenge/solution/src/input.txt");
        Scanner in = null;
        try {
            in = new Scanner(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String startPoint = in.next();
        String endPoint = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        HashMap<String, Vertice> stops = new HashMap<>();
        List<Vertice> stopsList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Vertice stop = new Vertice(in.nextLine());
            stops.put(stop.getId(), stop);
            stopsList.add(stop);
        }
        int M = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        List<Edge> routes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] orgDest = in.nextLine().split(" ");
            Vertice origin = stops.get(orgDest[0].replace("StopArea:", ""));
            Vertice dest = stops.get(orgDest[1].replace("StopArea:", ""));
            Edge route = new Edge( dest, origin);
            routes.add(route);
        }

        Vertice start = stops.get(startPoint.replace("StopArea:", ""));
        Vertice end = stops.get(endPoint.replace("StopArea:", ""));

        BellmanFord bellmanFord = new BellmanFord(end, stopsList, routes);
        try{
            bellmanFord.exec();
        } catch (NegativeWeightException e) {
            System.out.println("IMPOSSIBLE");
        }

        bellmanFord.printRoutes(start);

    }
}