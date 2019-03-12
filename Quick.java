public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int partition ( int [] data, int start, int end){
   int pivotIndex = (int)(Math.random() * (end - start)) + start; // chooses random pivot index
   int pivot = data[pivotIndex]; //sets the pivot
   int pointer = start + 1; //points to value right after start
   data[pivotIndex] = data[start]; //moves pivot to front
   data[start] = pivot;
   //System.out.println(pivot);
   for (int x = start; x < end ; x++ ) {
     //System.out.println(Arrays.toString(data));
     //System.out.println(pointer);
     if(data[x] < pivot){ //swaps value at pointer and moves pivot if below
       int temp = data[pointer];
       data[pointer] = data[x];
       data[x] = temp;
       pointer++; //moves pointer up
     }
   }
   data[start] = data[pointer-1]; //moves pivot to right location based on pointer (values left of pointer are below pivot)
   data[pointer -1] = pivot;
   return pointer -1 ;
 }

 public static int quickselect(int []data, int k){
   int min = 0;
   int max = data.length;
   int pivot = partition(data,min,max);
   while(pivot != k){
     if(pivot < k){
       max = pivot;
       pivot = partition();
     }
   }
   return data[k];
 }
}
