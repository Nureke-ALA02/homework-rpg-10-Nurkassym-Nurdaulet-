package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.quest.QuestLog;
import java.util.List;

/**
 * Orchestrates a planning session that uses both Iterator and Mediator.
 */
public class CouncilEngine {

    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildMediator hall) {

        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 4;

        System.out.println("\n=== ORDERED QUESTS ===");

        var ordered = questLog.ordered();

        while (ordered.hasNext()) {

            var quest = ordered.next();

            System.out.println(quest);

            hall.dispatch(
                    "COMMAND",
                    null,
                    "Prepare party for: " + quest.getTitle()
            );

            questsTraversed++;
            messagesRouted++;
        }

        System.out.println("\n=== REVERSE QUESTS ===");

        var reverse = questLog.reverse();

        while (reverse.hasNext()) {

            var quest = reverse.next();

            System.out.println(quest);

            questsTraversed++;
        }

        return new CouncilRunResult(
                questsTraversed,
                messagesRouted,
                membersNotified
        );
    }
}
