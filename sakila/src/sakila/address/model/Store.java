package sakila.address.model;

public class Store {
	private int storeId;
	private Staff staff;
	private Address address;
	private String lastUpdate;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", staff=" + staff + ", address=" + address + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	
	
}
