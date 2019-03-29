package example.demoBank.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private BigDecimal ammount;

	@Enumerated(value = EnumType.STRING)
	@Column
	private TransactionType transactionType;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column
	private Date transactionDate;

	@ManyToOne
	@JoinColumn
	private Account account;
}
