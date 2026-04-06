class Solution {
    public int countComponents(int n, int[][] edges) {
        
        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList());

        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];
        int comp=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                comp++; 
                dfs(i,visited,list);
            }
        }

        return comp;
    }

    public void dfs(int i,int[] visited,List<ArrayList<Integer>> list){
        if(visited[i]==1) return;

        visited[i] = 1;

        for(int ele : list.get(i)){
            if(visited[ele] == 0){
                dfs(ele, visited, list);
            }
        }

        return;
    }
}
