//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
        int capacity=sc.nextInt();
        LFUCache obj = new LFUCache(capacity);
        int runs=sc.nextInt();
        for(int i = 0;i<runs;i++){
            int s=sc.nextInt();
            if(s==1){
                int key=sc.nextInt();
                int param_1 = obj.get(key);
                System.out.println(param_1);
            }else{
                int key=sc.nextInt(),value=sc.nextInt();
                obj.put(key,value);
            }
        }
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class LFUCache {

  final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;
     public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }
        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */