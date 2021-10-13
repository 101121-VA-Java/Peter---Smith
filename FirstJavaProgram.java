public class FirstJavaProgram {

	public static void main(String[] args) {
		for (int i=1; i <= 20; i++){
			if (i % 3 == 0 && i % 5 == 0){
				System.out.println(i + ": Woohoo! Both");
			} else if (i % 3 == 0){
				System.out.println(i + ": Divisible by 3");
			} else if (i % 5 == 0){
				System.out.println(i + ": Divisible by 5");
			} else {
				System.out.println(i);
			}
		}
	}
}
