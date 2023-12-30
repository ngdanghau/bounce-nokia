package com.nokia.mid.appl.boun;

import com.nokia.mid.ui.DeviceControl;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Bounce extends MIDlet {
	private Game game;
	
	public Bounce() {
		if (this.game == null){
		  this.game = new Game(this); 
		}
	}
	
	protected void startApp() {
		DeviceControl.setLights(0, 100);
	}
	
	protected void pauseApp() {}
	
	public void destroyApp(boolean paramBoolean) {
		if (this.game != null && this.game.mainScene != null) {
		  this.game.WriteRSM(3);
		  this.game.mainScene.j();
		} 
		Display.getDisplay(this).setCurrent(null);
		this.game = null;
	}
}