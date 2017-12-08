package GameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DeadState extends GameState {
	
	private Background dg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Return To Menu",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public DeadState(GameStateManager gsm){
		this.gsm = gsm;
		
		try{
			
			dg = new Background("" , 1);
			dg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 128);
			titleFont = new Font(
					"Century Gothic",
					Font.PLAIN, 
					24);
			
			font = new Font("Arial", Font.PLAIN, 12);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void init() {}
	public void update() {
		dg.update();
	}
	public void draw (Graphics2D g) {
		//draw dg
		dg.draw(g);
		
		//draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Get Gud",  7, 70);
		

		
		//draw dead options
		g.setFont(font);
		for(int i = 0; i < options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.BLACK);
			}
			else{
				g.setColor(Color.BLUE);
			}
			g.drawString(options[i], 145, 140 + i * 15 );
		}
	}
	private void select(){
		if(currentChoice == 0){
			gsm.setState(GameStateManager.MENUSTATE);
		}
		
		if(currentChoice == 1){
			System.exit(0);
		}
	}
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER){
			select();
		}
		
		if(k == KeyEvent.VK_UP){
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = options.length -1;
			}
		}
		
		if(k == KeyEvent.VK_DOWN){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}

}