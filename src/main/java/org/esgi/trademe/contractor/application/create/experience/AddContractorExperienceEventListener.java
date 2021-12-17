package org.esgi.trademe.contractor.application.create.experience;


import org.esgi.trademe.kernel.event.EventListener;

public class AddContractorExperienceEventListener implements EventListener<AddContractorExperienceEvent> {
    @Override
    public void listenTo(AddContractorExperienceEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}
