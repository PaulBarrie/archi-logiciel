package org.esgi.trademe.contract.domain;



import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.trademan.domain.WorkDomain;
import org.esgi.trademe.kernel.Entity;
import org.esgi.trademe.contractor.domain.ContractorID;

import java.util.Objects;

public final class Contract implements Entity<ContractID> {
    private final ContractID contractID;
    private final ContractorID contractorID;
    private final TradesmanID tradesmanID;
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;
    private ContractStatus contractStatus;

    public Contract(ContractID contractID, ContractorID contractorID, TradesmanID tradesmanID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.contractID = contractID;
        this.contractorID = contractorID;
        this.tradesmanID = tradesmanID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
        this.contractStatus = ContractStatus.PENDING;
    }


    public static Contract of(ContractID contractID, ContractorID contractorID, TradesmanID tradesmanID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new Contract(contractID, contractorID, tradesmanID, hourlyWage, hoursPerMonth, workDomain);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract tradesman = (Contract) o;
        return Objects.equals(contractID, tradesman.contractID) && Objects.equals(tradesmanID, tradesman.tradesmanID)
                && Objects.equals(contractorID, tradesman.contractorID) && Objects.equals(hourlyWage, tradesman.hourlyWage)
                && Objects.equals(hoursPerMonth, tradesman.hoursPerMonth) && Objects.equals(workDomain, tradesman.workDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractID, contractorID, contractID, hourlyWage, hoursPerMonth, workDomain);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + contractID.toString() +
                ", contractor_id='" + contractorID.toString() + '\'' +
                ", tradesman_id='" + contractID.toString() + '\'' +
                ", hourly_work='" + hourlyWage + '\'' +
                ", hours_per_month='" + hoursPerMonth + '\'' +
                ", work_domain=" + workDomain +
                '}';
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ContractorID getContractorID() {
        return contractorID;
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }

    public Float getHourlyWage() {
        return hourlyWage;
    }

    public Integer getHoursPerMonth() {
        return hoursPerMonth;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }

    @Override
    public ContractID id() {
        return contractID;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
}
