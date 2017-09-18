package collectionTutorial;

import static org.junit.Assert.*;

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

public class UserTest {

	private User user1 = new User(1, "johnwpurcell", "John Purcell", true);
	private User user2 = new User(2, "richardhannay", "Richard Hannay", true);
	private User user3 = new User(3, "suetheviolinist", "Sue Black", true);
	private User user4 = new User(4, "rogerblake", "Rog Blake", true);

	private User user6 = new User(1, "rogerblake", "RosdSue Black", true);
	private User user12 = new User(1, "rogelake", "oausge", true);
	private User user13 = new User(1, "rogee", "Rjauke", false);

	@Test
	public void test() {
		Set<User> childSet = new HashSet<>();
		user1.setUser(childSet);
		childSet.add(user12);
		childSet.add(user13);
		childSet.add(user6);
		Set<User> userSet = new HashSet<>();
		userSet.add(user1);
		userSet.add(user2);
		userSet.add(user3);
		userSet.add(user4);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		{

			Map<Integer, List<User>> subs = new HashMap<Integer, List<User>>();
			Set<User> noCHild = new HashSet<>();
			for (User use : userSet) {
				if (use.getUser() == null) {
					noCHild.add(use);
					noCHild.remove(use.getName());
					// iterate through your objects
					for (User o : noCHild) {
						// fetch the list for this object's id
						List<User> temp = subs.get(o.getIk());
							temp = new ArrayList<User>();
							// and add it to the map
							subs.put(o.getIk(), temp);
							temp.add(o);
					}
				}
			}
			String json = gson.toJson(subs);
			System.out.println("json = " + json);
		}
		{
			for (User use : userSet) {
				if (use.getUser() != null) {
					System.out.println("****************" + "Second Part " + "**************");
					Set<User> withCHild = new HashSet<>();
					withCHild.add(use);
					Map<Integer, List<User>> subs = new HashMap<Integer, List<User>>();
					// iterate through your objects
					for (User o : withCHild) {
						// fetch the list for this object's id
						List<User> temp = subs.get(o.getIk());
						if (temp == null) {
							// if the list is null we haven't seen an
							// object with this id before, so create
							// a new list
							temp = new ArrayList<User>();
							// and add it to the map
							subs.put(o.getIk(), temp);
						}
						// whether we got the list from the map
						// or made a new one we need to add our
						// object.
						temp.add(o);

					}
					Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
					String json2 = gson2.toJson(subs);
					System.out.println("json = " + json2);

				}

			}
		}
	}

}
