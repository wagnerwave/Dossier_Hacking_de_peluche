package com.tuya.smart.blescan;

public class ScanRequest {
    public long duration;
    public LeScanResponse response;
    public ScanFilter scanFilter;
    public FilterTypeEnum type;

    public static class Builder {
        public long duration = 10000;
        public LeScanResponse response;
        public ScanFilter scanFilter;
        public FilterTypeEnum type = FilterTypeEnum.ADD;

        public ScanRequest build() {
            ScanRequest scanRequest = new ScanRequest();
            long unused = scanRequest.duration = this.duration;
            FilterTypeEnum unused2 = scanRequest.type = this.type;
            LeScanResponse unused3 = scanRequest.response = this.response;
            ScanFilter unused4 = scanRequest.scanFilter = this.scanFilter;
            return scanRequest;
        }

        public Builder setDuration(long j) {
            this.duration = j;
            return this;
        }

        public Builder setResponse(LeScanResponse leScanResponse) {
            this.response = leScanResponse;
            return this;
        }

        public Builder setScanFilter(ScanFilter scanFilter2) {
            this.scanFilter = scanFilter2;
            return this;
        }

        public Builder setType(FilterTypeEnum filterTypeEnum) {
            this.type = filterTypeEnum;
            return this;
        }
    }

    public ScanRequest() {
    }

    public long getDuration() {
        return this.duration;
    }

    public LeScanResponse getResponse() {
        if (this.response == null) {
            this.response = new LeScanResponse() {
                public void onDeviceFounded(ScanLeBean scanLeBean) {
                }

                public void onScanCancel() {
                }

                public void onScanStart() {
                }

                public void onScanStop() {
                }
            };
        }
        return this.response;
    }

    public ScanFilter getScanFilter() {
        return this.scanFilter;
    }

    public FilterTypeEnum getType() {
        return this.type;
    }
}
