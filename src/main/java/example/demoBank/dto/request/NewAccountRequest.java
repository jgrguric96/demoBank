package example.demoBank.dto.request;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class NewAccountRequest {
	
	private Long customerID;
	private BigDecimal initialCredit;

}
