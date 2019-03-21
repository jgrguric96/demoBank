package example.demoBank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="customerID")
	private Long customerID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;

}
