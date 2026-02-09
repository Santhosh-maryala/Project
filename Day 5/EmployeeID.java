class EmployeeID{
    public static void main(String[] args) {
        int empId[]={201,202,203,204};
        String empName []  ={"Harish","Anudeep","Mahesh Babu","Pavan Kalyan"};
       
    System.out.println("Employee Details");
        for(int i=0;i<empId.length;i++)
        {
            System.out.println("EmpID : "+ empId[i] + ", EmployeeName: " + empName[i]);
        }
        System.out.println("Total No of Employees :" + empId.length);

    }
}