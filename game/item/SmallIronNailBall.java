package game.item;

import util.BmpRes;
import game.entity.*;

public class SmallIronNailBall extends StoneBall{
private static final long serialVersionUID=1844677L;
	public static BmpRes bmp=new BmpRes("Item/SmallIronNailBall");
	public BmpRes getBmp(){return bmp;}
	public double hardness(){return game.entity.NormalAttacker.IRON;}
	public Entity toEnt(){
		return new game.entity.SmallIronNailBall();
	}
};
