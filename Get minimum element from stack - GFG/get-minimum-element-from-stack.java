//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
     int minEle;
    Stack<Integer> s;
    
    // Constructor    
    GfG()
	{
        s = new Stack<>();
        minEle = Integer.MAX_VALUE;
	}
	
    int getMin() {
        if (s.isEmpty()){
           return -1;
        }
        return minEle;
    }

    void push(int x) {
        if(s.empty()){
            s.push(x);
            minEle=x;
        }
        else{
            if(x<minEle){
                int value=2*x-minEle;
                s.push(value);
                minEle=x;
            }else{
                s.push(x);
            }
        }
    }

      int pop() {
        if (s.isEmpty()) {
            return -1;
        }
        int curr=s.pop();
        if(curr>minEle){
            return curr;
        }else{
            int prevmin=minEle;
            int value=2*minEle-curr;
            minEle=value;
            return prevmin;
        }
      }
}

