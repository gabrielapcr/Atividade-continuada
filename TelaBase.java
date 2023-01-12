package Telas.gui;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaBase {

	protected Shell shlCalculadora;
	private Text txOp1;
	private Button btnSubtrao;
	private Button btnProduto;
	private Button btnDiviso;
	private Button btnLimpar;
	private Button btnRadioButton;
	private Button btnRadioButton_1;
	private Button btnRadioButton_2;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaBase window = new TelaBase();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCalculadora.open();
		shlCalculadora.layout();
		while (!shlCalculadora.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCalculadora = new Shell();
		shlCalculadora.setSize(555, 262);
		shlCalculadora.setText("Calculadora");
		
		Label lblOperando = new Label(shlCalculadora, SWT.NONE);
		lblOperando.setBounds(10, 25, 91, 20);
		lblOperando.setText("valores");
		
		Label lblOperando_1 = new Label(shlCalculadora, SWT.NONE);
		lblOperando_1.setBounds(10, 62, 91, 20);
		lblOperando_1.setText("Operacao");
		
		Label lblResultado = new Label(shlCalculadora, SWT.NONE);
		lblResultado.setBounds(10, 149, 70, 20);
		lblResultado.setText("Resultado");
		
		txOp1 = new Text(shlCalculadora, SWT.BORDER);
		txOp1.setBounds(115, 19, 78, 26);
		
		Button btnCalcular = new Button(shlCalculadora, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				double[] operandos = obterOperandos();
				if (operandos != null) {
					double soma = operandos[0] + operandos[1];
					text.setText("" + soma);
				}
			}
		});		
		btnCalcular.setBounds(11, 175, 90, 30);
		btnCalcular.setText("Calcular");
		
	
		
		btnLimpar = new Button(shlCalculadora, SWT.NONE);
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				txOp1.setText("");
				text.setText("");
				txOp1.setFocus();
			}
		});	
		btnLimpar.setBounds(115, 175, 90, 30);
		btnLimpar.setText("Limpar");
		
		btnRadioButton = new Button(shlCalculadora, SWT.RADIO);
		btnRadioButton.setBounds(107, 61, 191, 15);
		btnRadioButton.setText("Média aritmética");
		
		double[] operandos = obterOperandos();
		if (operandos != null) {
			double MediaAritmetica = operandos[0] + operandos[1];
			text.setText("" + MediaAritmetica);
		}
		
		btnRadioButton_1 = new Button(shlCalculadora, SWT.RADIO);
		btnRadioButton_1.setBounds(107, 93, 180, 15);
		btnRadioButton_1.setText("Média geométrica");
		
		btnRadioButton_2 = new Button(shlCalculadora, SWT.RADIO);
		btnRadioButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRadioButton_2.setBounds(107, 128, 206, 15);
		btnRadioButton_2.setText("Média harmônica");
		
		text = new Text(shlCalculadora, SWT.BORDER);
		text.setBounds(107, 146, 64, 19);
		text.setEditable(false);
		text.setEnabled(false);
		
	}
	private double[] obterOperandos() {
		try {
			double n1 = Double.parseDouble(txOp1.getText().trim());
			double[] operandos = {n1};
			return operandos;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Operando 1  representa um n�mero");
			txOp1.setFocus();
			return null;
		}
	}

}