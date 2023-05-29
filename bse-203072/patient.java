package hospitalmanagement;

import java.util.List;

public class patient
{
    int p_id;
    String p_name;
    String P_Father;
    String P_address;
    int P_contact;
    String P_email;
    int P_age;
    char P_gender;
    char P_bloodgroup;
    String P_info;
    String P_disease;
    

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_Father() {
        return P_Father;
    }

    public void setP_Father(String P_Father) {
        this.P_Father = P_Father;
    }

    public String getP_address() {
        return P_address;
    }

    public void setP_address(String P_address) {
        this.P_address = P_address;
    }

    public int getP_contact() {
        return P_contact;
    }

    public void setP_contact(int P_contact) {
        this.P_contact = P_contact;
    }

    public String getP_email() {
        return P_email;
    }

    public void setP_email(String P_email) {
        this.P_email = P_email;
    }

    public int getP_age() {
        return P_age;
    }

    public void setP_age(int P_age) {
        this.P_age = P_age;
    }

    public char getP_gender() {
        return P_gender;
    }

    public void setP_gender(char P_gender) {
        this.P_gender = P_gender;
    }

    public char getP_bloodgroup() {
        return P_bloodgroup;
    }

    public void setP_bloodgroup(char P_bloodgroup) {
        this.P_bloodgroup = P_bloodgroup;
    }

    public String getP_info() {
        return P_info;
    }

    public void setP_info(String P_info) {
        this.P_info = P_info;
    }

    public String getP_disease() {
        return P_disease;
    }

    public void setP_disease(String P_disease) {
        this.P_disease = P_disease;
    }

    void add(List<Doctor> patient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}
