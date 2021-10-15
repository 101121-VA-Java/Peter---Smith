package week1.models;
import java.util.Random;
public class Frog{
    public boolean isPoisonous;
    public String name;
    public int age;

    public Frog(){}

    public Frog(String name){
        this.name = name;
    }

    public Frog(String name, boolean isPoisonous){
        this.name = name;
        this.isPoisonous = isPoisonous;
    }
    
    public Frog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Frog(String name, boolean isPoisonous, int age){
        this.name = name;
        this.isPoisonous = isPoisonous;
        this.age = age;
    }

    public void croaking(){
        System.out.println("CROOOOOOAAAAAAAK");
    }

    public void swim(){
        System.out.println("Splash, splash");
    }
    public void eating(){
        Random rand = new Random();
        int randFlies = rand.nextInt(7);
        if (randFlies == 1){
            System.out.println("Only 1 fly, I'm so hungry");    
        }
        else{
            System.out.println(name + " just ate " + randFlies + " flies");
        }    
    }

}