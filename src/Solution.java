import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, (i1, i2) -> i2 - i1);
        for(int a_i=0; a_i < n; a_i++){
        	//System.out.println("minHeap:" + minHeap + ", maxHeap:" + maxHeap);
            a[a_i] = in.nextInt();
            // offer to heaps
            if (minHeap.size() > 0 && a[a_i] < minHeap.peek()) {
                maxHeap.offer(a[a_i]);
            }
            else {
                minHeap.offer(a[a_i]);
            }
            // adjustment
            if (minHeap.size() > 0 && maxHeap.size() > 0) {
            	if (minHeap.peek() < maxHeap.peek()) {
	            	PriorityQueue<Integer> temp = new PriorityQueue<Integer>(minHeap);
	            	minHeap = new PriorityQueue<Integer>(maxHeap);
	            	maxHeap = new PriorityQueue<Integer>(temp);
            	}
            }
            if (minHeap.size() - maxHeap.size() > 1) {
        		maxHeap.offer(minHeap.poll());
        	}
        	if (maxHeap.size() - minHeap.size() > 1) {
        		minHeap.offer(maxHeap.poll());
        	}
            if (a_i % 2 == 1) {
                System.out.println((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
            else {
            	System.out.println((maxHeap.size() > minHeap.size() ? (double)maxHeap.peek() : (double)minHeap.peek()));
            }
        }    
    }
}