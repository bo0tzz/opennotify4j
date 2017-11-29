package me.bo0tzz.opennotify4j.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class ISSEvent {

    private final String message;

    private ISSEvent() {
        this.message = "";
    }

}
