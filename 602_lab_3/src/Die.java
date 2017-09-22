
public class Die extends Object implements Rollable
{
	private int lastRoll;

	public Die()
	{
		// StdOut.println("In Die()");
		this.roll();
	}

	public Die(int firstValue)
	{
		// StdOut.println("In Die(int)");
		lastRoll = firstValue;
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	protected void setLastRoll(int lastRoll) // expose this only to subclasses?
	{
		this.lastRoll = lastRoll;
	}

	public void roll()
	{
		setLastRoll((int) (Math.random() * 6 + 1));
		//this.lastRoll((int) (Math.random() * 6 + 1));
	}

//	public String toString() // can you change this to protected visiblity?
//	{
//		return "A Die object with lastRoll == " + this.getLastRoll() + super.toString();
//		// does getLastRoll() *always* call the method above?
//	}

	public String toString(int msg) // Overloading... but NOT overriding!
	{
		return msg + " -> " + this.toString();
	}
}
