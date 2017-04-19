package thinger.timer;

import java.util.ArrayList;
import java.util.List;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.common.Side;
import com.robrua.orianna.type.core.currentgame.CurrentGame;
import com.robrua.orianna.type.core.currentgame.MasteryRank;
import com.robrua.orianna.type.core.currentgame.Participant;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import thinger.timer.gui.MainWindowController;

public class ThingerTimerMain extends Application {
	
	public static final String APIKEY = "RGAPI-46a43097-c59d-427f-ae0c-4daa7f7d15a9";
	public static final String SUMMONER_NAME = "poopyface69";
	
	//TODO: ENTER SUMM NAME
	//TODO: MAKE IT WORK FOR MORE THAN 1 GAME
	//TODO: LUCIDITY BOOTS RIGHT CLICK
	
	public static void main(String[] args) {	

			Application.launch();
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(ThingerTimerMain.class.getResource("gui/MainWindow.fxml"));
		loader.load();

		MainWindowController winMain = (MainWindowController) loader.getController();

		
		
		RiotAPI.setRegion(Region.NA);
        RiotAPI.setAPIKey(APIKEY);
        
        CurrentGame cG = RiotAPI.getCurrentGame(SUMMONER_NAME);
        
        List<Champion> champs = new ArrayList<>();
        
        if(cG != null){
        	
        	
        	
        	System.out.println("In game");
        	
        	 List<Participant> pList = cG.getParticipants();
        	 Side myTeam = null;
        	 
        	 for(Participant p : pList){
        		 if(p.getSummonerName().equalsIgnoreCase(SUMMONER_NAME)){
        			 myTeam = p.getTeam();
        			 break;
        		 }
        	 }
        	 
             for(Participant p : pList){
            	if(p.getTeam().getID() != myTeam.getID()){
            		 System.out.println("-----------------------------");
                	 
                  	System.out.println(p.getChampion());
                  	
                  	System.out.println(p.getSummonerSpell1().getName());
                  	System.out.println(p.getSummonerSpell1().getCooldownBurn());
                  	System.out.println(p.getSummonerSpell2().getName());
                  	System.out.println(p.getSummonerSpell2().getCooldownBurn());
                  	List<MasteryRank> masteries = p.getMasteries();
                  	
                  	boolean hasInsight = false;
                  	
                  	for(MasteryRank m : masteries){
                  		System.out.println(m.getMastery().getName());
                  		if(m.getMastery().getName().equals("Insight")){
                  			hasInsight = true;
                  			break;
                  		}
                  	}
                  	
                  	Champion champ = new Champion(p.getChampion().getName(), p.getSummonerSpell1(), p.getSummonerSpell2(), hasInsight);
                  	champs.add(champ);
                  	
                  	 System.out.println("-----------------------------");
            	}
             }
        }else{
        	System.out.println("Not in game");
        }
        
        winMain.setChampList(champs);
        
        winMain.setStage(stage);
        stage.show();

		System.out.println("Started");
	}
}