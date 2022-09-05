//import java.util.HashSet;
//import java.util.*;
//
//public class DijkstraAlgorithm {
//
//    public static int calculateShortestPath (Set<Node> nodes, Node source){
//
//        int distTravelled = 0;
//        source.setDistance(0);
//
//        Set<Node> settledNodes = new HashSet<>();
//        Set<Node> unsettledNodes = new HashSet<>();
//
//        unsettledNodes.add(source);
//
//        while (! unsettledNodes.isEmpty ()) {
//            Node currentNode = getLowestDistanceNode (unsettledNodes);
//            unsettledNodes.remove (currentNode);
//
//            for (Map.Entry< Node, Integer > adjacentNodePair : currentNode.getAdjacentNodes ().entrySet ()) {
//                Node adjacentNode = adjacentNodePair.getKey ();
//                int edgeWeight = adjacentNodePair.getValue ();
//
//                if ( ! settledNodes.contains (adjacentNode) ) {
//                    int sourceDistance = currentNode.getDistance ();
//                    if ( sourceDistance + edgeWeight < adjacentNode.getDistance () ) {
//                        adjacentNode.setDistance (sourceDistance + edgeWeight);
//                    LinkedList<Node> shortestPath = new LinkedList<>();
//                    shortestPath.add(currentNode);
//                    }
//
//                    unsettledNodes.add (adjacentNode);
//                }
//            }
//
//            settledNodes.add(currentNode);
//        }
//
//        return 0;
//    }
//
//    public static Node getLowestDistanceNode (Set<Node> unsettledNodes){
//
//        Node lNode = null;
//        int lowestDistance = Integer.MAX_VALUE;
//        for (Node n: unsettledNodes) {
//            int d = n.getDistance();
//            if (d < lowestDistance) {
//                lowestDistance = d;
//                lNode = n;
//            }
//        }
//        return lNode;
//    }
//
//    public static void main(String[] args){
//        Set<Node> nodes = new HashSet<>();
//
//        Node nodeA = new Node("A");
//        Node nodeB = new Node("B");
//        Node nodeC = new Node("C");
//        Node nodeD = new Node("D");
//        Node nodeE = new Node("E");
//        Node nodeF = new Node("F");
//
//        nodeA.addDestination(nodeB, 10);
//        nodeA.addDestination(nodeC, 15);
//
//        nodeB.addDestination(nodeD, 12);
//        nodeB.addDestination(nodeF, 15);
//
//        nodeC.addDestination(nodeE, 10);
//
//        nodeD.addDestination(nodeE, 2);
//        nodeD.addDestination(nodeF, 1);
//
//        nodeF.addDestination(nodeE, 5);
//
//        nodes.addNode(nodeA);
//        nodes.addNode(nodeB);
//        nodes.addNode(nodeC);
//        nodes.addNode(nodeD);
//        nodes.addNode(nodeE);
//        nodes.addNode(nodeF);
//
//    }
//}
//
//    class Node {
//
//    private String name;
//    private List<Node> shortestPath = new LinkedList<>();
//    private Integer distance = Integer.MAX_VALUE;
//    Map<Node, Integer> adjacentNodes = new HashMap<>();
//
//    public void addDestination(Node destination, int distance) {
//        adjacentNodes.put(destination, distance);
//    }
//
//    public Node(String name) {
//        this.name = name;
//    }
//
//    // getters and setters
//        public void setDistance(int d){
//            this.distance = d;
//        }
//
//        public int getDistance(){
//            return this.distance;
//        }
//
//        public Map<Node, Integer> getAdjacentNodes(){
//            return this.adjacentNodes;
//        }
//}