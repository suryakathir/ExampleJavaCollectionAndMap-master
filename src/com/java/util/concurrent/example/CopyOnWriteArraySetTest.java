package com.java.util.concurrent.example;
/**
 * Same CopyOnWriteArrayList operations but not allowed duplicate ,its the thread safe 
 */
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {
	public static void main(String...arg){
	HashSet<String> hsobj = new HashSet<String>();
    hsobj.add("Alive is awesome");
    hsobj.add("Love yourself");
    hsobj.add("Love yourself"); 
    System.out.println("HashSet object output :"+ hsobj);

     

    CopyOnWriteArraySet<String> coponwrtobj = 
                                       new CopyOnWriteArraySet<String>();
    coponwrtobj.add("Alive is awesome");  
    coponwrtobj.add("Love yourself"); 
    coponwrtobj.add("Love yourself"); 
    System.out.println("CopyOnWriteArraySet object output :"+ coponwrtobj);   
	}

}
