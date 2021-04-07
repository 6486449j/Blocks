package game.block;

import game.item.*;
import game.entity.DroppedItem;
import game.world.World;

public abstract class CraftHelperBlock extends IronBasedType implements EnergyContainer{
	private static final long serialVersionUID=1844677L;
	protected SpecialItem<EnergyCell> ec;
	public BlockCraftHelper ch;
	public EnergyCell getEnergyCell(){return ec.get();}
	public void onPlace(int x,int y){
		ec=new SpecialItem<EnergyCell>(EnergyCell.class);
		ch=new BlockCraftHelper(new BlockAt(x,y,this),this);
	}
	public boolean onCheck(int x,int y){
		ch.upd();
		return super.onCheck(x,y);
	}
	public int getEnergy(){
		if(ec.isEmpty())return 0;
		return ec.get().getEnergy();
	}
	public void loseEnergy(int v){
		if(v!=0)ec.get().loseEnergy(v);
	}
	public int resCap(){
		if(ec.isEmpty())return 0;
		return ec.get().resCap();
	}
	public void gainEnergy(int v){
		if(v!=0)ec.get().gainEnergy(v);
	}
	public void onDestroy(int x,int y){
		ch.interrupt();
		DroppedItem.dropItems(ec,x+0.5,y+0.5);
		ec=null;
		super.onDestroy(x,y);
	}
	public boolean isDeep(){return true;}
}
