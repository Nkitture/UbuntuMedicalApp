package nitin.project;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import nitin.project.Model;

public class JsonExample {
	public static void main(String args[]){    
		JSONObject obj=new JSONObject();
		//ArrayList<> l=new ArrayList<>();
		  obj.put("name","sonoo");    
		  obj.put("age",new Integer(27));    
		  obj.put("salary",new Double(600000));    
		   System.out.print(obj);    
		}} 
