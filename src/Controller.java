import java.util.ArrayList;

public class Controller {
	private View view;
	String p1;
	String p2;
	Model model;
	private ArrayList<Polinom> rezultat = new ArrayList<Polinom>();
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;

		this.view.getAdunare().addActionListener(e -> {
			Polinom p1 = new Polinom(view.getPolinom1());
			Polinom p2 = new Polinom(view.getPolinom2());
			Polinom p3 = model.adunare(p1, p2);
			view.setRezultat(model.print(p3));
		});
		this.view.getScadere().addActionListener(e -> {
			Polinom p1 = new Polinom(view.getPolinom1());
			Polinom p2 = new Polinom(view.getPolinom2());
			Polinom p3 = model.scadere(p1, p2);
			view.setRezultat(model.print(p3));
		
		});
		this.view.getInmultire().addActionListener(e -> {
			Polinom p1 = new Polinom(view.getPolinom1());
			Polinom p2 = new Polinom(view.getPolinom2());
			Polinom p3 = model.inmultire(p1, p2);
			view.setRezultat(model.print(p3));
		});
		this.view.getImpartire().addActionListener(e -> {
			
			Polinom p1 = new Polinom(view.getPolinom1());
			Polinom p2 = new Polinom(view.getPolinom2());
			
			rezultat=model.impartire(p1, p2);
			
			view.setRezultat(model.printFloat(rezultat.get(0)) + " Rest:" + model.printFloat(rezultat.get(1)));
			// 1x^3-2x^2+6x^1-5x^0
			//1x^2-1x^0
		});
		this.view.getDerivare().addActionListener(e -> {
			Polinom p1 = new Polinom(view.getPolinom1());
			Polinom p3 = model.derivare(p1);
			view.setRezultat(model.print(p3));
		});
		this.view.getIntegrare().addActionListener(e -> {
			Polinom p1 = new Polinom(view.getPolinom1());
			Polinom p3 = model.integrare(p1);
			view.setRezultat(model.printFloat(p3));
		});
	}

}
