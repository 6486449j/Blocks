package game.item;

import util.BmpRes;
import game.entity.*;

public class HeatBall extends ExplosiveBall{
private static final long serialVersionUID=1844677L;
	public static BmpRes bmp=new BmpRes("Item/HeatBall");
	public BmpRes getBmp(){return bmp;}
	public Entity toEnt(){
		return new game.entity.HeatBall();
	}
};
