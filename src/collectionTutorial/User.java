package collectionTutorial;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

public class User {

	private static final long serialVersionUID = 1L;

	@Expose(serialize = true, deserialize = false)
	int ik;
	@Expose(deserialize = false)
	private String username;
	private String name;
	private boolean enabled = false;

	private Set<User> user;

	private Email email;

	public Set<User> getUser() {
		return user;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public User(String username, String name, boolean enabled, Set<User> user) {
		super();
		this.username = username;
		this.name = name;
		this.enabled = enabled;
		this.user = user;
	}

	public User(int ik, String username, String name, boolean enabled) {
		this.ik = ik;
		this.username = username;
		this.name = name;
		this.enabled = enabled;
	}

	public int getIk() {
		return ik;
	}

	public void setIk(int ik) {
		this.ik = ik;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
