package lab8;

public class CCFraudRecord {
	protected int time;
	protected double amount;
	protected int fraudclass;
	
	public CCFraudRecord(int time, double amount, int fraudclass) {
		this.time = time;
		this.amount = amount;
		this.fraudclass = fraudclass;
	}
	
	
}
