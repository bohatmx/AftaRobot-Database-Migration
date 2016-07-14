package com.aftarobot.library.data.google;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 6/11/16.
 */
public class AdvertisedId  implements Serializable
{
    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private String id;

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }
}
