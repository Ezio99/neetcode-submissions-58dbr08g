class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new List[numCourses];
        for (int[] condition : prerequisites) {
            if (adjacencyList[condition[1]] == null) {
                adjacencyList[condition[1]] = new ArrayList<>();
            }
            adjacencyList[condition[1]].add(condition[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
//        int[] ordering = new int[numCourses];
        int ctr = 0;
        for (int i = 0; i < numCourses; i++) {
            ctr++;
            if (!visit[i] && recursiveHelper(i, visit, adjacencyList, path)) {//not visited
                return false;
            }
        }

        return true;

    }

    private boolean recursiveHelper(int i, boolean[] visit, List<Integer>[] adjacencyList, boolean[] path) {
        if (path[i]) {
            return true;
        }

        boolean result = false;
        visit[i] = true;
        path[i] = true;
        List<Integer> neighbours = adjacencyList[i] == null ? new ArrayList<>() : adjacencyList[i];
        for (int neighbour : neighbours) {
            if (path[neighbour]) {
                return true;
            }
            if (!visit[neighbour]) {
                result = recursiveHelper(neighbour, visit, adjacencyList, path);
                if (result) {
                    return result;
                }
            }
        }
        path[i] = false;

        return result;

    }
}
