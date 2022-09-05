import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
 public class MaximumCurrencyExchange {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;


        line = in.readLine();
        String[] inpStr = line.split(";");

        String convertFrom = in.readLine();
        String convertTo = in.readLine();

        MaximumCurrencyExchange m = new MaximumCurrencyExchange ();
        Double val = m.maxTargetCurr(convertFrom, convertTo, prepareData(inpStr));

        System.out.println(val);
    }

    // Gloabl variable of graph
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();


    // preparing List data of all currency coversions
    public static List<Edge> prepareData (String[] inputStr){


        List<Edge> l = new ArrayList<>();
        for (int i =0; i < inputStr.length; i++){
            String[] currencyData = inputStr[i].split(",");
            Edge nd = new Edge( currencyData[0], currencyData[1], Double.parseDouble(currencyData[2]) );
            l.add(nd);
        }

        return l;
    }

    // calculate the max currency convert
    public double maxTargetCurr (String convertFrom, String convertTo, List<Edge> rates){

        buildGraph(rates);

        if (!graph.containsKey(convertFrom))
            return -1;

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(null, convertFrom, 1.0 ));

        // tracking the visited node and updates the best currency coversion
        Map<String, Double> visited = new HashMap<>();

        Map<String,String> parent = new HashMap<>();
        parent.put(convertFrom , convertFrom);

        while (!queue.isEmpty()){

            Node n = queue.poll();
            String top = n.currency;

            if (visited.containsKey(top) && visited.get(top) > n.cost) { // if it is already visited and has the best rate, continue
                continue;
            }

            visited.put(top, n.cost);
            parent.put(top, n.parent);
            graph.get(convertFrom).put(top, n.cost);

            for (var destination: graph.get(top).entrySet()){

                double rate = graph.get(convertFrom).get(top) * destination.getValue();

                if (visited.containsKey(destination.getKey()) && visited.get(destination.getKey()) >= rate || destination.getKey().equals(convertFrom))
                    continue;

                queue.add(new Node(top, destination.getKey(), rate));
            }
        }

        if (!graph.get(convertFrom).containsKey(convertTo)){
            System.out.println("it's here");
            System.out.println(convertFrom + "  " + convertTo);
            return -1;
        }

        System.out.println(graph.get(convertFrom).get(convertTo));
        return graph.get(convertFrom).get(convertTo);

    }



    private void buildGraph (List<Edge> rates){

        for (Edge ed: rates){

            if (!graph.containsKey(ed.convertFrom)){
                graph.put(ed.convertFrom, new HashMap());
            }
            graph.get(ed.convertFrom).put(ed.convertTo, ed.rate);
            // adding inverse rate conversion
            if (!graph.containsKey(ed.convertTo)){
                graph.put(ed.convertTo, new HashMap());
            }
            graph.get(ed.convertTo).put(ed.convertFrom, (1.0/ed.rate));
        }


    }




    //****************************

    public static class Node implements Comparable<Node>{

        String currency;
        String parent;
        Double cost;

        public Node (String parent, String curr, Double cost){
            this.currency = curr;
            this.parent= parent;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost == o.cost)
                return 1;
            else
                return Double.compare(this.cost, o.cost);
        }

    }

    public static class Edge{

        // creating an edge to store the conversion rates

        String convertFrom;
        String convertTo;
        double rate;

        public Edge (String f, String t, double r){
            this.convertFrom = f;
            this.convertTo = t;
            this.rate = r;
        }
    }
}
