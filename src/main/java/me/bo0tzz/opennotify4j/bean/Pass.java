package me.bo0tzz.opennotify4j.bean;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Pass {

    Long risetime;
    Integer duration;

}
