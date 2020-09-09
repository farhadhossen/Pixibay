package com.example.pixibay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponse {

    @SerializedName("totalHits")
    @Expose
    private int totalHits;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;
    @SerializedName("total")
    @Expose
    private int total;

    /**
     * @return The totalHits
     */
    public int getTotalHits() {
        return totalHits;
    }

    /**
     * @param totalHits The totalHits
     */
    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    /**
     * @return The hits
     */
    public List<Hit> getHits() {
        return hits;
    }

    /**
     * @param hits The hits
     */
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    /**
     * @return The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

}


