public class Hint {
	public static void main(String[] args) {
		System.out.println("""
				import java.io.*;
				import java.util.*;
				public class template {
				    public static void main(String[] args) throws IOException{
				        Scanner s = new Scanner(new File("hint.dat"));
				        int numSets = s.nextInt();
				        s.nextLine();
				        for(int i = 1; i <= numSets; i++){
				            // do stuff for data set
				        }
				        s.close();
				    }
				}
						   """.trim());
	}
}
