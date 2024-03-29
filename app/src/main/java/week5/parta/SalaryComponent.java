package week5.parta;

public class SalaryComponent {

// this class is used for storing the information of a salary component
String component_name; // name of the salary component
int amount;         // amount earned for this component

        // Constructor
        public SalaryComponent(String component_name, int amount) throws RuntimeException {
            // check that the parameters are valid
            if (component_name == null || component_name.equals("") || amount < 0 || amount > 10000)
                throw new RuntimeException("Illegal inputs for Salary Component");

            // store the salary component name and the amount earned
            this.component_name = component_name;
            this.amount = amount;
        }

        // method to get the name of the salary component
        public String getComponentName() { return component_name; }

        // method to get the amount earned for the salary component
        public int getComponentAmount() { return amount; }
    }
