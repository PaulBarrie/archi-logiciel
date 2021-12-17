package org.esgi.trademe.member.application.create;


import org.esgi.trademe.kernel.event.EventListener;

public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {
    @Override
    public void listenTo(CreateMemberEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}
