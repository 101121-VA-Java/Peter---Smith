public class ArrayReverse {
    public static void main(String[] args){
//        String[] animals = {"Lion", "Tiger", "Monkey", "Bear", "Smake", "Rhino"};

        System.out.print("The original array: ");
//        printArray(animals);
//        String[] reversedArray = revArray(animals);
        printArray(args);

        System.out.println();

        String[] reversedArray = revArray(args);
        System.out.print("The reversed array: ");
        printArray(reversedArray);

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