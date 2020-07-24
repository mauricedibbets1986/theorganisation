package com.theorganisation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double salary;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="the_messages",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @ JoinColumn(name = "messages_id"))
	private List<Message> messages = new ArrayList<>();
	
	@OneToOne
	@JoinColumn( name = "telefoon_id" )
	private Telefoon telefoon;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	public Telefoon getTelefoon() {
		return telefoon;
	}
	public void setTelefoon(Telefoon telefoon) {
		this.telefoon = telefoon;
	}

	
}
