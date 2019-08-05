/**************************************************************************
*                                                                         *
*     Program Filename:  Student4.java                                    *
*     Author          :  Jasmine McCants                                  *
*     Date Written    :  April 24, 2017                                   *
*     Purpose         :  To build and profile a binary search tree        *
*     Input from      :  Keyboard and a file to be named at the keyboard  *
*     Output to       :  Screen                                           *
*                                                                         *
**************************************************************************/
import java.util.Scanner;
import java.io.*;

public class Mccants4
{
public static class TreeNode
{
   TreeNode LeftLink;
   int      Content;
   TreeNode RightLink;
   
   public TreeNode(TreeNode LeftLink, TreeNode RightLink, int Content)
   {
	   this.LeftLink = LeftLink;
	   this.RightLink = RightLink;
	   this.Content = Content;
   }
}

// end class TreeNode

public static void main(String[] args) throws IOException
{
   TreeNode T = null;
   int      H, i;

   T = BuildSearchTree();

   H = Height(T);
   System.out.println("The number of nodes on the tree is " + NodeCount(T));
   System.out.println("The height of the tree is " + H);
   for (i = 0; i <= H; i++)
      System.out.println("The number of nodes on level " + i + " is " + CountLevel(T,i));
   // end for
}
// end main method

/*********************************************************************
*                                                                    *
*     Method Name     :  Height                                      *
*     Purpose         :  To return the height of a BST               *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static int Height(TreeNode T)
{
   if (T == null)
      return -1;
   // end if

   int LeftHeight = -1, RightHeight = -1;

   if (T.LeftLink != null)
      LeftHeight = Height(T.LeftLink);
   // end if

   if (T.RightLink != null)
      RightHeight = Height(T.RightLink);
   // end if

   if (LeftHeight > RightHeight)
      return LeftHeight + 1;
   else
      return RightHeight + 1;
   // end if
}
// end method Height

/*********************************************************************
*                                                                    *
*     Method Name     :  NodeCount                                   *
*     Purpose         :  To return the number of nodes on a BST      *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static int NodeCount(TreeNode T)
{
   if (T == null)
      return 0;
   // end if

   return (NodeCount(T.LeftLink) + NodeCount(T.RightLink) + 1);
}
// end method NodeCount

/*********************************************************************
*                                                                    *
*     Method Name     :  CountLevel                                  *
*     Purpose         :  To return the number of nodes on level N    *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
*********************************************************************/
public static int CountLevel(TreeNode T, int N)
{
   if (T == null)
      return 0;
   // end if

   if (N == 0)
      return 1;
   else
      return CountLevel(T.LeftLink, N-1) + CountLevel(T.RightLink, N-1);
   // end if
}
// end method CountLevel

/*********************************************************************
*                                                                    *
*     Method Name     :  BuildSearchTree                             *
*     Purpose         :  To build a binary search tree               *
*     Called by       :  Main Method                                 *
*     Methods Called  :  None                                        *
*                                                                    *
 * @param content 
 * @param leftLink 
*********************************************************************/
public static TreeNode BuildSearchTree() throws IOException
{
	Scanner Keyboard = new Scanner(System.in);
	System.out.println("Please enter the name of the input file:");
	String NameOfTheInputFile = Keyboard.nextLine();
	Scanner InputFile = new Scanner(new File(NameOfTheInputFile));
	
	TreeNode root = new TreeNode(null, null, InputFile.nextInt());
	
	while(InputFile.hasNext())
	{
		Insert(root, InputFile.nextInt());
		
	}
	return root;
}
private static void Insert(TreeNode root, int Content) 
{
	if (Content < root.Content) 
	{
        if (root.LeftLink == null) 
        {
            root.LeftLink = new TreeNode(null, null, Content);
          
        } else 
        {
            Insert(root.LeftLink, Content);
        }
    } else if (Content > root.Content) 
    {
        if (root.RightLink == null) 
        {
            root.RightLink = new TreeNode(null, null, Content);
           
        } else 
        {
            Insert(root.RightLink, Content);
        }
    }
}

// end method BuildSearchTree

}
// end class Student4


