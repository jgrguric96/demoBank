package example.demoBank.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

//koristi getter i setter prije @data zbog mogucih problema koji se stvaraju sa promjenama u kodu
@Getter
@Setter
@Entity
public class Account {

	@Id
	/*
	 * Reason why strategy generation type was written back is because it iterates
	 * over every ID column. Account table continues from 5 (4 customers before
	 * that) The transaction table continues where accountID left off. Example id
	 * values: CUSTOMERID ACCOUNTID TRANSACTIONID 1 5 6 2 7 8 3 9 10 4 11 12 And so
	 * on...
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	// Renamed back to account_ID instead of ID becauses it finds duplicate table
	// values, possible because of @JoinColumn
	private long id;

	@Column
	private BigDecimal initialCredit;

	@Column
	private BigDecimal balance;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date creationDate;

	@ManyToOne(optional = false)
	@JoinColumn
	private Customer customer;
//	
//	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//    private List<Transaction> transactions;

}
