class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 < edges.length) return false;

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++) list.add(new ArrayList());


        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }


        Set<Integer> visited = new HashSet<>();

        
        if(!dfs(list,visited,0,-1)) return false;
        
        return visited.size()==n;
    }


    public boolean dfs(List<ArrayList<Integer>> list, Set<Integer> visited, int curr, int parent){
        if(visited.contains(curr)) return false;
        visited.add(curr);

        for(int con : list.get(curr)){
            if(con == parent) continue;
            if(!dfs(list, visited, con, curr)) return false;
        }


        return true;
    }
}
