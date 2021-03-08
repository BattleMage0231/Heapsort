import java.util.*;

public class Heapsort<E extends Comparable<E>> {

   private void swap(E[] arr, int i, int j) {
   
      E tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
   
   }

   private void heapify(E[] heap, int i, int len) {
   
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      
      int maxIndex = i;
      
      if(left < len && heap[left].compareTo(heap[maxIndex]) > 0) {
      
         maxIndex = left;
      
      }
      
      if(right < len && heap[right].compareTo(heap[maxIndex]) > 0) {
      
         maxIndex = right;
      
      }
      
      if(maxIndex != i) {
      
         swap(heap, i, maxIndex);
         heapify(heap, maxIndex, len);
      
      }
      
   }

   public void sort(E[] arr) {
   
      for(int i = arr.length - 1; i >= 0; i--) {
      
         heapify(arr, i, arr.length);
      
      }
      
      for(int i = arr.length - 1; i >= 0; i--) {
      
         swap(arr, 0, i);
         heapify(arr, 0, i);
      
      }
   
   }
   
   public static void main(String[] args) {
   
      Heapsort<Integer> h = new Heapsort<Integer>();
      
      Scanner s = new Scanner(System.in);
      
      int n = s.nextInt();
      
      Integer[] arr = new Integer[n];
      
      for(int i = 0; i < n; ++i) {
      
         arr[i] = s.nextInt();
      
      }
      
      h.sort(arr);
      
      for(int i = 0; i < n; ++i) {
      
         System.out.print(arr[i] + " ");
      
      }
      
      System.out.println();
   
   }

}
