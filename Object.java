public class Object {
    char name;
    CoodinateValue value = new CoodinateValue();
    CoodinateValue nextValue = new CoodinateValue();

    public void update() {
	setValue(this.nextValue.x , this.nextValue.y);
    }

    public void setValue(int x, int y) {
	this.value.x = x;
	this.value.y = y;
    }

    public void setNextValue(int x, int y) {
	this.nextValue.x = x;
	this.nextValue.y = y;
    }

    class CoodinateValue {
	public int x;
	public int y;
    }
}
