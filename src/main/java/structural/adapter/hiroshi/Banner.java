package structural.adapter.hiroshi;

public class Banner {
	private String string;
	
	public Banner(String string) {
		this.string = string;
	}
	
	public String showWithParentheses() {
		return "(" + string + ")";
	}
	
	public String showWithAsterisk() {
		return "*" + string + "*";
	}
}