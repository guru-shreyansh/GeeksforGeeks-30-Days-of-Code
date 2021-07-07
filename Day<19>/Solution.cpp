#include <bits/stdc++.h>
#include <unordered_set>
using namespace std;

class Solution
{
    public:
    int candies(int m, int n)
    {
    	int X = (m * n) - m - n;
    	unordered_set<int> hash_set;
    	queue<int> queue;
    	queue.push(X);
    	hash_set.insert(X);

        int count = 0;
    	while (queue.size() > 0)
    	{
    		int curr = queue.front();
    		queue.pop();
    		count++;

    		int key = curr-m;
    		if (key > 0 && (hash_set.find(key) == hash_set.end()))
    		{
    			queue.push(key);
    			hash_set.insert(key);
    		}

    		key = curr-n;
    		if (key > 0 && (hash_set.find(key) == hash_set.end()))
    		{
    			queue.push(key);
    			hash_set.insert(key);
    		}
    	}
    	return count;
    }
};

int main() 
{ 
	int t;
	cin>>t;
	while (t--)
	{
		int m,n;
		cin>>m>>n;
		Solution obj;
		cout << obj.candies(m,n)<<endl;
	}
	return 0;
}
