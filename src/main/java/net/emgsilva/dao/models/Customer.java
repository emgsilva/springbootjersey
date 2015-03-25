package net.emgsilva.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.util.Assert;

@Entity
public class Customer extends AbstractEntity {

	private String firstname, lastname;

	@Column
	private EmailAddress emailAddress;

	public Customer(String firstname, String lastname) {

		Assert.hasText(firstname);
		Assert.hasText(lastname);

		this.firstname = firstname;
		this.lastname = lastname;
	}

	protected Customer() {
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}
}