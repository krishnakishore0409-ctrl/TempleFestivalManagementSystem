package com.example.TempleFestival.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TempleFestival.DTO.request.EventRequestDTO;
import com.example.TempleFestival.DTO.response.EventResponseDTO;
import com.example.TempleFestival.exception.ResourceNotFoundException;
import com.example.TempleFestival.mapper.EventMapper;
import com.example.TempleFestival.model.Festival;
import com.example.TempleFestival.model.Event;
import com.example.TempleFestival.repository.EventRepository;
import com.example.TempleFestival.repository.FestivalRepository;

@Service 
public class EventService {
    
       @Autowired      
      private EventRepository eventRepository;

      @Autowired 
      private FestivalRepository festivalRepository;

      @Autowired
      private EventMapper eventMapper;

      public String eventInsert(EventRequestDTO request){

        Festival festival = festivalRepository.findById(request.getFestivalId()). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

        Event event = eventMapper.toEntity(festival,request);

        eventRepository.save(event);

        return "Event added Successfully...";
      }

      public List<EventResponseDTO> eventGet(){

        List<Event> event = eventRepository.findAll();


        List<EventResponseDTO> response = new ArrayList<>();

        for(Event e : event){

          EventResponseDTO dto = eventMapper.toResponse(e);

          response.add(dto);

        }

        return response;
      }

      public EventResponseDTO eventGetId(int id){

         Event event = eventRepository.findById(id).
         orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));

        EventResponseDTO response = eventMapper.toResponse(event);

        return response;
      }
      
      public String eventUpdate(int id,EventRequestDTO request){

      Event existingEvent = eventRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id ));

      Festival festival = festivalRepository.findById(request.getFestivalId()). 
           orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + request.getFestivalId() ));

      Event event = eventMapper.toEntityUpdate(existingEvent,festival,request);

        eventRepository.save(event);

         return "Event Updated Successfully...";

      }

      public String eventDeleteId(int id){

        Event existingEvent = eventRepository.findById(id). 
           orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));

         eventRepository.deleteById(existingEvent.getEventId());

         return "Event Id :"+id+" Deleted Successfully...";

      }


}
