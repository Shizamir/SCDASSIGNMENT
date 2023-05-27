package patientadmitinfo1;

/**
 *
 * @author Dell
 */
public class Patient {
    private String patientId;
    private String patientName;
    private String gender;
    private String bloodGroup;
    private String disease;
    private String admitDate;
    private String roomNo;
    private String doctorId;
    private String doctorName;
    private String dischargeDate;
    private double roomCharges;
    private int noOfDays;
    private double totalRoomCharges;
    private double serviceCharges;
    private String billingDate;
    private String paymentMode;
    private String paymentModeDetail;
    private double totalCharges;
    private String billNo;

    public Patient(String patientId, String patientName, String gender, String bloodGroup, String disease, String admitDate, String roomNo, String doctorId, String doctorName, String dischargeDate, double roomCharges, int noOfDays, double totalRoomCharges, double serviceCharges, String billingDate, String paymentMode, String paymentModeDetail, double totalCharges, String billNo) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.disease = disease;
        this.admitDate = admitDate;
        this.roomNo = roomNo;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.dischargeDate = dischargeDate;
        this.roomCharges = roomCharges;
        this.noOfDays = noOfDays;
        this.totalRoomCharges = totalRoomCharges;
        this.serviceCharges = serviceCharges;
        this.billingDate = billingDate;
        this.paymentMode = paymentMode;
        this.paymentModeDetail = paymentModeDetail;
        this.totalCharges = totalCharges;
        this.billNo = billNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(String admitDate) {
        this.admitDate = admitDate;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public double getTotalRoomCharges() {
        return totalRoomCharges;
    }

    public void setTotalRoomCharges(double totalRoomCharges) {
        this.totalRoomCharges = totalRoomCharges;
    }

    public double getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentModeDetail() {
        return paymentModeDetail;
    }

    public void setPaymentModeDetail(String paymentModeDetail) {
        this.paymentModeDetail = paymentModeDetail;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    
}
