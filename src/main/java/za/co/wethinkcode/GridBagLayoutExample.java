package za.co.wethinkcode;

import java.awt.*;
import javax.swing.*;  
public class GridBagLayoutExample extends JFrame{ 
	 
    public static void main(String[] args) {  
            GridBagLayoutExample a = new GridBagLayoutExample();  
        }  
        public GridBagLayoutExample() {  
			GridBagLayout GridBagLayoutgrid = new GridBagLayout();
				GridBagConstraints gbc = new GridBagConstraints();  

				setTitle("Swingy");  
				GridBagLayout layout = new GridBagLayout();  
				this.setLayout(layout);  
				gbc.fill = GridBagConstraints.HORIZONTAL;    
				gbc.fill = GridBagConstraints.HORIZONTAL;  
				gbc.ipady = 20;  
				gbc.gridx = 0;  
				gbc.gridy = 1;  
				this.add(new Button("Create a new Hero"), gbc);  
				gbc.gridx = 1;  
				gbc.gridy = 1;  
				this.add(new Button("Select an Existing Hero"), gbc);  
				gbc.gridx = 0;  
				gbc.gridy = 2;  
				gbc.fill = GridBagConstraints.HORIZONTAL;  
				gbc.gridwidth = 2;  
				this.add(new Button("Close"), gbc);  
					setSize(300, 300);  
					setPreferredSize(getSize());  
					setVisible(true);  
					setDefaultCloseOperation(EXIT_ON_CLOSE);  
      
        }  
      
} 