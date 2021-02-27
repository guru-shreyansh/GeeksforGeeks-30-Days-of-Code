#include<bits/stdc++.h>
using namespace std;
 
/* Link list node */
struct Node
{
    int data;
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};

void push(struct Node** head_ref, int new_data)
{
   
    struct Node* new_node = new Node(new_data);
    
    new_node->next = (*head_ref);
    (*head_ref)    = new_node;
} 

int countTriplets(struct Node* head, int x) ;

/* Driver program to test count function*/
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n , x ,i , num;
        struct Node *head = NULL;
        cin>>n>>x;
        for(i=0;i<n;i++)
        {
            cin>>num;
            push(&head,num);
        }
 
    /* Check the count function */
    cout <<countTriplets(head, x)<< endl;
    }
    return 0;
}// } Driver Code Ends


//User function Template for C++

int countTriplets(struct Node* head, int x) 
{ 
    struct Node* ptr, *ptr1, *ptr2; 
    int count = 0; 
  
    // unordered_map 'um' implemented as hash table 
    unordered_map<int, Node*> um; 
  
    // insert the <node data, node pointer> tuple in 'um' 
    for (ptr = head; ptr != NULL; ptr = ptr->next) 
        um[ptr->data] = ptr; 
  
    // generate all possible pairs 
    for (ptr1 = head; ptr1 != NULL; ptr1 = ptr1->next) 
        for (ptr2 = ptr1->next; ptr2 != NULL; ptr2 = ptr2->next) { 
  
            // p_sum - sum of elements in the current pair 
            int p_sum = ptr1->data + ptr2->data; 
  
            // if 'x-p_sum' is present in 'um' and either of the two nodes 
            // are not equal to the 'um[x-p_sum]' node 
            if (um.find(x - p_sum) != um.end() && um[x - p_sum] != ptr1 
                && um[x - p_sum] != ptr2) 
  
                // increment count 
                count++; 
        } 
  
    // required count of triplets 
    // division by 3 as each triplet is counted 3 times 
    return (count / 3); 
}
