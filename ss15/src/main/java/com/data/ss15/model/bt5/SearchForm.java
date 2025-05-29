package com.data.ss15.model.bt5;

import javax.validation.constraints.NotBlank;

public class SearchForm {
    @NotBlank(message = "Vui lòng nhập từ khóa tìm kiếm")
    private String keyword;

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
}

