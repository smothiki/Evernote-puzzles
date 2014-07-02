import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Arrays;

public class Solution {
public static void main(String args[]) throws IOException
{
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
String line=input.readLine();
String splits[];
class compared implements Comparator<Integer>
{
public int compare(Integer x, Integer y)
{
if(x<y)
return -1;
if(x>y)
return 1;
return 0;
}
}
PriorityQueue<Integer> queue=new PriorityQueue<Integer>(4,new compared());
while((line=input.readLine())!=null)
{
if(queue.size()<4)
{
//System.out.println("<4"+line);
queue.add(Integer.parseInt(line));
}
else{
int a=queue.peek();
if(a<Integer.parseInt(line))
{
//System.out.println(a+"-"+line);
queue.poll();
queue.add(Integer.parseInt(line));
}
}
}
int ar[ ]=new int[4];
                int counter=0;
for(int i:queue)
{
ar[counter++]=i;
//System.out.println(i);
}
            Arrays.sort(ar);
for(int i=3;i>=0;i--)
{
System.out.println(ar[i]);
}
}
}
