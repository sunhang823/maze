package maze;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate{
    int x,y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
	public boolean maze(int[][] matrix, Coordinate start, Coordinate end ){
	   if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	       return false;
	   }
	   int m = matrix.length;
	   int n = matrix[0].length;
	   
	   if (start.x <= 0 && start.x >= n || start.y <= 0 && start.y >= m ||
		   end.x <= 0 && end.x >= n || end.y <= 0 && end.y >= m ||
		   matrix[start.x][start.y] == 1 || matrix[end.x][end.y] == 1) {
		       return false;
		   }
	        
       int[] directionX = {0, 1, -1, 0};
       int[] directionY = {1, 0, 0, -1};
       
       Queue<Coordinate> queue = new LinkedList<>();     
       queue.offer(new Coordinate(start.x, start.y));
       matrix[start.x][start.y] = 2;
       
       while (!queue.isEmpty()) {
           Coordinate coor = queue.poll();
 
           for (int i = 0; i < 4; i++) {
               Coordinate adj = new Coordinate(
                   coor.x + directionX[i],
                   coor.y + directionY[i]
               );
               if (matrix[coor.x][coor.y] == 1) {
                   continue;
               }
               if (matrix[adj.x][adj.y] == 0) {
                   matrix[adj.x][adj.y] = 2;
                   queue.offer(adj);
               }
           }
       }
	   return matrix[end.x][end.y] == 2;
	}
}
