package com.wc.HelloVelocity;

import java.io.StringWriter;

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
    	VelocityEngine ve = new VelocityEngine();
		ve.init();
		
		Template t = ve.getTemplate("helloworld.vm");
		VelocityContext context = new VelocityContext();
		context.put("name", "World");
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		System.out.println(writer.toString());
    }
}
