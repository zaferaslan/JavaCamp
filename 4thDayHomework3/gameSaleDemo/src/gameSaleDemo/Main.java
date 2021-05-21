package gameSaleDemo;

import Concrete.GamerManager;
import java.time.LocalDate;
import Adapter.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.GamerManager;
import Concrete.SaleManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class Main {

	public static void main(String[] args) {
		GamerManager gamerManager1 = new GamerManager(new MernisServiceAdapter());
		gamerManager1.add(new Gamer(1,"Zafer","Aslan",LocalDate.of(1999, 2, 10),"1111111111"));
		
		GamerManager gamerManager2 = new GamerManager(new MernisServiceAdapter());
		gamerManager2.add(new Gamer(2,"Sait","Aslan",LocalDate.of(2003,10, 8),"22222222222"));
		
		GameManager gameManager1 = new GameManager();
		gameManager1.add(new Game(1,"Forza Horizon 4",92,10));
		
		GameManager gameManager2 = new GameManager();
		gameManager2.add(new Game(2,"Fifa 21",200,8));
		
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(new Campaign(1,"Paskalya",40));
		
		SaleManager saleManager1 = new SaleManager();
		saleManager1.sale(new Game(1,"Forza Horizon 4",92,10), new Gamer(1,"Zafer","Aslan",LocalDate.of(1999, 2, 10),"1111111111"));
		
		SaleManager saleManager2 = new SaleManager();
		saleManager2.campaignSale(new Game(2,"Fifa 21",200,8), new Gamer(1,"Sait","Aslan",LocalDate.of(2003,10, 8),"22222222222"),new Campaign(1,"Paskalya",40));
		
		
		
		
		

	}

}
