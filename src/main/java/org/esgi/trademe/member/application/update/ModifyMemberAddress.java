package org.esgi.trademe.member.application.update;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.member.exposition.MemberAddressDTO;

public final class ModifyMemberAddress implements Command {

    public final int memberId;
    public final MemberAddressDTO address;

    private ModifyMemberAddress(int memberId, MemberAddressDTO address) {
        this.memberId = memberId;
        this.address = address;
    }

    public static ModifyMemberAddress of(int memberId, MemberAddressDTO address) {
        return new ModifyMemberAddress(memberId, address);
    }
}
