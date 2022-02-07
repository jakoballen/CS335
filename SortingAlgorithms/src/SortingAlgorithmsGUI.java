import java.util.Arrays;

/**
 * Class SortingAlgorithmsGUI - GUI that accepts user
 * input and displays it sorting and the sorted output
 *
 * @author Jakob Allen
 */
public class SortingAlgorithmsGUI extends javax.swing.JFrame {

    /**
     * Creates new form SortingAlgorithmsGUI
     */
    public SortingAlgorithmsGUI() {
        initComponents();
    }

    /**
     * Add the supplied string to the jTextArea
     * @param s string to be appended
     */
    public static void appendTextField(String s) {
        display.setText(display.getText() + s);
    }


    /**
     * Initialize the contents of the GUI window
     */
    private void initComponents() {

        saLabel = new javax.swing.JLabel();
        inputPrompt = new javax.swing.JLabel();
        algorithmSelection = new javax.swing.JComboBox<>();
        userInput = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 750));

        saLabel.setText("Sorting Algorithm:");

        inputPrompt.setText("Numbers to be sorted:");

        algorithmSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Merge Sort", "Bubble Sort"}));

        userInput.setToolTipText("List of integers delimited by a space");

        display.setEditable(false);

        submitButton.setText("Go");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(inputPrompt)
                                                        .addComponent(saLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(userInput)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(algorithmSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(saLabel)
                                        .addComponent(algorithmSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(inputPrompt)
                                        .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submitButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    /**
     * React to submit button
     * @param evt event that occurred
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        display.setText("");
        int[] ints = parseInput(userInput.getText());
        if(algorithmSelection.getSelectedIndex() == 0){
            ms.mergeSort(ints);
        }else {
            bs.bubbleSort(ints);
        }
        appendTextField("\n\tOrdered: " + Arrays.toString(ints));
    }


    /**
     * Parse the user's input from the GUI window
     * @param s user input from jTextField
     * @return int array of user input
     */
    private int[] parseInput(String s){
        String[] intStrings = s.split(" ");
        int[] ints = new int[intStrings.length];
        for(int i = 0; i<intStrings.length; i++){
            ints[i] = Integer.parseInt(intStrings[i]);
        }
        return ints;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortingAlgorithmsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton submitButton;                       //button to start sorting
    private javax.swing.JComboBox<String> algorithmSelection;       //box to select which algorithm
    private javax.swing.JLabel saLabel;                             //label for algorithm selection box
    private javax.swing.JLabel inputPrompt;                         //tell user what to put in the text box
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea display;                   //display sorting
    private javax.swing.JTextField userInput;                       //take in user input
    private MergeSort ms = new MergeSort();                         //object that sorts using merge sort
    private BubbleSort bs = new BubbleSort();                       //object to sort bubble sort
    // End of variables declaration



}
