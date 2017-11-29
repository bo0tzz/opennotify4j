package me.bo0tzz.opennotify4j.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import me.bo0tzz.opennotify4j.bean.Pass;
import me.bo0tzz.opennotify4j.bean.PassLocation;

import java.util.List;

@Data
public class ISSPass extends ISSEvent {

    private final PassLocation request;
    @Singular
    @SerializedName("response") private final List<Pass> passes;

    @Builder
    private ISSPass(String message, PassLocation request, List<Pass> passes) {
        super(message);
        this.request = request;
        this.passes = passes;
    }

    public Pass nextPass() {
        return passes.get(0);
    }

}
