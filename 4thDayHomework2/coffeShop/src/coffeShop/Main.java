package coffeShop;

import java.time.LocalDate;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Zafer");
		customer.setLastName("Aslan");
		customer.setDateOfBirth(LocalDate.of(1999, 02, 10));
		customer.setNationalityID("************");//Burada doðru T.C. numarasý verilirse
		                                   //Saved to Database: "+ customer.getFirstName() ekrana verilir
		
		BaseCustomerManager baseCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		baseCustomerManager.save(customer);
		
		

	}

}
