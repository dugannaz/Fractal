package fractals;

import java.awt.event.*;

public class JuliaMouse extends MouseAdapter {
  Julia j;

  public JuliaMouse(Julia julia) {
    this.j = julia;
  }

  public void mouseClicked(MouseEvent e) {
    j.origin.x += ((double)e.getX() / (double)j.size - 0.5) * j.drawSize;
    j.origin.y += ((double)e.getY() / (double)j.size - 0.5) * j.drawSize;
    j.drawSize /= 4.0;
    j.repaint();
  }

}
