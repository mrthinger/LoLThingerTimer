package thinger.timer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TimerClickHandler implements EventHandler<MouseEvent>{

	
	private float initialTimer;
	private Label label;
	
	private String initialText;
	
	private boolean timerRunning;

	
	public TimerClickHandler(float initialTimer, Label label) {
		super();
		this.initialTimer = initialTimer;
		this.label = label;
		this.initialText = label.getText();
		this.timerRunning = false;
	}


	@Override
	public void handle(MouseEvent event) {

		System.out.println("clicked" + initialText);
		
		if(timerRunning == false){
			timerRunning = true;
			Thread t = new Thread(()-> {
				float startTime = initialTimer;
				
				while(initialTimer > 0F){
					float sT = System.currentTimeMillis();
					
					//update label
					Platform.runLater(()->{
						
						int mins = (int) initialTimer / 60;
						float seconds = initialTimer - (mins * 60F);
						
						String display = initialText + " : " + mins + ":" + seconds;
						
						label.setText(display);
						
						
					});
					
					//Wait
					try {
						Thread.sleep(980);
					} catch (InterruptedException e) {}
					
					//Calculate how much time has passed
					float eT = System.currentTimeMillis();
					float dT = eT - sT;
					dT /= 1000;
					initialTimer -= dT;
					
				}
				
				//reset
				Platform.runLater(()->{
					label.setText(initialText);
				});
				initialTimer = startTime;
				timerRunning = false;
				
			});
			
			t.setDaemon(true);
			t.start();
		}
		
		
	}

}
