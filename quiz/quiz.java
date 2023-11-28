

package quiz;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class quiz extends JFrame {

  private Animator animator;
  private GLCanvas glcanvas;
  private quizfile listener = new quizfile();

  public static void main(String[] args) {
    new quiz().animator.start();
  }

  public quiz() {
    super("quiz");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    animator = new FPSAnimator(5);
    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
    animator = new Animator(glcanvas);

    add(glcanvas, BorderLayout.CENTER);
    setSize(700, 700);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}