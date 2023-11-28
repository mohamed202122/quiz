package quiz;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

public class quizfile implements GLEventListener {

    GL gl;
    // 0 --> up , 1 ==> down , 2 ==> left, 3 ==> right 
    static int direction = 0;
    static int direX = 200, direY = 300;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(0, 700, 0, 700, -1.0, 1.0);

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        gl = glAutoDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        drawFlag();
        drawBall();
        updataBall();

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    private void drawFlag() {

        // white 
        gl.glColor3f(1, 1, 1);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(0, 450);
        gl.glVertex2d(700, 450);
        gl.glVertex2d(700, 250);
        gl.glVertex2d(0, 250);
        gl.glEnd();

        // green
        gl.glColor3f(0, 0.8f, 0);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(0, 0);
        gl.glVertex2d(700, 0);
        gl.glVertex2d(700, 250);
        gl.glVertex2d(0, 250);
        gl.glEnd();

        // red
        gl.glColor3f(1, 0, 0);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2d(0, 700);
        gl.glVertex2d(200, 350);
        gl.glVertex2d(0, 0);
        gl.glEnd();
    }

    private void drawBall() {
        int ballRadius = 50;
        gl.glColor3f(1, 0, 0.5f);
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0; a < Math.toRadians(360); a += Math.toRadians(1)) {
            double x = direX + ballRadius * (Math.cos(a));
            double y = direY + ballRadius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }

    private void updataBall() {
        switch (direction) {
            case 0: // up-right
                direX++;
                direY++;
                break;
            case 1: // up-left
                direX--;
                direY++;
                break;
            case 2: // down-right
                direX++;
                direY--;
                break;
            case 3: // down-left
                direX--;
                direY--;
                break;
        }
        
        
        if (direction == 0 && (direX > 700 || direY > 700))
            direction = 2;
        else if (direction == 2 && (direX > 700 || direY < 0))
            direction = 3;
        else if (direction == 3 && (direX < 0 || direY < 0))
            direction = 1;
        else if (direction == 1 && (direX < 0 || direY > 700))
            direction = 0;
    }

}
