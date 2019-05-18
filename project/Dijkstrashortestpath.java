
package graphs;

public class Dijkstrashortestpath {

	public int shortdistance(int weight[], Boolean b[], int numbernodes) // instead of priority queue
	{
		int min_weight = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < numbernodes; i++) {
			if (b[i] == false && weight[i] <= min_weight) // if element isnt visited yet and the weight of the path is
															// les than the min wieght
			{
				min_weight = weight[i];
				min_index = i;
			}

		}
		return min_index;
	}

	public void Dij_alg(int numnodes, int g[][], int start) {
		int no_nodes = numnodes;
		int Finalpathweight[] = new int[no_nodes];
		Boolean visited_arr[] = new Boolean[no_nodes];

		// Then We Fill Weights Array By Infinity For All Paths & Boolean Array By False
		// As We didnt Visit Any Node Yet
		for (int i = 0; i < no_nodes; i++) {
			Finalpathweight[i] = Integer.MAX_VALUE;
			visited_arr[i] = false;
		}
		Finalpathweight[start] = 0;

		for (int row_count = 0; row_count < no_nodes; row_count++) {
			int min = shortdistance(Finalpathweight, visited_arr, no_nodes);
			visited_arr[min] = true; // marking as visited
			// update weights in final path weight array only if not yet visited and the
			// total weight from source to destination is less than current
			for (int column_des = 0; column_des < numnodes; column_des++) {
				if (visited_arr[column_des] == false && g[min][column_des] != 0
						&& Finalpathweight[min] + g[min][column_des] < Finalpathweight[column_des]) {
					Finalpathweight[column_des] = Finalpathweight[min] + g[min][column_des];
				}
			}

		}
		System.out.println("Starting Node is " + start);
		for (int i = 0; i < no_nodes; i++) {
			System.out.println("Node [" + i + "] Is [" + Finalpathweight[i] + "] Away From Start Node");
		}
	}
}
