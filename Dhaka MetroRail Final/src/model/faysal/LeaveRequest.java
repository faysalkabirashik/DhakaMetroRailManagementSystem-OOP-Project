
package model.faysal;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.faysal.users.Employee;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class LeaveRequest  implements Serializable {
            
    private String id;
    private Employee employee;
    LocalDate   startTime;
    LocalDate   endTime;

    private String reason;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LeaveRequest{");
        sb.append("id=").append(id);
        sb.append(", employee=").append(employee);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public LeaveRequest(String id, Employee employee, LocalDate startTime, LocalDate endTime, String reason, String status) {
        this.id = id;
        this.employee = employee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.status = status;
    }
    
    
    
}
