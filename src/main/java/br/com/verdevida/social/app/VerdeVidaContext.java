package br.com.verdevida.social.app;

public class VerdeVidaContext {
	
	private String userLogin;
	
	public VerdeVidaContext(String userLogin) {
		super();
		this.userLogin = userLogin;
	}

	public VerdeVidaContext() {
		super();
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUsuarioLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	
	
}
