
package model.faysal;

import java.io.Serializable;
import java.time.LocalDate;

 
public class Rules implements Serializable{
    
    private String rulesName;
    private int no;
    private LocalDate dateIssue;
    private String rulesType;
    public Rules()
    {
        
    }
    public Rules(int no,String rulesName,LocalDate dob,String rulesType) {
        this.rulesName = rulesName;
        this.no = no;
        dateIssue=dob;
        this.rulesType=rulesType;
    }

    public String getRulesName() {
        return rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = rulesName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getRulesType() {
        return rulesType;
    }

    public void setRulesType(String rulesType) {
        this.rulesType = rulesType;
    }
    
    
    
}
