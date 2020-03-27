package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class User {

	private String firstName;
	private String lastName;

	public User() {

		firstName = "Tre";
		lastName = "Stevens";

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@PostConstruct
	public void init() {
		// Get the logged in Principle
		Principal principle = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if (principle == null) {
			setFirstName("Unknown");
			setLastName("");
		} else {
			setFirstName(principle.getName());
			setLastName("");
		}

	}

}
