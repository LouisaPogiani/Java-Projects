import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerFrame extends JFrame {
	
	private JPanel panel = new JPanel(); //το γενικο πανελ
	private JPanel fieldPanel = new JPanel(); //τα πεδια κειμενου
	private JTextField codeField, destinationField, weightField, powerField;
	private JButton createBulkButton, createRefrButton;
	private JList shipList;	 
	private ArrayList<Ship> ships = new ArrayList<Ship>(); //αναφορα προς arrayList της main
	
	
	public ContainerFrame(ArrayList<Ship> someShips) {
		ships = someShips;
		
		panel.setLayout(new BorderLayout());
		
		fieldPanel.setLayout(new GridLayout(3,2));
		
		codeField = new  JTextField("code");
		destinationField = new JTextField("destination");
		weightField = new  JTextField("weight");
		powerField = new  JTextField("power");
		createBulkButton = new JButton("Create Bulk");
		createRefrButton = new JButton("Create Refridgerator");
		shipList = new JList();
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(Ship ship: ships)
			model.addElement(ship.getName());
		
	/*	model.addElement("ship1");
		model.addElement("ship2");
		model.addElement("ship3");
		model.addElement("ship4");
		model.addElement("ship5");
		model.addElement("ship6"); */
		
		shipList.setModel(model);
		
		fieldPanel.add(codeField);
		fieldPanel.add(destinationField);
		fieldPanel.add(powerField);
		fieldPanel.add(weightField);
		fieldPanel.add(createBulkButton);
		fieldPanel.add(createRefrButton);
		
		panel.add(fieldPanel,BorderLayout.CENTER);
		panel.add(shipList,BorderLayout.SOUTH);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		createBulkButton.addActionListener(listener);
		createRefrButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("SHIP FRAME");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String code = codeField.getText();
		String destination = destinationField.getText();
		String powerText = powerField.getText();
		String weightText = weightField.getText();
		
		if(arg0.getSource().equals(createBulkButton)) {
			double weight = Double.parseDouble(weightText);
			Container bulk = new Bulk(code,destination,weight);
		}
			//entoles dhm bulk 
		else {
			double power = Double.parseDouble(powerText);
			Container refridgerator = new Refridgerator(code,destination,power);
		//	selectedShip.loadContainer(refridgerator);
		}
			//entoles dim refridgerator
		// bazo to container sto selected ship
		
		double weight = Double.parseDouble(weightText);
	//	double power = Double.parseDouble(powerText);
		
		Container bulk = new Bulk(code,destination,weight);
//		Container refridgerator = new Refridgerator(code,destination,power);
		
		
		 String selectedShipName = (String)shipList.getSelectedValue();
		 
		 Ship selectedShip = null;
		 
		 for(Ship ship: ships) { 
			 if(ship.getName().equals(selectedShipName))
				 selectedShip = ship;
			 
		 selectedShip.loadContainer(bulk);}
		 System.out.println("container loaded successfully to the Ship: " +selectedShipName);
		 System.out.println("Total charge for "+selectedShipName +" is:\n" +selectedShip.calcTotalCharge() +"$");
	}
  }
}
	
