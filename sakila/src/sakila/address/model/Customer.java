package sakila.address.model;

public class Customer {
	private int customerId;
	private Store store;
	private String firstName;
	private String lastName;
	private String eMail;
	private Address address;
	private int active;
	private String createDate;
	private String lastUpdate;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", store=" + store + ", firstName=" + firstName + ", lastName="
				+ lastName + ", eMail=" + eMail + ", address=" + address + ", active=" + active + ", createDate="
				+ createDate + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
	
}
