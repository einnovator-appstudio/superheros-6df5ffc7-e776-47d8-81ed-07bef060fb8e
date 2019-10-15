package com.jsimao71.superheros.xmodel;

import com.jsimao71.superheros.model.Squad;
import org.einnovator.util.model.ToStringCreator;

public class SuperheroFilter extends SuperheroOptions {

    private String q;

    private Squad squad;

    public SuperheroFilter() {
        super();
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getQ() {
        return this.q;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Squad getSquad() {
        return this.squad;
    }

    public SuperheroFilter withQ(String q) {
        this.q = q;
        return this;
    }

    public SuperheroFilter withSquad(Squad squad) {
        this.squad = squad;
        return this;
    }

    @Override()
    public ToStringCreator toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("q", q)
                    .append("squad", squad);
    }
}
