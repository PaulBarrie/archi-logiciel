package org.esgi.trademe.trademan.application.create.education_level;


import org.esgi.trademe.kernel.event.EventListener;

public final class AddTradesmanEducationLevelEventListener implements EventListener<AddTradesmanEducationLevelEvent> {
    @Override
    public void listenTo(AddTradesmanEducationLevelEvent event) {
        System.out.println("listening CreateContractorEvent.");
    }
}
