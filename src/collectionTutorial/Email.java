package collectionTutorial;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.gson.annotations.Expose;

public class Email {

	
	@Expose(serialize = false)
	private  String emailAddress;
	@Expose(serialize = false)
	private String pattren;
	

	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPattren() {
		return pattren;
	}

	public void setPattren(String pattren) {
		this.pattren = pattren;
	}
	
	
}
