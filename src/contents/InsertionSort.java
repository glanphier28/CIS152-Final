package contents;




class InsertionSort {
    int[] sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
  
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
  

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }
  

   /* public static void main(String args[])
    {
      int arraySize = 100000;
   	   int array[];
       Random rand = new Random();
       array = new int[arraySize];
       for (int i = 0; i < arraySize; i++) {
     	  array[i] = rand.nextInt(0 , 100);
     }
  
        InsertionSort ob = new InsertionSort();
        //printArray(array);
        long time1 = System.nanoTime();
        ob.sort(array);
        long time2 = System.nanoTime();
        System.out.println(time1);
        System.out.println(time2);
        System.out.println("Difference: " + (time2 - time1));
  
        //printArray(array);
    }*/ }
