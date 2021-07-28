import java.util.ArrayList;

public class Maze {
    private int N;
    private ArrayList<Coordinate> mazePath;
    private boolean[][] visited;

    public Maze(int n) {
        this.N = n;
        this.mazePath = new ArrayList<>();
        this.visited = new boolean[n][n];
    }

    private void printSolution()
    {
        System.out.println("\nSolution: \n");
        for (Coordinate c : mazePath) {
            System.out.print("("+c.getX()+","+c.getY()+")"+" ");
        }

    }
    private boolean isValid(int[][] arr, Coordinate c){
        return (c.getX()>=0 && c.getX()< N && c.getY()>=0 && c.getY()< N && arr[c.getX()][c.getY()]==0 && !visited[c.getX()][c.getY()]);
    }

    public void solveMaze(int[][] arr){
        if(!mazeSolver(arr,new Coordinate(0,0))){
            System.out.println("Solution not found!!");
            return;
        }
        printSolution();
    }

    private boolean mazeSolver(int[][] arr, Coordinate c){
        if(c.getX() == N -1 && c.getY() == N -1 && arr[c.getX()][c.getY()] == 0){
            visited[c.getX()][c.getY()] = true;
            mazePath.add(c);
            return true;
        }

        if(isValid(arr,c)){
            mazePath.add(c);
            visited[c.getX()][c.getY()] = true;


            if(mazeSolver(arr, new Coordinate(c.getX(),c.getY()+1))){  //goes right
                return true;
            }
            if(mazeSolver(arr,new Coordinate(c.getX()+1,c.getY()))){ //goes down
                return true;
            }
            if(mazeSolver(arr,new Coordinate(c.getX(),c.getY()-1))){  //goes left
                return true;
            }
            if(mazeSolver(arr, new Coordinate(c.getX()-1,c.getY()))){ //goes up
                return true;
            }

            mazePath.remove(c);
            return false;
        }

        return false;
    }
}