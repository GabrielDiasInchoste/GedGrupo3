package br.upf.ads.topicos.jsf;

public class TrataException {

	public static String getMensagem(Throwable e) {
		if (e.getCause() != null) {
			return getMensagem(e.getCause());
		} else {
			return e.getMessage();
		}
	}
	
}
