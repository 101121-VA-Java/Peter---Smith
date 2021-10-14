public class Calculator {
    public static void main(String[] args){
        int x = 30;
        int y = 6;

        System.out.println(x + " + " + y + " = " + add(x, y));

        System.out.println(x + " - " + y + " = " + subtract(x, y));

        System.out.println(x + " * " + y + " = " + multiply(x, y));

        System.out.println(x + " mod " + y + " = " + remainder(x, y));

        weekday(args[0]);

        countdown(y);

        greeting(args[1]);

    }    
    public static int add(int a, int b){
        return a + b;    
    }

    public static int subtract(int a, int b){
        return a - b;
    }
     
    public static double multiply(double a, double b){
        return a * b;
    } 

    public static int remainder(int a, int b){
        return a % b;
    }

    public static void countdown(int startValue){
        if (startValue < 0){
            System.out.println("Input must be positive or 0");
        }
        else {
            for (int i = startValue; i >= 0; i--){
            System.out.println(i);
            }
        }
    }

    public static void greeting(String name){
        System.out.println("Great to meet you, " + name);
    }

    public static void weekday(String weekday){
        switch(weekday.toLowerCase()){
            case "sunday": System.out.println("Sunday Funday!");
	        break;
            case "monday": System.out.println("Rainy days and Mondays....");
            break;
            case "tuesday": System.out.println("Bingo night!");
           	break;
            case "wednesday": System.out.println("Wet n Wild Wednesdays, anyone?");
           	break;
            case "thursday": System.out.println("Th...Th...Th..Thursday, :-)");
          	break;
            case "friday": System.out.println("Happy Hour, finally!");
            break;
            case "saturday": System.out.println("Hooray for weekend!  Darn, I need to run errands");
            break;
            default: System.out.println("?? You crazy, man");
        }
    }

}
