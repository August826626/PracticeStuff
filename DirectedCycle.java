import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
    public Digraph D;
    public Stack<Integer> cycle;
    public Boolean hasCycle;
    public Boolean marked[];
    
    
    public DirectedCycle(Digraph D) {
        this.D = D;
        cycle = new Stack<Integer>();
        marked = new Boolean[D.V()];
        hasCycle = false;
        
        
        //do dfs on every vertice to check for cycles
        for (int w = 0; w < D.V(); w++) {
            
            for (int i = 0; i < marked.length; i++) {
                marked[i] = false;
            }
            
            System.out.println("Dfs on vertice " + w);
            dfs(D, w);
        }
    }
    
    //checks whether a vertice is reachable
    //if we have already marked that vertice, 
    //add it to the cycle
    private void dfs(Digraph D, int v) {
        marked[v] = true; 
        for (int w : D.adj(v)) {
            if (!marked[w]) {
                System.out.println("Dfs on " + w);
                dfs(D, w);
            } else {
                hasCycle = true;
                cycle.push(w);
            }
        }
    }
    
    public boolean hasCycle() {
        return hasCycle;
    }
    
    public Iterable<Integer> cycle() {
        return cycle;
    }
    
    public static void main(String[] args) {
        Digraph test = new Digraph(4);
        test.addEdge(0, 1);
        test.addEdge(1, 2);
        test.addEdge(2, 3);
        test.addEdge(3, 0);
        
        DirectedCycle tester = new DirectedCycle(test);
        
        System.out.println(tester.hasCycle());
    }
}