package com.java.lang.ref;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class StrongSoftWeakAndPhantomRef
{
    public static void main(String[] args)
    {
    	/** Strong Ref Ref **/
    	A s = new A("Strong");      //Strong Reference
    	 
        s = null;    //Now, object to which 'a' is pointing earlier is eligible for garbage collection.
   
    	
    	/** Soft Ref **/
        A a = new A("Soft");      //Strong Reference
 
        //Creating Soft Reference to A-type object to which 'a' is also pointing
 
        SoftReference<A> softA = new SoftReference<A>(a);
 
        a = null;    //Now, A-type object to which 'a' is pointing earlier is eligible for garbage collection. But, it will be garbage collected only when JVM needs memory.
       
        a = softA.get();    //You can retrieve back the object which has been softly referenced
        System.out.println(a.getS());
        
        /** Weak Ref **/
        A b = new A("weak");      //Strong Reference
        
        //Creating Weak Reference to A-type object to which 'a' is also pointing.
 
        WeakReference<A> weakA = new WeakReference<A>(b);
 
        b = null;    //Now, A-type object to which 'a' is pointing earlier is available for garbage collection.
 
        b = weakA.get();    //You can retrieve back the object which has been weakly referenced.
    
        System.out.println(b.getS());
        
        
        
        A c = new A("Phantom");      //Strong Reference
        
        //Creating ReferenceQueue
 
        ReferenceQueue<A> refQueue = new ReferenceQueue<A>();
 
        //Creating Phantom Reference to A-type object to which 'a' is also pointing
 
        PhantomReference<A> phantomA = new PhantomReference<A>(c, refQueue);
 
        c = null;    //Now, A-type object to which 'a' is pointing earlier is available for garbage collection. But, this object is kept in 'refQueue' before removing it from the memory.
 
        c = phantomA.get();    //it always returns null
        
        System.out.println(c.getS());
        
    }
}