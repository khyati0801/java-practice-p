package com.rivet.Springexample.FristSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
//    	ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
//    	Firstpage fp=(Firstpage)factory.getBean("Student");
        ApplicationContext factory=new ClassPathXmlApplicationContext("/com/rivet/Springexample/xml/config.xml");
       Student s= factory.getBean("Student",Student.class);
       System.out.println("Student Details by setter");
      System.out.println(s);
       Student s1= factory.getBean("Student1",Student.class);
       System.out.println("Student Details by constructor");
      System.out.println(s1);
       
    }
}
