import java.util.ArrayList;

public class Ship {
	
	private String name;
	private int capacity;
	private ArrayList<Container> containers = new ArrayList<Container>();
	 	
	public Ship(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
	

	public String getName() {
		return name;
	}

	public void loadContainer(Container aContainer) {
		if(containers.size()<capacity) {
			containers.add(aContainer);
		System.out.println("succesful load");
		}
		else
			System.out.println("the ship is full");
		}
	
	public double calcTotalCharge() {
		double sum = 0;
		for(Container container:containers)
			sum+= container.calculateCharge();
			return sum;		
	}

}
