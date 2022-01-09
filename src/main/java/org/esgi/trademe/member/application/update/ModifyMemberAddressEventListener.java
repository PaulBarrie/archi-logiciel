package org.esgi.trademe.member.application.update;


import org.esgi.trademe.kernel.event.EventListener;

public final class ModifyMemberAddressEventListener implements EventListener<ModifyMemberAddressEvent> {
    @Override
    public void listenTo(ModifyMemberAddressEvent event) {
        System.out.println("Listening ModifyUserAddressEvent.");
    }
}
