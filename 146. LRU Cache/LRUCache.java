class LRUCache {
    class DLinkedList{
        int value;
        int key;
        DLinkedList post, pre;

        public DLinkedList(int key, int value){
            this.value = value;
            this.key   = key;
        }
    }
    
    DLinkedList head, tail;
    HashMap<Integer, DLinkedList> map;
    int cap;
    int count = 0;
    
    public void addToHead(DLinkedList node){
        
        if(node.pre != null && node.post != null){
            node.post.pre = node.pre;
            node.pre.post = node.post;
        }
        
        node.pre      = head;
        node.post     = head.post;
        
        head.post     = node;
        node.post.pre = node;
    }
    
    public int removeFromTail(){
        int temp = tail.pre.key;
        tail.pre = tail.pre.pre;
        tail.pre.post = tail;
        return temp;
    }
    
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        
        head = new DLinkedList(-1, -1);
        tail = new DLinkedList(-1, -1);
        
        head.pre = null;
        head.post= tail;
        
        tail.pre = head;
        tail.post= null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLinkedList temp = map.get(key);
            addToHead(temp);
            map.put(key, temp);
            return map.get(key).value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            //update
            DLinkedList temp = map.get(key);
            temp.value = value;
            addToHead(temp);
            map.put(key, temp);
        }
        else{
            DLinkedList temp = new DLinkedList(key, value);
            addToHead(temp);
            map.put(key, temp);
            count++;
            
            if(count > cap){
                int removedKey = removeFromTail();
                map.remove(removedKey);
                count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */