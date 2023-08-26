package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.HPCharacter;



@Controller
@RequestMapping("/hp")
public class HPController {
	
	private static List<HPCharacter> list;
	
	static
	{
		list=new ArrayList<HPCharacter>();
		Supplier<HPCharacter> sup=()->new HPCharacter("Harry Potter","Gryffindor","Student","Self","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Ginny Weasley","Gryffindor","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Ron Weasley","Gryffindor","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Hermione Granger","Gryffindor","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Neville Longbottom ","Gryffindor","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Oliver Wood","Gryffindor","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Luna Lovegood","Ravenclaw","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Cho Chang","Ravenclaw","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Cedric Diggory","Hufflepuff","Student","Friend","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Hannah Abbot","Hufflepuff","Student","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Draco Malfoy","Slytherin","Student","Enemy","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Vincent Crabbe","Slytherin","Student","Enemy","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Gregory Goyle","Slytherin","Student","Enemy","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Penelope Clearwater","Slytherin","Student","Enemy","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Albus Dumbledore","Gryffindor","Faculty","Friend","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Severus Snape","Slytherin","Faculty","Enemy","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Remus Lupin ","Gryffindor","Faculty","Friend","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Horace Slughorn ","Slytherin","Faculty","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Rubeus Hagrid","Gryffindor","Faculty","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("Minerva McGonagall","Gryffindor","Faculty","Friend","No");
		list.add(sup.get());
		sup=()->new HPCharacter("James Potter","Gryffindor","Student","Family","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Sirius Black","Gryffindor","Student","Friend","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Lily Potter","Gryffindor","Student","Family","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Peter Pettigrew","Gryffindor","Student","Enemy","Yes");
		list.add(sup.get());
		sup=()->new HPCharacter("Tom Marvolo Riddle","Slytherin","Student","Enemy","Yes");
		list.add(sup.get());
	}
	
	@GetMapping("/allchar")
	public List<HPCharacter> all()
	{
		return list;
	}
	
	@GetMapping("/getchar/{name}")
	public HPCharacter onechar(@PathVariable String name)
	{
		for(HPCharacter p:list)
		{
			if(p.getName().equalsIgnoreCase(name))
				return p;
		}		
		return null;
	}
	
	@GetMapping("/getgryffindor")
	public HPCharacter gryff()
	{
		for(HPCharacter p:list)
		{
			if(p.getHouse().equalsIgnoreCase("Gryffindor"))
				return p;
		}		
		return null;
	}
	
	@GetMapping("/getalive")
	public HPCharacter alive()
	{
		for(HPCharacter p:list)
		{
			if(p.getDies().equalsIgnoreCase("No"))
				return p;
		}		
		return null;
	}
	
	@GetMapping("/getfamily")
	public HPCharacter family()
	{
		for(HPCharacter p:list)
		{
			if(p.getStatus().equalsIgnoreCase("Family"))
				return p;
		}		
		return null;
	}
	
	@GetMapping("/getdeadfaculty")
	public HPCharacter deadfaculty()
	{
		for(HPCharacter p:list)
		{
			if((p.getDies().equalsIgnoreCase("Yes")) && (p.getRole().equalsIgnoreCase("Faculty")))
				return p;
		}		
		return null;
	}
	
	
	
}

