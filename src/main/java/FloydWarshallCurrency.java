
import java.io.*;
import java.lang.*;
import java.util.*;

public class FloydWarshallCurrency {
// Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.

    final static int INF = 99999, V = 6;

    void floydWarshall(double graph[][])
    {
        double dist[][] = new double[V][V];
        int i, j, k;

		/* Initialize the solution matrix
		same as input graph matrix.
		Or we can say the initial values
		of shortest distances
		are based on shortest paths
		considering no intermediate
		vertex. */
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = Math.log(graph[i][j]);

//        dist[1][2] =-INF  ;
//        dist[1][3] =-INF  ;
//        dist[2][1] =-INF  ;
//        dist[3][1] =  -INF  ;
		/* Add all vertices one by one
		to the set of intermediate
		vertices.
		---> Before start of an iteration,
			we have shortest
			distances between all pairs
			of vertices such that
			the shortest distances consider
			only the vertices in
			set {0, 1, 2, .. k-1} as
			intermediate vertices.
		----> After the end of an iteration,
				vertex no. k is added
				to the set of intermediate
				vertices and the set
				becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path
                    // from i to j, then update the value of
                    // dist[i][j]
                    if ((i!=j)&&( dist[i][k] + dist[k][j]
                         > dist[i][j]) ) {
                        dist[i][j]
                                = dist[i][k] + dist[k][j];
                        //if(i==0 && j==3)
                            //System.out.println (dist[i][j]+"    "+k);

                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    void printSolution(double dist[][])
    {
        System.out.println(
                "The following matrix shows the shortest "
                        + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Driver's code
    public static void main(String[] args)
    {
		/* Let us create the following weighted graph
		10
		(0)------->(3)
		|		 /|\
		5 |		 |
		|		 | 1
		\|/		 |
		(1)------->(2 )
		3		 */
//        double graph[][] = { { 1, 1.3, 0.71, 109.0 },
//                        { 1/1.3, 1, -INF, -INF },
//                        { 1/0.71, -INF, 1, 155 },
//                        { 1/109.0, -INF, 1/155.0, 1} };
                            // USD     GBP  JPY     CAD  CNY    KRW
        double graph[][] = { { 1,      0.7, 109,    -INF, -INF,   -INF  },
                            { 1/0.7,    1,  155,    -INF, -INF,   -INF  },
                            { 1/109.0, 1/155.0,  1, -INF, -INF,   -INF },
                            { -INF,     -INF, -INF,     1,  5.27,  921},
                            { -INF,     -INF, -INF,    1/5.27,  1,    -INF},
                            { -INF,     -INF, -INF,    1/921.0, -INF,   1 }};
        FloydWarshallCurrency a = new FloydWarshallCurrency();
        // Function call
        a.floydWarshall(graph);
    }
}

// Contributed by Aakash Hasija

