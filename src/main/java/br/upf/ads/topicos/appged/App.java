package br.upf.ads.topicos.appged;

import br.upf.ads.topicos.jpa.JpaUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		JpaUtil.getInstance().getEntityManager();
	}
}
