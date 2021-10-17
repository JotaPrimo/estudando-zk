package estudando.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import estudando.DAO.CatProdutoDAO;
import estudando.models.CatProduto;

public class ProdutoController extends BaseController {
	
	private Listbox listProdutos;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);	
		
		all();
	}
	
	public void onClick$create(Event event) {
		create();
	}
	
	private void create() {
		
		System.out.println("==================================");
		System.out.println("Salvando produto");
		CatProduto prod = new CatProduto();
		prod.setId(1);
		prod.setNombre("Teste create");
		prod.setDescripcion("Teste Descreption");
		prod.setPrecio(150.23);
		
		int result;
		
		try {
			result = CatProdutoDAO.getInstance().insert(prod);
			
			System.out.println("==================================");
			System.out.println("Produto Salvo com Sucesso");
			
			if(result == 0) {
				System.out.println("ERRO, não foi possivel inserir");
			} else {
				System.out.println("ERRO, não foi possivel inserir");
			}
			
		} catch (SQLException sqlException) {
			// TODO: handle exception
			sqlException.getMessage();
		} catch (NamingException namingException) {
			// TODO: handle exception
			namingException.printStackTrace();
		}
		 
		
		
	}

	public void all() {
		List<CatProduto> produtos = new ArrayList<CatProduto>();
		
		CatProduto prod = new CatProduto();
		prod.setId(1);
		prod.setNombre("Mesa");
		prod.setDescripcion("Mesa for job");
		prod.setPrecio(150.35);	
		produtos.add(prod);
		
		
		CatProduto prod2 = new CatProduto();
		prod2.setId(2);
		prod2.setNombre("Notebook");
		prod2.setDescripcion("Notebook for gamer");
		prod2.setPrecio(3450.35);
		produtos.add(prod2);		
		
		
		CatProduto prod3 = new CatProduto();
		prod3.setId(1);
		prod3.setNombre("Carro");
		prod3.setDescripcion("Utilitario");
		prod3.setPrecio(6000.00);
		produtos.add(prod3);
		
		
		if(produtos != null && produtos.size() > 0) {
			listProdutos.getItems().clear();
			
			Listitem iten;
			Listcell cell;
			
			
			for(CatProduto produto : produtos) {
				
				iten = new Listitem();
				iten.setParent(listProdutos);
				iten.setValue(produto);
				
				cell = new Listcell();
				cell.setParent(iten);
				cell.setLabel(String.valueOf(produto.getId()));
				
				
				cell = new Listcell();
				cell.setParent(iten);
				cell.setLabel(produto.getNombre());
				
				
				cell = new Listcell();
				cell.setParent(iten);
				cell.setLabel(produto.getDescripcion());
				
				cell = new Listcell();
				cell.setParent(iten);
				cell.setLabel(produto.getPrecio().toString());
				
			}
			
			listProdutos.invalidate();
			
			
			
		}
		
		
	}
	
}
