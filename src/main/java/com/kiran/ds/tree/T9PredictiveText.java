package com.kiran.ds.tree;

import java.util.ArrayList;
import java.util.List;

//     [2,2,8]     --      [act,bat,cat,actually]

//         2
//         |
//         2
//         |
//         8---------------------
//         |      |      |      |
//         act   bat    cat  actually

public class T9PredictiveText {
    public static void main(String[] args) {
        Node pred61 = new Node("baun");
        Node pred62 = new Node("caum");
        Node six = new Node("6", new Node[]{pred61,pred62});

        Node pred81 = new Node("act");
        Node pred82 = new Node("bat");
        Node pred83 = new Node("cat");
        Node pred84 = new Node("actually");
        Node eight = new Node("8", new Node[]{pred81,pred82,pred83,pred84,six});


        Node pred91 = new Node("baw");
        Node pred92 = new Node("bay");
        Node pred93 = new Node("caw");
        Node pred94 = new Node("cay");
        Node nine = new Node("9", new Node[]{pred91,pred92,pred93,pred94});

        Node two2 = new Node("2", new Node[]{nine,eight});
        Node two1 = new Node("2", new Node[]{two2});
        Node root = new Node("", new Node[]{two1});

        List<String> result = new ArrayList<> ();
        getPredictions(-1, new String[]{"2","2","9"}, root, result);
        System.out.println(result);
    }

    static void getPredictions(int i, String[] chars, Node node, List<String> result) {
        // Base case: index out-of-bounds, empty node value, char value neq node value
        if(i>chars.length-1 || (!node.value.equals("") && !chars[i].equals(node.value))) {
            return;
        }
        Node[] children = node.children;
        // Base case: index eq chars last index, then result found
        if(i == chars.length-1) {
            for(Node child : children) {
                if(child.children == null) {
                    result.add(child.value);
                }
            }
        } else {    // Recurse through the child nodes by incrementing index
            for(Node child : children) {
                getPredictions(++i, chars, child, result);
            }
        }
    }

    private static class Node {
        String value;
        Node[] children;

        Node(String value) {
            this.value = value;
        }
        Node(String value, Node[] children) {
            this.value = value;
            this.children = children;
        }
    }
}
