public class Insertion{

    public static void main(String[] args){
        int[] arr = {5, 3, 8, 2, 7, 3, 0, 11, 13, 2};

        for (int i = 1; i < arr.length; i++){       //looping starting from the 2nd element
            int key = arr[i];   //insertion line
            int j = i - 1;      //geting the first value

            while (j >= 0 && arr[j] > key){ // while the element is inside the array and if the first element is bigger than the 2nd element
                arr[j+1] = arr[j];  // 3 become 5
                j--;                // j and number goes down
            }                       // continues until a

            arr[j+1] = key;
        }

        for(int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + " ");
        }



    }

}