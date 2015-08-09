package fractals;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import geometry.Vector2D;

public class Julia extends Canvas {
  int size;
  double drawSize;
  Vector2D origin;
  double ReC;
  double ImC;

  public Julia(double ReC, int size) {
    this.size = size;
    this.drawSize = 4.0;
    this.ReC = ReC;
    setImC();
    this.origin = new Vector2D();
    this.addMouseListener(new JuliaMouse(this));
    this.setBackground(new Color(0,0,0));
    this.setSize(size, size);
    this.setVisible(true);
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(null);
    frame.setSize(size, size+25);
    frame.getContentPane().add(this);
    frame.show();

  }
  private void setImC() {
    boolean check = true;
    ImC =0.0;
    double ReZ;
    double ImZ;
    double tempR;
    while (check) {
      ImC += 0.01;
      ReZ = 0.0;
      ImZ = 0.0;
      tempR= 0.0;
      for (int k=0; k < 100; k++) {
        tempR = ReZ*ReZ - ImZ*ImZ + ReC;
        ImZ = 2*ReZ*ImZ + ImC;
        ReZ = tempR;
        if (Math.sqrt(ReZ*ReZ+ImZ*ImZ) > 2.0){
          check = false;
          break;
        }
      }
    }
  }

  public void paint(java.awt.Graphics g) {
    g.setColor(new java.awt.Color(225,225,225));
    double ReZ;
    double ImZ;
    double a;
    double b;
    double tempR;
    int col;
    for (int i=0; i < this.size; i++) {
      a = drawSize * ((double)i / this.size - 0.5) + origin.x;
      for (int j=0; j < this.size; j++) {
        b = drawSize * ((double)j / this.size - 0.5) + origin.y;
        ReZ = a;
        ImZ = b;
        tempR= 0.0;
        for (int k=0; k < 100; k++) {
          tempR = ReZ*ReZ - ImZ*ImZ + ReC;
          ImZ = 2*ReZ*ImZ + ImC;
          ReZ = tempR;
          if (Math.sqrt(ReZ*ReZ+ImZ*ImZ) > 2.0) break;
        }
        col = (int)(Math.sqrt(ReZ*ReZ+ImZ*ImZ) / 2.0 * 225.0);
        if (col > 225) col =225;
        g.setColor(new java.awt.Color(225-col,225-col,225-col));
        g.drawRect(i, j, 1, 1);
      }
    }
  }

  public static void main(String[] args) {
    Julia julia = new Julia(-0.6, 600);
  }
}
