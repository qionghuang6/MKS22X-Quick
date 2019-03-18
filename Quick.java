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
   //System.out.println("pivot index " + pivotIndex );
   //System.out.println("pivot: " + pivot);
   for (int x = start + 1; x < end ; x++ ) {
     //System.out.println(Arrays.toString(data));
     //System.out.println("pointer " + pointer);
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
     System.out.println(Arrays.toString(data) + " " + min + " " + max);
     pivot = partition(data,min,max); //calls parition again
     if(pivot < k){
       min = pivot; //narrows down range where we search for the index
     }
     if(pivot > k){
       max = pivot;
     }

   }
   System.out.println(Arrays.toString(data) + " " + min + " " + max);
   return data[k];
 }
 /*
 public static void main(String[] args) {
   /* int[] numbers = {765,564,123,212,324,56,76,8,123,123,123,34};
   System.out.println(partition(numbers,0,numbers.length));
   System.out.println(Arrays.toString(numbers) + "hi");
  //System.out.println(quickselect(numbers, 4))
  int[] ary1 = {32,32,4,32,213,2213,5435,76,21,34,75};
  int[] ary2 = {32,32,4,32,213,2213,5435,76,21,34,75};
  quicksort(ary1);
  quicksort(ary2);
  System.out.println(Arrays.toString(ary1));
  System.out.println(Arrays.toString(ary2));
} */

public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

 public static void quicksort(int[] data){
   quicksort(data,0,data.length);
 }
 private static void quicksort(int[] ary, int lo, int hi){
   //System.out.println("low / hi" + lo + " " + hi);
   //System.out.println(Arrays.toString(ary));
   if (lo >= hi){
     return;
   }
   int pivot = partition(ary,lo,hi);
   quicksort(ary,lo,pivot);
   quicksort(ary,pivot+ 1,hi);
 }
}
