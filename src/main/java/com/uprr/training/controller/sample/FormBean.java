package com.uprr.training.controller.sample;

import com.uprr.netcontrol.shared.components.datetime.NCDate;
import com.uprr.netcontrol.shared.components.datetime.NCDateTime;

import javax.validation.constraints.NotNull;

/**
 * The FormBean holds the incoming request parameters, mapped automatically by Spring.
 *
 * @author Steven A. Wicklund
 */
public class FormBean {

    NCDate trainDate;

    NCDateTime departTime;

    @NotNull   //JSR-303 tag indicating that this value should not be null
            String trainSymbol;

    private Integer yard;

    public NCDate getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(NCDate trainDate) {
        this.trainDate = trainDate;
    }

    public NCDateTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(NCDateTime departTime) {
        this.departTime = departTime;
    }

    public String getTrainSymbol() {
        return trainSymbol;
    }

    public void setTrainSymbol(String trainSymbol) {
        this.trainSymbol = trainSymbol;
    }

    public Integer getYard() {
        return yard;
    }

    public void setYard(Integer yard) {
        this.yard = yard;
    }

}
