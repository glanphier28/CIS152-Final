package contents;

public class ParkingPass {
	
	private int passID;
	private String tenantFName;
	private String tenantLName;
	private boolean sellPass;
	private int spotNumber;
	
	public ParkingPass() {
		ComplexParkingDriver.incrementID();
		int parkingPassID = ComplexParkingDriver.getID();
		this.tenantFName = null;
		this.tenantLName = null;
		this.sellPass = true;
		this.passID = parkingPassID;
		this.spotNumber = -1;
	}
	
	public ParkingPass(String tenantFName, String tenantLName, boolean sellPass, int spotNumber) {
		super();
		ComplexParkingDriver.incrementID();
		int parkingPassID = ComplexParkingDriver.getID();
		this.tenantFName = tenantFName;
		this.tenantLName = tenantLName;
		this.sellPass = sellPass;
		this.passID = parkingPassID;
		this.spotNumber = spotNumber;
	}
	
	//constructor for queue class // these objects will not be enqueued
	
	public ParkingPass(int id, String tenantFName, String tenantLName, boolean sellPass, int spotNumber) {
		super();
		this.tenantFName = tenantFName;
		this.tenantLName = tenantLName;
		this.sellPass = sellPass;
		this.passID = id;
		this.spotNumber = spotNumber;
	}

	public int getPassID() {
		return passID;
	}

	public void setPassID(int passID) {
		this.passID = passID;
	}

	public String getTenantFName() {
		return tenantFName;
	}

	public void setTenantFName(String tenantFName) {
		this.tenantFName = tenantFName;
	}

	public String getTenantLName() {
		return tenantLName;
	}

	public void setTenantLName(String tenantLName) {
		this.tenantLName = tenantLName;
	}

	public boolean isSellPass() {
		return sellPass;
	}

	public void setSellPass(boolean sellPass) {
		this.sellPass = sellPass;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}
	
	
}
