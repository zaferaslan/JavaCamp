package eCommerceSimulation.business.concretes;

import eCommerceSimulation.business.abstracts.EmailService;
import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.business.abstracts.UserValidationService;
import eCommerceSimulation.core.AuthService;
import eCommerceSimulation.core.utils.BusinessRules;
import eCommerceSimulation.entities.concretes.User;

public class AuthManager implements AuthService {
	UserService userService;
	UserValidationService userValidationService;
	EmailService emailService;

	public AuthManager(UserService userService, UserValidationService userValidationService,
			EmailService emailService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}

	@Override
	public void register(int id, String email, String password, String firstName, String lastName) {
		User userToRegister = new User(id, email, password, firstName, lastName, false);

		if (!userValidationService.validate(userToRegister)) {
			System.out.println("Validasyon i�lemi ba�ar�s�z. L�tfen t�m alanlar� do�ru girdi�inizden emin olunuz.");
			return;
		}

		if (!BusinessRules.run(checkIfUserExists(email))) {
			System.out.println("Kay�t olma i�lemi ba�ar�s�z. Bu email ile bir ba�ka �ye mevcut.");
			return;
		}
		System.out.println(
				"Ba�ar�yla kay�t olundu. �yeli�inizi do�rulamak i�in l�tfen e-posta adresinizi kontrol ediniz.");
		emailService.send(
				"Deneme do�rulama mesaj�d�r. Do�rulamak i�in kodlama.io/dogrula?id=xyz&token=abc adresine gidin.",
				userToRegister.getEmail());
		userService.add(userToRegister);

	}

	@Override
	public void login(String email, String password) {
		if (!BusinessRules.run(checkIfAllFieldsFilled(email, password))) {
			System.out.println("Giri� ba�ar�s�z. Inputlar do�ru doldurulmad�.");
			return;
		}
		User userToLogin = userService.getByEmailAndPassword(email, password);

		if (userToLogin == null) {
			System.out.println("Giri� ba�ar�s�z. E-posta adresiniz veya �ifreniz yanl��.");
			return;
		}

		if (!checkIfUserVerified(userToLogin)) {
			System.out.println("Giri� ba�ar�s�z. �yeli�inizi do�rulamad�n�z.");
			return;
		}
		System.out.println(
				"Giri� ba�ar�l�. Ho�geldiniz : " + userToLogin.getFirstName() + " " + userToLogin.getLastName());

	}

	private boolean checkIfUserExists(String email) {
		return userService.getByEmail(email) == null;
	}

	private boolean checkIfUserVerified(User user) {
		return user.isVerified();
	}

	private boolean checkIfAllFieldsFilled(String email, String password) {
		if (email.length() <= 0 || password.length() <= 0) {
			return false;
		}
		return true;
	}

}
