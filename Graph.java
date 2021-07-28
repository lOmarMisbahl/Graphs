import java.util.LinkedList;

public class Graph {
    private int E;
    public LinkedList<Integer> List[];

    Graph(int e) {
        E = e;
        List = new LinkedList[e];
        for (int i = 0; i < e; ++i)
            List[i] = new LinkedList();
    }

    void addEdge(int x, int y) {
        List[x].add(y);
        List[y].add(x);
    }

    void BreadthFirstTraversal(int starting, int k) {

        int level = -1;
        int counter = 0;
        int LevelSize = 0;
        boolean marked[] = new boolean[E];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        while (!areAllTrue(marked)) {

            for(int y = 0 ; y < List.length ; y++) {
                if (List[y].isEmpty()) {
                    marked[y] = true;
                }
            }

            marked[starting] = true;
            queue.add(starting);


            while (!queue.isEmpty()) {
                if (LevelSize == 0) {
                    LevelSize = queue.size();
                    level++;
                }
                if(level == k){
                    counter = LevelSize;
                    System.out.println("There are " + counter + " people with " + k + " connections away starting from " + starting);
                    return;

                }

                int top = queue.poll();



                int i = 0;
                while (i < List[top].size()) {
                    int n = List[top].get(i);
                    if (!marked[n]) {
                        marked[n] = true;
                        queue.add(n);
                    }
                    i++;
                }
                LevelSize--;
            }
        }
        System.out.println("There are 0 people with " + k + " connections away starting from " + starting);
    }


    public static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }


}
