package game.item;

import static java.lang.Math.*;
import static util.MathUtil.*;
import game.entity.*;

public class EnergyStoneShield extends Shield{
	private static final long serialVersionUID=1844677L;
	public int maxDamage(){return 2000;}
	protected double toolVal(){return 0.5;}
	@Override
	public double light(){return 1;}
	public double hardness(){return game.entity.NormalAttacker.IRON;}
	
	@Override
	public void onCarried(Agent a){
		last_attacked_val*=0.99;
	}
	double last_attacked_val=0;
	public Attack transform(Attack a){
		damage+=rf2i(a.val);
		double delta=a.val;
		if(a.val>0)a.val=min(delta,sqrt(last_attacked_val+delta)-sqrt(last_attacked_val))*0.3;
		last_attacked_val+=delta;
		return a;
	}
	public void onBroken(double x,double y){
		new EnergyStone().drop(x,y,rndi(1,3));
		super.onBroken(x,y);
	}
}