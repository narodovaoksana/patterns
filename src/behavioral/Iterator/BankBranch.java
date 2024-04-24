package behavioral.Iterator;

public class BankBranch {
    private String branchName;
    private String branchAddress;
    private String phoneNumber;

    public BankBranch(String branchName, String branchAddress, String phoneNumber) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
