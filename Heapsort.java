import java.util.*;

public class Heapsort<E extends Comparable<E>> {

   /**
    * Swaps two elements in an array.
    *
    * @param arr the array
    * @param i the first index
    * @param j the second index
    */
   private void swap(E[] arr, int i, int j) {
   
      E tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
   
   }

   /**
    * Makes a subheap rooted at index i valid.
    *
    * @param heap the max binary heap
    * @param i the index at which the subheap is rooted
    * @param len the length of the heap
    */
   private void heapify(E[] heap, int i, int len) {

      int left = 2 * i + 1;
      int right = 2 * i + 2;
      
      int maxIndex = i;
      
      if(left < len && heap[left].compareTo(heap[maxIndex]) > 0) {
      
         // the left child is bigger
         maxIndex = left;
      
      }
      
      if(right < len && heap[right].compareTo(heap[maxIndex]) > 0) {
      
         // the right child is bigger
         maxIndex = right;
      
      }
      
      if(maxIndex != i) {
      
         // swap the values and reheapify subheap
         swap(heap, i, maxIndex);
         heapify(heap, maxIndex, len);
      
      }
      
   }

   /**
    * Sorts an array using heapsort in ascending order.
    *
    * @param arr the array
    */
   public void sort(E[] arr) {
   
      // make the array a valid heap
      for(int i = arr.length - 1; i >= 0; i--) {
      
         heapify(arr, i, arr.length);
      
      }
      
      // continuously find the maximum value
      for(int i = arr.length - 1; i >= 0; i--) {
      
         swap(arr, 0, i);
         heapify(arr, 0, i);
      
      }
   
   }
   
   /**
    * The main method of the program.
    * Prompts the user for an integer array and outputs its sorted form.
    *
    * @param args the command line arguments
    */
   public static void main(String[] args) {
   
      Scanner s = new Scanner(System.in);
      
      System.out.print("Enter the size of the array: ");
      int n = s.nextInt();
      
      Integer[] arr = new Integer[n];
      
      for(int i = 0; i < n; ++i) {
         
         System.out.print("Enter the element at index " + i + ": ");
         arr[i] = s.nextInt();
      
      }
      
      Heapsort<Integer> h = new Heapsort<Integer>();
      h.sort(arr);
      
      System.out.println("\nThe sorted array:");
      
      for(int i = 0; i < n; ++i) {
      
         System.out.println(arr[i]);
      
      }
   
   }

}
