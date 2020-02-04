package untitled6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class untitled6 extends JFrame

{

    untitled6()
    {

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp1 = new JPanel();
        jp1.setVisible(true);
        jp1.setLayout(null);
        jp1.setSize(getSize());
        jp1.setLocation(getLocation());
        add(jp1);

        JLabel jl1 = new JLabel("");
        jl1.setLocation(10,10);
        jl1.setSize(60,20);
        jl1.setVisible(true);

        jp1.add(jl1);

        jp1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {


                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();
                int x = (int) b.getX();
                int y = (int) b.getY();

                jl1.setText(x+","+y);

                jl1.setLocation(x+5,y-35);
                //System.out.print(y + "jjjjjjjjj");
                //System.out.print(x);
               // Robot r = new Robot();
               // r.mouseMove(x, y - 50);

            }
        });



        setVisible(true);


    }

    public static void main(String [] args)
    {
       new untitled6();
    }

}
