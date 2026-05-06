package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Topic-based mediator for the Adventurers' Guild war council.
 */
public class GuildHall implements GuildMediator {

    private final Map<String, List<GuildMember>> membersByTopic = new HashMap<>();

    @Override
    public void register(GuildMember member) {
        addSubscriber("SCOUT", member);
        addSubscriber("HEALER", member);
        addSubscriber("SUPPLY", member);
        addSubscriber("COMMAND", member);
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        List<GuildMember> targets = subscribersFor(topic);
        for (GuildMember m : targets) {
            if (m != from) {
                m.receive(topic, from, payload);
            }
        }
    }

    protected void addSubscriber(String topic, GuildMember member) {
        membersByTopic.computeIfAbsent(topic, key -> new ArrayList<>()).add(member);
    }

    protected List<GuildMember> subscribersFor(String topic) {
        return membersByTopic.getOrDefault(topic, List.of());
    }
}
