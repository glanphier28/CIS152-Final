package contents;

public class Queue {
// Members
	private int head; 
	private int tail; 
	private int size; 
	private int maxSize; 
	private ParkingPass queueItems[]; 

	public Queue() {
		this.maxSize = 500;
		this.size = 0;
		this.head = -1;
		this.tail = -1;
		this.queueItems = new ParkingPass[maxSize];
	}


	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		this.head = -1;
		this.tail = -1;
		this.queueItems = new ParkingPass[maxSize];
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean spotIsEmpty(int i) {
		if (queueItems[i].getTenantFName().equals(null)) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return size; 
	}


	public ParkingPass peek() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException();
		} 
		
		return queueItems[head];
	}


	public ParkingPass dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException();
		} 
		head = head +1;
		ParkingPass item = this.queueItems[head];
		size --;
		return item;

	}


	public void enqueue(ParkingPass item) throws QueueFullException {
		if (isFull()) {
			throw new QueueFullException();
		}
		tail = tail +1;
		queueItems[tail] = item;
		size ++;
		
	}
	
	public String print(int id) {
		return ("ID: " + queueItems[id].getPassID() + ", NAME: " + queueItems[id].getTenantFName()  +" " + queueItems[id].getTenantLName() + ", SELL PASS: " + queueItems[id].isSellPass() + ", SPOT: " + queueItems[id].getSpotNumber());
	}


	public String printQueue() {
		String queueString = new String();

		return queueString; 
	}
	
	public ParkingPass getParkingPass(int i) {
		if (i >= queueItems.length) {
			ParkingPass pass = new ParkingPass(0, "", "", false, 0);
			return pass;
		} else {
		return queueItems[i];
		}
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public ParkingPass[] getQueueItems() {
		return queueItems;
	}
	
	public int getSize() {
		return size;
	}
	
	public int[] createArrayBySpot() {

		ParkingPass[] queueArray = ComplexParkingDriver.complexQueue.queueItems;
		System.out.println(queueArray[0].getSpotNumber());
		int[] arr = new int[ComplexParkingDriver.complexQueue.size];
		
		for(int i = 0; i < ComplexParkingDriver.complexQueue.size; i++) {
			arr[i] = queueArray[i].getSpotNumber();
			System.out.println("arr[" + i + "]" + " = " + queueArray[i].getSpotNumber());
		}
		return arr;
	}
}