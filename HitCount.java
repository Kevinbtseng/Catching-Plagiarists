import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This HitCount class represents . . .
 *
 * @author  (your name)
 * @version (todays date)
 */
public class HitCount
{
    private ArrayList<String> filea;
    private ArrayList<String> fileb;
    public HitCount()
    {
        Files file = new Files();
    }

    public HitCount(String a, String b, int phraseLength) throws FileNotFoundException
    {
        Files file = new Files();
        filea = file.phrase(a, phraseLength);
        fileb = file.phrase(b, phraseLength);
    }
    
    public int mHitcount (int phraseLength, int tHold, String path, ArrayList<String> dir) throws FileNotFoundException
    {
        Files file = new Files();
        ArrayList<HashSet<String>> save = new ArrayList();
        HashSet<String> hSet = new HashSet();        
        ArrayList<String> directs = new ArrayList();
        ArrayList<Integer> index = new ArrayList();
        
        int hC = 0;
        int count = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < dir.size(); i++)
        {
            HashSet<String> currentSet = new HashSet(file.phrase(path + dir.get(i), phraseLength));
            save.add(currentSet);
        }
        for (int i = 0; i < dir.size() - 1; i++)
        {
            HashSet<String> saveSet = new HashSet(save.get(i));
            for (int j = i + 1; j < dir.size(); j++)
            {
                saveSet.retainAll(save.get(j));
                if (saveSet.size() >= tHold)
                {
                    hC = saveSet.size();
                    directs.add("[" + dir.get(i) + ", " + dir.get(j) + "] = " + hC);
                    index.add(hC);
                }
                saveSet = new HashSet(save.get(i));
                count++;
                System.out.print("\f");
                System.out.println("Number of files scanned: " + count);
            }
        }
        quickSort(index, directs, 0, index.size() - 1);
        long endTime = System.currentTimeMillis();
        System.out.print("\f");
        System.out.println("Number of files scanned: " + count + "\n");
        for (String a : directs)
        {
            System.out.println(a);
        }
        System.out.println("\n" + "Plagiarism was detected in " + directs.size() + " files." + "\n" + 
                           count + " files were scanned in total over the time of " + (endTime - startTime) + " milliseconds.");
        return hC;   
    }
    
    public void quickSort(ArrayList<Integer> arr, ArrayList<String> arr2, int begin, int end) 
    {
        if (begin < end) 
        {
            int partitionIndex = partition(arr, arr2, begin, end);
            quickSort(arr, arr2, begin, partitionIndex-1);
            quickSort(arr, arr2, partitionIndex+1, end);
        }
    }

    private int partition(ArrayList<Integer> arr, ArrayList<String> arr2, int begin, int end) 
    {
        int pivot = arr.get(end);
        int i = (begin-1);
        for (int j = begin; j < end; j++)   
        {
            if (arr.get(j) <= pivot)    
            {
                i++;
                int swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
                String swapTemp2 = arr2.get(i);
                arr2.set(i, arr2.get(j));
                arr2.set(j, swapTemp2);
            }
        }
        int swapTemp = arr.get(i+1);
        arr.set(i+1, arr.get(end));
        arr.set(end, swapTemp);
        String swapTemp2 = arr2.get(i+1);
        arr2.set(i+1, arr2.get(end));
        arr2.set(end, swapTemp2);
        return i+1;
    }
}
