import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CriarContaEspecial_IHC extends CriarContaNova_IHC {
	
	private JLabel limite, juros;
	private JTextField limiteInserir, jurosInserir;
	private JButton cancelar, ok;
	
	public CriarContaEspecial_IHC(String tipoDeConta) {
		
		super(tipoDeConta);
		
		limite = new JLabel("Limite da Conta:");
		add(limite);
		
		limiteInserir = new JTextField(10);
		add(limiteInserir);
		
		juros = new JLabel("Juros da Conta:");
		add(juros);
		
		jurosInserir = new JTextField(10);
		add(jurosInserir);
		
		cancelar = new JButton("Cancelar");
		add(cancelar);
		
		ok = new JButton("OK");
		add(ok);
		
		opcao botao = new opcao();
		ok.addActionListener(botao);
		cancelar.addActionListener(botao);
	}
	
	private class opcao implements ActionListener {
		
		public void actionPerformed (ActionEvent evento) {
			
			Singleton objeto = Singleton.getInstance();
			
			if(evento.getSource() == ok) {
				
				try {
					
					if(objeto.contaEspecial(nomeInserir.getText(), Integer.parseInt(numeroInserir.getText()), Double.parseDouble(limiteInserir.getText()), Double.parseDouble(jurosInserir.getText())) == true) {
					
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso", "Criar Conta Especial", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Numero de conta ja existente", "Criar Conta Especial", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch(NumberFormatException NumberFormatException) {
					
					JOptionPane.showMessageDialog(null, "Entrada Invalida, tente novamente", "Criar Conta Especial", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else {
				
				dispose();
			}
		}
	}
}