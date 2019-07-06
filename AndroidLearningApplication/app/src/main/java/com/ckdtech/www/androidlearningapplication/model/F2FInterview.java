package com.ckdtech.www.androidlearningapplication.model;

import java.util.List;

public class F2FInterview{ private String dateAvailable;

        private List<String> timeAvailable = null;

        private String panelName;

        private String panelEmailAddress;

        private String jobID;

        private String objectID;


        public String getJobID() {
            return jobID;
        }

        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        public String getDateAvailable() {
            return dateAvailable;
        }

        public void setDateAvailable(String dateAvailable) {
            this.dateAvailable = dateAvailable;
        }

        public List<String> getTimeAvailable() {
            return timeAvailable;
        }

        public void setTimeAvailable(List<String> timeAvailable) {
            this.timeAvailable = timeAvailable;
        }

        public String getPanelName() {
            return panelName;
        }

        public void setPanelName(String panelName) {
            this.panelName = panelName;
        }

        public String getPanelEmailAddress() {
            return panelEmailAddress;
        }

        public void setPanelEmailAddress(String panelEmailAddress) {
            this.panelEmailAddress = panelEmailAddress;
        }

        public F2FInterview(String dateAvailable, String jobId,String panelName, String panelEmailAddress,String objectID) {
            this.dateAvailable = dateAvailable;
            //this.timeAvailable = timeAvailable;
            this.jobID=jobId;
            this.panelName = panelName;
            this.panelEmailAddress = panelEmailAddress;
            this.objectID = objectID;
        }

        public String getObjectID() {
            return objectID;
        }

        public void setObjectID(String objectID) {
            this.objectID = objectID;
        }

        @Override
        public String toString() {
            return "F2FInterview{" +
                    "dateAvailable='" + dateAvailable + '\'' +
                    ", timeAvailable=" + timeAvailable +
                    ", panelName='" + panelName + '\'' +
                    ", panelEmailAddress='" + panelEmailAddress + '\'' +
                    ", jobID='" + jobID + '\'' +
                    ", objectID='" + objectID + '\'' +
                    '}';
        }}