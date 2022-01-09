package org.esgi.trademe.member.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.member.domain.MemberID;

public final class RetrieveMemberByIDEvent implements ApplicationEvent {
    private final MemberID memberID;

    public RetrieveMemberByIDEvent(MemberID memberID) {
        this.memberID = memberID;
    }

    public static RetrieveMemberByIDEvent of(MemberID memberID) {
        return new RetrieveMemberByIDEvent(memberID);
    }
}
