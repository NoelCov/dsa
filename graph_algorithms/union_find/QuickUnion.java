package union_find;

import java.util.Arrays;

// The main idea of quick union is that the union metohd will take <= O(n) compared to quick find (since it goes through all the vertices every call to union()).
// However, due to this, find drops from O(1) to O(n) in the worst case.
public class QuickUnion implements UnionFind {
    private int[] arr;
    private int count;

    public QuickUnion(int n) {
        this.arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    @Override
    public int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return find(arr[x]);
    }

    @Override
    public int union(int x, int y) {
        int arrX = find(x), arrY = find(y);
        if (arrX != arrY) {
            arr[y] = arrX;
        }
        return arrX;
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    @Override
    public int count() {
        return this.count;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}
