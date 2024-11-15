/*  
Name: Tsugoii
Date: 26/09/2021
Description: Main
*/

import java.lang.*;
import java.util.*;

public class BinaryTree {
    // The actual code we care about
  private Node root;

  public BinaryTree(String input) throws InvalidTreeSyntax {
    if (input == null || input.trim().length() == 0)
      return;
    input = input.trim();

    if (charCount(input, '(') != charCount(input, ')'))
      throw new InvalidTreeSyntax("Uneven number of parentheses");

    if (charCount(input, ' ') > 0)
      throw new InvalidTreeSyntax("Please enter tree with no spaces");

    try {
      root = createNodes(input);
    } catch (Exception exception) {
      throw new InvalidTreeSyntax("Malformed parenthetical structure: " + exception.getMessage());
    }
  }

  @Override
  public String toString() {
    return root.toString();
  }

  private long charCount(String input, Character character) {
    return input.chars().filter(ch -> ch == character).count();
  }

  private Node createNodes(String input) throws InvalidTreeSyntax {
    if (input.length() < 3 || input.charAt(0) != '(') {
      throw new InvalidTreeSyntax("Node is not fully formed. " + input);
    }

    Node node = new Node(input.charAt(1));

    int parenthesesCount = 0;

    for (int i = 2; i < input.length(); i++) {

      if (input.charAt(i) == ')')
        break;

      else if (input.charAt(i) == '(') {
        int j = i;
        parenthesesCount++;
        while (parenthesesCount != 0) {
          j++;
          if (input.charAt(j) == '(')
            parenthesesCount++;
          else if (input.charAt(j) == ')')
            parenthesesCount--;
        }
        if (node.Left == null) {
          node.Left = createNodes(input.substring(i, j + 1));
        } else {
          node.Right = createNodes(input.substring(i, j + 1));
        }
        i = j;
      }

      else {
        throw new InvalidTreeSyntax("Saw back-to-back characters.");
      }
    }
    return node;
  }

  public boolean isBalanced() {
    if (root == null)
      return true;

    return isBalanced(root);
  }

  public boolean isFull() {
    int height = height();
    int count = nodeCount(root);

    int runningTotal = (int) Math.pow(2, height);
    while (height > -1) {
      height--;
      runningTotal += (int) Math.pow(2, height);
    }

    return count == runningTotal;
  }

  public boolean isProper() {
    return isProper(root);
  }

  private boolean isProper(Node node) {
    if (node == null)
      return true;

    return !(node.Left == null ^ node.Right == null) && isProper(node.Left) && isProper(node.Right);
  }

  private boolean isBalanced(Node node) {
    if (node == null)
      return true;

    int diff = Math.abs(height(node.Left) - height(node.Right));

    return diff < 2 && isBalanced(node.Left) && isBalanced(node.Right);
  }

  public int count() {
    return nodeCount(root);
  }

  private int nodeCount(Node node) {
    if (node == null)
      return 0;

    return nodeCount(node.Left) + nodeCount(node.Right) + 1;
  }

  public int height() {
    return height(root) - 1;// to account for zero-base
  }

  private int height(Node node) {
    if (node == null)
      return 0;
    else {
      return Math.max(height(node.Left), height(node.Right)) + 1;
    }
  }

  private class Node {
    public Node Left;
    public Node Right;
    public Character Data;

    public Node(Character data) {
      Data = data;
    }

    public String toString() {
      String result = "(";
      if (Left != null)
        result += Left.toString();

      result += " " + this.Data + " ";

      if (Right != null)
        result += Right.toString();

      return result + ")";
    }
  }
}