public final class User {
	private final String firstname;
	private final String surname;
	private final String email;


	public User(String firstname, String surname, String email) {
		this.firstname = firstname;
		this.surname = surname;
		this.email = email;
	}


	//User creation with Input validation
	static User createUser()  {

		boolean validInput;
		String firstname = null;
		String surname = null;
		String email = null;

		do {
			validInput = true;

			System.out.println("First we create your User");

			firstname = InputReader.readString("Please type in your Firstname");
			if (firstname.length() < 3) {
				System.out.println("Firstname is too short - try again");
				validInput = false;
				continue;
			}

			surname = InputReader.readString("Please type in your Surname");
			if (surname.length() < 3) {
				System.out.println("Surname is too short - try again");
				validInput = false;
				continue;
			}

			email = InputReader.readString("Please type in your Email");
			if (email.length() < 3 || !email.contains("@")) {
				System.out.println("Email is not valid - try again");
				validInput = false;
			}

		} while (!validInput);

		return new User(firstname, surname, email);
	}


	@Override
	public String toString() {
		return "User Data:\nFirstname: "+ firstname+
				"\nSurname: " + surname+
				"\nEmail: " + email;
	}
}
