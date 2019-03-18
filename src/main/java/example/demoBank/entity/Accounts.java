package example.demoBank.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ACCOUNTS")
@Getter
@Setter
public class Accounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accountID")
	private Long accountID;
	
	@Column(name="initialCredit")
	private BigDecimal initialCredit;
	
	@Column(name="balance")
	private BigDecimal balance;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "customerID")
	private Customer customer;
	
}
