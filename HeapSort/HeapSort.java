public class HeapSort
{
    public static int left(int i)
    {
        return i * 2 + 1;
    }
    
    public static int right(int i)
    {
        return i * 2 + 2;
    }
    
    public static void swap(int a[], int i, int largest)
    {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }
    
    public static void maxHeapify(int[] a, int i, int length)
    {
        int l = left(i);
        int r = right(i);
        int largest = i;
        
        if (l < length && a[l] > a[i])
        {
            largest = l;
        }
        if (r < length && a[r] > a[largest])
        {
            largest = r;
        }
        if (i != largest)
        {
            swap(a, i, largest);
            maxHeapify(a, largest, length);
        }
    }
    
    public static void maxHeapify_iter(int[] a, int i, int length)
    {
        int l = left(i);
        int r = right(i);
        int largest = i;
        
        while(true)
        {
            if (l < length && a[l] > a[i])
            {
                largest = l;
            }
            if (r < length && a[r] > a[largest])
            {
                largest = r;
            }
            if (i != largest)
            {
                swap(a, i, largest);
            }
            else
            {
                break;
            }
            i = largest;
            l = left(i);
            r = right(i);
        }
    }
    
    public static void buildMaxHeap(int[] a)
    {
        for (int i = a.length / 2; i >= 0; --i)
        {
            maxHeapify(a, i, a.length);
        }
    }
    
    public static void sort(int[] a)
    {
        if (a == null || a.length <= 1)
        {
            return;
        }
        
        buildMaxHeap(a);
        int length = a.length;
        for (int i = a.length - 1; i > 0; --i)
        {
            swap(a, i, 0);
            length--;
            maxHeapify(a, 0, length);
        }
    }
    
    public static void main(String[] args)
    {
        int a[] = { 10, 2, 30, 4, 5, 13, 11, 91, 23, 87 };
        HeapSort.sort(a);
        for (int i : a)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}





