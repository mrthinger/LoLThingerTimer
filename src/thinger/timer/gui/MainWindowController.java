package thinger.timer.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import thinger.timer.Champion;
import thinger.timer.TimerClickHandler;

public class MainWindowController implements Initializable{

    @FXML
    private Label eRed;

    @FXML
    private Label allyGromp;

    @FXML
    private Label allyRed;

    @FXML
    private Label eKrug;

    @FXML
    private Label eWolf;

    @FXML
    private Label eBlue;

    @FXML
    private Label allyRaptor;

    @FXML
    private Label allyBlue;

    @FXML
    private Label eRaptor;

    @FXML
    private Label eGromp;

    @FXML
    private VBox champBox;

    @FXML
    private Label allyWolf;

    @FXML
    private Label allyKrug;

    @FXML
    private AnchorPane mainPane;

	private Stage stage;

	private List<HBox> champBoxes;

	private List<Champion> champs;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//5 min buff timers
		eRed.setOnMouseClicked(new TimerClickHandler(300F, eRed));
		eBlue.setOnMouseClicked(new TimerClickHandler(300F, eBlue));
		allyRed.setOnMouseClicked(new TimerClickHandler(300F, allyRed));
		allyBlue.setOnMouseClicked(new TimerClickHandler(300F, allyBlue));
		
		
		allyGromp.setOnMouseClicked(new TimerClickHandler(150F, allyGromp));
		allyRaptor.setOnMouseClicked(new TimerClickHandler(150F, allyRaptor));
		allyKrug.setOnMouseClicked(new TimerClickHandler(150F, allyKrug));
		allyWolf.setOnMouseClicked(new TimerClickHandler(150F, allyWolf));
		
		eGromp.setOnMouseClicked(new TimerClickHandler(150F, eGromp));
		eRaptor.setOnMouseClicked(new TimerClickHandler(150F, eRaptor));
		eKrug.setOnMouseClicked(new TimerClickHandler(150F, eKrug));
		eWolf.setOnMouseClicked(new TimerClickHandler(150F, eWolf));
		
		

	}

	public void setStage(Stage stage){
		this.stage = stage;
		stage.setAlwaysOnTop(true);
		stage.setScene(new Scene(mainPane));
	}

	public void setChampList(List<Champion> champs){
		this.champs = champs;
		genChampBoxes();
	}

	private void genChampBoxes(){
		for(Champion c : champs){
			HBox hb = new HBox(4);
			Label name = new Label(c.getName());
			Label ss1Name = new Label(c.getSs1().getName());
			ss1Name.setOnMouseClicked(new TimerClickHandler(c.getTimer1(), ss1Name));
			
			
			Label ss2Name = new Label(c.getSs2().getName());
			ss2Name.setOnMouseClicked(new TimerClickHandler(c.getTimer2(), ss2Name));
			
			hb.getChildren().addAll(name, ss1Name, ss2Name);

			champBox.getChildren().add(hb);
		}


	}


}