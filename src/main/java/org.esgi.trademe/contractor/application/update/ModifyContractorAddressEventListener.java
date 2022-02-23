package org.esgi.trademe.contractor.application.update;


import org.esgi.trademe.kernel.event.EventListener;

public final class ModifyContractorAddressEventListener implements EventListener<ModifyContractorAddressEvent> {
    @Override
    public void listenTo(ModifyContractorAddressEvent event) {
        System.out.println("Listening ModifyUserAddressEvent.");
    }
}
