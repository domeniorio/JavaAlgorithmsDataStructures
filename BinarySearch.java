

public class BinarySearch{

    public static void main(String[] args) {

        int[] arr = {1,2,5,7,10,14,15,17};
        System.out.println(recursiveBinarySearch(arr, 11, 0, arr.length));
    }


    public static int binarySearch(int[] arr, int elem){

        int start = 0;
        int end = arr.length - 1;
        int middle;

        while(start <= end){
            middle = (int)Math.floor((start+end)/2);

            if(arr[middle] == elem) return middle;
            else if(arr[middle] < elem) start = middle + 1;
            else end = middle - 1;
        }

        return -1;

    }

    public static int recursiveBinarySearch(int[] arr, int elem, int left, int right){

        if(left > right) return -1;

        int middle = (int)Math.floor((left+right)/2);
        if (arr[middle] == elem) return middle;
        else if(arr[middle] < elem) return recursiveBinarySearch(arr, elem, middle+1, right);
        else return recursiveBinarySearch(arr, elem, left, middle-1);

    }
}
