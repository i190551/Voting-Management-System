package application;

public class InvalidCredentialsException extends Exception {

	public InvalidCredentialsException() {
		super("Invalid CNIC or Password");
	}

}
