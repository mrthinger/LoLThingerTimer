package thinger.timer;

import com.robrua.orianna.type.core.staticdata.SummonerSpell;

public class Champion {


	private String name;
	private SummonerSpell ss1;
	private SummonerSpell ss2;
	private boolean hasInsight;
	
	private float timer1;
	private float timer2;
	
	public Champion(String name, SummonerSpell ss1, SummonerSpell ss2, boolean hasInsight) {
		this.name = name;
		this.ss1 = ss1;
		this.ss2 = ss2;
		this.hasInsight = hasInsight;
		
		timer1 = Float.parseFloat(ss1.getCooldownBurn());
		timer2 = Float.parseFloat(ss2.getCooldownBurn());
		
		if(hasInsight){
			timer1 *= .85F;
			timer2 *= .85F;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SummonerSpell getSs1() {
		return ss1;
	}

	public void setSs1(SummonerSpell ss1) {
		this.ss1 = ss1;
	}

	public SummonerSpell getSs2() {
		return ss2;
	}

	public void setSs2(SummonerSpell ss2) {
		this.ss2 = ss2;
	}

	public boolean isHasInsight() {
		return hasInsight;
	}

	public void setHasInsight(boolean hasInsight) {
		this.hasInsight = hasInsight;
	}

	public float getTimer1() {
		return timer1;
	}

	public void setTimer1(float timer1) {
		this.timer1 = timer1;
	}

	public float getTimer2() {
		return timer2;
	}

	public void setTimer2(float timer2) {
		this.timer2 = timer2;
	}
	
	
}
