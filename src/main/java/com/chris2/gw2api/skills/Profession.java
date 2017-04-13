package com.chris2.gw2api.skills;


import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public enum Profession {

    @SerializedName("Guardian")
    GUARDIAN("Guardian"),
    @SerializedName("Warrior")
    WARRIOR("Warrior"),
    @SerializedName("Engineer")
    ENGINEER("Engineer"),
    @SerializedName("Ranger")
    RANGER("Ranger"),
    @SerializedName("Thief")
    THIEF("Thief"),
    @SerializedName("Elementalist")
    ELEMENTALIST("Elementalist"),
    @SerializedName("Mesmer")
    MESMER("Mesmer"),
    @SerializedName("Necromancer")
    NECROMANCER("Necromancer"),
    @SerializedName("Revenant")
    REVENANT("Revenant");
    private final String value;
    private final static Map<String, Profession> CONSTANTS = new HashMap<String, Profession>();

    static {
        for (Profession c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private Profession(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static Profession fromValue(String value) {
        Profession constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
