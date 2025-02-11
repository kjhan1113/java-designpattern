package structural.adapter.hiroshi;

public class PrintBanner extends Banner implements Print{

	public PrintBanner(String string) {
		super(string);
	}

	@Override
	public String printWeak() {
		return showWithParentheses();
	}

	@Override
	public String printStrong() {
		return showWithAsterisk();
	}
}