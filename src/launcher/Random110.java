package launcher;

public class Random110 {
	public static int randomNum() {
		long num = Math.round(Math.random()*10+1);
		if (num > 10) { num=10;}
		int re = (int) num;
		return re;
	}
}
