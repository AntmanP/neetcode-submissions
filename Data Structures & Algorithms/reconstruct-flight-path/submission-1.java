class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj = new HashMap<>();

        for(int i=0;i<tickets.size();i++){
            adj.putIfAbsent(tickets.get(i).get(0), new ArrayList<>());
        }

        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));

        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");

        if (dfs("JFK", res, adj, tickets.size() + 1)) {
            return res;
        }

        return new ArrayList<>();
    }

    public boolean dfs(String src, List<String> res, Map<String, List<String>> adj, int target){
        if (res.size() == target) {
            return true;
        }

        if (!adj.containsKey(src)) {
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(src));
        for(int i=0;i<temp.size();i++){
           String v = (temp.get(i));
           adj.get(src).remove(i);
           res.add(v);
           if(dfs(v,res,adj,target)) return true;
           adj.get(src).add(i,v);
           res.remove(res.size()-1);
        }
        return false;
    }
}
