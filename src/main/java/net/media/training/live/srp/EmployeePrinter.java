package net.media.training.live.srp;

public class EmployeePrinter {

    Employee employee;

    public EmployeePrinter(Employee employee) {
        this.employee = employee;
    }

    public String toHtml() {
        String str = "<div>" +
                "<h1>Employee Info</h1>" +
                "<div id='emp" + this.employee.getempId() + "'>" +
                "<span>" + this.employee.getName() + "</span>" +
                "<div class='left'>" +
                "<span>Leave Left :</span>" +
                "<span>Annual Salary:</span>" +
                "<span>Manager:</span>" +
                "<span>Reimbursable Leave:</span>" +
                "</div>";
        str += "<div class='right'><span>" + (this.employee.getTotalLeaveAllowed() - this.employee.getLeaveTaken()) + "</span>";
        str += "<span>" + Math.round(this.employee.getMonthlySalary() * 12) + "</span>";
        if (this.employee.getManager() != null) str += "<span>" + this.employee.getManager() + "</span>";
        else str += "<span>None</span>";
        int years = 3;
        if (this.employee.getYearsInOrg() < 3) {
            years = this.employee.getYearsInOrg();
        }
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPreviously += this.employee.getLeavesLeftPreviously()[this.employee.getYearsInOrg()-i-1];
        }
        str += "<span>" + totalLeaveLeftPreviously + "</span>";
        return str + "</div> </div>";
    }
}
