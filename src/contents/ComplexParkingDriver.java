package contents;
public class ComplexParkingDriver {
	public static Queue complexQueue = new Queue();
	public static int ID = 0;
	
	public static void main(String[] args) throws QueueFullException {

		new HomeFrame();
		ParkingPass tenant1 = new ParkingPass("John", "Cowboy", false, 1);
		ParkingPass tenant2 = new ParkingPass("Gabriel", "Lanphier", false, 29);
		ParkingPass tenant3 = new ParkingPass("Carl", "Stanley", true, 0);
		ParkingPass tenant4 = new ParkingPass("Jason", "Stein", false, 53);
		ParkingPass tenant5 = new ParkingPass("Chris", "Micheal", false, 14);
		ParkingPass tenant6 = new ParkingPass("Carlos", "Martinez", false, 54);
		ParkingPass tenant7 = new ParkingPass("Brayden", "Johnson", false, 12);
		ParkingPass tenant8 = new ParkingPass("Kyle", "Jackson", false, 152);
		ParkingPass tenant9 = new ParkingPass("Jack", "Martin", false, 31);
		ParkingPass tenant10 = new ParkingPass("Eric", "Cowman", false, 142); 
		
		complexQueue.enqueue(tenant1);
		complexQueue.enqueue(tenant2);
		complexQueue.enqueue(tenant3);
		complexQueue.enqueue(tenant4);
		complexQueue.enqueue(tenant5);
		complexQueue.enqueue(tenant6);
		complexQueue.enqueue(tenant7);
		complexQueue.enqueue(tenant8);
		complexQueue.enqueue(tenant9);
		complexQueue.enqueue(tenant10);

		
		complexQueue.printQueue();
		
	}
	
	public static int getID() {
		return ID;
	}
	
	public static void incrementID() {
		ID++;
	}
}
