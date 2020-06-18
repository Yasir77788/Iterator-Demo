package collectiontest;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.Iterator;

public class IteratorDemo
{
    public static void main(String[] args)
    {
       String [] names = {"Ali", "Omar", "David", "Mahirs", "Gafreri", "Adamama"};
       
       ArrayList<String> nameList = new ArrayList<>();
       for(String name: names)
       {
           nameList.add(name);
       }
       
       // define an action for the remaining elements
       Consumer <String> action = x ->
           {
                 System.out.printf("%s\n", x);
           };
        
       // get the iterator to the list
       Iterator<String> iter = nameList.iterator();
        
       while(iter.hasNext())
       {
           String name = iter.next();
           System.out.printf("%s and length is %d\n", name, name.length());
           
           if (name.equals("David"))
           {
               // Act differently for names after David
               iter.forEachRemaining(action);
           }
       }
       
    }
}
