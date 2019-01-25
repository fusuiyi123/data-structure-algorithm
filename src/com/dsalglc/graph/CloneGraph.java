package com.dsalglc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 133. Clone Graph
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    private HashMap<Integer, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<>();
        return dfs(node);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }
        return clone;
    }
}
