package com.nokia.mid.appl.boun;

import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public abstract class TileCanvas extends FullCanvas {
  protected int tileX;
  
  protected int tileY;
  
  protected int divTileX;
  
  protected int divisorLine;
  
  protected int v;
  
  protected boolean z;
  
  protected Image mGameBuffer;
  
  private Image[] tileImages;
  
  private Image tmpTileImage;
  
  private Graphics tmpTileImageG;
  
  public int mLevelNum = -1;
  
  public String levelTitle;
  
  public String levelCompletedText;
  
  public boolean mLoadLevelFlag;
  
  protected int mStartCol;
  
  protected int mStartRow;
  
  public int mStartBallSize;
  
  protected int mExitPosX;
  
  protected int mExitPosY;
  
  public short[][] tileMap;
  
  public int mTileMapWidth;
  
  public int mTileMapHeight;
  
  public int totalRingInLevel;
  
  public int mNumMoveObj;
  
  public short[][] mMOTopLeft;
  
  public short[][] mMOBotRight;
  
  public short[][] mMODirection;
  
  public short[][] mMOOffset;
  
  public Image[] mMOImgPtr;
  
  public Graphics[] mMOImgGraphics;
  
  public Image mSpikeImgPtr;
  
  public Image mUILife;
  
  public Image mUIRing;
  
  public int mTopLeftExitTileCol;
  
  public int mTopLeftExitTileRow;
  
  public Image mExitTileImage;
  
  public Image mImgPtr;
  
  public int mImageOffset;
  
  public boolean mOpenFlag;
  
  protected int mWidth = 0;
  
  protected int mHeight = 0;
  
  protected Display mDisplay;
  
  public com.nokia.mid.appl.boun.GameTimer mGameTimer = null;
  
  public TileCanvas(Display paramDisplay) {
    this.mDisplay = paramDisplay;
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    this.v = 0;
    this.divisorLine = 156;
    this.mGameBuffer = Image.createImage(156, 96);
    this.tmpTileImage = Image.createImage(12, 12);
    this.tmpTileImageG = this.tmpTileImage.getGraphics();
    loadTileImages();
    this.mLoadLevelFlag = false;
    this.tileX = 0;
    this.tileY = 0;
    this.z = false;
    this.divTileX = this.tileX + 13;
    this.tileMap = null;
  }
  
  public void ReadLevelMap(int paramInt) {
    InputStream inputStream = null;
    DataInputStream dataInputStream = null;
    this.mLoadLevelFlag = false;
    String str = "";
    String[] arrayOfString = new String[1];
    arrayOfString[0] = (new Integer(this.mLevelNum)).toString();
    this.levelTitle = com.nokia.mid.appl.boun.Local.getText(9, arrayOfString); // Level {}
    this.levelCompletedText = com.nokia.mid.appl.boun.Local.getText(10, arrayOfString); // Level {} completed!
    arrayOfString[0] = null;
    arrayOfString = null;
    if (paramInt < 10) {
      str = "00" + paramInt;
    } else if (paramInt < 100) {
      str = "0" + paramInt;
    } 
    try {
      inputStream = getClass().getResourceAsStream("/levels/J2MElvl." + str);
      dataInputStream = new DataInputStream(inputStream);
      this.mStartCol = dataInputStream.read();
      this.mStartRow = dataInputStream.read();
      int i = dataInputStream.read();
      if (i == 0) {
        this.mStartBallSize = 12;
      } else {
        this.mStartBallSize = 16;
      } 
      this.mExitPosX = dataInputStream.read();
      this.mExitPosY = dataInputStream.read();
      createExitTileObject(this.mExitPosX, this.mExitPosY, this.tileImages[12]);
      this.totalRingInLevel = dataInputStream.read();
      this.mTileMapWidth = dataInputStream.read();
      this.mTileMapHeight = dataInputStream.read();
      this.tileMap = new short[this.mTileMapHeight][this.mTileMapWidth];
      for (byte b1 = 0; b1 < this.mTileMapHeight; b1++) {
        for (byte b2 = 0; b2 < this.mTileMapWidth; b2++)
          this.tileMap[b1][b2] = (short)dataInputStream.read(); 
      } 
      this.mNumMoveObj = dataInputStream.read();
      if (this.mNumMoveObj != 0)
        createMovingObj(dataInputStream); 
      dataInputStream.close();
    } catch (IOException iOException) {}
  }
  
  public static Image manipulateImage(Image paramImage, int paramInt) {
    Image image = DirectUtils.createImage(paramImage.getWidth(), paramImage.getHeight(), 0);
    if (image == null)
      image = Image.createImage(paramImage.getWidth(), paramImage.getHeight()); 
    Graphics graphics = image.getGraphics();
    DirectGraphics directGraphics = DirectUtils.getDirectGraphics(graphics);
    switch (paramInt) {
      case 0:
        directGraphics.drawImage(paramImage, 0, 0, 20, 8192);
        return image;
      case 1:
        directGraphics.drawImage(paramImage, 0, 0, 20, 16384);
        return image;
      case 2:
        directGraphics.drawImage(paramImage, 0, 0, 20, 24576);
        return image;
      case 3:
        directGraphics.drawImage(paramImage, 0, 0, 20, 90);
        return image;
      case 4:
        directGraphics.drawImage(paramImage, 0, 0, 20, 180);
        return image;
      case 5:
        directGraphics.drawImage(paramImage, 0, 0, 20, 270);
        return image;
    } 
    graphics.drawImage(paramImage, 0, 0, 20);
    return image;
  }
  
  public void createMovingObj(DataInputStream paramDataInputStream) throws IOException {
    this.mMOTopLeft = new short[this.mNumMoveObj][2];
    this.mMOBotRight = new short[this.mNumMoveObj][2];
    this.mMODirection = new short[this.mNumMoveObj][2];
    this.mMOOffset = new short[this.mNumMoveObj][2];
    this.mMOImgPtr = new Image[this.mNumMoveObj];
    this.mMOImgGraphics = new Graphics[this.mNumMoveObj];
    for (byte b1 = 0; b1 < this.mNumMoveObj; b1++) {
      this.mMOTopLeft[b1][0] = (short)paramDataInputStream.read();
      this.mMOTopLeft[b1][1] = (short)paramDataInputStream.read();
      this.mMOBotRight[b1][0] = (short)paramDataInputStream.read();
      this.mMOBotRight[b1][1] = (short)paramDataInputStream.read();
      this.mMODirection[b1][0] = (short)paramDataInputStream.read();
      this.mMODirection[b1][1] = (short)paramDataInputStream.read();
      int i = paramDataInputStream.read();
      int j = paramDataInputStream.read();
      this.mMOOffset[b1][0] = (short)i;
      this.mMOOffset[b1][1] = (short)j;
    } 
    this.mSpikeImgPtr = Image.createImage(24, 24);
    Graphics graphics = this.mSpikeImgPtr.getGraphics();
    graphics.drawImage(this.tileImages[46], 0, 0, 20);
    graphics.drawImage(manipulateImage(this.tileImages[46], 0), 12, 0, 20);
    graphics.drawImage(manipulateImage(this.tileImages[46], 4), 12, 12, 20);
    graphics.drawImage(manipulateImage(this.tileImages[46], 1), 0, 12, 20);
    graphics = null;
  }
  
  public void disposeLevel() {
    for (byte b1 = 0; b1 < this.mNumMoveObj; b1++) {
      this.mMOImgPtr[b1] = null;
      this.mMOImgGraphics[b1] = null;
    } 
    this.mMOImgPtr = null;
    this.mMOImgGraphics = null;
    this.tileMap = null;
    Runtime.getRuntime().gc();
  }
  
  public void updateMovingSpikeObj() {
    for (byte b1 = 0; b1 < this.mNumMoveObj; b1++) {
      short s1 = this.mMOTopLeft[b1][0];
      short s2 = this.mMOTopLeft[b1][1];
      short s3 = this.mMOOffset[b1][0];
      short s4 = this.mMOOffset[b1][1];
      this.mMOOffset[b1][0] = (short)(this.mMOOffset[b1][0] + this.mMODirection[b1][0]);
      int n = (this.mMOBotRight[b1][0] - s1 - 2) * 12;
      int i1 = (this.mMOBotRight[b1][1] - s2 - 2) * 12;
      if (this.mMOOffset[b1][0] < 0) {
        this.mMOOffset[b1][0] = 0;
      } else if (this.mMOOffset[b1][0] > n) {
        this.mMOOffset[b1][0] = (short)n;
      } 
      if (this.mMOOffset[b1][0] == 0 || this.mMOOffset[b1][0] == n)
        this.mMODirection[b1][0] = (short)-this.mMODirection[b1][0]; 
      this.mMOOffset[b1][1] = (short)(this.mMOOffset[b1][1] + this.mMODirection[b1][1]);
      if (this.mMOOffset[b1][1] < 0) {
        this.mMOOffset[b1][1] = 0;
      } else if (this.mMOOffset[b1][1] > i1) {
        this.mMOOffset[b1][1] = (short)i1;
      } 
      if (this.mMOOffset[b1][1] == 0 || this.mMOOffset[b1][1] == i1)
        this.mMODirection[b1][1] = (short)(this.mMODirection[b1][1] * -1); 
      short s5 = this.mMOOffset[b1][0];
      short s6 = this.mMOOffset[b1][1];
      if (s5 < s3) {
        short s = s5;
        s5 = s3;
        s3 = s;
      } 
      if (s6 < s4) {
        short s = s6;
        s6 = s4;
        s4 = s;
      } 
      s5 += 23;
      s6 += 23;
      int i = s3 / 12;
      int j = s4 / 12;
      int k = s5 / 12 + 1;
      int m = s6 / 12 + 1;
      for (int i2 = i; i2 < k; i2++) {
        for (int i3 = j; i3 < m; i3++)
          this.tileMap[s2 + i3][s1 + i2] = (short)(this.tileMap[s2 + i3][s1 + i2] | 0x80); 
      } 
    } 
  }
  
  public int findSpikeIndex(int paramInt1, int paramInt2) {
    for (byte b1 = 0; b1 < this.mNumMoveObj; b1++) {
      if (this.mMOTopLeft[b1][0] <= paramInt1 && this.mMOBotRight[b1][0] > paramInt1 && this.mMOTopLeft[b1][1] <= paramInt2 && this.mMOBotRight[b1][1] > paramInt2)
        return b1; 
    } 
    return -1;
  }
  
  public void drawTile(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j;
    int k;
    Graphics graphics = this.mGameBuffer.getGraphics();
    if (paramInt1 < 0 || paramInt2 < 0 || paramInt1 >= this.mTileMapWidth || paramInt2 >= this.mTileMapHeight) {
      graphics.drawImage(this.tileImages[0], paramInt3, paramInt4, 20);
      return;
    } 
    this.tileMap[paramInt2][paramInt1] = (short)(this.tileMap[paramInt2][paramInt1] & 0xFF7F);
    int i = this.tileMap[paramInt2][paramInt1];
    boolean bool = ((i & 0x40) != 0) ? true : false;
    if (bool)
      i = i & 0xFFFFFFBF; 
    graphics.setColor(bool ? 1073328 : 11591920);
    switch (i) {
      case 1:
        graphics.drawImage(this.tileImages[0], paramInt3, paramInt4, 20);
        break;
      case 0:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        break;
      case 2:
        graphics.drawImage(this.tileImages[1], paramInt3, paramInt4, 20);
        break;
      case 3:
        if (bool) {
          graphics.drawImage(this.tileImages[6], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[2], paramInt3, paramInt4, 20);
        break;
      case 4:
        if (bool) {
          graphics.drawImage(this.tileImages[9], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[5], paramInt3, paramInt4, 20);
        break;
      case 5:
        if (bool) {
          graphics.drawImage(this.tileImages[7], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[3], paramInt3, paramInt4, 20);
        break;
      case 6:
        if (bool) {
          graphics.drawImage(this.tileImages[8], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[4], paramInt3, paramInt4, 20);
        break;
      case 7:
        graphics.drawImage(this.tileImages[10], paramInt3, paramInt4, 20);
        break;
      case 8:
        graphics.drawImage(this.tileImages[11], paramInt3, paramInt4, 20);
        break;
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[com.nokia.mid.appl.boun.BounceConst.a[i - 13]], paramInt3, paramInt4, 20);
        graphics.drawImage(this.tileImages[com.nokia.mid.appl.boun.BounceConst.b[i - 13]], paramInt3, paramInt4, 20);
        break;
      case 9:
        j = (paramInt1 - this.mTopLeftExitTileCol) * 12;
        k = (paramInt2 - this.mTopLeftExitTileRow) * 12;
        graphics.setClip(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.mExitTileImage, paramInt3 - j, paramInt4 - k, 20);
        graphics.setClip(0, 0, this.mGameBuffer.getWidth(), this.mGameBuffer.getHeight());
        this.z = true;
        break;
      case 10:
        j = findSpikeIndex(paramInt1, paramInt2);
        if (j != -1) {
          k = (paramInt1 - this.mMOTopLeft[j][0]) * 12;
          int m = (paramInt2 - this.mMOTopLeft[j][1]) * 12;
          int n = this.mMOOffset[j][0] - k;
          int i1 = this.mMOOffset[j][1] - m;
          if ((n > -36 && n < 12) || (i1 > -36 && i1 < 12)) {
            this.tmpTileImageG.setColor(11591920);
            this.tmpTileImageG.fillRect(0, 0, 12, 12);
            this.tmpTileImageG.drawImage(this.mSpikeImgPtr, n, i1, 20);
            graphics.drawImage(this.tmpTileImage, paramInt3, paramInt4, 20);
            break;
          } 
          graphics.setColor(11591920);
          graphics.fillRect(paramInt3, paramInt4, 12, 12);
        } 
        break;
      case 29:
        graphics.drawImage(this.tileImages[45], paramInt3, paramInt4, 20);
        break;
      case 30:
        if (bool) {
          graphics.drawImage(this.tileImages[61], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[57], paramInt3, paramInt4, 20);
        break;
      case 31:
        if (bool) {
          graphics.drawImage(this.tileImages[60], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[56], paramInt3, paramInt4, 20);
        break;
      case 32:
        if (bool) {
          graphics.drawImage(this.tileImages[59], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[55], paramInt3, paramInt4, 20);
        break;
      case 33:
        if (bool) {
          graphics.drawImage(this.tileImages[62], paramInt3, paramInt4, 20);
          break;
        } 
        graphics.drawImage(this.tileImages[58], paramInt3, paramInt4, 20);
        break;
      case 34:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[65], paramInt3, paramInt4, 20);
        break;
      case 35:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[64], paramInt3, paramInt4, 20);
        break;
      case 36:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[63], paramInt3, paramInt4, 20);
        break;
      case 37:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[66], paramInt3, paramInt4, 20);
        break;
      case 39:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[50], paramInt3, paramInt4, 20);
        break;
      case 40:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(manipulateImage(this.tileImages[50], 5), paramInt3, paramInt4, 20);
        break;
      case 41:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(manipulateImage(this.tileImages[50], 4), paramInt3, paramInt4, 20);
        break;
      case 42:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(manipulateImage(this.tileImages[50], 3), paramInt3, paramInt4, 20);
        break;
      case 43:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(this.tileImages[51], paramInt3, paramInt4, 20);
        break;
      case 44:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(manipulateImage(this.tileImages[51], 5), paramInt3, paramInt4, 20);
        break;
      case 45:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(manipulateImage(this.tileImages[51], 4), paramInt3, paramInt4, 20);
        break;
      case 46:
        graphics.fillRect(paramInt3, paramInt4, 12, 12);
        graphics.drawImage(manipulateImage(this.tileImages[51], 3), paramInt3, paramInt4, 20);
        break;
      case 47:
        graphics.drawImage(this.tileImages[52], paramInt3, paramInt4, 20);
        break;
      case 48:
        graphics.drawImage(manipulateImage(this.tileImages[52], 5), paramInt3, paramInt4, 20);
        break;
      case 49:
        graphics.drawImage(manipulateImage(this.tileImages[52], 4), paramInt3, paramInt4, 20);
        break;
      case 50:
        graphics.drawImage(manipulateImage(this.tileImages[52], 3), paramInt3, paramInt4, 20);
        break;
      case 38:
        graphics.drawImage(this.tileImages[53], paramInt3, paramInt4, 20);
        break;
      case 51:
        graphics.drawImage(this.tileImages[54], paramInt3, paramInt4, 20);
        break;
      case 52:
        graphics.drawImage(manipulateImage(this.tileImages[54], 5), paramInt3, paramInt4, 20);
        break;
      case 53:
        graphics.drawImage(manipulateImage(this.tileImages[54], 4), paramInt3, paramInt4, 20);
        break;
      case 54:
        graphics.drawImage(manipulateImage(this.tileImages[54], 3), paramInt3, paramInt4, 20);
        break;
    } 
  }
  
  public void a(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = (paramInt1 - paramInt3) / 12;
    int j = (paramInt2 - paramInt3) / 12;
    int k = (paramInt1 + paramInt3 - 1) / 12 + 1;
    int m = (paramInt2 + paramInt3 - 1) / 12 + 1;
    if (i < 0)
      i = 0; 
    if (j < 0)
      j = 0; 
    if (k > this.mTileMapWidth)
      k = this.mTileMapWidth; 
    if (m > this.mTileMapHeight)
      m = this.mTileMapHeight; 
    for (int n = i; n < k; n++) {
      for (int i1 = j; i1 < m; i1++) {
        int i2 = this.tileMap[i1][n] & 0xFFFFFFBF;
        if (i2 >= 13 && i2 <= 28) {
          int i3 = (n - this.tileX) * 12 + paramInt4;
          int i4 = (i1 - this.tileY) * 12;
          paramGraphics.drawImage(this.tileImages[com.nokia.mid.appl.boun.BounceConst.b[i2 - 13]], i3, i4, 20);
        } 
      } 
    } 
  }
  
  public void f() {
    for (byte b1 = 0; b1 < 13; b1++) {
      for (byte b2 = 0; b2 < 8; b2++)
        drawTile(this.tileX + b1, this.tileY + b2, b1 * 12, b2 * 12); 
    } 
  }
  
  public void i() {
    int i = this.tileX;
    int j = this.tileY;
    for (byte b1 = 0; b1 < 13; b1++) {
      if (b1 * 12 >= this.divisorLine && i >= this.tileX)
        i = this.divTileX - 13; 
      for (byte b2 = 0; b2 < 8; b2++) {
        if ((this.tileMap[j][i] & 0x80) != 0)
          drawTile(i, j, b1 * 12, b2 * 12); 
        j++;
      } 
      j = this.tileY;
      i++;
    } 
  }
  
  public void scrollBuffer(int paramInt) {
    int i = this.divTileX - 13;
    int j = this.divTileX;
    int k = paramInt - 64;
    if (k < 0) {
      k = 0;
    } else if (k > (this.mTileMapWidth + 1) * 12 - 156) {
      k = (this.mTileMapWidth + 1) * 12 - 156;
    } 
    while (k / 12 < i) {
      this.divisorLine -= 12;
      int m = this.divisorLine;
      this.divTileX--;
      j--;
      i--;
      if (this.divisorLine <= 0) {
        this.divisorLine = 156;
        this.tileX -= 13;
      } 
      for (byte b1 = 0; b1 < 8; b1++)
        drawTile(this.divTileX - 13, this.tileY + b1, m, b1 * 12); 
    } 
    while ((k + 128) / 12 >= j) {
      if (this.divisorLine >= 156) {
        this.divisorLine = 0;
        this.tileX += 13;
      } 
      int m = this.divisorLine;
      this.divisorLine += 12;
      this.divTileX++;
      j++;
      i++;
      for (byte b1 = 0; b1 < 8; b1++)
        drawTile(this.tileX + m / 12, this.tileY + b1, m, b1 * 12); 
    } 
    this.v = this.tileX * 12 - k;
  }
  
  public int m() {
    return this.tileX * 12 - this.v;
  }
  
  public int g() {
    return this.tileX * 12 - this.v + 128;
  }
  
  public Image a(Image paramImage) {
    Image image = DirectUtils.createImage(16, 16, 0);
    if (image == null)
      image = Image.createImage(16, 16); 
    Graphics graphics = image.getGraphics();
    DirectGraphics directGraphics = DirectUtils.getDirectGraphics(graphics);
    graphics.drawImage(paramImage, -4, -4, 20);
    directGraphics.drawImage(paramImage, 8, -4, 20, 8192);
    directGraphics.drawImage(paramImage, -4, 8, 20, 16384);
    directGraphics.drawImage(paramImage, 8, 8, 20, 180);
    return image;
  }
  
  public Image createExitImage(Image paramImage) {
    Image image = Image.createImage(24, 48);
    Graphics graphics = image.getGraphics();
    graphics.setColor(11591920);
    graphics.fillRect(0, 0, 24, 48);
    graphics.setColor(16555422);
    graphics.fillRect(4, 0, 16, 48);
    graphics.setColor(14891583);
    graphics.fillRect(6, 0, 10, 48);
    graphics.setColor(12747918);
    graphics.fillRect(10, 0, 4, 48);
    graphics.drawImage(paramImage, 0, 0, 20);
    graphics.drawImage(manipulateImage(paramImage, 0), 12, 0, 20);
    graphics.drawImage(manipulateImage(paramImage, 1), 0, 12, 20);
    graphics.drawImage(manipulateImage(paramImage, 2), 12, 12, 20);
    return image;
  }
  
  public void loadTileImages() {
    Image image = loadImage("/icons/objects_nm.png");
    this.tileImages = new Image[67];
    this.tileImages[0] = extractImage(image, 1, 0);
    this.tileImages[1] = extractImage(image, 1, 2);
    this.tileImages[2] = extractImageBG(image, 0, 3, -5185296);
    this.tileImages[3] = manipulateImage(this.tileImages[2], 1);
    this.tileImages[4] = manipulateImage(this.tileImages[2], 3);
    this.tileImages[5] = manipulateImage(this.tileImages[2], 5);
    this.tileImages[6] = extractImageBG(image, 0, 3, -15703888);
    this.tileImages[7] = manipulateImage(this.tileImages[6], 1);
    this.tileImages[8] = manipulateImage(this.tileImages[6], 3);
    this.tileImages[9] = manipulateImage(this.tileImages[6], 5);
    this.tileImages[10] = extractImage(image, 0, 4);
    this.tileImages[11] = extractImage(image, 3, 4);
    this.tileImages[12] = createExitImage(extractImage(image, 2, 3));
    this.tileImages[14] = extractImage(image, 0, 5);
    this.tileImages[13] = manipulateImage(this.tileImages[14], 1);
    this.tileImages[15] = manipulateImage(this.tileImages[13], 0);
    this.tileImages[16] = manipulateImage(this.tileImages[14], 0);
    this.tileImages[18] = extractImage(image, 1, 5);
    this.tileImages[17] = manipulateImage(this.tileImages[18], 1);
    this.tileImages[19] = manipulateImage(this.tileImages[17], 0);
    this.tileImages[20] = manipulateImage(this.tileImages[18], 0);
    this.tileImages[22] = extractImage(image, 2, 5);
    this.tileImages[21] = manipulateImage(this.tileImages[22], 1);
    this.tileImages[23] = manipulateImage(this.tileImages[21], 0);
    this.tileImages[24] = manipulateImage(this.tileImages[22], 0);
    this.tileImages[26] = extractImage(image, 3, 5);
    this.tileImages[25] = manipulateImage(this.tileImages[26], 1);
    this.tileImages[27] = manipulateImage(this.tileImages[25], 0);
    this.tileImages[28] = manipulateImage(this.tileImages[26], 0);
    this.tileImages[29] = manipulateImage(this.tileImages[14], 5);
    this.tileImages[30] = manipulateImage(this.tileImages[29], 1);
    this.tileImages[31] = manipulateImage(this.tileImages[29], 0);
    this.tileImages[32] = manipulateImage(this.tileImages[30], 0);
    this.tileImages[33] = manipulateImage(this.tileImages[18], 5);
    this.tileImages[34] = manipulateImage(this.tileImages[33], 1);
    this.tileImages[35] = manipulateImage(this.tileImages[33], 0);
    this.tileImages[36] = manipulateImage(this.tileImages[34], 0);
    this.tileImages[37] = manipulateImage(this.tileImages[22], 5);
    this.tileImages[38] = manipulateImage(this.tileImages[37], 1);
    this.tileImages[39] = manipulateImage(this.tileImages[37], 0);
    this.tileImages[40] = manipulateImage(this.tileImages[38], 0);
    this.tileImages[41] = manipulateImage(this.tileImages[26], 5);
    this.tileImages[42] = manipulateImage(this.tileImages[41], 1);
    this.tileImages[43] = manipulateImage(this.tileImages[41], 0);
    this.tileImages[44] = manipulateImage(this.tileImages[42], 0);
    this.tileImages[45] = extractImage(image, 3, 3);
    this.tileImages[46] = extractImage(image, 1, 3);
    this.tileImages[47] = extractImage(image, 2, 0);
    this.tileImages[48] = extractImage(image, 0, 1);
    this.tileImages[49] = a(extractImage(image, 3, 0));
    this.tileImages[50] = extractImage(image, 3, 1);
    this.tileImages[51] = extractImage(image, 2, 4);
    this.tileImages[52] = extractImage(image, 3, 2);
    this.tileImages[53] = extractImage(image, 1, 1);
    this.tileImages[54] = extractImage(image, 2, 2);
    this.tileImages[55] = extractImageBG(image, 0, 0, -5185296);
    this.tileImages[56] = manipulateImage(this.tileImages[55], 3);
    this.tileImages[57] = manipulateImage(this.tileImages[55], 4);
    this.tileImages[58] = manipulateImage(this.tileImages[55], 5);
    this.tileImages[59] = extractImageBG(image, 0, 0, -15703888);
    this.tileImages[60] = manipulateImage(this.tileImages[59], 3);
    this.tileImages[61] = manipulateImage(this.tileImages[59], 4);
    this.tileImages[62] = manipulateImage(this.tileImages[59], 5);
    this.tileImages[63] = extractImage(image, 0, 2);
    this.tileImages[64] = manipulateImage(this.tileImages[63], 3);
    this.tileImages[65] = manipulateImage(this.tileImages[63], 4);
    this.tileImages[66] = manipulateImage(this.tileImages[63], 5);
    this.mUILife = extractImage(image, 2, 1);
    this.mUIRing = extractImage(image, 1, 4);
  }
  
  public void setBallImages(Ball paramf) {
    paramf.smallBallImage = this.tileImages[47];
    paramf.poppedImage = this.tileImages[48];
    paramf.largeBallImage = this.tileImages[49];
  }
  
  public static Image extractImage(Image paramImage, int paramInt1, int paramInt2) {
    return extractImageBG(paramImage, paramInt1, paramInt2, 0);
  }
  
  public static Image extractImageBG(Image paramImage, int paramInt1, int paramInt2, int paramInt3) {
    Image image = DirectUtils.createImage(12, 12, paramInt3);
    if (image == null) {
      image = Image.createImage(12, 12);
      Graphics graphics1 = image.getGraphics();
      graphics1.setColor(paramInt3);
      graphics1.fillRect(0, 0, 12, 12);
    } 
    Graphics graphics = image.getGraphics();
    graphics.drawImage(paramImage, -paramInt1 * 12, -paramInt2 * 12, 20);
    return image;
  }
  
  public static Image loadImage(String paramString) {
    Image image = null;
    try {
      image = Image.createImage(paramString);
    } catch (IOException iOException) {}
    return image;
  }
  
  public void createExitTileObject(int paramInt1, int paramInt2, Image paramImage) {
    this.mTopLeftExitTileCol = paramInt1;
    this.mTopLeftExitTileRow = paramInt2;
    this.mImgPtr = paramImage;
    this.mExitTileImage = Image.createImage(24, 24);
    this.mImageOffset = 0;
    repaintExitTile();
    this.mOpenFlag = false;
  }
  
  public void repaintExitTile() {
    Graphics graphics = this.mExitTileImage.getGraphics();
    graphics.drawImage(this.mImgPtr, 0, 0 - this.mImageOffset, 20);
  }
  
  public void openExit() {
    this.mImageOffset += 4;
    if (this.mImageOffset >= 24) {
      this.mImageOffset = 24;
      this.mOpenFlag = true;
    } 
    repaintExitTile();
  }
  
  public abstract void run();
  
  public synchronized void start() {
    if (this.mGameTimer != null)
      return; 
    this.mGameTimer = new com.nokia.mid.appl.boun.GameTimer(this, this);
  }
  
  public synchronized void stop() {
    if (this.mGameTimer == null)
      return; 
    this.mGameTimer.stop();
    this.mGameTimer = null;
  }
  
  protected void timerTrigger() {
    run();
  }
}
