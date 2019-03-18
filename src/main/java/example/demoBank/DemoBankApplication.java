/*
 * The assessment consists of an API to be used for opening a “current account” of already
existent customers.

The API will expose an endpoint which accepts the user information (customerID,
initialCredit).

Once the endpoint is called, a new account will be opened connected to the user whose ID
is customerID.

Also, if initialCredit is not 0, a transaction will be sent to the new account.

Another Endpoint will output the user information showing Name, Surname, balance, and
transactions of the accounts.

Feel free to use any open source tool.

For storing the information, the data can be saved in memory and not actually persisted, so
that we can test the solution easier.

The expected deliverable is the source code published on github or gitlab and instructions
on how to execute it.

The programming language by default is Java but we are flexible if you let us know which
other language you prefer.

Bonus:
Accounts and Transactions are different services.

Bonus:
Frontend (simple one it is OK).

Testability will be also assessed.
*/

package example.demoBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBankApplication.class, args);
	}

}
