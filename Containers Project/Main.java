import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	  
		Ship ship1 = new Ship("Copacabana",3);
		Ship ship2 = new Ship("Hercules",100);
		Ship ship3 = new Ship("Zeus",80);
		Ship ship4 = new Ship("Olympus",120);
		Ship ship5 = new Ship("Tinos",140);
		
		ArrayList<Ship> ships = new ArrayList<Ship>();
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		ships.add(ship5);
		
		new ContainerFrame(ships);
		
	/*	Container b1 = new Bulk("CYZ21","Barcelona",1200);
		Container r1 = new Refridgerator("COA245","Piraeus",2.3);
		Container b2 = new Bulk("YBZ214","London",1800);
		Container r2 = new Refridgerator("LOA785","Malaga",2.7); 
		
		ship1.loadContainer(b1);
		ship1.loadContainer(r1);
		ship1.loadContainer(b2);
		ship1.loadContainer(r2); */
		
		
	//	new ChargeCalculator(ship1);
		

	}

}
