package com.Paths;

import java.util.ArrayList;
import java.util.List;

public class Path {
	City from;
	City to;
    List<City> connectors;
    int cost;
	Path (City from, City to, List<City>connectors, int cost) {
		this.from = from;
		this.to = to;
        this.connectors = connectors;
        this.cost = cost;
	}

	public boolean equals(Object pathArg) {
		Path path = (Path)pathArg;
        if(path.connectors == null && this.connectors == null)
		    return path.from.equals(this.from) && path.to.equals(this.to);
        if(path.connectors == null || this.connectors == null)
            return false;
        return path.from.equals(this.from) && path.to.equals(this.to) &&
                path.connectors.containsAll(this.connectors) && this.connectors.containsAll(path.connectors);

    }
}