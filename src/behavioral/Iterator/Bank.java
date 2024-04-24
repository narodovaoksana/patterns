package behavioral.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankBranch> branchList;

    public Bank() {
        this.branchList = new ArrayList<>();
    }

    public void addBranch(BankBranch branch) {
        branchList.add(branch);
    }

    public BankBranchIterator createIterator() {
        return new BankBranchIterator(branchList);
    }
}
