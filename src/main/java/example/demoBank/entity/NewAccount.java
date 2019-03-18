package example.demoBank.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class NewAccount {

	private Long customerID;
	private BigDecimal initialCredit;
	
}
