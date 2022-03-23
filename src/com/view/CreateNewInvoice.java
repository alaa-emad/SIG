package com.view;

import javax.swing.*;

public class CreateNewInvoice extends JDialog {

    public CreateNewInvoice(InvoiceGeneratorUI frame) {
            okButton = new JButton("OK");
            okButton.setActionCommand("createOK");
            okButton.addActionListener(frame);

            cancelButton = new JButton("Cancel");
            cancelButton.setActionCommand("createCancel");
            cancelButton.addActionListener(frame);

            newItemButton = new JButton("Add new Item");
            newItemButton.setActionCommand("addNewItem");
            newItemButton.addActionListener(frame);

            dateDialouge = new JTextField();
            customerNameDialouge = new JTextField();
            itemNameDialouge = new JTextField();
            itemPriceDialouge = new JTextField();
            countDialouge = new JTextField();
            jLabel1 = new JLabel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jLabel4 = new JLabel();
            jLabel5 = new JLabel();

            jLabel1.setText("Date: ");
            jLabel2.setText("Customer Name: ");

            jLabel3.setText("Item Name: ");
            jLabel4.setText("Item price: ");
            jLabel5.setText("Number of Items:");

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(newItemButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(20,20,20)
                                                    .addComponent(cancelButton,GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(23, 23, 23)
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jLabel1)
                                                            .addComponent(jLabel2,GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLabel5,GroupLayout.Alignment.TRAILING))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(countDialouge)
                                                            .addComponent(itemPriceDialouge)
                                                            .addComponent(itemNameDialouge)
                                                            .addComponent(customerNameDialouge)
                                                            .addComponent(dateDialouge, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(30, 30, 30))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(dateDialouge, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(customerNameDialouge,GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(itemNameDialouge, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(itemPriceDialouge, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(countDialouge, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(okButton)
                                            .addComponent(newItemButton))
                                            .addGap(18,18,18)
                                            .addComponent(cancelButton)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            getRootPane().setDefaultButton(okButton);
            pack();

    }



    // Variables declaration - do not modify
    private JButton cancelButton;
    private JButton okButton;
    private JButton newItemButton;
    public JTextField countDialouge;
    private JTextField customerNameDialouge;
    private JTextField dateDialouge;
    public JTextField itemNameDialouge;
    public JTextField itemPriceDialouge;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;

    // End of variables declaration

    public JTextField getCustomerName() {
        return customerNameDialouge;
    }

    public JTextField getInvoiceDate() {
        return dateDialouge;
    }

    public JTextField getItemName() {
        return itemNameDialouge;
    }

    public JTextField getItemCount() {
        return countDialouge;
    }

    public JTextField getItemPrice() {
        return itemPriceDialouge;
    }
}
