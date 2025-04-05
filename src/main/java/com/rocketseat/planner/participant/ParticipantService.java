package com.rocketseat.planner.participant;

import com.rocketseat.planner.trip.Trip;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantsToEvent (List<String> participantsToInvite, Trip trip){
        List<Participants> participants = participantsToInvite.stream().map(email -> new Participants(email, trip)).toList();

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());

    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){

    };

    public void triggerConfirmationEmailToParticipant(String email){

    }

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip){
        Participants newParticipant = new Participants(email, trip);
        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    public List<ParticipantData> getAllParticipantsFromEvent(UUID tripId){
        return this.repository.findByTripId(tripId).stream().map(participants -> new ParticipantData(participants.getId(), participants.getName(), participants.getEmail(), participants.getIsConfirmedAt())).toList();
    }
}
