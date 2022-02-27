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
                ", project_id='" + contract.getProjectID().toString() + '\'' +
                ", hourly_work='" + contract.getHourlyWage() + '\'' +
                ", nb_hours='" + contract.getNbHours() + '\'' +
                ", work_domain=" + contract.getWorkDomain() +
                '}';
    }
}
