import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class TransWord
{
    LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary)
    {
        startWord = startWord.toUpperCase();
        stopWord = stopWord.toUpperCase();
        Queue<String> actionQueue = new LinkedList<String>();
        Set<String> visitedSet = new HashSet<String>();
        Map<String, String> backtrackMap = new TreeMap<String, String>();
        
        actionQueue.add(startWord);
        visitedSet.add(startWord);
        
        while (!actionQueue.isEmpty())
        {
            String w = actionQueue.poll();
            // For each possible word v from w with one edit operation
            for (String v : getOneEditWords(w))
            {
                if (v.equals(stopWord))
                {
                    // Found our word, now back track
                    LinkedList<String> list = new LinkedList<String>();
                    // Append v to list
                    list.add(v);
                    while (w != null)
                    {
                        list.add(0, w);
                        w = backtrackMap.get(w);
                    }
                    return list;
                }
                // If v is a dictionary word
                if (dictionary.contains(v))
                {
                    if (!visitedSet.contains(v))
                    {
                        actionQueue.add(v);
                        visitedSet.add(v);
                        backtrackMap.put(v, w);
                    }
                }
            }
        }
        return null;
    }
    
    Set<String> getOneEditWords(String word)
    {
        Set<String> words = new TreeSet<String>();
        for (int i = 0; i < word.length(); ++i)
        {
            char[] wordArray = word.toCharArray();
            
            for (char c = 'A'; c <= 'Z'; ++c)
            {
                if (c != word.charAt(i))
                {
                    wordArray[i] = c;
                    words.add(new String(wordArray));
                }
            }
        }
        return words;
    }
}










