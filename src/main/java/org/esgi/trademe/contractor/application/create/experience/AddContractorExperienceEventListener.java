package org.esgi.trademe.contractor.application.create.experience;


import org.esgi.trademe.kernel.event.EventListener;

public final class AddContractorExperienceEventListener implements EventListener<AddContractorExperienceEvent> {
    @Override
    public void listenTo(AddContractorExperienceEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}
