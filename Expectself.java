import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
int input[];
int total;
        int counter;
        int zeroposition;
        int zeroCount;
Solution(int size)
{
input=new int[size];
                total=1;
                counter=0;
                zeroCount=0;
                zeroposition=0;
}
void insert(int data)
{
            if(data == 0) {
                zeroCount++;
                input[counter++]=data;
          } else {
              input[counter++]=data;
        total *= data;
      }
}
void eliminateSelf()
{
            for(int i=0;i<input.length;i++)
            {
                 int item = input[i];
              if(item == 0) {
            if(zeroCount == 1) {
              System.out.println(total);
        } else {
          System.out.println(0);
        }
      } else {
        if(zeroCount == 0) {
          System.out.println(total / item);
        } else {
          System.out.println(0);
        }
      }
                
}
        }
public static void main(String args[]) throws IOException
{
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
String count=input.readLine();
String line;
Solution prob=new Solution(Integer.parseInt(count));
int i=0;
while(i<Integer.parseInt(count))
{
line=input.readLine();
prob.insert(Integer.parseInt(line));
                    i++;
}
prob.eliminateSelf();

}
}
