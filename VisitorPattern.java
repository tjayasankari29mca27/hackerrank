import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}
class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
        // Internal nodes are not leaves
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

// FIX: Match the exact naming context invoked by the uneditable main block
class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;

    @Override
    public int getResult() {
        return (int) result;
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeafSum = 0;

    @Override
    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeafSum);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Solution {
    // A fast I/O custom parser avoids Timeout Errors on 10^5 node updates
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    // Single-node constraints handled elegantly via array primitives 
    public static Tree solve() {
        FastReader fr = new FastReader();
        String firstToken = fr.next();
        if (firstToken == null) return null;
        int n = Integer.parseInt(firstToken);
        
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = fr.nextInt();
        
        Color[] colors = new Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = (fr.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        // Handle single-node edge-case safely
        if (n == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }

        // Using List arrays instead of nested Maps avoids huge memory allocations
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        Tree[] nodes = new Tree[n];
        int[] depths = new int[n];
        Arrays.fill(depths, -1);
        depths[0] = 0;

        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        
        int[] order = new int[n];
        int head = 0, tail = 0;
        order[tail++] = 0;
        
        // Fast Array-backed BFS execution
        while (head < tail) {
            int u = order[head++];
            for (int v : adj[u]) {
                if (depths[v] == -1) {
                    depths[v] = depths[u] + 1;
                    parents[v] = u;
                    order[tail++] = v;
                }
            }
        }

        // Identify structural leaf status efficiently via parent tracking arrays
        boolean[] hasChildren = new boolean[n];
        for (int i = 1; i < n; i++) {
            hasChildren[parents[i]] = true;
        }

        // Build leaf elements upward to avoid recursion stack overflow limits
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            if (!hasChildren[u]) {
                nodes[u] = new TreeLeaf(values[u], colors[u], depths[u]);
            } else {
                nodes[u] = new TreeNode(values[u], colors[u], depths[u]);
            }
        }

        // Connect the calculated child nodes directly to their parents 
        for (int i = 1; i < n; i++) {
            int p = parents[i];
            ((TreeNode) nodes[p]).addChild(nodes[i]);
        }
        
        return nodes[0];
    }




    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}
