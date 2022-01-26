package org.esgi.trademe.contract.exposition;

import org.esgi.trademe.contract.domain.Contract;

@SuppressWarnings("all")
public final class ContractDTO {

    public final Contract contract;

    public ContractDTO(Contract contract) {
        this.contract = contract;
    }


    public static ContractDTO of(Contract contract){
        return new ContractDTO(contract);
    }

    @Override
    public String toString() {
        return "ContractDTO{" +
                "id=" + contract.getContractID().toString() + '\'' +
                ", contractor_id='" + contract.getContractorID().toString() + '\'' +
                ", tradesman_id='" + contract.getTradesmanID().toString() + '\'' +
                ", hourly_work='" + contract.getHourlyWage() + '\'' +
                ", hours_per_month='" + contract.getHoursPerMonth() + '\'' +
                ", work_domain=" + contract.getWorkDomain() +
                '}';
    }
}
