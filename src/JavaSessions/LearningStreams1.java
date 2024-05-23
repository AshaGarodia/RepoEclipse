package JavaSessions;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
import java.util.stream.Stream;

public class LearningStreams1 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>() ;
		names.add("Asha");
		names.add("Arijit");
		names.add("Tom");
		names.add("Alex");
		names.add("Avisekh");
		
		int count = 0;
		
		for(int i=0;i<names.size();i++)
		{
		 String actual = names.get(i);
		 if(actual.startsWith("A"))
		 {
			 count++;
		 }
		}
		System.out.println("The required count is "+count);
		
		Stream.of("Asha","Arijita","Tom","Alexa","Avisekh").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
	}
	
	
}
