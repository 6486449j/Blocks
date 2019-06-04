package game.block;

import util.BmpRes;
import static util.MathUtil.*;

public class DiamondBlock extends StoneType{
	private static final long serialVersionUID=1844677L;
	static BmpRes bmp=new BmpRes("Block/DiamondBlock");
	public BmpRes getBmp(){return bmp;}
	int maxDamage(){return 1000;}
	public int fuelVal(){return 640;}
	public void onDestroy(int x,int y){
		new game.item.Diamond().drop(x,y,rndi(14,16));
	}
};
