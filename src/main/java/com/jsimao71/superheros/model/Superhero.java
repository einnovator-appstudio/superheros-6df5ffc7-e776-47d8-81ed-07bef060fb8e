package com.jsimao71.superheros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.einnovator.util.model.ToStringCreator;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class Superhero extends org.einnovator.jpa.model.EntityBase2<Long> {

    @Column()
    private String img;

    @Column(length = 1024)
    private String name;

    @Column()
    private Squad squad;

    @Column()
    private Boolean villain;

    @Column()
    private List<Superhero> friends;

    @Column()
    private String description;

    public Superhero() {
        super();
    }

    public Superhero(Object obj) {
        super(obj);
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return this.img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Squad getSquad() {
        return this.squad;
    }

    public void setVillain(Boolean villain) {
        this.villain = villain;
    }

    public Boolean getVillain() {
        return this.villain;
    }

    public void setFriends(List<Superhero> friends) {
        this.friends = friends;
    }

    public List<Superhero> getFriends() {
        return this.friends;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Superhero findFriend(String id) {
        if (id != null && friends != null) {
            for (Superhero friend : friends) {
                if (id.equals(friend.getUuid()) || id.equals(friend.getName())) {
                    return friend;
                }
            }
        }
        return null;
    }

    public void addFriend(Superhero friend) {
        if (this.friends == null) {
            this.friends = new ArrayList<>();
        }
        this.friends.add(friend);
    }

    public Superhero removeFriend(Superhero friend) {
        if (friend != null && friends != null) {
            for (int i = 0; i < friends.size(); i++) {
                Superhero friend0 = friends.get(i);
                if (friend0.getId().equals(friend.getId())) {
                    friends.remove(i);
                    return friend0;
                }
            }
        }
        return null;
    }

    @Override()
    public ToStringCreator toString0(ToStringCreator creator) {
        return super.toString0(creator);
    }

    @Override()
    public ToStringCreator toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("img", img)
                    .append("name", name)
                    .append("squad", squad)
                    .append("villain", villain)
                    .append("friends", friends)
                    .append("description", description);
    }

    @Override()
    public ToStringCreator toString2(ToStringCreator creator) {
        return super.toString2(creator);
    }
}
