import java.util.Comparator;
import java.util.PriorityQueue;

public class Median
{
    private Comparator<Integer> maxHeapComparator, minHeapComparator;
    private PriorityQueue<Integer> maxHeap, minHeap;
    
    public Median()
    {
        maxHeapComparator = new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                if (a > b) return -1;
                if (a < b) return 1;
                return 0;
            }
        };
        
        minHeapComparator = new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                if (a > b) return 1;
                if (a < b) return -1;
                return 0;
            }
        };
        
        maxHeap = new PriorityQueue<Integer>(11, maxHeapComparator);
        minHeap = new PriorityQueue<Integer>(11, minHeapComparator);
    }
    
    public void addNewNumber(int randomNumber)
    {
        if (maxHeap.size() == minHeap.size())
        {
            if ((minHeap.peek() != null) && randomNumber > minHeap.peek())
            {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            }
            else
            {
                maxHeap.offer(randomNumber);
            }
        }
        else
        {
            if (randomNumber < maxHeap.peek())
            {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            }
            else
            {
                minHeap.offer(randomNumber);
            }
        }
    }
    
    public double getMedian()
    {
        if (maxHeap.isEmpty()) return minHeap.peek();
        else if (minHeap.isEmpty()) return maxHeap.peek();
        if (maxHeap.size() == minHeap.size())
        {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else if (maxHeap.size() > minHeap.size())
        {
            return maxHeap.peek();
        }
        else
        {
            return minHeap.peek();
        }
    }
    
    public void print()
    {
        System.out.println("max heap top: " + maxHeap.peek());
        System.out.println("min heap top: " + minHeap.peek());
    }
    
    public static void main(String[] args)
    {
        Median m = new Median();
        m.addNewNumber(7);
        m.addNewNumber(10);
        m.addNewNumber(2);
        m.addNewNumber(1);
        m.addNewNumber(5);
        m.addNewNumber(6);
        m.print();
        System.out.println(m.getMedian());
    }
}