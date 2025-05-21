package hiroshi.creational.factory;

public class IDCard extends Product {

	private String owner;
	
	public IDCard(String owner) {
		System.out.println(owner + "'s card is being created");
		this.owner = owner;
	}
	
	@Override
	public void use() {
		System.out.println(owner + "'s card has been used");
	}

	public String getOwner() {
		return owner;
	}
}
