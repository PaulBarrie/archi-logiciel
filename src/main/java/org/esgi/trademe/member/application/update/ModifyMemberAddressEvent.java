package org.esgi.trademe.member.application.update;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.member.domain.MemberID;

public final class ModifyMemberAddressEvent implements ApplicationEvent {
    private final MemberID memberId;

    public ModifyMemberAddressEvent(MemberID memberId) {
        this.memberId = memberId;
    }
}
