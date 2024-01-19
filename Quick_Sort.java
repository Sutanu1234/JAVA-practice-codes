class Quick_Sort{

public static int part(int arr[], int low, int high){
  int pivot = arr[high];
  int i = low - 1;

  for(int j = low; j < high; j++){
    if(arr[j] < pivot){
      i++;
      int temp = arr[i];
      arr [i] = arr[j];
      arr [j] = temp;
    }
  }
  i++;
  int temp = arr[i];
  arr [i] = arr[high];
  arr [high] = temp;
  return i;
}

  public static void quick(int arr[], int low, int high){
    if(low < high){
      int pi = part(arr, low, high);

      quick(arr, low, pi - 1);
      quick(arr, pi + 1, high);
    }
  }

  public static void printArray(int arr[]) {
       for(int i=0; i<arr.length; i++) {
           System.out.print(arr[i]+" ");
       }
       System.out.println();
   }
  
  public static void main(String arg[]){
     int arr[] = {7, 8, 1, 3, 2, 4};
    int n = arr.length;

    quick(arr, 0, n-1);
    printArray(arr);
  }
}
