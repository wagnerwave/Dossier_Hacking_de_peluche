package com.tuya.smart.android.user.bean;

import java.io.Serializable;
import java.util.List;

public class Region implements Serializable {
    public String defaultServer;
    public List<Server> servers;

    public static class Server implements Serializable {
        public String name;
        public String server;

        public String getName() {
            return this.name;
        }

        public String getServer() {
            return this.server;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setServer(String str) {
            this.server = str;
        }
    }

    public String getDefaultServer() {
        return this.defaultServer;
    }

    public List<Server> getServers() {
        return this.servers;
    }

    public void setDefaultServer(String str) {
        this.defaultServer = str;
    }

    public void setServers(List<Server> list) {
        this.servers = list;
    }
}
