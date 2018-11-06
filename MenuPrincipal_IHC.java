import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuPrincipal_IHC extends JFrame {
	
	private JLabel tipoDeUsuario;
	private JButton gerente, cliente;
	
	public MenuPrincipal_IHC() {
		
		super("Menu Principal");
		setLayout(new FlowLayout());
		
		tipoDeUsuario = new JLabel("tipo de usuario:");
		add(tipoDeUsuario);
		
		gerente = new JButton("Gerente");
		add(gerente);
		
		cliente = new JButton("Cliente");
		add(cliente);
		
		usuario botao = new usuario();
		gerente.addActionListener(botao);
		cliente.addActionListener(botao);
	}
	
	private class usuario implements ActionListener{
		
		public void actionPerformed (ActionEvent evento) {
			
			if(evento.getSource() == gerente) {

				Gerente_IHC gerente = new Gerente_IHC();
				gerente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				gerente.setSize(250,190);
				gerente.setLocationRelativeTo(null);
				gerente.setVisible(true);
			}
			
			else {
				
				Cliente_IHC cliente = new Cliente_IHC();
				cliente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				cliente.setSize(350,130);
				cliente.setLocationRelativeTo(null);
				cliente.setVisible(true);
			}
			
		}
	}
}