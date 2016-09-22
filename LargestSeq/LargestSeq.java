import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

public class LargestSeq
{
    ArrayList<HtWt> items;
    ArrayList<HtWt> maxSeq;
    
    public LargestSeq(ArrayList<HtWt> list)
    {
        items = list;
        maxSeq = new ArrayList<HtWt>();
    }                                        
    
    ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2)
    {
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }
    
    int fillNextSeq(int startFrom, ArrayList<HtWt> seq)
    {
        int firstUnfitItem = startFrom;
        if (startFrom < items.size())
        {
            for (int i = 0; i < items.size(); ++i)
            {
                HtWt item = items.get(i);
                if (i == 0 || items.get(i - 1).isBefore(item))
                {
                    seq.add(item);
                }
                else
                {
                    firstUnfitItem = i;
                }
            }
        }
        return firstUnfitItem;
    }
    
    void findMaxSeq()
    {
        Collections.sort(items);
        
        int currentUnfit = 0;
        while (currentUnfit < items.size())
        {
            ArrayList<HtWt> nextSeq = new ArrayList<HtWt>();
            int nextUnfit = fillNextSeq(currentUnfit, nextSeq);
            maxSeq = seqWithMaxLength(maxSeq, nextSeq);

            if (nextUnfit == currentUnfit)
            {
                break;
            }
            else
            {
                currentUnfit = nextUnfit;
            }
        }
        
        for (HtWt i : maxSeq)
        {
            System.out.println(i.height + " " + i.weight);
        }
    }
    
    
    public static void main(String[] args)
    {
        ArrayList<HtWt> list = new ArrayList<HtWt>();
        list.add(new HtWt(65, 100));
        list.add(new HtWt(70, 150));
        list.add(new HtWt(56, 90));
        list.add(new HtWt(56, 91));
        list.add(new HtWt(75, 190));
        list.add(new HtWt(60, 95));
        list.add(new HtWt(68, 110));
        
        LargestSeq ls = new LargestSeq(list);
        ls.findMaxSeq();
    }
}

class HtWt implements Comparable<HtWt>
{
    public int height, weight;

    public HtWt(int h, int w)
    {
        height = h;
        weight = w;
    }
    
    public boolean isBefore(HtWt ht)
    {
        if (this.height < ht.height && this.weight < ht.weight)
        {
            return true;
        }
        return false;
    }
    
    public int compareTo(HtWt ht)
    {
        if (height < ht.height)
        {
            return -1;
        }
        else if (height > ht.height)
        {
            return 1;
        }
        else
        {
            return ht.weight - weight;
        }
    }
}











