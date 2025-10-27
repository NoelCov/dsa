package union_find;

import java.util.Arrays;

// This is the implementation for Quick Find. Allowing O(1) for the find method.
// The idea behind quick find is to store the value of the vertex parent/root at the given vertex index.
class QuickFind implements UnionFind {
    private int[] arr;
    private int count;

    public QuickFind(int n) {
        this.arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    @Override
    public int find(int x) {
        return arr[x];
    }

    @Override
    public int union(int x, int y) {
        int arrX = find(x), arrY = find(y);
        if (arrX != arrY) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arrY) {
                    arr[i] = arrX;
                }
            }
            this.count += 1;
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