package eCommerceSimulation;

import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.business.concretes.AuthManager;
import eCommerceSimulation.business.concretes.EmailManager;
import eCommerceSimulation.business.concretes.UserManager;
import eCommerceSimulation.business.concretes.UserValidationManager;
import eCommerceSimulation.core.AuthService;
import eCommerceSimulation.core.GoogleAuthManagerAdapter;
import eCommerceSimulation.dataAccess.concretes.InMemoryUserDao;


public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());
		authService.register(1, "zafer-aslan99@hotmail.com", "zafer123", "Zafer", "Aslan");//Başarılı
		authService.register(2, "bubirepostadeðil..","þifrevalid", "Zafer","Aslan");//Başarısız eposta invalid
		authService.register(3, "bubireposta@gmail.com", "b","Zafer","Aslan");// Başarısız şifre invalid
		authService.register(4, "zafer-aslan99@hotmail.com", "b", "Z","A");// Başarısız ad-soyad invalid
		authService.register(5, "zafer-aslan99@hotmail.com", "zafer123", "Zafer", "Aslan"); // Başarısız e-posta mevcut
		
		authService.login("zafer-aslan99@hotmail.com","zafer123");// Başarısız üye doğrulama yapmamış
		userService.verifyUser(1);//Kullanıcı doğrulaması
		authService.login("zafer-aslan99@hotmail.com", "zafer1234");//Başarısız şifre yanlış
		authService.login("zafer-aslan99@hotmail.com","zafer123");//Başarılı
		authService.login("", ""); // Başarısız e-posta parola zorunlu
		
		authService.login("zafer-aslan99@hotmail.com","zafer123");// Başarısız üye doğrulama yapmamış
		userService.verifyUser(1); // Kullanıcı doğrulaması
		authService.login("zafer-aslan99@hotmail.com", "zafer1234");//Başarısız şifre yanlış
		authService.login("zafer-aslan99@hotmail.com","zafer123");//Başarılı
		authService.login("", ""); // Başarısız e-posta parola zorunlu
		
		AuthService googleAuthService=new GoogleAuthManagerAdapter();
		googleAuthService.register(6, "zaferr.aslan1@gmail.com", "zafer123", "Zafer", "Aslan");
		googleAuthService.login("zaferr.aslan1@gmail.com", "zafer123");
		
		
		
		
		

	}

}
