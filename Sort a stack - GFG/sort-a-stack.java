//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
	Stack<Integer> stack = new Stack<>();
        while(!s.isEmpty()){
            int top=s.pop();
            insert(stack, top);
        }
        return stack;
    }
    public static void insert(Stack<Integer> res, int val){
        if(res.isEmpty() || res.peek()<=val){
            res.push(val);
            return;
        }
        int top=res.pop();
        insert(res,val);
        res.push(top);
    }
}