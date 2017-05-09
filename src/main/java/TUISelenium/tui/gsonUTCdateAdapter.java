package TUISelenium.tui;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class gsonUTCdateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

	private final DateFormat dateFormat;
	
	public gsonUTCdateAdapter(){
		dateFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss zzz", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	//@Override
	public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext json) {
		try {
			return dateFormat.parse(jsonElement.getAsString());
		} catch (Exception e) {
			// TODO: handle exception
			throw new JsonParseException(e);
		}
		//return null;
		
	}
    //@Override
	public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		return new JsonPrimitive(dateFormat.format(date));
	}

}
