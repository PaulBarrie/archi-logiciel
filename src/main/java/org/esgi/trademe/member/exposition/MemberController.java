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
public final class MemberController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public MemberController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @PostMapping(value="/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> register(@RequestParam(required = true, name = "first_name" ) String first_name,
                                              @RequestParam(required = true, name = "last_name") String last_name,
                                              @RequestParam(required = true, name= "email") String email,
                                              @RequestParam(required = true, name= "birth") String birth,
                                              @RequestParam(required = true, name= "username") String username,
                                              @RequestParam(required = true, name= "password") String password,
                                              @RequestParam(required = true, name= "street_number") String street_number,
                                              @RequestParam(required = true, name= "street_name") String street_name,
                                              @RequestParam(required = true, name= "zip_code") String zip_code,
                                              @RequestParam(required = true, name= "city") String city,
                                              @RequestParam(required = true, name= "country") String country)
            throws InvalidEntryException, NoSuchAlgorithmException {

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
