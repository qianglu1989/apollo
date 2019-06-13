package com.ctrip.framework.apollo.portal.entity.bo;

import com.ctrip.framework.apollo.common.entity.App;
import com.ctrip.framework.apollo.core.enums.Env;
import com.ctrip.framework.apollo.portal.entity.vo.ReleaseCompareResult;

public class SecooBo {

    private String env;

    private ReleaseCompareResult releaseCompareResult;

    private ReleaseHistoryBO releaseHistoryBO;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public ReleaseCompareResult getReleaseCompareResult() {
        return releaseCompareResult;
    }

    public void setReleaseCompareResult(ReleaseCompareResult releaseCompareResult) {
        this.releaseCompareResult = releaseCompareResult;
    }

    public ReleaseHistoryBO getReleaseHistoryBO() {
        return releaseHistoryBO;
    }

    public void setReleaseHistoryBO(ReleaseHistoryBO releaseHistoryBO) {
        this.releaseHistoryBO = releaseHistoryBO;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private SecooBo secooBo = new SecooBo();


        public Builder env(String env) {
            this.secooBo.env = env;
            return this;
        }

        public Builder releaseCompareResult(ReleaseCompareResult releaseCompareResult) {
            this.secooBo.releaseCompareResult = releaseCompareResult;
            return this;
        }

        public Builder releaseHistoryBO(ReleaseHistoryBO releaseHistoryBO) {
            this.secooBo.releaseHistoryBO = releaseHistoryBO;
            return this;
        }

        public SecooBo build() {
            return secooBo;
        }


    }
}
