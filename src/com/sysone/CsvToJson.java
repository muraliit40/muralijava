package com.sysone;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//import org.simpleflatmapper.csv.CsvParser;
//import org.simpleflatmapper.csv.CsvReader;

//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.*;
//import com.sun.xml.internal.ws.developer.SerializationFeature;

public class CsvToJson {

    public static void main(String[] args) throws IOException {
    	String  csvFile="C:\\Users\\Jai Ganesh\\Documents\\report.csv";
    	//System.out.print("Hello World");
    	try (InputStream in = new FileInputStream(csvFile);) {
    	    CSV csv = new CSV(true, ',', in );
    	    List < String > fieldNames = null;
    	    if (csv.hasNext()) fieldNames = new ArrayList < > (csv.next());
    	    List < Map< String, String >> list = new ArrayList < > ();
    	    while (csv.hasNext()) {
    	        List < String > x = csv.next();
    	        Map < String, String > obj = new LinkedHashMap< > ();
    	        for (int i = 0; i < fieldNames.size(); i++) {
    	            obj.put(fieldNames.get(i), x.get(i));
    	        }
    	        list.add(obj);
    	    }
    	    ObjectMapper mapper = new ObjectMapper();
    	    
    	    System.out.println("List size is:" +list.size());
    	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	    mapper.writeValue(System.out, list);
    	}catch(Exception e) {
    		
    	}
    }
}
