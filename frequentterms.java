import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;




class Store{
  int count;
  String item;
  Store(String item)
  {
    this.item=item;
    count=0;
  }
  void update()
  {
    count++;
  }
  int getCount()
  {
    return count;
  }
  String getItem()
  {
    return item;
  }
}

public class Solution {

  class compared implements Comparator<Store>
  {
    public int compare(Store x, Store y)
    {
      if(x.getCount()<y.getCount())
      return 1;
      if(x.getCount()>y.getCount())
      return -1;
      if(x.getCount()==y.getCount())
      return (x.getItem()).compareToIgnoreCase((y.getItem()));
      return 0;
    }
  }
  HashMap <String,Store> queue=new HashMap<String,Store>();
  void insert(String data)
  {
    Store count;
    if(queue.containsKey(data))
    {
      count=queue.get(data);
      count.update();
      queue.put(data, count);
    }
    else
    {
      count=new Store(data);
      queue.put(data, count);
    }
  }
  void display(int count)
  {
    PriorityQueue<Store> store=new PriorityQueue<Store>(queue.size(),new compared());
    for (Map.Entry<String, Store> entry:queue.entrySet())
    {
      store.add(entry.getValue());
      //System.out.println(entry.getKey()+"--"+entry.getValue().getCount());
    }
    for(int i=0;i<count;i++)
    {
      System.out.println(store.poll().getItem());
    }
  }
  public static void main(String args[]) throws IOException
  {
    BufferedReader input = new BufferedReader((new InputStreamReader(System.in)));
    String count=input.readLine();
    String line;
    Solution prob=new Solution();
    int i=0;
    while(i<Integer.parseInt(count))
    {
      line=input.readLine();
      prob.insert(line.trim());
      i++;
    }
    line=input.readLine();
    prob.display(Integer.parseInt(line));
    input.close();
  }
}
