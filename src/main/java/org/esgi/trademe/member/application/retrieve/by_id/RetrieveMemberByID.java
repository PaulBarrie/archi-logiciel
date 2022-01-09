package org.esgi.trademe.member.application.retrieve.by_id;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.member.domain.MemberID;

public final class RetrieveMemberByID implements Query {
    public final MemberID id;

    public RetrieveMemberByID(MemberID id) {
        this.id = id;
    }
}
