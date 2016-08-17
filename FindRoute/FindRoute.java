class AdjGraph
{
    int[][] edges;
    int numOfVertices = 0;
    boolean[] visited;
    
    public AdjGraph(int n)
    {
        edges = new int[n][n];
        numOfVertices = n;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                edges[i][j] = 0;
            }
        }
    }
    
    public void insertEdge(int v1, int v2, int weight) throws Exception
    {
        if ((v1 < 0 || v1 >= numOfVertices) || (v2 < 0 || v2 >= numOfVertices))
        {
            throw new Exception("v1 or v2 out of bound.");
        }
        
        edges[v1][v2] = weight;
    }
    
    public void print()
    {
        for (int i = 0; i < numOfVertices; i++)
        {
            for (int j = 0; j < numOfVertices; j++)
            {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean DFS(int v1, int v2)
    {
        visited[v1] = true;

        if (v1 == v2)
        {
            return true;
        }
        
        for (int i = 0; i < numOfVertices; i++)
        {
            if (edges[v1][i] > 0 && visited[i] == false)
            {
                boolean res = DFS(i, v2);
                
                if (res) return true;
            }
        }
        return false;
    }
    
    public boolean isConnected(int v1, int v2)
    {
        visited = new boolean[numOfVertices];
        
        for (int i = 0; i < numOfVertices; i++)
        {
            visited[i] = false;
        }
        
        return DFS(v1, v2);
    }
}

public class FindRoute
{
    public static void main(String[] args)
    {
        AdjGraph g = new AdjGraph(6);
        try
        {
            g.insertEdge(0, 1, 1);
            g.insertEdge(0, 4, 1); 
            g.insertEdge(4, 1, 1);
            g.insertEdge(1, 3, 1);
            g.insertEdge(3, 4, 1);
            g.insertEdge(4, 5, 1);
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        g.print();
        
        int v1 = 3;
        int v2 = 2;
        if (g.isConnected(v1, v2))
        {
            System.out.println(v1 + " -> " + v2 + " is connected");
        }
        else
        {
            System.out.println(v1 + " -> " + v2 + " is not connected");
        }
    }
}







