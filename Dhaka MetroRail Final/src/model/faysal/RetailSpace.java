/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

/**
 *
 * @author Faysal Kabir Ashik
 */
public class RetailSpace {
 
    private String  leaseAgreements;
    private String tenantInfo;
    private String usage;
    private int id;

    public RetailSpace() {
    }

    public RetailSpace(String leaseAgreements, String tenantInfo, String usage, int id) {
        this.leaseAgreements = leaseAgreements;
        this.tenantInfo = tenantInfo;
        this.usage = usage;
        this.id = id;
    }

    public String getLeaseAgreements() {
        return leaseAgreements;
    }

    public void setLeaseAgreements(String leaseAgreements) {
        this.leaseAgreements = leaseAgreements;
    }

    public String getTenantInfo() {
        return tenantInfo;
    }

    public void setTenantInfo(String tenantInfo) {
        this.tenantInfo = tenantInfo;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RetailSpace{" + "leaseAgreements=" + leaseAgreements + ", tenantInfo=" + tenantInfo + ", usage=" + usage + ", id=" + id + '}';
    }
    
    
    
    
}
