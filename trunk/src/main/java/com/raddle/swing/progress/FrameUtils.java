package com.raddle.swing.progress;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.JComponent;

public class FrameUtils {

    /**
     * 获得某个组件所在的frame
     *
     * @param component
     * @return
     */
    public static Frame getFrame(JComponent component) {
        Container frame = component.getParent();
        while (frame != null) {
            if (frame instanceof Frame) {
                return (Frame) frame;
            } else {
                frame = frame.getParent();
            }
        }
        return null;
    }
}
