import java.util.Arrays;
public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int partition ( int [] data, int start, int end){
   int[] pivotPossibilities = new int[3];
   for (int x = 0;x < 3 ;x++ ) {
     pivotPossibilities[x] = (int)(Math.random() * (end - start)) + start;
   }
   Arrays.sort(pivotPossibilities);
   int pivotIndex = pivotPossibilities[1]; // chooses random pivot index
   int pivot = data[pivotIndex]; //sets the pivot
   int pointer = start; //points to value right after start
   data[pivotIndex] = data[start]; //moves pivot to front
   data[start] = pivot;
   //System.out.println(pivot);
   for (int x = start; x < end ; x++ ) {
     //System.out.println(Arrays.toString(data));
     //System.out.println(pointer);
     if(data[x] < pivot  || (data[x] == pivot && Math.random() > 0.5) ){ //swaps value at pointer and moves pivot if below
       pointer++; //moves pointer up
       int temp = data[pointer];
       data[pointer] = data[x];
       data[x] = temp;
     }
   }
   data[start] = data[pointer]; //moves pivot to right location based on pointer (values left of pointer are below pivot)
   data[pointer] = pivot;
   return pointer ;
 }

 public static int quickselect(int []data, int k){
   int min = 0; //set basic max and min for the data
   int max = data.length;
   int pivot = -1;
   while(pivot != k){
     //System.out.println(Arrays.toString(data) + " " + min + " " + max);
     pivot = partition(data,min,max); //calls parition again
     if(pivot < k){
       min = pivot; //narrows down range where we search for the index
     }
     if(pivot > k){
       max = pivot;
     }

   }
  // System.out.println(Arrays.toString(data) + " " + min + " " + max);
   return data[k];
 }
 public static void main(String[] args) {
   int[] numbers = {765,564,123,212,324,56,76,8,123,123,123,34};
   System.out.println(partition(numbers,0,numbers.length));
   System.out.println(Arrays.toString(numbers));
  System.out.println(quickselect(numbers, 4));
 }
}
