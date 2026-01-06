import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    // variable to keep track of current index in the list
    // --- TO DO: why is this static? ---
    private static int currentIndex = 0;

    public static void main(String[] args) throws Exception {
        // create a list of top 5 things
        // --- TO DO: Change to your own list ---
        String[] top5 = {
            "1. money",
            "2. Music",
            "3. food",
            "4. friends/family",
            "5. Travel"
        };

         // A JFrame is a window where we can design our UI
        JFrame frame = new JFrame("My Top 5 List");
        frame.setSize(500, 500);
        frame.setLayout(null);

        // create a Button and a Label
        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back"); // --- TO DO: create a back button, format, and add it to the frame ---
        JLabel outputLabel = new JLabel();

        // place and size for components
        // setBounds(x position, y position, width, height)
        nextButton.setBounds(250, 200, 100, 50);
        backButton.setBounds(50, 200, 100, 50); // position the back button
        outputLabel.setBounds(100,100,300,50);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        outputLabel.setForeground(Color.BLUE);

        // the output label will display the first item in the list initially
        outputLabel.setText( top5[currentIndex] );

        // add components to JFrame f
        frame.add(outputLabel);
        frame.add(nextButton);
        frame.add(backButton); // add back button to the frame

        // add event listener for button click
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = getNextIndex(currentIndex, top5.length);
                outputLabel.setText(top5[currentIndex]);
            }
        });

        // --- TO DO: add event listener for back button ---
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = getPreviousIndex(currentIndex, top5.length);
                outputLabel.setText(top5[currentIndex]);
            }
        });

        // make the frame visible
        frame.setVisible(true);
    }

    /**
     *  find the next index in the list
     * @param currentIndex
     * @param listLength
     * @return next index
     */
    public static int getNextIndex(int currentIndex, int listLength) {
        if (currentIndex == listLength - 1) {
            return 0; // wrap around to the start
        }
        else {
            return currentIndex + 1; // move to the next index
        }
    }

    // --- TO DO: create a getPreviousIndex function ---
    /**
     *  find the previous index in the list
     * @param currentIndex
     * @param listLength
     * @return previous index
     */
    public static int getPreviousIndex(int currentIndex, int listLength) {
        if (currentIndex == 0) {
            return listLength - 1; // wrap around to the end
        } else {
            return currentIndex - 1; // move to the previous index
        }
    }
}
