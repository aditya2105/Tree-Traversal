import java.util.*;
public class Tree 
{
	public void preorder(BinaryTreeNode root)
	{ if (root==null)
		return ;
	Stack <BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
	stack.push(root);
	
	while(!stack.empty())
	{ BinaryTreeNode n= stack.pop();
	   System.out.println(n.data);
	   if(n.right!=null)
		   stack.push(n.right);
	   if(n.left!=null)
		   stack.push(n.left);
	   }
	}
	
	
	
	public void inorder(BinaryTreeNode root)
	{  if(root==null)
		return;
	 Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
	   BinaryTreeNode c=root;
	     while(!s.empty() || c!=null)
	     { if(c!=null)
	         { s.push(c);
	          c=c.left;
	         }
	     else
	     {BinaryTreeNode n=s.pop();
	       System.out.println(n.data);
	       c=n.right;
	      }
	     }
	}
	 
	public void postorder(BinaryTreeNode root)
	{ if(root==null)
        return;
	    Stack<BinaryTreeNode> st=new Stack<BinaryTreeNode>();
	    BinaryTreeNode cn=root;
	      while(true)
	      {  if(cn!=null)
	         {if(cn.right!=null)
	    	  st.push(cn.right);
	         st.push(cn);
	         cn=cn.left;
	          continue;       
	      }
	       if(st.empty()) 
	    	   return;
	       cn=st.pop();
	       
	       if(cn.right!=null && !st.empty() && cn.right==st.peek())
	       {  st.pop();
	             st.push(cn);
	             cn=cn.right;
	       }
	       else 
	       {System.out.println(cn.data);
	        cn=null;
	       }
	       
	      }
	      
	}
	     
	
	
    
	public static void main(String arg[])
	{  Scanner obj=new Scanner(System.in);
	 System.out.println("Enter number of nodes");
	 int n=obj.nextInt();
       int a[]=new int[n+1];
       
       System.out.println("Enter the nodes in order:");
       for(int i=0;i<n;i++)
         a[i]=obj.nextInt();
       
       Tree t=new Tree();
       
        BinaryTreeNode root=new BinaryTreeNode(a[0]);
      
        
        ArrayList<BinaryTreeNode> al= new ArrayList<BinaryTreeNode>(n);  
        al.add(root);
        for(int i=0;i<n;i++)
        { if(2*i + 1 <n)
        	{  BinaryTreeNode l=new BinaryTreeNode(a[2*i + 1]);
        	   (al.get(i)).left=l;
        	   al.add((al.get(i)).left);
        	}
        if(2*i + 2 <n)
        {BinaryTreeNode r=new BinaryTreeNode(a[2*i + 2]);
             (al.get(i)).right=r;
             al.add((al.get(i)).right);
             
        }
        }
        
        
        
    System.out.println("preorder :");    
	t.preorder(root);
	System.out.println("inorder:");
	t.inorder(root);
	System.out.println("postorder:");
	t.postorder(root);
	}
}