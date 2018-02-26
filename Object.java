public class Object {
    char name;
    CoodinateValue value = new CoodinateValue();
    CoodinateValue nextValue = new CoodinateValue();

    public void update() {
	this.value = this.nextValue;
    }

    public void setValue(int x, int y) {
	this.value.x = x;
	this.value.y = y;
    }

    class CoodinateValue {
	public int x;
	public int y;
    }
}
