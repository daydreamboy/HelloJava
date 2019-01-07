package com.wc.HelloVelocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	test_hello_world();
    	System.out.println("=========================");
    	
    	test_pet_store_email();
    }
    
    public static void test_hello_world() {
    	// 1. create an engine and initialize it
    	VelocityEngine engine = new VelocityEngine();
		engine.init();
		
		// 2. get a template
		Template template = engine.getTemplate("helloworld.vm");
		
		// 3. create a context and put data into it
		VelocityContext context = new VelocityContext();
		context.put("name", "World");
		
		// 4. create a StringWriter for receiving template string
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		
		// 5. get plain string from the StringWriter
		System.out.println(writer.toString());
    }
    
    public static void test_pet_store_email() {
    	VelocityEngine engine = new VelocityEngine();
    	engine.init();
    	
    	ArrayList list = new ArrayList();
    	Map map = new HashMap();
    	map.put("name", "horse");
    	map.put("price", "00.00");
    	list.add(map);
    	
    	map = new HashMap();
    	map.put("name", "dog");
    	map.put("price", "9.99");
    	list.add(map);
    	
    	map = new HashMap();
    	map.put("name", "bear");
    	map.put("price", "0.99");
    	list.add(map);
    	
    	VelocityContext context = new VelocityContext();
    	context.put("petList", list);
    	
    	Template template = engine.getTemplate("PetStoreEmail.vm");
    	StringWriter writer = new StringWriter();
    	template.merge(context, writer);
    	
    	System.out.println(writer.toString());
    	
    	
    }
}
