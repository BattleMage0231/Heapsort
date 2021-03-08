import java.util.*;

public class Heapsort {

   private int left(int i) {
   
      return 2 * i + 1;
   
   }
   
   private int right(int i) {
   
      return 2 * i + 2;
   
   }

   private void swap(int[] arr, int i, int j) {
   
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
   
   }

   private void heapify(int[] heap, int i, int len) {
   
      int left = left(i);
      int right = right(i);
      
      int maxIndex = i;
      
      if(left < len && heap[left] > heap[maxIndex]) {
      
         maxIndex = left;
      
      }
      
      if(right < len && heap[right] > heap[maxIndex]) {
      
         maxIndex = right;
      
      }
      
      if(maxIndex != i) {
      
         swap(heap, i, maxIndex);
         heapify(heap, maxIndex, len);
      
      }
      
   }

   public void sort(int[] arr) {
   
      for(int i = arr.length - 1; i >= 0; i--) {
      
         heapify(arr, i, arr.length);
      
      }
      
      for(int i = arr.length - 1; i >= 0; i--) {
      
         swap(arr, 0, i);
         heapify(arr, 0, i);
      
      }
   
   }
   
   public static void main(String[] args) {
   
      Heapsort h = new Heapsort();
      
      Scanner s = new Scanner(System.in);
      
      int n = s.nextInt();
      
      int[] arr = new int[n];
      
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
