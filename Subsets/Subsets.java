import java.util.LinkedList;
import java.util.ArrayList;

public class Subsets
{
    public static LinkedList<Integer> q;

    public static void print(int[] arr)
    {
        q = new LinkedList<Integer>();
        
        if (arr.length == 0) return;
        
        print_worker(arr, 0);
        
    }
    
    public static void print_worker(int[] arr, int cur)
    {
        if (cur > arr.length - 1)
        {
            for (int i = 0; i < q.size(); ++i)
            {
                System.out.print(q.get(i) + " ");
            }
            System.out.println();
            return;
        }
        
        q.addLast(arr[cur]);
        print_worker(arr, cur + 1);
        q.removeLast();
        print_worker(arr, cur + 1);
    }
    
    public ArrayList<ArrayList<Integer>> get(ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> allsubsets;
        
        if (set.size() == index)
        {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }
        else
        {
            allsubsets = get(set, index + 1);
            
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets)
            {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
    
    public ArrayList<ArrayList<Integer>> get2(ArrayList<Integer> set)
    {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        
        int max = 1 << set.size();
        for (int i = 0; i < max; ++i)
        {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            int k = i;
            int index = 0;
            while (k > 0)
            {
                if ((k & 1) > 0)
                {
                    subset.add(set.get(index));
                }
                k >>= 1;
                index++;
            }
            allsubsets.add(subset);
        }
        return allsubsets;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);

        int[] arr = { 1, 2, 3, 4, 5 };

        // test print
        Subsets.print(arr);
        
        // test get
        ArrayList<ArrayList<Integer>> al;
        Subsets s = new Subsets();
        al = s.get(test, 0);
        for (int i = 0; i < al.size(); ++i)
        {
            ArrayList<Integer> inner = al.get(i);
            for(int j = 0; j < inner.size(); ++j)
            {
                System.out.print(inner.get(j) + " ");
            }
            System.out.println();
        }
        
        // test get2
        al = s.get2(test);
        for (int i = 0; i < al.size(); ++i)
        {
            ArrayList<Integer> inner = al.get(i);
            for(int j = 0; j < inner.size(); ++j)
            {
                System.out.print(inner.get(j) + " ");
            }
            System.out.println();
        }
    }
}