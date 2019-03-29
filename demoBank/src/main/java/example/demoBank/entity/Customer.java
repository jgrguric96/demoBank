package example.demoBank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String surname;
//
//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Account> accounts;
}
