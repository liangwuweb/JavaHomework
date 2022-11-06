package com.liangwu.java;

import java.util.ArrayList;

public class Org {
    private String name;
    private Leader leader;
    private ArrayList<Member> members = new ArrayList<>();

    // default constructor
    public Org() {
        this("", new Leader());
    }

    // specify constructor
    public Org(String name, Leader leader) {
        this.name = name;
        this.leader = leader;
    }


    // accessor
    public void addMembers(Member member) {
        members.add(member);
    }

    // accessor
    public String getLeader() {
        return this.leader.getName();
    }

    // accessor
    public String getMembers() {
        ArrayList<String> memberList = new ArrayList<>();
        for(Member member: members) {
            memberList.add(member.getName());
        }
        return memberList + "";
    }

    // to string
    public String toString() {
        return "Leader: " + this.getLeader() + "\nMembers: " + getMembers();
    }
}
