/*  
Name: Tsugoii
Date: 26/09/2021
Description: Main
*/

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Project3 extends JFrame implements ActionListener {

    public static BinaryTree tree;

    public static void main(String[] args) {
        // GUI THINGS
        JFrame framea = new JFrame("Binary Tree Categorizer");
        JButton a = new JButton("Make Tree");
        a.setBounds(10, 75, 100, 25);
        JButton b = new JButton("Is Balanced?");
        b.setBounds(120, 75, 100, 25);
        JButton c = new JButton("Is Full?");
        c.setBounds(230, 75, 100, 25);
        JButton d = new JButton("Is Proper?");
        d.setBounds(340, 75, 100, 25);
        JButton e = new JButton("Height");
        e.setBounds(450, 75, 100, 25);
        JButton f = new JButton("Nodes");
        f.setBounds(560, 75, 100, 25);
        JButton g = new JButton("Inorder");
        g.setBounds(670, 75, 100, 25);
        JTextField enterTree = new JTextField("Enter Tree:");
        enterTree.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        enterTree.setBounds(120, 10, 100, 25);
        enterTree.setEditable(false);
        JTextField output = new JTextField("Output:");
        output.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        output.setBounds(120, 150, 100, 25);
        output.setEditable(false);
        JTextArea enterTreeText = new JTextArea();
        enterTreeText.setBounds(220, 10, 350, 20);
        JTextArea outputText = new JTextArea();
        outputText.setBounds(220, 150, 350, 20);
        outputText.setEditable(false);
        a.addActionListener(new ActionListener() {
            // Drivers for BinaryTree class and Catching Exceptions
            public void actionPerformed(ActionEvent e) {
                try {
                    BinaryTree x = new BinaryTree(enterTreeText.getText());
                    tree = x;
                    outputText.setText(tree.toString());
                } catch (InvalidTreeSyntax exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BinaryTree x = tree;
                outputText.setText(String.valueOf(x.isBalanced()));
                // for each node in the tree,the absolute difference between the height of its
                // left and right subtrees is at most 1
            }
        });
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BinaryTree x = tree;
                outputText.setText(String.valueOf(x.isFull()));
                // as the maximum number of nodes for a tree of its height.
            }
        });
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BinaryTree x = tree;
                outputText.setText(String.valueOf(x.isProper()));
                // every node has either 0 or 2 children
            }
        });
        e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BinaryTree x = tree;
                outputText.setText(String.valueOf(x.height()));
                // The height of a tree is the maximum level of all of its nodes
            }
        });
        f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BinaryTree x = tree;
                outputText.setText(String.valueOf(x.count()));
                // number of nodes in the tree
            }
        });
        g.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BinaryTree x = tree;
                outputText.setText(x.toString());
                // ully parenthesized inorder traversal of the tree
            }
        });
        framea.add(a);
        framea.add(b);
        framea.add(c);
        framea.add(d);
        framea.add(e);
        framea.add(f);
        framea.add(g);
        framea.add(enterTree);
        framea.add(output);
        framea.add(enterTreeText);
        framea.add(outputText);
        framea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framea.setSize(800, 225);
        framea.setLayout(null);
        framea.setVisible(true);
    }
}