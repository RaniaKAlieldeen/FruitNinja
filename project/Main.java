package graphs;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dijkstrashortestpath d = new Dijkstrashortestpath();
		MST mst = new MST();
		int size;
		int start;
		int choice;
		// int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
		// {4, 0, 8, 0, 0, 0, 0, 11, 0},
		// {0, 8, 0, 7, 0, 4, 0, 0, 2},
		// {0, 0, 7, 0, 9, 14, 0, 0, 0},
		// {0, 0, 0, 9, 0, 10, 0, 0, 0},
		// {0, 0, 4, 14, 10, 0, 2, 0, 0},
		// {0, 0, 0, 0, 0, 2, 0, 1, 6},
		// {8, 11, 0, 0, 0, 0, 1, 0, 7},
		// {0, 0, 2, 0, 0, 0, 6, 7, 0}
		// };
		System.out.print("Enter the size of your array: ");
		size = sc.nextInt();
		int graph[][] = new int[size][size];
		System.out.println("Enter the element of your array: ");
		for (int i = 0; i < size * size; i++) {
			graph[i / size][i % size] = sc.nextInt();

		}
		System.out.println("Enter your start point:");
		start = sc.nextInt();

		System.out.println("\n1. Djikstra's shortest path");
		System.out.println("2. Prim's MST");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			d.Dij_alg(size, graph, start);
			break;
		case 2:
			mst.mstAlg(graph, size);
		}

	}

}
