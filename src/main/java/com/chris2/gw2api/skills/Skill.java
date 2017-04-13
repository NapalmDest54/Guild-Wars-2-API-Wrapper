package com.chris2.gw2api.skills;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skill {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("chat_link")
    @Expose
    private String chatLink;
    @SerializedName("type")
    @Expose
    private Skill.Type type;
    @SerializedName("weapon_type")
    @Expose
    private String weaponType;
    @SerializedName("professions")
    @Expose
    private List<Profession> professions = null;
    @SerializedName("slot")
    @Expose
    private Skill.Slot slot;
    @SerializedName("facts")
    @Expose
    private List<SkillFact> skillFacts = null;
    @SerializedName("traited_facts")
    @Expose
    private List<SkillTraitedFact> traitedFacts = null;
    @SerializedName("categories")
    @Expose
    private List<String> categories = null;
    @SerializedName("attunement")
    @Expose
    private Skill.Attunement attunement;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("dual_wield")
    @Expose
    private String dualWield;
    @SerializedName("flip_skill")
    @Expose
    private Integer flipSkill;
    @SerializedName("initiative")
    @Expose
    private Integer initiative;
    @SerializedName("next_chain")
    @Expose
    private Integer nextChain;
    @SerializedName("prev_chain")
    @Expose
    private Integer prevChain;
    @SerializedName("transform_skills")
    @Expose
    private List<Integer> transformSkills = null;
    @SerializedName("bundle_skills")
    @Expose
    private List<Integer> bundleSkills = null;
    @SerializedName("toolbelt_skill")
    @Expose
    private Integer toolbeltSkill;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getChatLink() {
        return chatLink;
    }

    public void setChatLink(String chatLink) {
        this.chatLink = chatLink;
    }

    public Skill.Type getType() {
        return type;
    }

    public void setType(Skill.Type type) {
        this.type = type;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public Skill.Slot getSlot() {
        return slot;
    }

    public void setSlot(Skill.Slot slot) {
        this.slot = slot;
    }

    public List<SkillFact> getSkillFacts() {
        return skillFacts;
    }

    public void setSkillFacts(List<SkillFact> skillFacts) {
        this.skillFacts = skillFacts;
    }

    public List<SkillTraitedFact> getTraitedFacts() {
        return traitedFacts;
    }

    public void setTraitedFacts(List<SkillTraitedFact> traitedFacts) {
        this.traitedFacts = traitedFacts;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Skill.Attunement getAttunement() {
        return attunement;
    }

    public void setAttunement(Skill.Attunement attunement) {
        this.attunement = attunement;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDualWield() {
        return dualWield;
    }

    public void setDualWield(String dualWield) {
        this.dualWield = dualWield;
    }

    public Integer getFlipSkill() {
        return flipSkill;
    }

    public void setFlipSkill(Integer flipSkill) {
        this.flipSkill = flipSkill;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getNextChain() {
        return nextChain;
    }

    public void setNextChain(Integer nextChain) {
        this.nextChain = nextChain;
    }

    public Integer getPrevChain() {
        return prevChain;
    }

    public void setPrevChain(Integer prevChain) {
        this.prevChain = prevChain;
    }

    public List<Integer> getTransformSkills() {
        return transformSkills;
    }

    public void setTransformSkills(List<Integer> transformSkills) {
        this.transformSkills = transformSkills;
    }

    public List<Integer> getBundleSkills() {
        return bundleSkills;
    }

    public void setBundleSkills(List<Integer> bundleSkills) {
        this.bundleSkills = bundleSkills;
    }

    public Integer getToolbeltSkill() {
        return toolbeltSkill;
    }

    public void setToolbeltSkill(Integer toolbeltSkill) {
        this.toolbeltSkill = toolbeltSkill;
    }

    public enum Attunement {

        @SerializedName("Fire")
        FIRE("Fire"),
        @SerializedName("Water")
        WATER("Water"),
        @SerializedName("Air")
        AIR("Air"),
        @SerializedName("Earth")
        EARTH("Earth");
        private final String value;
        private final static Map<String, Skill.Attunement> CONSTANTS = new HashMap<String, Skill.Attunement>();

        static {
            for (Skill.Attunement c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Attunement(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Skill.Attunement fromValue(String value) {
            Skill.Attunement constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Slot {

        @SerializedName("Downed_1")
        DOWNED_1("Downed_1"),
        @SerializedName("Downed_2")
        DOWNED_2("Downed_2"),
        @SerializedName("Downed_3")
        DOWNED_3("Downed_3"),
        @SerializedName("Downed_4")
        DOWNED_4("Downed_4"),
        @SerializedName("Profession_1")
        PROFESSION_1("Profession_1"),
        @SerializedName("Profession_2")
        PROFESSION_2("Profession_2"),
        @SerializedName("Profession_3")
        PROFESSION_3("Profession_3"),
        @SerializedName("Profession_4")
        PROFESSION_4("Profession_4"),
        @SerializedName("Utility")
        UTILITY("Utility"),
        @SerializedName("Weapon_1")
        WEAPON_1("Weapon_1"),
        @SerializedName("Weapon_2")
        WEAPON_2("Weapon_2"),
        @SerializedName("Weapon_3")
        WEAPON_3("Weapon_3"),
        @SerializedName("Weapon_4")
        WEAPON_4("Weapon_4"),
        @SerializedName("Weapon_5")
        WEAPON_5("Weapon_5");
        private final String value;
        private final static Map<String, Skill.Slot> CONSTANTS = new HashMap<String, Skill.Slot>();

        static {
            for (Skill.Slot c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Slot(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Skill.Slot fromValue(String value) {
            Skill.Slot constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        @SerializedName("Bundle")
        BUNDLE("Bundle"),
        @SerializedName("Elite")
        ELITE("Elite"),
        @SerializedName("Heal")
        HEAL("Heal"),
        @SerializedName("Profession")
        PROFESSION("Profession"),
        @SerializedName("Utility")
        UTILITY("Utility"),
        @SerializedName("Weapon")
        WEAPON("Weapon");
        private final String value;
        private final static Map<String, Skill.Type> CONSTANTS = new HashMap<String, Skill.Type>();

        static {
            for (Skill.Type c: values()) {
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

        public static Skill.Type fromValue(String value) {
            Skill.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
