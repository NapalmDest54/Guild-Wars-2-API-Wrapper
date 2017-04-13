package com.chris2.gw2api.client.skills;

import com.chris2.gw2api.common.typeadapters.BooleanTypeAdapter;
import com.chris2.gw2api.skills.Skill;
import com.chris2.gw2api.skills.SkillFact;
import com.chris2.gw2api.skills.SkillsIDList;
import com.chris2.gw2api.client.GW2APIClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by napal on 4/11/2017.
 */
public class SkillsClient {
    private static String SKILLS_URL = "https://api.guildwars2.com/v2/skills";
    private static final int CHUNK_SIZE = 200;

    public static Skill getSkill(int id) throws IOException {
        Request request = new Request.Builder()
                .url(SKILLS_URL + "?id=" + Integer.toString(id))
                .build();

        Response response = null;
        try {
            response = GW2APIClient.executeRequest(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        BooleanTypeAdapter adapter = new BooleanTypeAdapter();
        builder.registerTypeAdapter(SkillFact.class, adapter);
        Gson gson = builder.create();

        String body = response.body().string();

        System.out.println(body);
        Skill skill = gson.fromJson(body, Skill.class);
        return skill;
    }


    public static LinkedList<Skill> getAllSkills() throws IOException {
        Request request = new Request.Builder()
                .url(SKILLS_URL)
                .build();

        Response response = null;
        try {
            response = GW2APIClient.executeRequest(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String bodySkillList = response.body().string();

        GsonBuilder builder = new GsonBuilder();
        BooleanTypeAdapter adapter = new BooleanTypeAdapter();
        builder.registerTypeAdapter(SkillFact.class, adapter);
        Gson gson = builder.create();

        SkillsIDList skillsIDList = getSkillsIdList();

        StringBuilder stringBuilderSkillIds = new StringBuilder();

        for (int skillId : skillsIDList.getSkillIds()) {
            stringBuilderSkillIds.append(skillId).append(",");
        }

        stringBuilderSkillIds.deleteCharAt(stringBuilderSkillIds.length() - 1);

        return getSkills(skillsIDList.getSkillIds());
    }


    public static LinkedList<Skill> getSkills(int ...skilLIds) throws IOException {
        int numOfChunks = (int)Math.ceil((double)skilLIds.length / CHUNK_SIZE);
        int[][] skillIdChunks = new int[numOfChunks][];


        for(int i = 0; i < numOfChunks; ++i) {
            int start = i * CHUNK_SIZE;
            int length = Math.min(skilLIds.length - start, CHUNK_SIZE);

            int[] temp = new int[length];
            System.arraycopy(skilLIds, start, temp, 0, length);
            skillIdChunks[i] = temp;
        }

        LinkedList<Skill> skillsToReturn = new LinkedList<Skill>();

        for (int[] chunk : skillIdChunks) {
            StringBuilder stringBuilderSkillIds = new StringBuilder();
            for (int skillId : chunk) {
                stringBuilderSkillIds.append(skillId).append(",");
            }
            stringBuilderSkillIds.deleteCharAt(stringBuilderSkillIds.length() - 1);
            Request request = new Request.Builder()
                    .url(SKILLS_URL + "?ids=" + stringBuilderSkillIds.toString())
                    .build();


            System.out.println(SKILLS_URL + "?ids=" + stringBuilderSkillIds.toString());
            System.out.println(chunk.length);
            Response response = null;
            try {
                response = GW2APIClient.executeRequest(request);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            GsonBuilder builder = new GsonBuilder();
            BooleanTypeAdapter adapter = new BooleanTypeAdapter();
            builder.registerTypeAdapter(SkillFact.class, adapter);
            Gson gson = builder.create();

            String body = response.body().string();

            Skill[] skills = gson.fromJson(body, Skill[].class);
            skillsToReturn.addAll(Arrays.asList(skills));

            System.out.println(skills.length);
        }

        return skillsToReturn;
    }

    public static SkillsIDList getSkillsIdList() throws IOException {
        Request request = new Request.Builder()
                .url(SKILLS_URL)
                .build();

        Response response = null;
        try {
            response = GW2APIClient.executeRequest(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String bodySkillList = response.body().string();

        Gson gson = new Gson();

        SkillsIDList skillsIDList = new SkillsIDList();
        skillsIDList.setSkillIds(gson.fromJson(bodySkillList, int[].class));

        return skillsIDList;
    }
}
