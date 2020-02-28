package untitled6;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.util.List;

public class untitled6 extends JFrame

{

    untitled6()
    {

        setSize(500,300);
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



       JList jli1 = new JList<String>(new DefaultListModel<String>());


        jli1.setBackground(Color.GRAY);
        jli1.setSelectedIndex(0);
        jli1.setSelectionMode(0);
        jli1.setLocation(10,10);
        jli1.setSize(400,200);
        jli1.setVisible(true);

        jli1.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) evt
                            .getTransferable().getTransferData(
                                    DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        /*
                         * NOTE:
                         *  When I change this to a println,
                         *  it prints the correct path
                         */
                        //jl1.setText(file.getAbsolutePath());

                        ((DefaultListModel)jli1.getModel()).addElement(file.getAbsolutePath());
                        //jli1.add
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jp1.add(jli1);



        JTextArea myPanel = new JTextArea();
        myPanel.setVisible(false);
myPanel.setSize(400,100);
myPanel.setLocation(20,20);





        myPanel.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>) evt
                            .getTransferable().getTransferData(
                                    DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        /*
                         * NOTE:
                         *  When I change this to a println,
                         *  it prints the correct path
                         */
                        myPanel.setText(file.getAbsolutePath());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        jp1.add(myPanel);

        /*
        jp1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {


                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();
                int x = (int) b.getX();
                int y = (int) b.getY();

                jl1.setText(x+","+y);

                jl1.setLocation(x+5,y-35);


            }
        });
         */




        setVisible(true);


    }

    public static void main(String [] args)
    {
       new untitled6();
    }

}
