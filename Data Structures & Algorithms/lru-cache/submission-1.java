class LRUCache {

    class Node{
        int k,v;
        Node prev, next;

        Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.v;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key); 
        }
        if(map.size()==capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.k);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key,newNode);
    }

    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev; 
    }

    public void insert(Node n){
        n.next = head.next;
        n.prev = head;

        head.next.prev = n;
        head.next = n;
    }
}
