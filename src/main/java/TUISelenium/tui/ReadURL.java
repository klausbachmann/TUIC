package TUISelenium.tui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class ReadURL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		URL u = new URL("http://meinereise-shadow.tuicruises.plusline.de/_backend/status");
		BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
		
		String inputLine;
		String buffer = "";
		while((inputLine = in.readLine()) != null ){
			if( !inputLine.equals("</pre>"))
				buffer += inputLine;
			
		}
		
		String b = buffer.replace("<pre>", "");
		String c = b.replace("</pre>", "");
		
		System.out.println(buffer.indexOf("</pre>"));
		
		//buffer.substring(4, buffer.length()-3);
		
		System.out.println(c);
		
		//Gson gson = new Gson();
		DateFormat d = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss Z zzz", Locale.US);
		System.out.println(d.format(new Date()));
		
		
		// Thu Nov 26 2015 13:28:16 GMT+0000 (UTC)
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new gsonUTCdateAdapter()).create();
				   //.setDateFormat("E MMM dd yyyy HH:mm:ss zzz").create();
		
		
		JsonParser jp = new JsonParser();
		JsonReader reader = new JsonReader(new StringReader(c.trim()));
		reader.setLenient(true);
		
		try {
			
			//jp.parse(reader);
			TuiObect tui = gson.fromJson(reader, TuiObect.class);
			//System.out.println(tui.version);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Geht nicht");
			System.out.println(e.getMessage());
		}
		//
		
		
		
		in.close();
	}

	public class TuiObect{
		public String name;
		public String conf;
		public String server;
		public String instance;
		public String version;
		public Boolean active;
		public Services services;
		
		public class Services{
			public Netmatch netmatch;
			
		}
		
		public class Netmatch{
			public String testURL;
			public String longestURL;
			public String longest;
			public String count;
			public String average;
			public List<LongestRequests> longestRequests;
		}
		
		public class LongestRequests{
			public String count;
			public String url;
			public Date latest;
			public int longest;
			public int average;
			
			
		}
		
	}
}
