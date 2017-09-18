package collectionTutorial;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class UserTest2 {
	Email em = new Email() ;
	
	Set<User> childSet = new HashSet<>();
	private User user1 = new User("johnwpurcell", "John Purcell", true, childSet);
	private User user2 = new User("richardhannay", "Richard Hannay", true, null);
	private User user3 = new User("suetheviolinist", "Sue Black", true, null);
	private User user4 = new User("rogerblake", "Rog Blake", true, null);

	private User user6 = new User(1, "rogerblake", "RosdSue Black", true);
	private User user12 = new User(1, "rogelake", "oausge", true);
	private User user13 = new User(1, "rogee", "Rjauke", false);

	@Test
	public void test() {
		em.setEmailAddress("jaber@gmail.com");
		em.setPattren("??!!33>><<");
		
		user1.setEmail(em);
		user2.setEmail(em);
		user3.setEmail(em);
		user4.setEmail(em);

		user1.setUser(childSet);
		childSet.add(user12);
		childSet.add(user13);
		childSet.add(user6);
		Set<User> userSet = new HashSet<>();
		userSet.add(user1);
		userSet.add(user2);
		userSet.add(user3);
		userSet.add(user4);

		// filter Array

		Gson gson = new GsonBuilder()
				.registerTypeAdapter(User.class, new ProductSerializer())
				.setPrettyPrinting().create();
		{
			List<User> temp = null;
			Map<String, List<User>> subs = new HashMap<String, List<User>>();
			// iterate through your objects
			for (User o : userSet) {
				// fetch the list for this object's id
				temp = subs.get(o.getIk());
				if (temp == null) {
					// if the list is null we haven't seen an
					// object with this id before, so create
					// a new list
					temp = new ArrayList<User>();
				}
				// whether we got the list from the map
				// or made a new one we need to add our
				// object.
				temp.add(o);
				// subs.put("Definition", temp);
				if (subs.get("Definition") == null) {
					List<User> list = new ArrayList<>();
					list.add(o);
					subs.put("Definition", list);
				} else {
					subs.get("Definition").add(o);
				}
			}
			// and add it to the map

			Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
			String json2 = gson2.toJson(subs);
			System.out.println("json = " + json2);

		}
	}
}
