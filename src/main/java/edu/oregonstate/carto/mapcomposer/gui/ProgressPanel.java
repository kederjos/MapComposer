/*
 * ProgressPanel.java
 *
 * Created on August 15, 2006, 12:18 PM
 */
package edu.oregonstate.carto.mapcomposer.gui;

import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * ProgressPanel displays a progress dialog for lengthy operations.
 * 
 * @author Bernhard Jenny, Institute of Cartography, ETH Zurich.
 */
public class ProgressPanel extends javax.swing.JPanel {

    /**
     * Dialogs created to show the progress information will have this name. This
     * can be used to identify progress dialogs using getName().
     */
    public static final String DIALOG_NAME = ProgressPanel.class.toString();

    /**
     * Creates new form ProgressPanel.
     * Must be called from the Swing Event Dispatch Thread!
     */
    public ProgressPanel(String message, ActionListener cancelActionListener) {
        this.initComponents();
        cancelButton.addActionListener(cancelActionListener);
        this.cancelButton.registerKeyboardAction(cancelActionListener, "EscapeKey",
                KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE,
                0, true), JComponent.WHEN_IN_FOCUSED_WINDOW);
        this.setMessage(message);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        messageLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        cancelButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.GridBagLayout());

        messageLabel.setText("Working. Please wait…");
        messageLabel.setMinimumSize(new java.awt.Dimension(350, 45));
        messageLabel.setPreferredSize(new java.awt.Dimension(350, 45));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        add(messageLabel, gridBagConstraints);

        progressBar.setPreferredSize(new java.awt.Dimension(250, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(progressBar, gridBagConstraints);

        cancelButton.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(cancelButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * start action. Setup the dialog and remember the current time.
     */
    public void start() {
        progressBar.setValue(0);
        cancelButton.setEnabled(true);
        progressBar.setIndeterminate(false);
    }

    public void updateProgressGUI(final int percentage) {
        progressBar.setIndeterminate(false);
        progressBar.setValue(percentage);
    }

    public void disableCancel() {
        cancelButton.setEnabled(false);
    }

    public void enableCancel() {
        cancelButton.setEnabled(true);
    }

    public void setMessage(final String msg) {
        messageLabel.setText(msg);
    }

    public void setIndeterminate(boolean indeterminate) {
        progressBar.setIndeterminate(indeterminate);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
