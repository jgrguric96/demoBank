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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TRANSACTIONS")
@Setter
@Getter
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transactionID")
	private Long transactionID;
	
	@Column(name="ammount")
	private  BigDecimal ammount;
	
	@ManyToOne
	@JoinColumn(name="accountID")
	private Accounts accounts;
}
