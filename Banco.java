import javax.swing.JFrame;

public class Banco {
	
	public static void main (String args[]) {
		
		MenuPrincipal_IHC MenuPrincipal = new MenuPrincipal_IHC();
		MenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuPrincipal.setSize(400,85);
		MenuPrincipal.setLocationRelativeTo(null);
		MenuPrincipal.setVisible(true);
		
	}
}