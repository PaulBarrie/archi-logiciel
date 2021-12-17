package org.esgi.trademe.member.exposition;

import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.member.application.create.CreateMember;
import org.esgi.trademe.member.application.retrieve.by_id.RetrieveMemberByID;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.domain.MemberID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.esgi.trademe.member.application.retrieve.all.RetrieveMembers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public class MemberController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public MemberController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @PostMapping(value="/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> register(@RequestParam(required = true) String first_name, @RequestParam(required = true) String last_name,
                                              @RequestParam(required = true) String email, @RequestParam(required = true) String birth,
                                              @RequestParam(required = true) String username, @RequestParam(required = true) String password,
                                              @RequestParam(required = true) String street_number,
                                              @RequestParam(required = true) String street_name, @RequestParam(required = true) String zip_code,
                                              @RequestParam(required = true) String city, @RequestParam(required = true) String country) throws InvalidEntryException, NoSuchAlgorithmException {

        final Member member = commandBus.send(CreateMember.of(first_name, last_name, email, birth, MemberCredentialsDTO.of(username, password),
                MemberAddressDTO.of(street_number, street_name, zip_code, city, country)));
        MemberDTO memberDTOResponse = MemberDTO.of(member);
        System.out.println(memberDTOResponse);
        return ResponseEntity.ok(memberDTOResponse);
    }

    @GetMapping(value = "/member", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> get(@RequestParam(required = true) String id) {
        final MemberDTO membersDTOResult = queryBus.send(new RetrieveMemberByID(MemberID.of(Integer.parseInt(id))));
        return ResponseEntity.ok(membersDTOResult);
    }

    @GetMapping(value = "/members", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembersDTO> getAll() {
        final List<MemberDTO> members = queryBus.send(new RetrieveMembers());
        MembersDTO membersDTOResult = new MembersDTO();
        membersDTOResult.members = members;
        return ResponseEntity.ok(membersDTOResult);
    }
    

}
