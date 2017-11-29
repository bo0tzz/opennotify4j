package me.bo0tzz.opennotify4j.api;

import lombok.Builder;
import lombok.Data;
import me.bo0tzz.opennotify4j.bean.Person;

import java.util.List;

@Data
public class ISSPeople extends ISSEvent {

    private final Integer number;
    private final List<Person> people;

    @Builder
    private ISSPeople(String message, Integer number, List<Person> people) {
        super(message);
        this.number = number;
        this.people = people;
    }

}
