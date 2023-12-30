package com.nokia.mid.appl.boun;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.rms.RecordStore;

public class BounceUI implements CommandListener {
  public Bounce mIDlet;
  
  public Display mDisplay; // man hinh hien tai 
  
  public BounceCanvas mCanvas;
  
  public int mState = 2;
  
  public int unlockedLevel;
  
  public int highScore;
  
  public boolean mNewBestScore;
  
  public int mLastScore;
  
  public byte mSavedValid = 0;
  
  public byte mSavedLives;
  
  public byte mSavedRings;
  
  public byte mSavedLevel;
  
  public byte mSavedSize;
  
  public int mSavedScore;
  
  public int mSavedTileX;
  
  public int mSavedTileY;
  
  public int mSavedXSpeed;
  
  public int mSavedYSpeed;
  
  public int mSavedGlobalBallX;
  
  public int mSavedGlobalBallY;
  
  public int mSavedRespawnX;
  
  public int mSavedRespawnY;
  
  public int mSavedSpeedBonus;
  
  public int mSavedGravBonus;
  
  public int mSavedJumpBonus;
  
  public int mSavedTileCount;
  
  public int[][] mSavedTiles;
  
  public int mSavedSpikeCount;
  
  public short[][] mSavedSpikeOffset;
  
  public short[][] mSavedSpikeDirection;
  
  public long o;
  
  private Command mOkayCmd;
  
  private Command mBackCmd;
  
  private Command EXIT;
  
  private Command OK;
  
  private List mMainMenu;
  
  private List mNewGameMenu;
  
  private Form mTextPage;
  
  private int mSavedMenuItem;
  
  private String[] mMainMenuItems = new String[4];
  
  public BounceUI(Bounce paramBounce) {
    this.mIDlet = paramBounce;
    ReadRMS();
    this.mCanvas = new BounceCanvas(this, 1);
    this.mCanvas.start();
    this.mDisplay = Display.getDisplay(this.mIDlet);
    this.mDisplay.setCurrent((Displayable)this.mCanvas);
    e();
  }
  
  public synchronized void e() {
    this.mMainMenuItems[0] = Local.getText(4); // Continue
    this.mMainMenuItems[1] = Local.getText(11); // New Game
    this.mMainMenuItems[2] = Local.getText(7);// High Score
    this.mMainMenuItems[3] = Local.getText(8); // Instructions
  }
  
  public synchronized void displayMainMenu() {
	
    this.mMainMenu = new List(Local.getText(0), 3); // 0 = Bounce
    if (this.mBackCmd == null) {
      this.mBackCmd = new Command(Local.getText(2), 2, 1); // 2 = Back
      this.EXIT = new Command(Local.getText(5), 7, 1); // 5 = Exit
    } 
    if (this.mState == 1 || this.mSavedValid == 1 || this.mSavedValid == 2)
      this.mMainMenu.append(this.mMainMenuItems[0], null); 
    for (byte b = 1; b < this.mMainMenuItems.length; b++)
      this.mMainMenu.append(this.mMainMenuItems[b], null); 
    this.mMainMenu.addCommand(this.EXIT);
    this.mMainMenu.setCommandListener(this);
    if (this.mCanvas.mSplashIndex != -1) {
      this.mCanvas.mSplashIndex = -1;
      this.mCanvas.mSplashImage = null;
    } 
    if (this.mState == 1 || this.mSavedValid == 1 || this.mSavedValid == 2) {
      this.mMainMenu.setSelectedIndex(0, true);
    } else {
      this.mMainMenu.setSelectedIndex(this.mSavedMenuItem, true);
    } 
    this.mCanvas.stop();
    this.mDisplay.setCurrent((Displayable)this.mMainMenu);
  }
  
  // su kien khi nhan vao new game
  public void displayNewGameMenu() {
    String[] arrayOfString1 = new String[this.unlockedLevel];  // arrayOfString1 = danh sach level da hoan thanh, unlockedLevel la level đã vượt qua 
    String[] arrayOfString2 = new String[1];
    for (byte b = 0; b < this.unlockedLevel; b++) {
      arrayOfString2[0] = String.valueOf(b + 1);
      arrayOfString1[b] = Local.getText(9, arrayOfString2);
    } 
    this.mNewGameMenu = new List(Local.getText(11), 3, arrayOfString1, null); // 11 = New game
    this.mNewGameMenu.addCommand(this.mBackCmd);
    this.mNewGameMenu.setCommandListener(this);
    this.mDisplay.setCurrent((Displayable)this.mNewGameMenu);
  }
  
