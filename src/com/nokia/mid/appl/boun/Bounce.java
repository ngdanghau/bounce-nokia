package com.nokia.mid.appl.boun;

import com.nokia.mid.ui.DeviceControl;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Bounce extends MIDlet {
	private BounceUI mUI;
	
	public Bounce() {
		if (this.mUI == null){
		  this.mUI = new BounceUI(this); 
		}
	}
	
	protected void startApp() {
		DeviceControl.setLights(0, 100);
	}
	
	protected void pauseApp() {}
	
	public void destroyApp(boolean paramBoolean) {
		if (this.mUI != null && this.mUI.mCanvas != null) {
		  this.mUI.saveGameData(3);
		  this.mUI.mCanvas.stop();
		} 
		Display.getDisplay(this).setCurrent(null);
		this.mUI = null;
	}
}