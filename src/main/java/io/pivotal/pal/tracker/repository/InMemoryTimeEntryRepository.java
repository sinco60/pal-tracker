package io.pivotal.pal.tracker.repository;

import io.pivotal.pal.tracker.model.TimeEntry;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap;


    public InMemoryTimeEntryRepository() {
        this.timeEntryMap = new HashMap<>();;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry.getId() == 0){
            timeEntry.setId(timeEntryMap.size() +1);
        }
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntryMap.get(timeEntry.getId());
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> list = new ArrayList<>();
        for(long id : timeEntryMap.keySet()){
            list.add(timeEntryMap.get(id));
        }
        return list;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(timeEntryMap.get(id) == null){
            return null;
        }
        timeEntry.setId(id);
        timeEntryMap.put(id, timeEntry);
        return timeEntryMap.get(id);
    }

    @Override
    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
