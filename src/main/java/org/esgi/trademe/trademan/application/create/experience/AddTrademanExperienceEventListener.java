package org.esgi.trademe.trademan.application.create.experience;


import org.esgi.trademe.kernel.event.EventListener;

public final class AddTrademanExperienceEventListener implements EventListener<AddTradesmanExperienceEvent> {
    @Override
    public void listenTo(AddTradesmanExperienceEvent event) {
        System.out.println("listening CreateContractorEvent.");
    }
}
