package Adapter;

import java.rmi.RemoteException;

import Abstract.GamerCheckService;
import Entities.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements GamerCheckService {

	@Override
	public boolean checkIfRealPerson(Gamer gamer) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(gamer.getNationalityId()),
					gamer.getFirstName(),
		            gamer.getLastName(),gamer.getDateofBirth().getYear());
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}catch(RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
