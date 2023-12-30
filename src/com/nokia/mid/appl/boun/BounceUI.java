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
  
  public Display m; // man hinh hien tai 
  
  public MainScene mCanvas;
  
  public int K = 2;
  
  public int unlockedLevel;
  
  public int highScore;
  
  public boolean isNewHighScore;
  
  public int sessionScore;
  
  public byte J = 0;
  
  public byte C;
  
  public byte t;
  
  public byte B;
  
  public byte A;
  
  public int G;
  
  public int I;
  
  public int H;
  
  public int a;
  
  public int g;
  
  public int y;
  
  public int M;
  
  public int e;
  
  public int b;
  
  public int w;
  
  public int z;
  
  public int n;
  
  public int p;
  
  public int[][] u;
  
  public int r;
  
  public short[][] D;
  
  public short[][] l;
  
  public long o;
  
  private Command iOK;
  
  private Command BACK;
  
  private Command EXIT;
  
  private Command OK;
  
  private List mainMenu;
  
  private List F;
  
  private Form displayForm;
  
  private int N;
  
  private String[] menu = new String[4];
  
  public BounceUI(Bounce paramBounce) {
    this.mIDlet = paramBounce;
    ReadRMS();
    this.mCanvas = new MainScene(this, 1);
    this.mCanvas.d();
    this.m = Display.getDisplay(this.mIDlet);
    this.m.setCurrent((Displayable)this.mCanvas);
    e();
  }
  
  public synchronized void e() {
    this.menu[0] = com.nokia.mid.appl.boun.c.a(4); // Continue
    this.menu[1] = com.nokia.mid.appl.boun.c.a(11); // New Game
    this.menu[2] = com.nokia.mid.appl.boun.c.a(7);// High Score
    this.menu[3] = com.nokia.mid.appl.boun.c.a(8); // Instructions
  }
  
  public synchronized void Home() {
	
    this.mainMenu = new List(com.nokia.mid.appl.boun.c.a(0), 3); // 0 = Bounce
    if (this.BACK == null) {
      this.BACK = new Command(com.nokia.mid.appl.boun.c.a(2), 2, 1); // 2 = Back
      this.EXIT = new Command(com.nokia.mid.appl.boun.c.a(5), 7, 1); // 5 = Exit
    } 
    if (this.K == 1 || this.J == 1 || this.J == 2)
      this.mainMenu.append(this.menu[0], null); 
    for (byte b = 1; b < this.menu.length; b++)
      this.mainMenu.append(this.menu[b], null); 
    this.mainMenu.addCommand(this.EXIT);
    this.mainMenu.setCommandListener(this);
    if (this.mCanvas.ap != -1) {
      this.mCanvas.ap = -1;
      this.mCanvas.t = null;
    } 
    if (this.K == 1 || this.J == 1 || this.J == 2) {
      this.mainMenu.setSelectedIndex(0, true);
    } else {
      this.mainMenu.setSelectedIndex(this.N, true);
    } 
    this.mCanvas.stop();
    this.m.setCurrent((Displayable)this.mainMenu);
  }
  
  // su kien khi nhan vao new game
  public void g() {
    String[] arrayOfString1 = new String[this.unlockedLevel];  // arrayOfString1 = danh sach level da hoan thanh, unlockedLevel la level đã vượt qua 
    String[] arrayOfString2 = new String[1];
    for (byte b = 0; b < this.unlockedLevel; b++) {
      arrayOfString2[0] = String.valueOf(b + 1);
      arrayOfString1[b] = com.nokia.mid.appl.boun.c.a(9, arrayOfString2);
    } 
    this.F = new List(com.nokia.mid.appl.boun.c.a(11), 3, arrayOfString1, null); // 11 = New game
    this.F.addCommand(this.BACK);
    this.F.setCommandListener(this);
    // F la List Control
    this.m.setCurrent((Displayable)this.F);
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    if (paramBoolean) {
      this.isNewHighScore = false;
      this.mCanvas.a(paramInt, 0, 3);
    } 
    this.mCanvas.d();
    this.mCanvas.player.a();
    this.m.setCurrent((Displayable)this.mCanvas);
    this.K = 1;
  }
  
  // su kien khi click vao high score
  // h la diem so
  public void c() {
    this.displayForm = new Form(com.nokia.mid.appl.boun.c.a(7)); // 7 = High score
    this.displayForm.append(String.valueOf(this.highScore));
    this.displayForm.addCommand(this.BACK);
    this.displayForm.setCommandListener(this);
    this.m.setCurrent((Displayable)this.displayForm);
  }
  
  // su kien khi nhan vao Instructions
  public void b() {
    this.displayForm = new Form(com.nokia.mid.appl.boun.c.a(8)); // 8 = Instructions
    String[] arrayOfString = { 
    		this.mCanvas.getKeyName(this.mCanvas.getKeyCode(2)), // 2 = LEFT
    		this.mCanvas.getKeyName(this.mCanvas.getKeyCode(5)),  // 5 = RIGHT
    		this.mCanvas.getKeyName(this.mCanvas.getKeyCode(1)) // 1 = UP
    };
    this.displayForm.append(com.nokia.mid.appl.boun.c.a(1, arrayOfString));
    this.displayForm.addCommand(this.BACK);
    this.displayForm.setCommandListener(this);
    this.m.setCurrent((Displayable)this.displayForm);
    this.displayForm = null;
  }
  
  public void a(boolean paramBoolean) {
    this.mCanvas.stop();
    if (this.iOK == null)
      this.iOK = new Command(com.nokia.mid.appl.boun.c.a(13), 4, 1);  // 13 = OK
    this.displayForm = new Form(com.nokia.mid.appl.boun.c.a(6)); // 6 = Game over
    if (paramBoolean) {
      this.displayForm.append(com.nokia.mid.appl.boun.c.a(3)); // 3 = Congrats!
    } else {
      this.displayForm.append(com.nokia.mid.appl.boun.c.a(6)); // 6 = Game over
    } 
    this.displayForm.append("\n\n");
    if (this.isNewHighScore) {
      this.displayForm.append(com.nokia.mid.appl.boun.c.a(12)); // 12 = New high score!
      this.displayForm.append("\n\n");
    } 
    this.displayForm.append(String.valueOf(this.sessionScore));
    this.displayForm.addCommand(this.iOK);
    this.displayForm.setCommandListener(this);
    this.m.setCurrent((Displayable)this.displayForm);
    this.displayForm = null;
  }
  
  // su kiem continue khi end 1 level
  public void d() {
    this.mCanvas.stop();
    a(false, 0);
    this.K = 5;
    if (this.OK == null)
      this.OK = new Command(com.nokia.mid.appl.boun.c.a(4), 4, 1); // 4 = Continue
    this.displayForm = new Form("");
    this.displayForm.append(this.mCanvas.levelCompletedText);
    this.displayForm.append("\n\n");
    this.displayForm.append("" + this.sessionScore + "\n");
    this.displayForm.addCommand(this.OK);
    this.displayForm.setCommandListener(this);
    this.m.setCurrent((Displayable)this.displayForm);
    this.displayForm = null;
  }
  
  public void commandAction(Command paramCommand, Displayable paramDisplayable) {
    if (paramCommand == List.SELECT_COMMAND) {
    	// nếu màn hình là màn chọn level
      if (paramDisplayable == this.F) {
        a(true, this.F.getSelectedIndex() + 1);
      } else {
        String str = this.mainMenu.getString(this.mainMenu.getSelectedIndex());
        this.N = this.mainMenu.getSelectedIndex();
        if (str.equals(this.menu[0])) {
          if (this.K == 1) {
            a(false, this.mCanvas.currentLevel);
          } else if (this.J != 0) {
            this.m.setCurrent((Displayable)this.mCanvas);
            if (this.J == 1) {
              this.mCanvas.a(this.y, this.M);
            } else {
              this.mCanvas.a(this.B, this.G, this.C);
            } 
            this.u = null;
            this.mCanvas.d();
            this.K = 1;
          } 
        } else if (str.equals(this.menu[1])) {
          if (this.K != 4)
            if (this.unlockedLevel > 1) {
              g();
            } else {
              this.K = 4;
              a(true, 1);
            }  
        } else if (str.equals(this.menu[2])) {
          c();
        } else if (str.equals(this.menu[3])) {
          b();
        } else if (str.equals("Read RMS")) {
        	ReadRMS();
        } else if (str.equals("Write RMS")) {
        	saveGameData(1);
        	saveGameData(2);
        	saveGameData(3);
        } 
      } 
    } else if (paramCommand == this.BACK || paramCommand == this.EXIT || paramCommand == this.iOK) {
      if (this.m.getCurrent() == this.mainMenu) {
        this.mIDlet.destroyApp(true);
        this.mIDlet.notifyDestroyed();
      } else {
    	  Home();
      } 
    } else if (paramCommand == this.OK) {
      this.K = 1;
      this.m.setCurrent((Displayable)this.mCanvas);
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
        this.J = dataInputStream.readByte();
        this.C = dataInputStream.readByte();
        this.t = dataInputStream.readByte();
        this.B = dataInputStream.readByte();
        this.A = dataInputStream.readByte();
        this.G = dataInputStream.readInt();
        this.I = dataInputStream.readInt();
        this.H = dataInputStream.readInt();
        this.y = dataInputStream.readInt();
        this.M = dataInputStream.readInt();
        this.a = dataInputStream.readInt();
        this.g = dataInputStream.readInt();
        dataInputStream.readInt();
        dataInputStream.readInt();
        this.e = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.w = dataInputStream.readInt();
        this.z = dataInputStream.readInt();
        this.n = dataInputStream.readInt();
        this.p = dataInputStream.readByte();
        this.u = new int[this.p][3];
        for (byte b1 = 0; b1 < this.p; b1++) {
          this.u[b1][0] = dataInputStream.readShort();
          this.u[b1][1] = dataInputStream.readShort();
          this.u[b1][2] = dataInputStream.readByte();
        } 
        this.r = dataInputStream.readByte();
        this.D = new short[this.r][2];
        this.l = new short[this.r][2];
        for (byte b2 = 0; b2 < this.r; b2++) {
          this.D[b2][0] = dataInputStream.readShort();
          this.D[b2][1] = dataInputStream.readShort();
          this.l[b2][0] = dataInputStream.readShort();
          this.l[b2][1] = dataInputStream.readShort();
        } 
        if (dataInputStream.readLong() != -559038737L)
          this.J = 0; 
      } 
      recordStore.closeRecordStore();
    } catch (Exception exception) {
      this.J = 0;
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
          if (this.mCanvas == null || this.mCanvas.player == null)
            return; 
          b1 = 0;
          if (this.K == 1) {
            b1 = 1;
          } else if (this.K == 5) {
            b1 = 2;
          } 
          dataOutputStream.writeLong(System.currentTimeMillis());
          dataOutputStream.writeByte(b1);
          dataOutputStream.writeByte(this.mCanvas.noOfLife);
          dataOutputStream.writeByte(this.mCanvas.noOfRingCollected);
          dataOutputStream.writeByte(this.mCanvas.currentLevel);
          dataOutputStream.writeByte(this.mCanvas.player.a);
          dataOutputStream.writeInt(this.mCanvas.sessionScore);
          dataOutputStream.writeInt(this.mCanvas.l);
          dataOutputStream.writeInt(this.mCanvas.k);
          dataOutputStream.writeInt(this.mCanvas.player.s);
          dataOutputStream.writeInt(this.mCanvas.player.r);
          dataOutputStream.writeInt(this.mCanvas.player.l);
          dataOutputStream.writeInt(this.mCanvas.player.o);
          dataOutputStream.writeInt(0);
          dataOutputStream.writeInt(0);
          dataOutputStream.writeInt(this.mCanvas.player.d);
          dataOutputStream.writeInt(this.mCanvas.player.c);
          dataOutputStream.writeInt(this.mCanvas.player.h);
          dataOutputStream.writeInt(this.mCanvas.player.g);
          dataOutputStream.writeInt(this.mCanvas.player.y);
          arrayOfInt = new int[50][3];
          b2 = 0;
          for (b3 = 0; b3 < this.mCanvas.height; b3++) {
            for (byte b = 0; b < this.mCanvas.width; b++) {
              byte b6 = (byte)(this.mCanvas.map[b3][b] & 0xFF7F & 0xFFFFFFBF);
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
          dataOutputStream.writeByte(this.mCanvas.B);
          for (b5 = 0; b5 < this.mCanvas.B; b5++) {
            dataOutputStream.writeShort(this.mCanvas.w[b5][0]);
            dataOutputStream.writeShort(this.mCanvas.w[b5][1]);
            dataOutputStream.writeShort(this.mCanvas.ae[b5][0]);
            dataOutputStream.writeShort(this.mCanvas.ae[b5][1]);
          } 
          dataOutputStream.writeLong(-559038737L);
          break;
      } 
      RecordStore recordStore = RecordStore.openRecordStore("bounceRMS", true);
      recordStore.setRecord(paramInt, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
      recordStore.closeRecordStore();
    } catch (Exception exception) {}
  }
  
  public void CompletedLevel() {
    if (this.mCanvas.currentLevel > this.unlockedLevel) {
      this.unlockedLevel = Math.min(this.mCanvas.currentLevel, 11); // 11 là level tối đa mà game có
      saveGameData(1);
    } 
    if (this.mCanvas.sessionScore > this.highScore) {
      this.highScore = this.mCanvas.sessionScore;
      this.isNewHighScore = true;
      saveGameData(2);
    } 
    this.sessionScore = this.mCanvas.sessionScore;
  }
  
  public void b(boolean paramBoolean) {
    this.K = 3;
    this.J = 0;
    this.mCanvas.isPlaying = false;
    a(paramBoolean);
  }
}


/* Location:              D:\Java Mobile\nokiabounc_jdifc8jb.jar!\com\nokia\mid\appl\boun\a.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */