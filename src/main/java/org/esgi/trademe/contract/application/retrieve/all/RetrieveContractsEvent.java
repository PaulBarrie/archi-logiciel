package org.esgi.trademe.contract.application.retrieve.all;

import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class RetrieveContractsEvent implements ApplicationEvent {

    public RetrieveContractsEvent(){
    }

    public static RetrieveContractsEvent of() {
        return new RetrieveContractsEvent();
    }
}
