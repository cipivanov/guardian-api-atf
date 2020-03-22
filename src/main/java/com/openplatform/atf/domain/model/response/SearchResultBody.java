package com.openplatform.atf.domain.model.response;

import java.util.List;

public class SearchResultBody {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    class Response {

        private String status;
        private String userTier;
        private Integer total;
        private Integer startIndex;
        private Integer pageSize;
        private Integer currentPage;
        private Integer pages;
        private String orderBy;
        private List<Result> results = null;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserTier() {
            return userTier;
        }

        public void setUserTier(String userTier) {
            this.userTier = userTier;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(Integer startIndex) {
            this.startIndex = startIndex;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public String getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(String orderBy) {
            this.orderBy = orderBy;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

    }

    class Result {

        private String id;
        private String type;
        private String sectionId;
        private String sectionName;
        private String webPublicationDate;
        private String webTitle;
        private String webUrl;
        private String apiUrl;
        private Boolean isHosted;
        private List<Edition> editions = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSectionId() {
            return sectionId;
        }

        public void setSectionId(String sectionId) {
            this.sectionId = sectionId;
        }

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public String getWebPublicationDate() {
            return webPublicationDate;
        }

        public void setWebPublicationDate(String webPublicationDate) {
            this.webPublicationDate = webPublicationDate;
        }

        public String getWebTitle() {
            return webTitle;
        }

        public void setWebTitle(String webTitle) {
            this.webTitle = webTitle;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        public Boolean getIsHosted() {
            return isHosted;
        }

        public void setIsHosted(Boolean isHosted) {
            this.isHosted = isHosted;
        }
    }

    class Edition {

        private String id;
        private String webTitle;
        private String webUrl;
        private String apiUrl;
        private String code;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getWebTitle() {
            return webTitle;
        }

        public void setWebTitle(String webTitle) {
            this.webTitle = webTitle;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}