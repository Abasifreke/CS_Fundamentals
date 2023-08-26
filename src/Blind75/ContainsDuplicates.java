package Blind75;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicates {
    
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> uniques = new HashSet<>();

        for(int i : nums){
            if(!uniques.contains(i)){
                uniques.add(i);
            }
            else{
                return true;
            }
        }
        return false;

    }
}
