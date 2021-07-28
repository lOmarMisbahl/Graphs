import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args){
        int num;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(
                    "1- Problem 1\n" +
                    "2- Problem 2\n" +
                    "3- Problem 3\n" +
                    "4- Exit\n" +
                    "Enter a number: ");
            num = scanner.nextInt();
            switch (num){
                case 1:
                    graph();
                    break;
                case 2:
                    maze();
                    break;
                case 3:
                    kestraRun();
                    break;
                case 4:
                    exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid number!\n");
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void graph(){
        System.out.println("Please Enter Number Of Vertices:");
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        System.out.println("Please Enter Number Of Edges:");
        in = new Scanner(System.in);
        int e = in.nextInt();
        Graph graph = new Graph(v+1);
        System.out.println("Please Enter Edges In The Form (U V):");
        for(int i = 0 ; i < e ; i++) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.addEdge(x,y);
        }
        System.out.println("Please Enter Starting Vertex:");
        in = new Scanner(System.in);
        v = in.nextInt();
        System.out.println("Please Enter Value Of K:");
        in = new Scanner(System.in);
        int k = in.nextInt();
        graph.BreadthFirstTraversal(v,k);
        System.out.println("\n");
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void maze(){
        int N;
        System.out.println("Enter maze size(N): ");
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[][] array = new int[N][N];
        System.out.println("Enter maze values: ");
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        Maze maze = new Maze(N);
        maze.solveMaze(array);
        System.out.println("\n");
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void kestraRun()
    {
        ShortestPath shortp = new ShortestPath();
        System.out.println("Enter cost M:\n");
        Scanner input1 = new Scanner(System.in);
        int m = input1.nextInt();

        System.out.println("Enter number of cities:\n");
        Scanner input2 = new Scanner(System.in);
        int cities = input2.nextInt();

        System.out.println("Enter number of routes:\n");
        Scanner input3 = new Scanner(System.in);
        int routes = input3.nextInt();

        System.out.println("Enter source , destination , time and cost:\n");
        Scanner s = new Scanner(System.in);

        Scanner d = new Scanner(System.in);

        Scanner t = new Scanner(System.in);

        Scanner c = new Scanner(System.in);


        Node[] adList = new Node[cities];

        for (int z = 0; z < cities; z++) {
            adList[z] = new Node(z + 1, 0, 0);
        }

        for (int i = 0; i < routes; i++) {
            int sr = s.nextInt();
            int des = d.nextInt();
            int time = t.nextInt();
            int cost = c.nextInt();

            shortp.insertInGraph(sr, des, time, cost, adList, m);

        }


        System.out.println("Enter source city:\n");
        Scanner input4 = new Scanner(System.in);
        int source = input4.nextInt();


        System.out.println("Enter desitnation city:\n");
        Scanner input5 = new Scanner(System.in);
        int destination = input5.nextInt();
        shortp.sortPriority(adList,source,destination,m);
        int totalTime=0;
        adList[source-1].time=0;
        totalTime=shortp.printPath(adList[destination-1],totalTime);



//        System.out.println("topman time="+adList[source-1].time);
        System.out.println("price= $"+adList[destination-1].d);
        totalTime+=adList[destination-1].t;
        System.out.println("time= "+totalTime);
        System.out.println("\n");
    }
}
