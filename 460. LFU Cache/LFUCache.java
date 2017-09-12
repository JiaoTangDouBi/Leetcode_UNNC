import java.util.HashMap;

class LFUCache {
    //Use double linked list
    
    class DoubleLinkedList{
        int key;
        int value;
        int freq;
        DoubleLinkedList pre;
        DoubleLinkedList next;
        
        DoubleLinkedList(int key, int value, int freq){
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
    
    DoubleLinkedList head, tail;
    
    public void addToTail(DoubleLinkedList dll){
        DoubleLinkedList preNode = tail.pre;
        tail.pre = dll;
        preNode.next = dll;
        
        dll.pre = preNode;
        dll.next = tail;
        return;
    }
    
    public int removeFromTail(){
        int returnKey = tail.pre.key;
        DoubleLinkedList preNode = tail.pre.pre;
        tail.pre = preNode;
        preNode.next = tail;
        
        return returnKey;
    }
    
    HashMap<Integer, DoubleLinkedList> map = new HashMap<>();
    int capacity = 0;
    int size = 0;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        
        head = new DoubleLinkedList(-1,-1,-1);
        tail = new DoubleLinkedList(-1,-1,-1);
        head.next = tail;
        tail.pre  = head;
    }
    
    public int get(int key) {
        if (capacity == 0 || !map.containsKey(key)){
            return -1;
        }
        else{
            DoubleLinkedList dll = map.get(key);
            dll.freq += 1;
            while(dll.pre.freq != -1 && dll.pre.freq<=dll.freq){
                swap(dll, dll.pre);
            }
            return dll.value;
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0)
            return;
        if(map.containsKey(key)){
            DoubleLinkedList dll = map.get(key);
            dll.value = value;
            dll.freq += 1;
            while(dll.pre.freq != -1 && dll.pre.freq<=dll.freq){
                swap(dll, dll.pre);
            }
        }
        else{
            if(size == capacity){
                int tempKey = removeFromTail();
                size--;
                map.remove(tempKey);
            }
            DoubleLinkedList dll = new DoubleLinkedList(key, value, 1);
            map.put(key,dll);
            addToTail(dll);
            
            while(dll.pre.freq != -1 && dll.pre.freq<=dll.freq){
                swap(dll, dll.pre);
            }
            
            size++;
        }
    }
    
    public void swap(DoubleLinkedList d1, DoubleLinkedList d2){
        DoubleLinkedList nextNode = d1.next;
        DoubleLinkedList preNode = d2.pre;
        preNode.next = d1;
        d1.pre = preNode;
        
        d1.next = d2;
        d2.pre = d1;
        
        d2.next = nextNode;
        nextNode.pre = d2;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */