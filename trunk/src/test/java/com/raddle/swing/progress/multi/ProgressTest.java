package com.raddle.swing.progress.multi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.raddle.swing.progress.FrameUtils;
import com.raddle.swing.progress.Progress;
import com.raddle.swing.progress.ProgressContext;
import com.raddle.swing.progress.ProgressUtils;
import com.raddle.swing.progress.single.ProgressCallback;

public class ProgressTest extends javax.swing.JFrame {

    {
        // Set Look & Feel
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final long serialVersionUID = 1L;
    private JDesktopPane jDesktopPane1;
    private JButton jButton1;
    private JButton jButton2;

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ProgressTest inst = new ProgressTest();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public ProgressTest(){
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                jDesktopPane1 = new JDesktopPane();
                getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
                {
                    jButton1 = new JButton();
                    jDesktopPane1.add(jButton1);
                    jButton1.setText("\u591a\u8fdb\u5ea6\u6761");
                    jButton1.setBounds(17, 12, 106, 23);
                    jButton1.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            ProgressUtils.doInMultiProgress(FrameUtils.getFrame((JComponent) evt.getSource()), "测试多进度条", 3, 2000, new MultiProgressCallback() {

                                @Override
                                public void doWithMultiProgress(ProgressContext context) {
                                    doProgress(context, 0);
                                    JOptionPane.showMessageDialog(context.getDialog(), "操作完成");
                                }

                                private void doProgress(ProgressContext context, int i) {
                                    context.getProgress(i).setDescription("测试进度条" + (i + 1));
                                    context.getProgress(i).setMaximum(1);
                                    context.getProgress(i).setMaximum(5);
                                    context.getProgress(i).setValue(0);
                                    for (int j = 0; j < 5; j++) {
                                        if (i == context.getProgressCount() - 1) {
                                            try {
                                                Thread.sleep(50);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        } else {
                                            doProgress(context, i + 1);
                                        }
                                        context.getProgress(i).setValue(j + 1);
                                    }
                                }
                            });
                        }
                    });
                }
                {
                    jButton2 = new JButton();
                    jDesktopPane1.add(jButton2);
                    jButton2.setText("\u5355\u8fdb\u5ea6\u6761");
                    jButton2.setBounds(17, 46, 106, 23);
                    jButton2.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            ProgressUtils.doInProgress(FrameUtils.getFrame((JComponent) evt.getSource()), "测试单度条", 200, new ProgressCallback() {

                                @Override
                                public void doWithProgress(JDialog dialog, Progress progress) {
                                    progress.setDescription("测试进度条");
                                    progress.setMaximum(1);
                                    progress.setMaximum(5);
                                    progress.setValue(0);
                                    for (int j = 0; j < 5; j++) {
                                        try {
                                            Thread.sleep(200);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        progress.setValue(j + 1);
                                    }
                                }
                            });
                        }
                    });
                }
            }
            pack();
            setSize(400, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
