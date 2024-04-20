class LRUCache {
    
    private class Node {
        
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private int size = 0;
    private Node head;
    private Node tail;
    private Node[] map = new Node[10_001];
    
    
    private void addNode(Node reference, Node node) {
        node.next = reference.next;
        node.prev = reference;
        node.next.prev = node;
        reference.next = node;
    }
    
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map[key] == null) return -1;
        Node node = map[key];
        deleteNode(node);
        addNode(head, node);
        return node.value;
    }
    
    
    public void put(int key, int value) {
        if (map[key] == null) {
            map[key] = new Node(key, value);
            addNode(head, map[key]);
            if (size == capacity) {
                map[tail.prev.key] = null;
                deleteNode(tail.prev);
            }
            else size++;
        }
        else {
            Node node = map[key];
            node.value = value;
            deleteNode(node);
            addNode(head, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */