package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.Captain;
import com.narxoz.rpg.guild.GuildHall;
import com.narxoz.rpg.guild.Healer;
import com.narxoz.rpg.guild.Quartermaster;
import com.narxoz.rpg.guild.Scout;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestLog;
import com.narxoz.rpg.quest.QuestPriority;
/**
 * Entry point for Homework 10 — The Adventurers' Guild: Iterator + Mediator.
 *
 * The scaffold prints the banner only; students fill in the guild demo.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Homework 10 Demo: Iterator + Mediator ===");

        Hero hero1 = new Hero("Archer", 100, 20, 5);
        Hero hero2 = new Hero("Mage", 80, 50, 10, 3, 100);

        QuestLog log = new QuestLog();

        log.add(new Quest(
                "Goblin Cave",
                QuestPriority.LOW,
                100,
                false
        ));

        log.add(new Quest(
                "Dragon Hunt",
                QuestPriority.URGENT,
                1000,
                true
        ));

        log.add(new Quest(
                "Escort Caravan",
                QuestPriority.NORMAL,
                300,
                false
        ));

        log.add(new Quest(
                "Cursed Ruins",
                QuestPriority.HIGH,
                700,
                true
        ));

        log.add(new Quest(
                "Bandit Camp",
                QuestPriority.HIGH,
                500,
                false
        ));

        GuildHall hall = new GuildHall();

        Scout scout = new Scout("Aria", hall);
        Healer healer = new Healer("Mina", hall);
        Quartermaster quartermaster = new Quartermaster("Borin", hall);
        Captain captain = new Captain("Ragnar", hall);

        scout.reportRoute(
                "SCOUT",
                "Road to ruins is dangerous"
        );

        healer.prepareAid(
                "HEALER",
                "Healing potions prepared"
        );

        captain.issueOrder(
                "COMMAND",
                "All heroes prepare for battle"
        );

        CouncilEngine engine = new CouncilEngine();

        CouncilRunResult result = engine.runCouncil(
                java.util.List.of(hero1, hero2),
                log,
                hall
        );

        System.out.println("\n=== FINAL RESULT ===");
        System.out.println(result);
    }
}
