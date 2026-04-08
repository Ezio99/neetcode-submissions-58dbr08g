/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Node root = new Node(node.val);
        HashMap<Integer, Node> visitedMap = new HashMap<>();


        return dfs(node, root, visitedMap);


    }

    public Node dfs(Node node, Node copy, HashMap<Integer, Node> visitedMap) {
        visitedMap.put(node.val, copy);

        List<Node> neighbours = node.neighbors;
        if (!neighbours.isEmpty()) {
            for (Node neighbour : neighbours) {
                if (!visitedMap.containsKey(neighbour.val)) {
                    Node copyNeighbour = new Node(neighbour.val);
                    copy.neighbors.add(copyNeighbour);
                    dfs(neighbour, copy.neighbors.get(copy.neighbors.size() - 1), visitedMap);
                } else {
                    copy.neighbors.add(visitedMap.get(neighbour.val));
                }
            }
        }


        return copy;
    }
}