import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    LoginFrame login = new LoginFrame();
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int w =800;
    private int h =600;
    private JMenuBar Jmb = new JMenuBar();
    private JMenu Jmu = new JMenu("File");
    private JMenu Jloto = new JMenu("Lotto");
    private JMenuItem Jexit = new JMenuItem("Exit");
    private JMenuItem Jlotto = new JMenuItem("Lotto");
    private Random rdm = new Random(System.currentTimeMillis());
    private JDesktopPane Jdp = new JDesktopPane();
    private JInternalFrame JIFloto = new JInternalFrame("lotto");
    private JPanel JPnum = new JPanel(new GridLayout(1,6,5,5));
    private JPanel JPre = new JPanel(new GridLayout(1,2,3,3));
    private JButton JBclose = new JButton("close");
    private JButton JBre = new JButton("Re");
    private JLabel Jlab[] = new JLabel[6];
    private int JLableNum[] = new int[6];
    private  JInternalFrame Jinkey = new JInternalFrame("inkey");



    public MainFrame(LoginFrame Login){
        login = Login ;
        init();
    }
    private void init() {
        this.setBounds(scrW / 2 - w / 2, scrH / 2 - h / 2, w, h);
        this.setJMenuBar(Jmb);
        this.setContentPane(Jdp);
        JIFloto.setBounds(100,100,600,200);
        Jmb.add(Jmu);
        Jmb.add(Jloto);
        Jmu.add(Jexit);
        Jdp.add(JIFloto);
        Jloto.add(Jlotto);
        JIFloto.setLayout(new BorderLayout(3, 3));
        JPre.add(JBclose);
        JPre.add(JBre);
        Jdp.add(Jinkey);
        Jinkey.setLayout(new BorderLayout(3, 3));
        JIFloto.add(JPnum, BorderLayout.CENTER);
        JIFloto.add(JPre, BorderLayout.SOUTH);
        regenerate();

        for(int i =0;i<6;i++) {
         Jlab[i] = new JLabel();
         JPnum.add(Jlab[i]);
         Jlab[i].setText(Integer.toString(JLableNum[i]));
        }



        Jexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        Jexit.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        Jlotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JIFloto.setVisible(true);
            }
        });




    }

    private void regenerate() {
        boolean check;
        for (int i = 0; i < 6; i++) {
            check = true;
            while (check) {
                check = false;
                int tmp = rdm.nextInt(49) + 1;
                for (int j = 0; j < i; j++) {
                    if (JLableNum[j] == tmp) {
                        check = true;
                    }
                }
                JLableNum[i] = tmp;
            }
        }
    }


}

