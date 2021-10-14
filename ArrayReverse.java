public class ArrayReverse {
    public static void main(String[] args){
//        String[] args = {"Lion", "Tiger", "Monkey", "Bear", "Snake", "Rhino"};  // for testing

        System.out.print("The original array: ");
        printArray(args);

        System.out.println();

        System.out.print("The reversed array: ");
 //       String[] reversedArray = revArray(args);          // This works but reversedArray only used in
 //       printArray(reversedArray);                        // this line.  Better way is below
          printArray(revArray(args)); 

    }
    public static void printArray(String[] array){    
        for(int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);    
    }


    public static String[] revArray(String[] array){
        String[] newArray = new String[array.length];
        int j = 0;
        for(int i = array.length - 1; i >= 0; i--){
           newArray[j] = array[i]; 
           j++;
        } 
        return newArray;
    } 
}       