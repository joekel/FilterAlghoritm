package collectionTutorial;


import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.List;

public class ProductSerializer implements JsonSerializer<User> {

    public JsonElement serialize(List<User> product, Type type, JsonSerializationContext jsc) {
        JsonObject jObj = (JsonObject)new GsonBuilder().create().toJsonTree(product);
        for (User o : product) {
        	jObj.remove(o.getName());
        }   
        return jObj;
    }

	@Override
	public JsonElement serialize(User arg0, Type arg1, JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		return null;
	}
}