 
package model.faysal;

public class Total {
    public int no;
    public String type;

    public Total(int no, String type) {
        this.no = no;
        this.type = type;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Total{" + "no=" + no + ", type=" + type + '}';
    }
}
