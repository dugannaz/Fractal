package fractals;

import java.awt.event.*;

public class MandelbrotMouse extends MouseAdapter {
  Mandelbrot m;

  public MandelbrotMouse(Mandelbrot mandelbrot) {
    this.m = mandelbrot;
  }

  public void mouseClicked(MouseEvent e) {
    m.origin.x += ((double)e.getX() / (double)m.size - 0.5) * m.drawSize;
    m.origin.y += ((double)e.getY() / (double)m.size - 0.5) * m.drawSize;
    m.drawSize /= 4.0;
    m.repaint();
  }

}
