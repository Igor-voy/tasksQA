package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetToList {
    public SetToList() {
    }

    public List<String> getList(Set nameSet) {
        return new ArrayList<>(nameSet);
    }
}
