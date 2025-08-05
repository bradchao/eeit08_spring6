package tw.brad.spring6.excption;

public class AuthException extends RuntimeException{
	public AuthException(String mesg) {
		super(mesg);
	}
}
