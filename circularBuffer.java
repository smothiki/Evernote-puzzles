import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {

String queue[];
int front;
int rear;
int SIZE;
Solution(int size)
{
SIZE=size;
queue=new String[size];
front=-1;
rear=-1;
}
public void insert(String data)
{
if (rear == SIZE - 1 && front == 0)
{
rear=0;
front++;
}
else if(rear == front - 1&& front!=SIZE-1)
{
rear++;
front++;
}
                else if(rear == front - 1&& front==SIZE-1)
{
rear=SIZE-1;
front=0;
}
                
else
{
if (front == -1)
{
front++;
rear++;
}
else if (rear == SIZE - 1)
{
rear = 0;
}
else
{
rear++;
}
}
queue[rear] = data;
}
public void delete()
{
            if (front == rear)
            {
front = rear = -1;
            }
            else if (front == SIZE - 1)
            {
                front = 0;
            }
            else
            {
front++;
            }
 
}
public void display()
{
if(front!=-1)
if (front <= rear)
{
for (int i = front; i <= rear; i++)
{
System.out.println(queue[i]);
}
}
else
{
ArrayList<String> queues=new ArrayList<String>();
for (int i = front; i < SIZE; i++)
{
System.out.println(queue[i]);
}
for (int i = 0; i <= rear; i++)
{
System.out.println(queue[i]);
}
}
}
public static void main(String args[]) throws IOException
{
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
String line=input.readLine();
String splits[];
int qflag=0;
Solution prob=new Solution(Integer.parseInt(line));
while((line=input.readLine())!=null)
{
splits=line.split(" ");
switch(splits[0].charAt(0))
{
case 'A':
for(int i=0;i<Integer.parseInt(splits[1]);i++)
{
line=input.readLine();
prob.insert(line);
}
break;
case 'R':
for(int i=0;i<Integer.parseInt(splits[1]);i++)
{
prob.delete();
}
break;
case 'L':
prob.display();
break;
case 'Q':
qflag=1;
break;
default :
break;
}
if(qflag==1)
break;
}
}
}
