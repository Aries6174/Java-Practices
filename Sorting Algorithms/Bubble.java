public class Bubble{
    
    public static void main(String[] args){
        
        int[] arr = {3, 8, 2, 5, 16, 28, 4, 23, 23};
        int temp;

        for(int i = 0; i < arr.length; i++){
            boolean swapped = false;
            
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
        
            if (!swapped){
                break;
            }
        }

        for(int i = 0; i < arr.length; i++){
        System.out.print(arr[i] + " ");
        }
    }

}