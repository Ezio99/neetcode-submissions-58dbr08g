class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];

        for (int[] courses : prerequisites) {
            if (adjList[courses[1]] == null) {
                adjList[courses[1]] = new ArrayList<>();
            }
            adjList[courses[1]].add(courses[0]);
        }

        List<Integer> ordering = new ArrayList<>();
        int[] result = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        Integer ctr = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && recursiveHelper(i, ordering, visited, path, adjList)) {
                return new int[]{};
            }
        }


        for (int i = 0; i < numCourses; i++) {
            result[i] = ordering.get(numCourses - i - 1);
        }

        return result;
    }

    private boolean recursiveHelper(int currentNode, List<Integer> ordering, boolean[] visited, boolean[] path,
                                    List<Integer>[] adjList) {
        if (path[currentNode]) {
            return true;//Contains cycle
        }
        if (visited[currentNode]) {
            return false; //Just returning false as we dont know yet if it has cycle
        }

        visited[currentNode] = true;
        path[currentNode] = true;
        List<Integer> neighbours = adjList[currentNode];
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                if (recursiveHelper(neighbour, ordering, visited, path, adjList)) {
                    return true;
                }
            }
        }
        path[currentNode] = false;
        ordering.add(currentNode);
        return false;

    }
}
