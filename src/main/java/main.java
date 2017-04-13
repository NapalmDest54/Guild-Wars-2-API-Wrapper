import com.chris2.gw2api.client.GW2APIClient;
import com.chris2.gw2api.client.skills.SkillsClient;
import com.chris2.gw2api.skills.Skill;

import java.io.IOException;

/**
 * Created by napal on 4/11/2017.
 */
class main {

    public static void main(String args[]) throws IOException {
        //SkillsClient.getAllSkills();
        SkillsClient.getSkills(5515);
    }
}
