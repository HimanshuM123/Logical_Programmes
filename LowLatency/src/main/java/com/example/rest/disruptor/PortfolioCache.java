package com.example.rest.disruptor;


import net.openhft.chronicle.map.ChronicleMap;

import java.io.File;
import java.io.IOException;

public class PortfolioCache {
    private final ChronicleMap<String, Portfolio> portfolioMap;

    public PortfolioCache() throws IOException {
        portfolioMap = ChronicleMap
                .of(String.class, Portfolio.class)
                .name("portfolio-map")
                .entries(1000)
                .createPersistedTo(new File("portfolio-cache.dat"));
    }

    public Portfolio get(String clientId){
        return portfolioMap.get(clientId);
    }

    public void put(String clientId, Portfolio portfolio){
        portfolioMap.put(clientId, portfolio);
    }
}
