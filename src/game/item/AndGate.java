package game.item;

import util.BmpRes;
import game.entity.Human;
import game.entity.Agent;
import game.world.World;
import game.block.Block;
import game.block.WireBlock;
import static util.MathUtil.*;

public class AndGate extends Item{
	private static final long serialVersionUID=1844677L;
	public static BmpRes[] bmp=BmpRes.load("Item/AndGate_",2);
	public BmpRes getBmp(){return bmp[tp];}
	static int tps[]={WireBlock.lr_and,WireBlock.ud_and};
	int tp=0;
	public void onUse(Human a){
		tp^=1;
		a.items.getSelected().insert(this);
	}
	public Item clickAt(double x,double y,Agent a){
		Block b=World._.get(x,y);
		if(b.getClass()==WireBlock.class){
			if(((WireBlock)b).ins(f2i(x),f2i(y),tps[tp],WireBlock._ctrl))return null;
		}
		return super.clickAt(x,y,a);
	}
	public BmpRes getUseBmp(){return rotate_btn;}
};
