package game.entity;

import game.block.Block;

public class SourceTool{
private static final long serialVersionUID=1844677L;
	public static Source item(game.item.Item it){
		return item(null,it);
	}
	public static Source item(Source src,game.item.Item it){
		if(src!=null)return make(src,"的"+it);
		return make(null,it.getName());
	}
	public static Source armor(Source src,game.item.Armor armor){
		return item(src,armor);
	}
	public static Source shoes(Source src,game.item.Shoes shoes){
		return item(src,shoes);
	}
	public static Source make(Source src,String verb){
		return new SourceInfo(src,verb);
	}
	public static Source block(int x,int y,Block b){
		return block(x,y,b,"");
	}
	public static Source block(int x,int y,Block b,String verb){
		if(b.src!=null)return make(b.src,"放置的"+b.getName()+verb);
		return make(null,b.getName()+verb);
	}
	public static Source explode(Source src){
		if(src==null)debug.Log.printStackTrace();
		return make(src,"爆炸产生的");
	}
	public static final Source OUT=make(null,"出界");
	public static final Source NO_AIR=make(null,"窒息");
	public static final Source IMPACT=make(null,"撞击");
	public static final Source FIRE_WEATHER=make(null,"火天");
}
class SourceInfo implements Source,java.io.Serializable{
private static final long serialVersionUID=1844677L;
	Source src;
	String verb;
	SourceInfo(Source _src,String _verb){
		src=_src;
		verb=_verb;
	}
	public Agent getSrc(){
		if(src!=null)return src.getSrc();
		return null;
	}
	public String toString(){
		if(src!=null)return src+verb;
		return verb;
	}
}