// <!-- 
// - put(object)
// - get(object)

//  -->

/*
import java.util.HashMap;
import java.util.Map;

public class LRU {

    private Map<Integer, Object> map;
    final int  SIZE = 10;
    DoublyLinkedList<Object> recency = new DoubleLinkedlist<>();

    public LRU (){
        this.map = map;
    }


    public void put(Object input){
        // check if there already
        if(map.containsKey(input.key)){
            recency.remove(input);
            recency.setHead(input);
        }else{

            if(map.size() == SIZE){
                // remove least recently used
                recency.removeTail();
                recency.setHead(input);
            }else {
                recency.setHead(input);
            }
    }   

    public Object get(int key){
        if(!map.containsKey(key)){
            // fetch from db
            return null;
        }else{
            recency.remove(map.get(key));
            recency.setHead(map.get(key));

            return map.get(key);
        }
    }
   
}



 */