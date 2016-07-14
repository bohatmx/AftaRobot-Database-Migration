package com.aftarobot.library.data.google;

import java.io.Serializable;

/**
 * Created by aubreymalabie on 6/11/16.
 */
public class IndoorLevel  implements Serializable
{
    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }
}