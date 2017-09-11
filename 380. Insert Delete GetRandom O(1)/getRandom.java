class RandomizedSet {

    //Use a map to store <val, index> pairs.
    HashMap<Integer, Integer> map;
    ArrayList<Integer> array;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        array=new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        else{
            map.put(val, array.size());
            array.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int loc = map.get(val);
            if(loc != (array.size()-1)){
                int temp = array.get(array.size()-1);
                array.set(loc, temp);
                map.put(temp, loc);
            }
            array.remove(array.size()-1);
            map.remove(val);
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int rand = (int)(Math.random()*array.size());
        return array.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */