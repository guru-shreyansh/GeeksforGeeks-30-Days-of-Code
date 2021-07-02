import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int a)
	{
        data = a;
        next = null;
    }
}

class LinkedList
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0)
		{
            int n=sc.nextInt();
            int x=sc.nextInt();
            Node head=null;
            for (int i=0; i<n; i++)
            {
				int a=sc.nextInt();
                if(head==null)
				{
                	head=new Node(a);
            	}
            	else
                	insert(head,a);
            }
            Solve y = new Solve();
            System.out.println(y.countTriplets(head,x));
        }
    }
    public static Node insert(Node head, int a)
	{
        if (head==null)
		{
            return new Node(a);
        }
        head.next=insert(head.next,a);
        return head;
    }
}

class Solve
{
    static int countTriplets(Node head, int x)
    {
        int triplets = 0;
        Node firstPtr = head;
		HashSet<Integer> visited = new HashSet<Integer>();

		while (firstPtr != null)
		{
			Node secondPtr = firstPtr.next;
			while (secondPtr != null)
			{
				if ( visited.contains(x - (firstPtr.data + secondPtr.data)) )
					++triplets;

				secondPtr = secondPtr.next;
			}

			visited.add(firstPtr.data);
			firstPtr = firstPtr.next;
		}
		return triplets;
    } 
}
