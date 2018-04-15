package controlleur;

public enum optionSession {
	session1, session2, session3, session4;
	
	private optionSession() {}
	
	public String value() {
		return name();
	}
	
	public static optionSession fromValue(String s) {
		return valueOf(s);
	}
}
