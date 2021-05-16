package Adapters;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService   {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityID()),
				customer.getFirstName(),
	            customer.getLastName(),customer.getDateOfBirth().getYear());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
