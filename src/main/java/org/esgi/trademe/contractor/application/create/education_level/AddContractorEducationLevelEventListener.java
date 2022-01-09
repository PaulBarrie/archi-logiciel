package org.esgi.trademe.contractor.application.create.education_level;


import org.esgi.trademe.kernel.event.EventListener;

public final class AddContractorEducationLevelEventListener implements EventListener<AddContractorEducationLevelEvent> {
    @Override
    public void listenTo(AddContractorEducationLevelEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}
