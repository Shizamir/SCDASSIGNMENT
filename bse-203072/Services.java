
package hospitalmanagement;

import java.util.List;

/**
 *
 * @author SoftwareEngineer
 */

public class Services
{
    String servicename;
    String date;
    int P_id;
    String P_name;
    int charges;

    public String getSName() {
        return servicename;
    }

    public void setSName(String name) {
        this.servicename = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getP_id() {
        return P_id;
    }

    public void setP_id(int P_id) {
        this.P_id = P_id;
    }

    public String getP_name() {
        return P_name;
    }

    public void setP_name(String P_name) {
        this.P_name = P_name;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    void add(List<Services> service) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
