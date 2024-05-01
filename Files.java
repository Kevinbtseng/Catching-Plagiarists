import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Files
{
    public ArrayList<String> filing(String directory)
    {
        File dir = new File(directory);
        String[] temp = dir.list();
        ArrayList<String> files = new ArrayList<String>();
        for(int i = 0; i < temp.length; i++)
        {
            if(temp[i].endsWith(".txt"))
            {
                files.add(temp[i]);
            }
        }
        return files;
    }

    public ArrayList<String> phrase(String pathName, int numWords) throws FileNotFoundException, NoSuchElementException
    {
        Scanner file = new Scanner(new File(pathName));    
        ArrayList<String> full = new ArrayList();
        ArrayList<Integer> indexes = new ArrayList();
        String temp = "";
        int startSize = 0;
        for (int i = 0; i < numWords; i++)
        {
            if (i == 0)
            {
                String a = file.next().replaceAll("[^A-z]","").toLowerCase();
                indexes.add(a.length());
                temp += a;
            }
            else
            {
                try
                {
                    String a = file.next().replaceAll("[^A-z]","").toLowerCase();
                    temp += a;
                    indexes.add(a.length());
                }
                catch(Exception NoSuchElementException)
                {
                    System.out.println(numWords + " is not a valid amount of words per phrase!");
                    Test.main(null);
                }
            }
        }
        full.add(temp);
        while (file.hasNext())
        {
            String a = file.next().replaceAll("[^A-z]","").toLowerCase();
            indexes.add(a.length());
            temp += a;
            temp = temp.substring(indexes.get(0));
            indexes.remove(0);
            full.add(temp);
        }
        return full;
    }   
}
