package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SaleManager implements SaleService {

	@Override
	public void sale(Game game, Gamer gamer) {
		System.out.println(game.getGameName() +"->" + gamer.getFirstName() +" "+gamer.getLastName() + " taraf�ndan sat�n al�nd�!");
		
	}

	@Override
	public void campaignSale(Game game, Gamer gamer, Campaign campaign) {
		System.out.println(gamer.getFirstName()+ " "+ gamer.getLastName() + "->"+game.getGameName()+
				" oyunu sat�n al�rken "+campaign.getCampaignName() + " kampanyas�ndan yararland�!");
		
	}

}
