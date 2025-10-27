package union_find;

import java.util.Arrays;

public class OptimizedUnionFind implements UnionFind {
   private int[] arr;
   private int[] ranks;
   private int count;

   public OptimizedUnionFind(int n) {
      this.arr = new int[n];
      this.ranks = new int[n];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = i;
         ranks[i] = 0;
      }
   }

   // For find, we'll make it so that when it's coming back from recursion, it
   // updates the indexes to point to their parent directly. This is called 'Path
   // Compression Optimization'
   @Override
   public int find(int x) {
      if (arr[x] == x) {
         return x;
      }
      return arr[x] = find(arr[x]);
   }

   // For union, we want to try to balance the tree as much as possible, so we pick
   // the side that has the highest rank, for this we need another array to keep
   // track of the rank. This is called 'Union by Rank'. This will ultimately help
   // the find function as well.
   @Override
   public int union(int x, int y) {
      int arrX = find(x), arrY = find(y);

      if (ranks[arrX] < ranks[arrY]) {
         arr[arrX] = arrY;
      } else if (ranks[arrY] < ranks[arrX]) {
         arr[arrY] = arrX;
      } else {
         // They are equal, make x parent and increase the height/rank by 1.
         arr[arrY] = arrX;
         ranks[arrX] += 1;
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