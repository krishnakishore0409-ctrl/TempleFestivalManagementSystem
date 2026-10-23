package com.example.TempleFestival.mapper;

import org.springframework.stereotype.Component;

import com.example.TempleFestival.DTO.request.EventRequestDTO;
import com.example.TempleFestival.DTO.response.EventResponseDTO;
import com.example.TempleFestival.model.*;


@Component
public class EventMapper {
    
    public Event toEntity(Festival festival,EventRequestDTO request){

       Event event = new Event();

       event.setEventName(request.getEventName());
       event.setEventDate(request.getEventDate());
       event.setDescription(request.getDescription());
       event.setDayNo(request.getDayNo());
       event.setEventTime(request.getEvenTime());
       event.setSession(request.getSession());
       event.setFestival(festival);

       return event;

    }

    public EventResponseDTO toResponse(Event event){

     EventResponseDTO response = new EventResponseDTO();

     response.setEventId(event.getEventId());
     response.setEventName(event.getEventName());
     response.setEventDate(event.getEventDate());
     response.setEventTime(event.getEventTime());
     response.setDescription(event.getDescription());
     response.setDayNo(event.getDayNo());
     response.setSession(event.getSession());
     response.setFestivalName(event.getFestival().getFestivalName());
     response.setFestivalYear(event.getFestival().getFestivalYear());

     return response;

    }

// public EventResponseDTO toResponseGetId(Event event){

//     EventResponseDTO response = new EventResponseDTO();

//      response.setEventId(event.getEventId());
//      response.setEventName(event.getEventName());
//      response.setEventDate(event.getEventDate());
//      response.setEventTime(event.getEventTime());
//      response.setDescription(event.getDescription());
//      response.setDayNo(event.getDayNo());
//      response.setSession(event.getSession());
//      response.setFestivalName(event.getFestival().getFestivalName());
//      response.setFestivalYear(event.getFestival().getFestivalYear());

//      return response;

// }

public Event toEntityUpdate(Event existingEvent,Festival festival,EventRequestDTO request){

    existingEvent.setEventName(request.getEventName());
    existingEvent.setEventDate(request.getEventDate());
    existingEvent.setEventTime(request.getEvenTime());
    existingEvent.setDayNo(request.getDayNo());
    existingEvent.setDescription(request.getDescription());
    existingEvent.setSession(request.getSession());
    existingEvent.setFestival(festival);

    return existingEvent;
    
}

}
