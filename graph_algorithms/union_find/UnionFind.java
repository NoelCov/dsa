package union_find;

public interface UnionFind {
    /**
     * Returns true if the Vertex at index x and the Vertex and index y are
     * connected, false otherwise.
     * 
     * @param x The index for vertex x.
     * @param y The index for vertex y.
     * @return True if vertices are connected, false othwerwise.
     */
    default boolean connected(int x, int y) {
        return false;
    }

    /**
     * Finds the root parent of vertex x.
     * 
     * @param x The vertex to find the parent of.
     * @return The root parent of vertex x.
     */
    default int find(int x) {
        return -1;
    }

    /**
     * Merges x and y vertices together. Modifying the vertices that connect to x
     * and y as well. Merging two subgraphs.
     * 
     * @param x
     * @param y
     * @return The root parent of both vertices.
     */
    default int union(int x, int y) {
        return -1;
    }

    default int count() {
        return -1;
    }
}