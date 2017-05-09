package TUISelenium.tui;

public class Tree extends BaseClass{

	static String a;
	
	public String getInfo(){
		return "B";
	}
	
	public void setA(){
		a = getInfo();
	}
	
	public void main(String[] args) {
		setA();
		System.out.println(a);

	}

}
