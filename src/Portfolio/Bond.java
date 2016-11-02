package Portfolio;

public class Bond extends Security {
	
	private float yield;
	
	public Bond(String code, String name, float yield) {
		super(code, name);
		this.yield = yield;
	}
	
	public float getYield() {
		return yield;
	}
	
	public void setyield(float yield){
		this.yield = yield;
	}
}