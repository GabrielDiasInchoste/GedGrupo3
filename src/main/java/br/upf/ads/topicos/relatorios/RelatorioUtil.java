package br.upf.ads.topicos.relatorios;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.upf.ads.topicos.jpa.JpaUtil;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class RelatorioUtil {

	public static StreamedContent gerarStreamRelatorioPDF(String pathRelatorio, HashMap parameters, String nomeArquivo)
			throws Exception {
		Connection con = getEntityManagerJDBCConnection();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
		JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/" + pathRelatorio), parameters,
				con);
		byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
		return DefaultStreamedContent.builder().name(nomeArquivo).contentType("application/pdf")
				.stream(() -> new ByteArrayInputStream(b)).build();
	}

	/**
	 * M�todo respons�vel por rodar um relat�rio do jasper e responder uma
	 * requisi��o JSF com um PDF
	 * 
	 * @param pathRelatorio Caminho de onde est� o relat�rio no contexto da
	 *                      aplica��o
	 * @param parameters    S�o os par�metros a serem repassados para o relat�rio
	 *                      executar
	 * @throws SQLException
	 */
	public static void rodarRelatorioPDF(String pathRelatorio, HashMap parameters, String nomeArquivo)
			throws Exception {
		Connection con = getEntityManagerJDBCConnection();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
		JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath("/" + pathRelatorio), parameters,
				con);
		byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
		HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		res.setContentType("application/pdf");
		res.setHeader("Content-disposition", "inline;filename=" + nomeArquivo); // diretamente na p�gina
		// res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf"); //
		// baixar ou salvar
		res.getOutputStream().write(b);
		FacesContext.getCurrentInstance().responseComplete();
	}

	/**
	 * M�todo respons�vel por obter uma conex�o JDBC a partir de uma EntityManager.
	 * Funciona com Hibernate 5.2 ou superior.
	 * 
	 * @return conex�o JDBC com o banco de dados
	 * @throws SQLException
	 */
	public static Connection getEntityManagerJDBCConnection() throws SQLException {
		EntityManager em = JpaUtil.getEntityManager();
		Session s = (Session) em;
		SessionImplementor sim = (SessionImplementor) s;
		Connection conexao = sim.connection();
		em.close();
		conexao.setAutoCommit(false);
		return conexao;
	}

	/*
	 * para vers�es mais antigas do Hibernate ... public static Connection
	 * getEntityManagerJDBCConnection() throws SQLException { EntityManager em =
	 * getEntityManager(); HibernateEntityManager hem = (HibernateEntityManager) em;
	 * SessionImplementor sim = (SessionImplementor) hem.getSession(); Connection
	 * conexao = sim.connection(); em.close(); return conexao; }
	 */

	// ou, mais antigo ainda fazer assim ...
	/*
	 * public static Connection getEntityManagerJDBCConnection() throws SQLException
	 * { EntityManager em = factory.createEntityManager(); Session ses = (Session)
	 * em.getDelegate(); SessionFactoryImpl sessionFactory = (SessionFactoryImpl)
	 * ses.getSessionFactory(); Connection conexao =
	 * sessionFactory.getConnectionProvider().getConnection(); em.close(); return
	 * conexao; }
	 */

}
