package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacketCompressor {
    
    /*
     * 
     */
    public int[][] compressPackets(int[] input, int max){
        // 1, 1, 2
        Arrays.sort(input);
        List<List<Integer>> compressedPackets = new ArrayList<>();
        // [[]]
        int count = 0, length = input.length;
        List<Integer> packet = new ArrayList<>();
        for(int i = 0; i < length; i++){
            int subInput = input[i];
            if(count < max && (count + subInput) <= max){
                packet.add(subInput);
            }else{
                compressedPackets.add(packet);
                packet = new ArrayList<>();
                count = 0;
            }

            count += subInput;
        }

        int arrayLength = compressedPackets.size();
        int[][] result = new int[arrayLength][];
        int i = 0;

        for(List<Integer> subPacket: compressedPackets){
            int[] component = new int[subPacket.size()];
            // add all items in compoennt
            result[i++] = component;
        }
        return result;
    }

}
