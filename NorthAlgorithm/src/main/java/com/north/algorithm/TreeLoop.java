package com.north.algorithm;

import java.util.*;


/**
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，并且我们用值-1代表一个节点为空。
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 * 输入描述:
 * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。输入的树最多为7层。
 * 输出描述:
 * 输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。
 * 示例1
 * 输入
 * 3 5 7 -1 -1 2 4
 * 输出
 * 3 7 2
 * 说明
 * 数组存储的二叉树如图，故到最小叶子节点的路径为3 7 2
 * 示例2
 * 输入
 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * 输出
 * 5 8 7 6
 * 说明
 * 数组存储的二叉树如图，故到最小叶子节点的路径为10 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124528902
 */
public class TreeLoop {

 public static void main(String[] args) {

     /**
      * 1. 将数组转换成二叉树
      * 2. 找到二叉树的最小节点
      * 3. 从最小节点往上寻找，将节点或者节点值放到栈中，然后打印
      */

     String input = "0 "+"3 5 7 -1 -1 2 4";
     String[] split = input.split(" ");

     TreeNode tree = new TreeNode(Integer.valueOf(split[1]));
     generateNode(tree,split,1);
//    System.out.println("1");

     Queue<TreeNode> queue = new LinkedList<>();
     queue.add(tree.left);
     queue.add(tree.right);

     TreeNode minNode = new TreeNode(Integer.MAX_VALUE);
    while (!queue.isEmpty()){
        TreeNode node = queue.poll();
        if(node.val < minNode.val){
            minNode = node;
        }

        if (node.left != null && node.left.val != -1){
            queue.add(node.left);
        }
        if(node.right != null && node.right.val != -1){
            queue.add(node.right);
        }
    }

    Stack<TreeNode> stack = new Stack<>();
    while( minNode!= null){
        stack.push(minNode);
        minNode = minNode.parent;
    }

    StringBuilder builder = new StringBuilder();
    while(stack.size()>1){
        builder.append(stack.pop().val+" ");
    }

    System.out.print(builder.append(stack.pop().val));


 }



 public static void generateNode(TreeNode tree, String[] array,int index){
//     3 5 7 -1 -1 2 4
//     if("-1".equals(array[index]))
//         return ;
     if (2*index >= array.length) return ;

     tree.left = new TreeNode(Integer.valueOf(array[2*index]),tree);

     if (2*index+1 >= array.length) return ;

     tree.right =new TreeNode(Integer.valueOf(array[2*index+1]),tree);
     generateNode(tree.left,array,2*index);
     generateNode(tree.right,array,2*index+1);

 }



 public List<Integer> inorderTraversal(TreeNode tree){
   List<Integer> list = new ArrayList<>();
   inorder(tree,list);
   return list;

 }

 public void inorder(TreeNode tree, List<Integer> list){
     if (tree == null){
      return;
     }
     inorder(tree.left,list);
     list.add(tree.val);
     inorder(tree.right,list);
 }


 static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode parent;

      TreeNode() {}


      TreeNode(int val) { this.val = val; }

     TreeNode(int val,TreeNode parent) {
          this.val = val;
          this.parent = parent;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
        this.right = right;
      }
     TreeNode(int val, TreeNode left, TreeNode right,TreeNode parent) {
         this.val = val;
         this.left = left;
         this.right = right;
         this.parent = parent;
     }
  }
}
