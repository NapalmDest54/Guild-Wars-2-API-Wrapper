package com.chris2.gw2api.common.typeadapters;

import java.lang.reflect.Type;

import com.chris2.gw2api.skills.SkillFact;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

/**
 * Created by napal on 4/11/2017.
 */
public class BooleanTypeAdapter implements JsonDeserializer<SkillFact> {


    @Override
    public SkillFact deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = arg0.getAsJsonObject();
        SkillFact sf = new SkillFact();
        if (jsonObject.has("value")) {
            String value = jsonObject.get("value").getAsString();
            if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
                sf.setValue(Boolean.parseBoolean(value));
            } else {
                try {
                    double valueInt = Double.parseDouble(value);
                    sf.setValue(valueInt);
                } catch(NumberFormatException e) {
                } catch(NullPointerException e) {
                }
            }


        }
        sf.setText(jsonObject.get("text").getAsString());
        sf.setIcon(jsonObject.get("icon").getAsString());
        sf.setType(SkillFact.Type.fromValue(jsonObject.get("type").getAsString()));
        sf.setTarget(jsonObject.get("target") != null ? jsonObject.get("target").getAsString() : null);
        sf.setStatus(jsonObject.get("status") != null ? jsonObject.get("status").getAsString() : null);
        sf.setDescription(jsonObject.get("description") != null ? jsonObject.get("description").getAsString() : null);
        sf.setApplyCount(jsonObject.get("apply_count") != null ? jsonObject.get("apply_count").getAsInt() : null);
        sf.setDuration(jsonObject.get("duration") != null ? jsonObject.get("duration").getAsInt() : null);
        sf.setFieldType(jsonObject.get("fieldType") != null ? jsonObject.get("fieldType").getAsString() : null);
        sf.setFinisherType(jsonObject.get("finisher_type") != null ? SkillFact.FinisherType.fromValue(jsonObject.get("finisher_type").getAsString()) : null);
        sf.setPercent(jsonObject.get("percent") != null ? jsonObject.get("percent").getAsInt() : null);
        sf.setDmgMultiplier(jsonObject.get("dmgMultiplier") != null ? jsonObject.get("dmgMultiplier").getAsDouble() : null);
        sf.setDistance(jsonObject.get("distance") != null ? jsonObject.get("distance").getAsInt() : null);


        return sf;
    }
}
