package org.esgi.trademe.member.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveMemberByIDEventListener implements EventListener<RetrieveMemberByIDEvent> {
    @Override
    public void listenTo(RetrieveMemberByIDEvent event) {
        System.out.println("listening RetrieveMemberByIDEvent.");
    }
}
