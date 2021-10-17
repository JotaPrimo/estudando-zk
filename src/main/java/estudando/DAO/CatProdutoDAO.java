package estudando.DAO;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import estudando.utils.Commons;

public class CatProdutoDAO extends DAO{

	protected static CatProdutoDAO dao;
	private final String INSERT = "INSERT INTO public.cat_producto(id, nombre, descripcion, precio) VALUES (?, ?, ?, ?);";
	
	public CatProdutoDAO( ) throws NamingException {
		this.ds = Commons.getDS();
		this.qr = new QueryRunner(ds);
	}
	
	public static CatProdutoDAO getInstance() throws NamingException {
		
		
		if( dao == null ) {
			dao = new CatProdutoDAO();
		}
		
		return dao;		
		
	}
	
public int insert(Object object) {
		
		int result = 0;
		
		
		
		return result;
	}
}
