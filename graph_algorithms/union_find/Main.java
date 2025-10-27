package union_find;

public class Main {
    public static void main(String[] args) {
        // Let's say we want to represent an indirected graph with 4 nodes. Nodes are 0,
        // 1, 2, 3.
        int n = 13;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 2, 3 }, { 4, 5 }, { 9, 10 },
                { 9, 11 }, { 9, 12 } };
        OptimizedUnionFind optimizedUnionFind = new OptimizedUnionFind(n);
        System.out.println(optimizedUnionFind);

        for (int[] edge : edges) {
            optimizedUnionFind.union(edge[0], edge[1]);
        }
        System.out.println(optimizedUnionFind);

        System.out.println(optimizedUnionFind.connected(0, 1));
        System.out.println(optimizedUnionFind.connected(0, 5));

        optimizedUnionFind.union(0, 4);
        System.out.println(optimizedUnionFind.connected(0, 5));
        System.out.println(optimizedUnionFind);
        optimizedUnionFind.union(9, 0);
        System.out.println(optimizedUnionFind);
        System.out.println(optimizedUnionFind.find(12));
        System.out.println(optimizedUnionFind);

    }
}