  public void displayGame(boolean paramBoolean, int paramInt) {
    if (paramBoolean) {
      this.mNewBestScore = false;
      this.mCanvas.a(paramInt, 0, 3);
    } 
    this.mCanvas.start();
    this.mCanvas.mBall.resetDirections();
    this.mDisplay.setCurrent((Displayable)this.mCanvas);
    this.mState = 1;
  }
  
  // su kien khi click vao high score
  public void displayHighScore() {
    this.mTextPage = new Form(Local.getText(7)); // 7 = High score
    this.mTextPage.append(String.valueOf(this.highScore));
    this.mTextPage.addCommand(this.mBackCmd);
    this.mTextPage.setCommandListener(this);
    this.mDisplay.setCurrent((Displayable)this.mTextPage);
  }
  
  // su kien khi nhan vao Instructions
  public void displayInstructions() {
    this.mTextPage = new Form(Local.getText(8)); // 8 = Instructions
    String[] arrayOfString = { 
    		this.mCanvas.getKeyName(this.mCanvas.getKeyCode(2)), // 2 = LEFT
    		this.mCanvas.getKeyName(this.mCanvas.getKeyCode(5)),  // 5 = RIGHT
    		this.mCanvas.getKeyName(this.mCanvas.getKeyCode(1)) // 1 = UP
    };
    this.mTextPage.append(Local.getText(1, arrayOfString));
    this.mTextPage.addCommand(this.mBackCmd);
    this.mTextPage.setCommandListener(this);
    this.mDisplay.setCurrent((Displayable)this.mTextPage);
    this.mTextPage = null;
  }
  
  public void displayGameOver(boolean paramBoolean) {
    this.mCanvas.stop();
    if (this.mOkayCmd == null)
      this.mOkayCmd = new Command(Local.getText(13), 4, 1);  // 13 = OK
    this.mTextPage = new Form(Local.getText(6)); // 6 = Game over
    if (paramBoolean) {
      this.mTextPage.append(Local.getText(3)); // 3 = Congrats!
    } else {
      this.mTextPage.append(Local.getText(6)); // 6 = Game over
    } 
    this.mTextPage.append("\n\n");
    if (this.mNewBestScore) {
      this.mTextPage.append(Local.getText(12)); // 12 = New high score!
      this.mTextPage.append("\n\n");
    } 
    this.mTextPage.append(String.valueOf(this.mLastScore));
    this.mTextPage.addCommand(this.mOkayCmd);
    this.mTextPage.setCommandListener(this);
    this.mDisplay.setCurrent((Displayable)this.mTextPage);
    this.mTextPage = null;
  }
  
  // su kiem continue khi end 1 level
  public void displayLevelComplete() {
    this.mCanvas.stop();
    displayGame(false, 0);
    this.mState = 5;
    if (this.OK == null)
      this.OK = new Command(Local.getText(4), 4, 1); // 4 = Continue
    this.mTextPage = new Form("");
    this.mTextPage.append(this.mCanvas.levelCompletedText);
    this.mTextPage.append("\n\n");
    this.mTextPage.append("" + this.mLastScore + "\n");
    this.mTextPage.addCommand(this.OK);
    this.mTextPage.setCommandListener(this);
    this.mDisplay.setCurrent((Displayable)this.mTextPage);
    this.mTextPage = null;
  }
  
  public void commandAction(Command paramCommand, Displayable paramDisplayable) {
    if (paramCommand == List.SELECT_COMMAND) {
    	// nếu màn hình là màn chọn level
      if (paramDisplayable == this.mNewGameMenu) {
        displayGame(true, this.mNewGameMenu.getSelectedIndex() + 1);
      } else {
        String str = this.mMainMenu.getString(this.mMainMenu.getSelectedIndex());
        this.mSavedMenuItem = this.mMainMenu.getSelectedIndex();
        if (str.equals(this.mMainMenuItems[0])) {
          if (this.mState == 1) {
            displayGame(false, this.mCanvas.mLevelNum);
          } else if (this.mSavedValid != 0) {
            this.mDisplay.setCurrent((Displayable)this.mCanvas);
            if (this.mSavedValid == 1) {
              this.mCanvas.a(this.mSavedGlobalBallX, this.mSavedGlobalBallY);
            } else {
              this.mCanvas.tileNotSavedAsActive(this.mSavedLevel, this.mSavedScore, this.mSavedLives);
            } 
            this.mSavedTiles = null;
            this.mCanvas.start();
            this.mState = 1;
          } 
        } else if (str.equals(this.mMainMenuItems[1])) {
          if (this.mState != 4)
            if (this.unlockedLevel > 1) {
              displayNewGameMenu();
            } else {
              this.mState = 4;
              displayGame(true, 1);
            }  
        } else if (str.equals(this.mMainMenuItems[2])) {
          displayHighScore();
        } else if (str.equals(this.mMainMenuItems[3])) {
          displayInstructions();
        } else if (str.equals("Read RMS")) {
        	ReadRMS();
        } else if (str.equals("Write RMS")) {
        	saveGameData(1);
        	saveGameData(2);
        	saveGameData(3);
        } 
      } 
    } else if (paramCommand == this.mBackCmd || paramCommand == this.EXIT || paramCommand == this.mOkayCmd) {
      if (this.mDisplay.getCurrent() == this.mMainMenu) {
        this.mIDlet.destroyApp(true);
        this.mIDlet.notifyDestroyed();
      } else {
    	  displayMainMenu();
      } 
    } else if (paramCommand == this.OK) {
      this.mState = 1;
      this.mDisplay.setCurrent((Displayable)this.mCanvas);
    } 
  }
  
