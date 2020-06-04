package org.arpit.java2blog;

class Main {
    public static void main(String[] args) {

        class CommissionEmployee {
            private final String firstName;
            private final String lastName;
            private final String socialSecurityNumber;
            private double grossSales; // gross weekly sales
            private double commissionRate; // commission percentage

            // five-argument constructor
            public CommissionEmployee(String firstName, String lastName,
                                      String socialSecurityNumber, double grossSales,
                                      double commissionRate) {
                // implicit call to Object constructor occurs here

                // if grossSales is invalid throw exception
                if (grossSales < 0.0)
                    throw new IllegalArgumentException(
                            "Gross sales must be >= 0.0");

                // if commissionRate is invalid throw exception
                if (commissionRate <= 0.0 || commissionRate >= 1.0)
                    throw new IllegalArgumentException(
                            "Commission rate must be > 0.0 and < 1.0");

                this.firstName = firstName;
                this.lastName = lastName;
                this.socialSecurityNumber = socialSecurityNumber;
                this.grossSales = grossSales;
                this.commissionRate = commissionRate;
            } // end constructor

            // return first name
            public String getFirstName() {
                return firstName;
            }

            // return last name
            public String getLastName() {
                return lastName;
            }

            // return social security number
            public String getSocialSecurityNumber() {
                return socialSecurityNumber;
            }

            // set gross sales amount
            public void setGrossSales(double grossSales) {
                if (grossSales < 0.0)
                    throw new IllegalArgumentException(
                            "Gross sales must be >= 0.0");

                this.grossSales = grossSales;
            }

            // return gross sales amount
            public double getGrossSales() {
                return grossSales;
            }

            // set commission rate
            public void setCommissionRate(double commissionRate) {
                if (commissionRate <= 0.0 || commissionRate >= 1.0)
                    throw new IllegalArgumentException(
                            "Commission rate must be > 0.0 and < 1.0");

                this.commissionRate = commissionRate;
            }

            // return commission rate
            public double getCommissionRate() {
                return commissionRate;
            }

            // calculate earnings
            public double earnings() {
                return getCommissionRate() * getGrossSales();
            }

            // return String representation of CommissionEmployee object
            @Override
            public String toString() {
                return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                        "commission employee", getFirstName(), getLastName(),
                        "social security number", getSocialSecurityNumber(),
                        "gross sales", getGrossSales(),
                        "commission rate", getCommissionRate());
            }
        } // end class CommissionEmployee


        class BasePlusCommissionEmployee extends CommissionEmployee {
            private double baseSalary; // base salary per week

            // six-argument constructor
            public BasePlusCommissionEmployee(String firstName, String lastName,
                                              String socialSecurityNumber, double grossSales,
                                              double commissionRate, double baseSalary) {
                super(firstName, lastName, socialSecurityNumber,
                        grossSales, commissionRate);

                // if baseSalary is invalid throw exception
                if (baseSalary < 0.0)
                    throw new IllegalArgumentException(
                            "Base salary must be >= 0.0");

                this.baseSalary = baseSalary;
            }

            // set base salary
            public void setBaseSalary(double baseSalary) {
                if (baseSalary < 0.0)
                    throw new IllegalArgumentException(
                            "Base salary must be >= 0.0");

                this.baseSalary = baseSalary;
            }

            // return base salary
            public double getBaseSalary() {
                return baseSalary;
            }

            // calculate earnings
            @Override
            public double earnings() {
                return getBaseSalary() + super.earnings();
            }

            // return String representation of BasePlusCommissionEmployee
            @Override
            public String toString() {
                return String.format("%s %s%n%s: %.2f", "base-salaried",
                        super.toString(), "base salary", getBaseSalary());
            }
        } // end class BasePlusCommissionEmployee

// BasePlusCommissionEmployeeTest.java
// Testing class BasePlusCommissionEmployee.

        class BasePlusCommissionEmployeeTest {
            public void main(String[] args) {
                // instantiate CommissionEmployee object
                CommissionEmployee employee1 = new CommissionEmployee(
                        "Sue", "Jones", "222-22-2222", 10000, .06);

                // get commission employee data
                System.out.println(
                        "Employee information obtained by get methods:");
                System.out.printf("%n%s %s%n", "First name is",
                        employee1.getFirstName());
                System.out.printf("%s %s%n", "Last name is",
                        employee1.getLastName());
                System.out.printf("%s %s%n", "Social security number is",
                        employee1.getSocialSecurityNumber());
                System.out.printf("%s %.2f%n", "Gross sales is",
                        employee1.getGrossSales());
                System.out.printf("%s %.2f%n", "Commission rate is",
                        employee1.getCommissionRate());

                employee1.setGrossSales(5000);
                employee1.setCommissionRate(.1);

                System.out.printf("%n%s:%n%n%s%n",
                        "Updated employee information obtained by toString", employee1);

                // instantiate BasePlusCommissionEmployee object
                BasePlusCommissionEmployee employee2 =
                        new BasePlusCommissionEmployee(
                                "Bob", "Lewis", "333-33-3333", 5000, .04, 300);

                // get base-salaried commission employee data
                System.out.println(
                        "Employee information obtained by get methods:");
                System.out.printf("%n%s %s%n", "First name is",
                        employee2.getFirstName());
                System.out.printf("%s %s%n", "Last name is",
                        employee2.getLastName());
                System.out.printf("%s %s%n", "Social security number is",
                        employee2.getSocialSecurityNumber());
                System.out.printf("%s %.2f%n", "Gross sales is",
                        employee2.getGrossSales());
                System.out.printf("%s %.2f%n", "Commission rate is",
                        employee2.getCommissionRate());
                System.out.printf("%s %.2f%n", "Base salary is",
                        employee2.getBaseSalary());

                employee2.setBaseSalary(1000);

                System.out.printf("%n%s:%n%n%s%n",
                        "Updated employee information obtained by toString",
                        employee2.toString());
            } // end main
        }
    }
}// end class BasePlusCommissionEmployeeTest

