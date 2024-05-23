package JavaSessions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
//import org.testng.annotations.*;


public class LearningStreams2 {
	
    public static void main(String[] args) {
	
		
		Stream.of("Asha","Arijita","Tom","Alexa","Avisekh").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		System.out.println("-----------------------------------");
		Stream.of("Asha","Arijita","Tom","Alexa","Avisekh").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
	
		List<String>names = Arrays.asList("Asha","Arijita","Tom","Alexa","Avisekh");
		System.out.println("-----------------------------------");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
		System.out.println("-----------------------------------");
		
//Merging 2 lists		
		List<String>names1 = Arrays.asList("Ash","Arijit","Tommy","Alex","Avi");
		
	Stream<String> merged =	Stream.concat(names.stream(),names1.stream());
	//merged.sorted().forEach(s-> System.out.println(s));
	
	boolean flag = merged.anyMatch(s->s.equalsIgnoreCase("Tommy"));
	System.out.println(flag);
	Assert.assertTrue(flag);
	System.out.println("-----------------------------------");
	//Stream Collect
	
List<String> ls = Stream.of("Asha","Arijita","Tom","Alexa","Avisekh").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
	.collect(Collectors.toList());
	
System.out.println(ls.get(0));
System.out.println(ls.get(1));
System.out.println("-----------------------------------");

List<Integer> values = Arrays.asList(3,1,2,4,5,2,1,3);
//Finding distinct numbers
values.stream().distinct().forEach(s-> System.out.println(s));

System.out.println("-----------------------------------");

//Sorting the list and printing it

values.stream().sorted().forEach(s-> System.out.println(s));

	}
    
  

}
