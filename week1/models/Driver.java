package week1.driver;
import week1.models.Frog;

public class Driver{

    public static void main(String[] args){
        Frog Todd = new Frog();
        Frog Lance = new Frog("Lance");
        Frog George = new Frog("George", true);
        Frog Brian = new Frog("Brian", true, 2);

        System.out.println("Hi I'm " + Lance.name);
        if (George.isPoisonous == true){
            System.out.println(George.name + " is deadly");
        } else{
            System.out.println("Kiss me!");
        }
        System.out.println("Hi I'm " + Lance.name);
        System.out.println("Frog " + Brian.name + " is " + Brian.age + " months old");
        System.out.println(George.eating());
        System.out.println(Todd.swim);
        System.out.println(Todd.croaking);
    }
}