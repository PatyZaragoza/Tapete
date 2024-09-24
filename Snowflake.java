import javax.swing.*;
import java.awt.*;
/**
 * @author Patricia Zaragoza Palma
 */
public class Snowflake extends JPanel {
    double sin60 = Math.sin(Math.PI / 3);  // ángulo de 60 grados
    int nivelDeRecursividad = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double xp1 = 400, yp1 = 100;
        double xp2 = 100, yp2 = 600;
        double xp3 = 700, yp3 = 600;

        paintRecursivo(g, nivelDeRecursividad, xp1, yp1, xp2, yp2);  
        paintRecursivo(g, nivelDeRecursividad, xp2, yp2, xp3, yp3);  
        paintRecursivo(g, nivelDeRecursividad, xp3, yp3, xp1, yp1);  
    }

    private void paintRecursivo(Graphics g, int nivel, double xp1, double yp1, double xp2, double yp2) {
        if (nivel <= 0) {
            g.drawLine((int) xp1, (int) yp1, (int) xp2, (int) yp2); // Dibuja una línea si se ha alcanzado el nivel base
        } else {
            double dx = (xp2 - xp1) / 3;
            double dy = (yp2 - yp1) / 3;
            double x1 = xp1 + dx;
            double y1 = yp1 + dy;
            double x2 = xp1 + 2 * dx;
            double y2 = yp1 + 2 * dy;
            double xPeak = x1 + dx / 2 - dy * sin60;
            double yPeak = y1 + dy / 2 + dx * sin60;

            paintRecursivo(g, nivel - 1, xp1, yp1, x1, y1);
            paintRecursivo(g, nivel - 1, x1, y1, xPeak, yPeak);
            paintRecursivo(g, nivel - 1, xPeak, yPeak, x2, y2);
            paintRecursivo(g, nivel - 1, x2, y2, xp2, yp2);
        }
    }

    // Método principal para iniciar la ventana con la curva de Koch
    public static void main(String[] args) {
        JFrame frame = new JFrame("Copo de Nieve de Koch");
        Snowflake panel = new Snowflake();
        frame.add(panel);
        frame.setSize(800, 800);  // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