  public void ReadRMS() {
    byte[] arrayOfByte1 = new byte[1];
    byte[] arrayOfByte2 = new byte[4];
    byte[] arrayOfByte3 = new byte[255];
    Object object = null;
    try {
      RecordStore recordStore = RecordStore.openRecordStore("bounceRMS", true);
      if (recordStore.getNumRecords() != 3) {
        recordStore.addRecord(arrayOfByte1, 0, arrayOfByte1.length);
        recordStore.addRecord(arrayOfByte2, 0, arrayOfByte2.length);
        recordStore.addRecord(arrayOfByte3, 0, arrayOfByte3.length);
      } else {
        arrayOfByte1 = recordStore.getRecord(1);
        arrayOfByte2 = recordStore.getRecord(2);
        arrayOfByte3 = recordStore.getRecord(3);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte1);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        this.unlockedLevel = dataInputStream.readByte();
        byteArrayInputStream = new ByteArrayInputStream(arrayOfByte2);
        dataInputStream = new DataInputStream(byteArrayInputStream);
        this.highScore = dataInputStream.readInt();
        byteArrayInputStream = new ByteArrayInputStream(arrayOfByte3);
        dataInputStream = new DataInputStream(byteArrayInputStream);
        this.o = dataInputStream.readLong();
        this.mSavedValid = dataInputStream.readByte();
        this.mSavedLives = dataInputStream.readByte();
        this.mSavedRings = dataInputStream.readByte();
        this.mSavedLevel = dataInputStream.readByte();
        this.mSavedSize = dataInputStream.readByte();
        this.mSavedScore = dataInputStream.readInt();
        this.mSavedTileX = dataInputStream.readInt();
        this.mSavedTileY = dataInputStream.readInt();
        this.mSavedGlobalBallX = dataInputStream.readInt();
        this.mSavedGlobalBallY = dataInputStream.readInt();
        this.mSavedXSpeed = dataInputStream.readInt();
        this.mSavedYSpeed = dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        this.mSavedRespawnX = dataInputStream.readInt();
        this.mSavedRespawnY = dataInputStream.readInt();
        this.mSavedSpeedBonus = dataInputStream.readInt();
        this.mSavedGravBonus = dataInputStream.readInt();
        this.mSavedJumpBonus = dataInputStream.readInt();
        this.mSavedTileCount = dataInputStream.readByte();
        this.mSavedTiles = new int[this.mSavedTileCount][3];
        for (byte b1 = 0; b1 < this.mSavedTileCount; b1++) {
          this.mSavedTiles[b1][0] = dataInputStream.readShort();
          this.mSavedTiles[b1][1] = dataInputStream.readShort();
          this.mSavedTiles[b1][2] = dataInputStream.readByte();
        } 
        this.mSavedSpikeCount = dataInputStream.readByte();
        this.mSavedSpikeOffset = new short[this.mSavedSpikeCount][2];
        this.mSavedSpikeDirection = new short[this.mSavedSpikeCount][2];
        for (byte b2 = 0; b2 < this.mSavedSpikeCount; b2++) {
          this.mSavedSpikeOffset[b2][0] = dataInputStream.readShort();
          this.mSavedSpikeOffset[b2][1] = dataInputStream.readShort();
          this.mSavedSpikeDirection[b2][0] = dataInputStream.readShort();
          this.mSavedSpikeDirection[b2][1] = dataInputStream.readShort();
        } 
        if (dataInputStream.readLong() != -559038737L)
          this.mSavedValid = 0; 
      } 
      recordStore.closeRecordStore();
    } catch (Exception exception) {
      this.mSavedValid = 0;
    } 
  }
  
  // Ghi data vao Record Management System (RSM)
  public void saveGameData(int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    Object object = null;
    try {
      byte b1;
      int[][] arrayOfInt;
      byte b2;
      byte b3;
      byte b4;
      byte b5;
      switch (paramInt) {
        case 1:
          dataOutputStream.writeByte(this.unlockedLevel);
          break;
        case 2:
          dataOutputStream.writeInt(this.highScore);
          break;
        case 3:
          if (this.mCanvas == null || this.mCanvas.mBall == null)
            return; 
          b1 = 0;
          if (this.mState == 1) {
            b1 = 1;
          } else if (this.mState == 5) {
            b1 = 2;
          } 
          dataOutputStream.writeLong(System.currentTimeMillis());
          dataOutputStream.writeByte(b1);
          dataOutputStream.writeByte(this.mCanvas.numLives);
          dataOutputStream.writeByte(this.mCanvas.numRings);
          dataOutputStream.writeByte(this.mCanvas.mLevelNum);
          dataOutputStream.writeByte(this.mCanvas.mBall.mBallSize);
          dataOutputStream.writeInt(this.mCanvas.mScore);
          dataOutputStream.writeInt(this.mCanvas.l);
          dataOutputStream.writeInt(this.mCanvas.k);
          dataOutputStream.writeInt(this.mCanvas.mBall.xPos);
          dataOutputStream.writeInt(this.mCanvas.mBall.yPos);
          dataOutputStream.writeInt(this.mCanvas.mBall.xSpeed);
          dataOutputStream.writeInt(this.mCanvas.mBall.ySpeed);
          dataOutputStream.writeInt(0);
          dataOutputStream.writeInt(0);
          dataOutputStream.writeInt(this.mCanvas.mBall.respawnX);
          dataOutputStream.writeInt(this.mCanvas.mBall.respawnY);
          dataOutputStream.writeInt(this.mCanvas.mBall.speedBonusCntr);
          dataOutputStream.writeInt(this.mCanvas.mBall.gravBonusCntr);
          dataOutputStream.writeInt(this.mCanvas.mBall.jumpBonusCntr);
          arrayOfInt = new int[50][3];
          b2 = 0;
          for (b3 = 0; b3 < this.mCanvas.mTileMapHeight; b3++) {
            for (byte b = 0; b < this.mCanvas.mTileMapWidth; b++) {
              byte b6 = (byte)(this.mCanvas.tileMap[b3][b] & 0xFF7F & 0xFFFFFFBF);
              if (b6 == 7 || b6 == 29 || b6 == 13 || b6 == 14 || b6 == 21 || b6 == 22 || b6 == 15 || b6 == 16 || b6 == 23 || b6 == 24) {
                arrayOfInt[b2][0] = b3;
                arrayOfInt[b2][1] = b;
                arrayOfInt[b2][2] = b6;
                b2++;
              } 
            } 
          } 
          dataOutputStream.writeByte(b2);
          for (b4 = 0; b4 < b2; b4++) {
            dataOutputStream.writeShort(arrayOfInt[b4][0]);
            dataOutputStream.writeShort(arrayOfInt[b4][1]);
            dataOutputStream.writeByte(arrayOfInt[b4][2]);
          } 
          arrayOfInt = null;
          dataOutputStream.writeByte(this.mCanvas.mNumMoveObj);
          for (b5 = 0; b5 < this.mCanvas.mNumMoveObj; b5++) {
            dataOutputStream.writeShort(this.mCanvas.mMOOffset[b5][0]);
            dataOutputStream.writeShort(this.mCanvas.mMOOffset[b5][1]);
            dataOutputStream.writeShort(this.mCanvas.mMODirection[b5][0]);
            dataOutputStream.writeShort(this.mCanvas.mMODirection[b5][1]);
          } 
          dataOutputStream.writeLong(-559038737L);
          break;
      } 
      RecordStore recordStore = RecordStore.openRecordStore("bounceRMS", true);
      recordStore.setRecord(paramInt, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
      recordStore.closeRecordStore();
    } catch (Exception exception) {}
  }
  
  public void checkData() {
    if (this.mCanvas.mLevelNum > this.unlockedLevel) {
      this.unlockedLevel = Math.min(this.mCanvas.mLevelNum, 11); // 11 là level tối đa mà game có
      saveGameData(1);
    } 
    if (this.mCanvas.mScore > this.highScore) {
      this.highScore = this.mCanvas.mScore;
      this.mNewBestScore = true;
      saveGameData(2);
    } 
    this.mLastScore = this.mCanvas.mScore;
  }
  
  public void gameOver(boolean paramBoolean) {
    this.mState = 3;
    this.mSavedValid = 0;
    this.mCanvas.mIncomingCall = false;
    displayGameOver(paramBoolean);
  }
}
