package org.esgi.trademe.member.application.create;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.member.domain.MemberID;

public final class CreateMemberEvent implements ApplicationEvent {
    private final MemberID memberID;

    public CreateMemberEvent(MemberID memberID) {
        this.memberID = memberID;
    }

    public static CreateMemberEvent of(MemberID memberID) {
        return new CreateMemberEvent(memberID);
    }
}
