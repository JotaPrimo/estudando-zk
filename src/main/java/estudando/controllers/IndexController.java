package estudando.controllers;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Label;
import org.zkoss.zk.ui.event.Event;

public class IndexController extends BaseController {
	
	
	private Label lblCumprimento;
	private Label btnCumprimento;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		lblCumprimento.setValue("Jota Santos setado via Index Controller");
	}
	
	public void onClik$btnCumprimento(Event event) {		
		lblCumprimento.setValue("Clique no botão");
		lblCumprimento.setStyle("color: blue");
	}
}
