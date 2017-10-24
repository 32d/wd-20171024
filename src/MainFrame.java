import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JDesktopPane Jdp = new JDesktopPane();
    private JInternalFrame JIFloto = new JInternalFrame("lotto");
    private JPanel JPnum = new JPanel(new GridLayout(1,6,5,5));
    private JPanel JPre = new JPanel(new GridLayout(1,2,3,3));
    private JButton JBclose = new JButton("close");
    private JButton JBre = new JButton("Re");


    public MainFrame(LoginFrame Login){
        login = Login ;
        init();
    }
    private void init(){
    this.setBounds(scrW/2-w/2,scrH/2-h/2,w,h);
    this.setJMenuBar(Jmb);
    Jmb.add(Jmu);
    Jmb.add(Jloto);
    Jmu.add(Jexit);
    Jloto.add(Jlotto);
    JIFloto.setLayout(new BorderLayout(3,3));
    JPnum.add(JBclose);
    JPnum.add(JBre);
    JIFloto.add(JPnum);
    JIFloto.add(JPre);

    Jexit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    Jexit.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));





    }
}
