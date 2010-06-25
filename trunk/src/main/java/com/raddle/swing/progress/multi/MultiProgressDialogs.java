package com.raddle.swing.progress.multi;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import com.raddle.swing.progress.Progress;

/**
 * 类MultiProgressDialogs.java的实现描述：多个滚动条
 *
 * @author xurong 2009-7-4 上午09:28:14
 */
public class MultiProgressDialogs extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private final static int labelHeigth    = 30;
    private final static int leftPad        = 35;
    private final static int rigthPad       = 50;
    private static int       progressHeigth = 50;
    private JDesktopPane     jDesktopPane;
    private int              progressCount;
    private List<Progress>   progressList   = new ArrayList<Progress>();

    public MultiProgressDialogs(Frame parent, int progressCount, boolean modal){
        super(parent, modal);
        this.progressCount = progressCount;
        initGUI();
    }

    public MultiProgressDialogs(Frame parent, int progressCount){
        super(parent);
        this.progressCount = progressCount;
        initGUI();
    }

    private void initGUI() {
        try {
            BorderLayout thisLayout = new BorderLayout();
            getContentPane().setLayout(thisLayout);
            {
                jDesktopPane = new JDesktopPane();
                getContentPane().add(jDesktopPane, BorderLayout.CENTER);
                for (int i = 0; i < progressCount; i++) {
                    JLabel jLabel = new JLabel();
                    jDesktopPane.add(jLabel, BorderLayout.CENTER);
                    jLabel.setFont(new java.awt.Font("黑体", 0, 16));
                    jLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    // /////////////
                    JProgressBar jProgressBar = new JProgressBar();
                    jProgressBar.setStringPainted(true);
                    jDesktopPane.add(jProgressBar, BorderLayout.NORTH);
                    // ///
                    progressList.add(new Progress(jLabel, jProgressBar));
                    //
                    jDesktopPane.addComponentListener(new ComponentAdapter() {

                        public void componentResized(ComponentEvent evt) {
                            resetSize();
                        }
                    });
                }
            }
            this.setSize(500 + leftPad, progressCount * 60 + rigthPad);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetSize() {
        progressHeigth = (int) ((this.getHeight() - rigthPad - progressCount * labelHeigth) / progressCount);
        for (int i = 0; i < progressCount; i++) {
            Progress p = progressList.get(i);
            p.getLabel().setBounds(10, i * (labelHeigth + progressHeigth), this.getWidth() - leftPad, labelHeigth);
            p.getProgressBar().setBounds(10, i * (labelHeigth + progressHeigth) + labelHeigth, this.getWidth() - leftPad, progressHeigth);
        }
    }

    public List<Progress> getProgressList() {
        return progressList;
    }

}
