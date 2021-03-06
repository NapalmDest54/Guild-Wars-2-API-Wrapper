package com.chris2.gw2api.skills;


import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillFact {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("type")
    @Expose
    private SkillFact.Type type;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("target")
    @Expose
    private String target;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("apply_count")
    @Expose
    private Integer applyCount;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("field_type")
    @Expose
    private String fieldType;
    @SerializedName("finisher_type")
    @Expose
    private SkillFact.FinisherType finisherType;
    @SerializedName("percent")
    @Expose
    private Integer percent;
    @SerializedName("dmg_multiplier")
    @Expose
    private Double dmgMultiplier;
    @SerializedName("distance")
    @Expose
    private Integer distance;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public SkillFact.Type getType() {
        return type;
    }

    public void setType(SkillFact.Type type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setValue(Boolean value) {
        this.value = value ? 1d : 0d;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public SkillFact.FinisherType getFinisherType() {
        return finisherType;
    }

    public void setFinisherType(SkillFact.FinisherType finisherType) {
        this.finisherType = finisherType;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Double getDmgMultiplier() {
        return dmgMultiplier;
    }

    public void setDmgMultiplier(Double dmgMultiplier) {
        this.dmgMultiplier = dmgMultiplier;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public enum FinisherType {

        @SerializedName("Blast")
        BLAST("Blast"),
        @SerializedName("Leap")
        LEAP("Leap"),
        @SerializedName("Projectile")
        PROJECTILE("Projectile"),
        @SerializedName("Whirl")
        WHIRL("Whirl");
        private final String value;
        private final static Map<String, SkillFact.FinisherType> CONSTANTS = new HashMap<String, SkillFact.FinisherType>();

        static {
            for (SkillFact.FinisherType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private FinisherType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static SkillFact.FinisherType fromValue(String value) {
            SkillFact.FinisherType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        @SerializedName("AttributeAdjust")
        ATTRIBUTE_ADJUST("AttributeAdjust"),
        @SerializedName("Buff")
        BUFF("Buff"),
        @SerializedName("ComboField")
        COMBO_FIELD("ComboField"),
        @SerializedName("ComboFinisher")
        COMBO_FINISHER("ComboFinisher"),
        @SerializedName("Damage")
        DAMAGE("Damage"),
        @SerializedName("Distance")
        DISTANCE("Distance"),
        @SerializedName("Duration")
        DURATION("Duration"),
        @SerializedName("Heal")
        HEAL("Heal"),
        @SerializedName("HealingAdjust")
        HEALING_ADJUST("HealingAdjust"),
        @SerializedName("NoData")
        NO_DATA("NoData"),
        @SerializedName("Number")
        NUMBER("Number"),
        @SerializedName("Percent")
        PERCENT("Percent"),
        @SerializedName("PrefixedBuff")
        PREFIXED_BUFF("PrefixedBuff"),
        @SerializedName("Radius")
        RADIUS("Radius"),
        @SerializedName("Range")
        RANGE("Range"),
        @SerializedName("Recharge")
        RECHARGE("Recharge"),
        @SerializedName("Time")
        TIME("Time"),
        @SerializedName("Unblockable")
        UNBLOCKABLE("Unblockable");
        private final String value;
        private final static Map<String, SkillFact.Type> CONSTANTS = new HashMap<String, SkillFact.Type>();

        static {
            for (SkillFact.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static SkillFact.Type fromValue(String value) {
            SkillFact.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}