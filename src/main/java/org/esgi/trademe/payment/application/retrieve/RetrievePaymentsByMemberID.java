package org.esgi.trademe.payment.application.retrieve;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.member.domain.MemberID;

public class RetrievePaymentsByMemberID implements Query {
    public final MemberID memberID;

    public RetrievePaymentsByMemberID(MemberID memberID) {
        this.memberID = memberID;
    }
}
